package ru.geekbrains.lesson_1314_3_1_main.repository

import com.google.gson.GsonBuilder
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PODRetrofitImpl {

    private val baseUrl = "https://api.nasa.gov/"

    private val api by lazy {
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            //.client(createOkHttpClient(PODInterceptor()))
            .build().create(RetrofitAPI::class.java)
    }

    fun getPictureOfTheDay(apiKey: String, podCallback: Callback<PODServerResponseData>) {
        api.getPictureOfTheDay(apiKey).enqueue(podCallback)
    }

    fun getSolarFlareToday(apiKey: String, podCallback: Callback<List<SolarFlareResponseData>>,startDate:String="2021-09-07") {
        api.getSolarFlareToday(apiKey,startDate).enqueue(podCallback)
    }



    /*private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }



    inner class PODInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            return chain.proceed(chain.request())
        }
    }*/

}