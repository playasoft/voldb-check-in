package net.wetfish.playasoftvolunteers.data.net.interceptors

/**
 * Created by  on 9/30/2019.
 */

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import splitties.init.appCtx
import java.io.IOException
import java.util.regex.Pattern

private val cookiesKey = "appCookies"
private val cookiesCFKey = "appCookiesCF"
private val cookiesLaravelKey = "appCookiesLaravel"
private val cookiesXSRFKeey = "appCookiesXSRF"

//class SendSavedCookiesInterceptor(private val context: Context) : Interceptor {
//    val sharedPref = appCtx?.getSharedPreferences("networkSettings", Context.MODE_PRIVATE)
//
//    @Throws(IOException::class)
//    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
//        val builder = chain.request().newBuilder()
//
//
//        val preferences = PreferenceManager
//            .getDefaultSharedPreferences(context)
//            .getStringSet(cookiesKey, HashSet()) as HashSet<String>
//
//        preferences.forEach {
//            builder.addHeader("Cookie", it)
//        }
//
//        return chain.proceed(builder.build())
//    }
//}

class SaveReceivedCookiesInterceptor(private val context: Context) : Interceptor {

    @JvmField
    val setCookieHeader = "Set-Cookie"

    val sharedPref = appCtx?.getSharedPreferences("networkSettings", Context.MODE_PRIVATE)

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val originalResponse = chain.proceed(chain.request())

        if (!originalResponse.headers(setCookieHeader).isEmpty()) {
            val cookies = PreferenceManager
                .getDefaultSharedPreferences(context)
                .getStringSet(cookiesKey, HashSet()) as HashSet<String>

            originalResponse.headers(setCookieHeader).forEach {

                val patternXSRF = Pattern.compile("(XSRF-TOKEN=(.*?);)")
                val patternLaraval = Pattern.compile("(laravel_session=(.*?);)")
                val patternCloudFlare = Pattern.compile("(__cfduid=(.*?);)")
                var matcherXSRF = patternXSRF.matcher(it)
                var matcherLaraval = patternLaraval.matcher(it)
                var matcherCloudFlare = patternCloudFlare.matcher(it)


                if (matcherCloudFlare.find()) {
                    sharedPref.edit().putString(cookiesCFKey, matcherCloudFlare.group(1)).commit()
                } else if (matcherXSRF.find()) {
                    sharedPref.edit().putString(cookiesXSRFKeey, matcherXSRF.group(1)).commit()
                } else if (matcherLaraval.find()) {
                    sharedPref.edit().putString(cookiesLaravelKey, matcherLaraval.group(0)).commit()
                }
                // Log the current cookie
                Log.d("Logging", "It to string" + it.toString())
            }
        }

        return originalResponse
    }
}

class cookieInterceptor(private val context: Context) : Interceptor {
    val setCookieHeader = "Set-Cookie"

    val sharedPref = appCtx?.getSharedPreferences("networkSettings", Context.MODE_PRIVATE)

    var booleanVariable = false;

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {


        var cfduidPresent = false

        if (!booleanVariable) {
            Log.d(
                "CHECK ME OUT COOKIES",
                "\n" + sharedPref.getStringSet("appCookies", setOf("whoops")).toString() + "\n"
            )
            Log.d("CHECK ME OUT ~~~", "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nCleared\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n")
            sharedPref.edit().remove("appCookies").commit()
            booleanVariable == true
        }

        val originalResponse = chain.proceed(chain.request())

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            val cookiesAuth = sharedPref.getStringSet(cookiesKey, HashSet()) as HashSet<String>
            var cookiesCF: String = ""

            originalResponse.headers(setCookieHeader).forEach {

                //                if (cookiesAuth.size == 2 ) {
//                } else {
                val patternAuth = Pattern.compile("(laravel_session=(.*?);)|(XSRF-TOKEN=(.*?);)")
                val patternCF = Pattern.compile("(__cfduid=(.*?);)")
                var matcherAuth = patternAuth.matcher(it)
                var matcherCF = patternCF.matcher(it)


                if (matcherAuth.find()) {
                    // Save the laravel or XSRF session cookies
                    cookiesAuth += it
                    Log.d("CookieStore", "getRequestLoggedIn| Data: " + matcherAuth.group(0))
                } else if (matcherCF.find()) {
                    // TODO: Write out an error
                    cookiesCF = it
                    cfduidPresent = true
                    Log.d(
                        "CookieStore",
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + it.toString() + "\n" + cookiesCF
                    )
                }
//                }

                Log.d("Logging", "It to string" + it.toString())
            }

            Log.d(
                "BOOM LOGGING",
                "Cookies: " + cookiesAuth.toString() + "\nCookies Size: " + cookiesAuth.size + "\nCookie Cloud Flare: " + cookiesCF
            )

            if (cfduidPresent) {
                Log.d("Matcher Check", "CFDUID HERE")
                with(sharedPref.edit()) {
                    putStringSet(cookiesKey, cookiesAuth)
                    putString(cookiesCFKey, cookiesCF)
                    commit()
                }
            } else {
                Log.d("Matcher Check", "CFDUID GONE")
                with(sharedPref.edit()) {
                    putStringSet(cookiesKey, cookiesAuth)
                    commit()
                }
            }


            Log.d("BOOM LOGGING", "Cookie CF: " + sharedPref.getString(cookiesCFKey, ""))
        }
        return originalResponse
    }
}

fun OkHttpClient.Builder.setCookieStore(context: Context): OkHttpClient.Builder {
    return this
//        .addInterceptor(cookieInterceptor(appCtx))
//        .addInterceptor(SendSavedCookiesInterceptor(appCtx))
        .addInterceptor(
            SaveReceivedCookiesInterceptor(
                appCtx
            )
        )
        .addInterceptor(JsonInterceptor())
}