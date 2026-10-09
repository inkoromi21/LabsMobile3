package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AppScreen()
    }
  }
}

@Composable
fun AppScreen() {
  MaterialTheme(colorScheme = lightColorScheme(background = Color.White, onBackground = Color.Black, surface = Color.White, onSurface = Color.Black)) {
    Surface(modifier = Modifier.fillMaxSize()) {
      ArticleScreen()
    }
  }
}

private val ArticlePadding = 16.dp
private val TitleFontSize = 24.sp

@Composable
fun ArticleScreen(modifier: Modifier = Modifier) {
  Column(modifier = modifier.fillMaxSize()) {
    Image(
      painter = painterResource(R.drawable.article),
      contentDescription = stringResource(R.string.article_image),
      modifier = Modifier.fillMaxWidth()
    )
    Text(
      text = stringResource(R.string.article_title),
      fontSize = TitleFontSize,
      modifier = Modifier.padding(ArticlePadding)
    )
    Text(
      text = stringResource(R.string.article_intro),
      textAlign = TextAlign.Justify,
      modifier = Modifier.padding(horizontal = ArticlePadding)
    )
    Text(
      text = stringResource(R.string.article_body),
      textAlign = TextAlign.Justify,
      modifier = Modifier.padding(ArticlePadding)
    )
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
  AppScreen()
}
