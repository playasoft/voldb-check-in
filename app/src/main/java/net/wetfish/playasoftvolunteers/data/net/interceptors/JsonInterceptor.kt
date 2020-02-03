package net.wetfish.playasoftvolunteers.data.net.interceptors

/**
 * Created by  on 9/30/2019.
 */

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException

class JsonInterceptor : Interceptor {
    //TODO: For testing if need be
    val LOG_TAG = JsonInterceptor::class.java.simpleName

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val response = chain.proceed(request)
        val rawJson = response.body()!!.string()

        // Re-create the response before returning it because body can be read only once
        return response.newBuilder()
            .body(ResponseBody.create(response.body()!!.contentType(), rawJson)).build()
    }
}