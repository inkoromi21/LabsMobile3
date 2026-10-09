package com.example.happybirthday

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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
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
      GreetingImage(message = stringResource(R.string.birthday_message), from = stringResource(R.string.birthday_signature))
    }
  }
}

private val CardPadding = 8.dp
private val SignaturePadding = 16.dp
private val GreetingFontSize = 100.sp
private val GreetingLineHeight = 116.sp
private val SignatureFontSize = 36.sp
private const val BackgroundOpacity = 0.5f

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
  Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
    Text(
      text = message,
      fontSize = GreetingFontSize,
      lineHeight = GreetingLineHeight,
      textAlign = TextAlign.Center
    )
    Text(
      text = from,
      fontSize = SignatureFontSize,
      modifier = Modifier.padding(SignaturePadding).align(Alignment.End)
    )
  }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
  Box(modifier = modifier.fillMaxSize()) {
    Image(
      painter = painterResource(R.drawable.androidparty),
      contentDescription = null,
      contentScale = ContentScale.Crop,
      alpha = BackgroundOpacity,
      modifier = Modifier.fillMaxSize()
    )
    GreetingText(message, from, Modifier.fillMaxSize().padding(CardPadding))
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
  AppScreen()
}
