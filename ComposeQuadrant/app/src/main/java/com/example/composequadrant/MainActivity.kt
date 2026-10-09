package com.example.composequadrant

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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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
      QuadrantScreen()
    }
  }
}

private val QuadrantPadding = 16.dp
private val HeadingBottomPadding = 16.dp
private const val EqualWeight = 1f

@Composable
fun QuadrantCard(title: String, description: String, background: Color, modifier: Modifier = Modifier) {
  Column(
    modifier = modifier.fillMaxHeight().background(background).padding(QuadrantPadding),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = HeadingBottomPadding))
    Text(text = description, textAlign = TextAlign.Justify)
  }
}

@Composable
fun QuadrantScreen(modifier: Modifier = Modifier) {
  Column(modifier = modifier.fillMaxSize()) {
    Row(modifier = Modifier.fillMaxWidth().weight(EqualWeight)) {
      QuadrantCard(
        stringResource(R.string.text_title), stringResource(R.string.text_description),
        colorResource(R.color.text_quadrant), Modifier.weight(EqualWeight)
      )
      QuadrantCard(
        stringResource(R.string.image_title), stringResource(R.string.image_description),
        colorResource(R.color.image_quadrant), Modifier.weight(EqualWeight)
      )
    }
    Row(modifier = Modifier.fillMaxWidth().weight(EqualWeight)) {
      QuadrantCard(
        stringResource(R.string.row_title), stringResource(R.string.row_description),
        colorResource(R.color.row_quadrant), Modifier.weight(EqualWeight)
      )
      QuadrantCard(
        stringResource(R.string.column_title), stringResource(R.string.column_description),
        colorResource(R.color.column_quadrant), Modifier.weight(EqualWeight)
      )
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
  AppScreen()
}
