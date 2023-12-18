package ir.newsappmvvmcompose.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.utilities.ResourceState
import ir.newsappmvvmcompose.ui.viewmodel.NewsViewModel

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsResponse by newsViewModel.news.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        when(newsResponse){
            is ResourceState.Loading -> {

            }

            is ResourceState.Success -> {

            }

            is ResourceState.Error -> {

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}