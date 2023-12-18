package ir.newsappmvvmcompose.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ir.newsappmvvmcompose.data.entity.Article
import ir.newsappmvvmcompose.data.entity.NewsResponse
import ir.newsappmvvmcompose.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp), color = Purple40

        )
    }
}


@Composable
fun NewsList(
    response: NewsResponse, page: Int
) {
    LazyColumn(content = {
        response.articles?.let { article ->
            items(article.size) {
                NormalTextComponent(text = article[it].title ?: "NA")
            }
        }
    })
}

@Composable
fun NormalTextComponent(
    text: String,
) {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(8.dp),
        text = text,
        style = TextStyle(
            fontSize = 18.sp, fontWeight = FontWeight.Normal
        )
    )
}

@Composable
fun NewsRowComponent(
    page: Int, article: Article?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article,
            contentDescription = "",
            contentScale = ContentScale.Fit
        )
        NormalTextComponent(text = "$page \n\n ${article?.title}")
    }
}