package empower.ca.model

import com.google.gson.Gson
import empower.ca.dto.ContentWrapperDto
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.util.concurrent.TimeUnit

object EmpowerHttp {

    private val client = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()

    fun getJson(url: String) : ContentWrapperDto?{
        val request = Request.Builder()
            .url(String.format(url, null))
            .build()

        try{
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            return Gson().fromJson(json, ContentWrapperDto::class.java)

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}
