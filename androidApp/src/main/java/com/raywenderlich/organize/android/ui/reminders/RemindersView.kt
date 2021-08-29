package com.raywenderlich.organize.android.ui.reminders

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.raywenderlich.organize.android.R
import com.raywenderlich.organize.android.ui.root.Screen

@Composable
fun RemindersView(
  navController: NavHostController,
) {
  Column {
    Toolbar(navController = navController)
    ContentView()
  }
}

@Composable
private fun Toolbar(
  navController: NavHostController,
) {
  TopAppBar(
    title = { Text(text = stringResource(R.string.reminders)) },
    actions = {
      IconButton(onClick = {
        navController.navigate(Screen.AboutDevice.route)
      }) {
        Icon(
          imageVector = Icons.Outlined.Info,
          contentDescription = stringResource(R.string.info_button_content_descr),
        )
      }
    }
  )
}

@Composable
private fun ContentView() {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Text("Hello World!")
  }
}

@Preview(showBackground = true)
@Composable
private fun RemindersViewPreview() {
  RemindersView(
    navController = NavHostController(LocalContext.current)
  )
}