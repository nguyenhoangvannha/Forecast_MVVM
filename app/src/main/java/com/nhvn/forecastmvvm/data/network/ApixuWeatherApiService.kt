package com.nhvn.forecastmvvm.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nhvn.forecastmvvm.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author: NGUYENHOANGVANNHA
 * Date: 9/17/2019
 * Project: Forecast MVVM
 */
const val API_KEY = "89e8bd89085b41b7a4b142029180210"
const val BASE_API_URL = "http://api.apixu.com/v1/"

interface ApixuWeatherApiService {
    @GET("current.json")
    fun getCurrentWeather(
        @Query("q") location: String
        , @Query("lang") language: String = "en"
    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(): ApixuWeatherApiService {
            val requestInterceptor = Interceptor { chain ->
                val url =
                    chain.request().url().newBuilder().addQueryParameter(
                        "key",
                        API_KEY
                    ).build()
                val request = chain.request().newBuilder().url(url).build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder().addInterceptor(requestInterceptor).build()
            return Retrofit.Builder().client(okHttpClient).baseUrl(BASE_API_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ApixuWeatherApiService::class.java)
        }
    }
}