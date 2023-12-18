package ir.newsappmvvmcompose.data.datasource

import ir.newsappmvvmcompose.data.api.ApiService
import ir.newsappmvvmcompose.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {

    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country)
    }

}