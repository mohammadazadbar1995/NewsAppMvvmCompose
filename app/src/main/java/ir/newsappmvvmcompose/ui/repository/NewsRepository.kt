package ir.newsappmvvmcompose.ui.repository

import com.utilities.ResourceState
import ir.newsappmvvmcompose.data.datasource.NewsDataSource
import ir.newsappmvvmcompose.data.entity.NewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

    /*  suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
          return newsDataSource.getNewsHeadline(country)
      }*/


    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadline(country)

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching news data"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Some error in flow"))
        }
    }
}