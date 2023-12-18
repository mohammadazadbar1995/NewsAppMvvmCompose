package ir.newsappmvvmcompose.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.newsappmvvmcompose.data.entity.NewsResponse
import ir.newsappmvvmcompose.ui.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewsResponse>> = _news

    init {
        getNews("us")
    }
    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d(TAG, "getNewsHeadline: $country")
            newsRepository.getNewsHeadline(country)
                .collectLatest { newsResponse ->
                    _news.value = newsResponse
                }
        }

    }

    companion object {
        private const val TAG = "NewsViewModel"
    }
}