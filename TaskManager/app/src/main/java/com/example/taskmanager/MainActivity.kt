package com.example.taskmanager

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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
      CompletedTasksScreen()
    }
  }
}

private val HeadingTopPadding = 24.dp
private val HeadingBottomPadding = 8.dp
private val MessageFontSize = 16.sp

@Composable
fun CompletedTasksScreen(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Image(painter = painterResource(R.drawable.completed), contentDescription = null)
    Text(
      text = stringResource(R.string.tasks_completed),
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(top = HeadingTopPadding, bottom = HeadingBottomPadding)
    )
    Text(text = stringResource(R.string.nice_work), fontSize = MessageFontSize)
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
  AppScreen()
}
