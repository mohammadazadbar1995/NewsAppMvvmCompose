package ir.newsappmvvmcompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ir.newsappmvvmcompose.R
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
                NormalTextComponent(textValue = article[it].title ?: "NA")
            }
        }
    })
}


@Composable
fun NewsRowComponent(
    page: Int, article: Article?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article?.urlToImage ?: "",
            contentDescription = "",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_background)
        )

        Spacer(modifier = Modifier.size(20.dp))

        HeadingTextComponent(textValue = article?.title ?: "")

        Spacer(modifier = Modifier.size(10.dp))

        NormalTextComponent(textValue = article?.description ?: "")

        Spacer(modifier = Modifier.weight(1f))

        AuthorDetailsComponent(
            authorName = article?.author ?: "",
            authorSourceName = article?.source?.name ?: ""
        )
    }
}

@Composable
fun NormalTextComponent(
    textValue: String,
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
            color = Purple40

        )
    )
}

@Composable
fun HeadingTextComponent(
    textValue: String,
    centeredAlignment: Boolean = false
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        ),
        textAlign = if (centeredAlignment) TextAlign.Center else TextAlign.Start
    )
}


@Composable
fun AuthorDetailsComponent(
    authorName: String = "",
    authorSourceName: String = "",
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
    ) {
        Text(
            text = authorName
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = authorSourceName
        )

    }
}


@Composable
fun EmptyStateComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_data),
            contentDescription = "",
        )

        HeadingTextComponent(
            textValue = "No news as of now\nPlease try again later",
            centeredAlignment = true
        )
    }
}