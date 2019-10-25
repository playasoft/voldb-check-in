package net.wetfish.playasoftvolunteers.data

import android.content.Context
import android.util.Log
import kotlinx.coroutines.*
import net.wetfish.playasoftvolunteers.data.model.UserCredentials
import net.wetfish.playasoftvolunteers.data.model.UserProfile
import net.wetfish.playasoftvolunteers.data.net.api.RetrofitClient
import net.wetfish.playasoftvolunteers.ui.login.LoginActivity
import retrofit2.HttpException
import splitties.init.appCtx
import java.util.regex.Pattern

/**
 * Class that handles authentication w/ login credentials and retrieves userProfile information.
 */
class LoginDataSource {

    private var myJob: Job? = null

    private val cookiesKey = "appCookies"
    private val cookiesCFKey = "appCookiesCF"
    private val cookiesLaravelKey = "appCookiesLaravel"
    private val cookiesXSRFKeey = "appCookiesXSRF"

    var userCredentials = UserCredentials()

    var _token = ""


    val LOG_TAG = LoginActivity::class.java.simpleName;

    fun login(username: String, password: String): Result<UserProfile> {

        val fakeUser = UserProfile(
            java.util.UUID.randomUUID().toString(),
            username,
            listOf("f"),
            "f",
            "f",
            "f"
        )

        val sharedPref2 = appCtx?.getSharedPreferences("networkSettings", Context.MODE_PRIVATE)

        Log.d(LOG_TAG, "Does this work? IF" + sharedPref2.getStringSet("appCookies", null))
        sharedPref2.edit().remove("appCookies").apply()
        Log.d(LOG_TAG, "Does this work? IF" + sharedPref2.getStringSet("appCookies", null))

        getRequest(username, password)

        return Result.Success(fakeUser)

    }

    fun logout() {
        // TODO: revoke authentication
    }

    suspend fun postRequestLogin(username: String, password: String) {
        delay(5000)
        val sharedPref = appCtx?.getSharedPreferences("networkSettings", Context.MODE_PRIVATE)
        CoroutineScope(Dispatchers.IO).launch {
            val userInformation = UserCredentials(
                username, password, _token
            )
//
            var cookies: String = ""

            cookies = sharedPref.getString(cookiesCFKey, "") +
                    sharedPref.getString(cookiesXSRFKeey, "") +
                    sharedPref.getString(cookiesLaravelKey, "")


            // Run the postWebResponse with the provided laravel cookie
            val postWebResponse = RetrofitClient.RETROFIT_CLIENT.postRequestLogin2(
                _token,
                username,
                password,
                "application/x-www-form-urlencoded",
                _token,
                "*/*",
                "no-cache",
                cookies

            ).await()

            try {
                if (postWebResponse.isSuccessful) {
                    //TODO: Do something here
                    Log.d(
                        LOG_TAG,
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n postWebResponse: \n" + postWebResponse.body()?.string() + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                    )
                } else {
                    Log.d(
                        LOG_TAG,
                        "postRequestLogin| Well, we did something at least: " + "\n" + postWebResponse.code() + "\n" + (postWebResponse.body()?.string())
                    )
                    Log.d(
                        LOG_TAG,
                        "postRequestLogin| Well, we didn't do ANYTHING something at least: " + "\n" + postWebResponse.code() + "\n" + (postWebResponse.body()?.string())
                    )
                }
            } catch (e: HttpException) {
                Log.e(LOG_TAG, "postRequestLogin| Exception ${e.message}")
            } catch (e: Throwable) {
                Log.e(
                    LOG_TAG,
                    "postRequestLogin| Ooops: Something else went wrong: " + e.message
                )
            }
        }
    }

    fun getRequest(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val getWebResponse = RetrofitClient.RETROFIT_CLIENT.getRequestCsrfToken(
                "application/x-www-form-urlencoded",
                "*/*",
                "no-cache"
            ).await()

            try {
                // Create a get request and store the response
                if (getWebResponse.isSuccessful) {
                    val responseBody = getWebResponse.body()?.string()

                    // If response body is not empty run it through regex to find the CSRF token
                    if (!responseBody.toString().isEmpty()) {
                        val pattern = Pattern.compile("type=\"hidden\" value=\"(.*?)\">")
                        val matcher = pattern.matcher(responseBody)

                        Log.d(
                            LOG_TAG,
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n getRequest: \n" + responseBody + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                        )

                        // If Matcher finds CSRF token use it for the next POST request.
                        if (matcher.find()) {
                            // If found, save the CSRF token
                            val sharedPref = appCtx?.getSharedPreferences(
                                "networkSettings",
                                Context.MODE_PRIVATE
                            )
                            _token = matcher.group(1)

                            sharedPref.edit().putString("csrfToken", _token).commit()
                            Log.d(
                                LOG_TAG,
                                "getRequest| Data: " + matcher.group(0) + " + " + matcher.group(
                                    1
                                )
                            )
                        }
                    } else {
                        Log.d(LOG_TAG, "getRequest| CSRF not found")
                    }
                } else {
                    Log.d(LOG_TAG, "getRequest| Response is null or empty")
                }
            } catch (e: HttpException) {
                Log.e(LOG_TAG, "getRequest| Exception ${e.message}")
            } catch (e: Throwable) {
                Log.e(LOG_TAG, "getRequest| Ooops: Something else went wrong: " + e.message)
            }
            postRequestLogin(username, password)
        }
        // TODO: handle loggedInUser authentication
        val fakeUser = UserProfile(
            java.util.UUID.randomUUID().toString(),
            username,
            listOf("f"),
            "f",
            "f",
            "f"
        )
    }
}

