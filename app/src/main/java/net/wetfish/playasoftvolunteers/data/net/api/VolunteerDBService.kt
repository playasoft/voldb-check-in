package net.wetfish.playasoftvolunteers.data.net.api

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by  on 9/27/2019.
 */
interface VolunteerDBService {

    companion object {
        private val BASE_URL = "https://volunteer.wetfish.net"
    }

    // Login @GET request to obtain a CSRF token
    @GET("/login")
    fun getRequestCsrfToken(
        @Header("Content-Type") contentType: String,
        @Header("Accept") accept: String,
        @Header("Cache-Control") cacheControl: String
    ): Deferred<Response<ResponseBody>>

//    // Homepage @GET request to obtain base user data/login verification
//    @GET("/profile")
//    fun getRequestProfile(@Header("Cookie") cookie: String): Deferred<Response<ResponseBody>>

    // Login @GET request to obtain base user data/login verification
    @FormUrlEncoded
    @POST("/login")
    fun postRequestLogin2(
        @Field("_token") csrfToken: String,
        @Field("departmentName") name: String,
        @Field("password") password: String,
        @Header("Content-Type") contentType: String,
        @Header("X-Csrf-Token") xCsrfToken: String,
        @Header("Accept") accept: String,
        @Header("Cache-Control") cacheControl: String,
        @Header("Cookie") cookie: String
    ): Deferred<Response<ResponseBody>>

    /**
     * Get requests that provide JSON data
     */
    @GET("/v1/profile")
    fun getRequestProfile(
        @Header("Cookie") cookie: String,
        @Query("username") username: String? = null,
        @Query("email") email: String? = null,
        @Query("full_name") fullName: String? = null,
        @Query( "burner_name")
    ): Deferred<Response<ResponseBody>>

    @GET("/v1/events")
    fun getRequestEvents(@Header("Cookie") cookie: String): Deferred<Response<ResponseBody>>

    @GET("/v1/event/{id}/departments")
    fun getRequestDepartments(@Header("Cookie") cookie: String): Deferred<Response<ResponseBody>>

    @GET("/v1/event/{id}/roles")
    fun getRequestRoles(@Header("Cookie") cookie: String): Deferred<Response<ResponseBody>>

    @GET("/v1/event/{id}/shifts")
    fun getRequestShifts(@Header("Cookie") cookie: String): Deferred<Response<ResponseBody>>
}