package ir.newsappmvvmcompose.data.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.newsappmvvmcompose.data.AppConstants
import ir.newsappmvvmcompose.data.api.ApiService
import ir.newsappmvvmcompose.data.datasource.NewsDataSource
import ir.newsappmvvmcompose.data.datasource.NewsDataSourceImpl
import ir.newsappmvvmcompose.ui.repository.NewsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
        }

        httpClient.apply {
            readTimeout(60, TimeUnit.SECONDS)
        }

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()

        return Retrofit
            .Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
            )


            .build()
    }


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsDataSource(apiService: ApiService): NewsDataSource {
        return NewsDataSourceImpl(apiService)
    }


    @Provides
    @Singleton
    fun providesNewsRepository(newsDataSource: NewsDataSource): NewsRepository {
        return NewsRepository(newsDataSource)
    }
}