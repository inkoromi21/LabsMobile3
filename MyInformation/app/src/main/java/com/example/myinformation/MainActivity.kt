package com.example.myinformation

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
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
      InformationScreen()
    }
  }
}

private val ScreenPadding = 24.dp
private val ProfileImageSize = 96.dp
private val ProfileBackground = Color(0xFF3DDC84)
private val NameFontSize = 32.sp
private val ProfileGap = 12.dp
private val ContactIconSize = 24.dp
private val ContactGap = 16.dp
private val ContactBottomPadding = 48.dp

@Composable
fun ContactRow(@DrawableRes iconResource: Int, text: String, modifier: Modifier = Modifier) {
  Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(ContactGap)) {
    Icon(painter = painterResource(iconResource), contentDescription = null, modifier = Modifier.size(ContactIconSize))
    Text(text = text)
  }
}

@Composable
fun InformationScreen(modifier: Modifier = Modifier) {
  Box(modifier = modifier.fillMaxSize().padding(ScreenPadding)) {
    Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
      Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = stringResource(R.string.profile_image),
        modifier = Modifier.size(ProfileImageSize).background(ProfileBackground)
      )
      Spacer(modifier = Modifier.height(ProfileGap))
      Text(text = stringResource(R.string.student_name), fontSize = NameFontSize)
      Text(text = stringResource(R.string.student_group), fontWeight = FontWeight.Bold)
    }
    Column(
      modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = ContactBottomPadding),
      verticalArrangement = Arrangement.spacedBy(ContactGap)
    ) {
      ContactRow(R.drawable.ic_phone, stringResource(R.string.phone))
      ContactRow(R.drawable.ic_social, stringResource(R.string.social))
      ContactRow(R.drawable.ic_email, stringResource(R.string.email))
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
  AppScreen()
}
