package ir.newsappmvvmcompose.data.api

import ir.newsappmvvmcompose.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "3fea0072e13c445a958ba9bee19e459b"
    ): Response<NewsResponse>

}