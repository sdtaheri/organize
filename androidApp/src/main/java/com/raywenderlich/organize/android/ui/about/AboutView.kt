package com.raywenderlich.organize.android.ui.about

import android.text.format.DateUtils
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raywenderlich.organize.android.R
import com.raywenderlich.organize.android.helpers.getViewModel
import com.raywenderlich.organize.presentation.AboutViewModel

@Composable
fun AboutView(
  viewModel: AboutViewModel = getViewModel(),
  onUpButtonClick: () -> Unit
) {
  Column {
    Toolbar(onUpButtonClick = onUpButtonClick)
    ContentView(
      items = viewModel.items,
      footer = "This page was first opened ${
        DateUtils.getRelativeTimeSpanString(
          viewModel.firstOpen * 1000
        ).toString()
      }",
    )
  }
}

@Composable
private fun Toolbar(
  onUpButtonClick: () -> Unit,
) {
  TopAppBar(
    title = { Text(text = stringResource(R.string.about_device)) },
    navigationIcon = {
      IconButton(onClick = onUpButtonClick) {
        Icon(
          imageVector = Icons.Default.ArrowBack,
          contentDescription = stringResource(R.string.back_button_content_desc),
        )
      }
    }
  )
}

@Composable
private fun ContentView(
  items: List<AboutViewModel.RowItem>,
  footer: String,
) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
  ) {
    items(items) { row ->
      RowView(title = row.title, subtitle = row.subtitle)
    }
    item {
      Text(
        text = footer,
        style = MaterialTheme.typography.caption,
        textAlign = TextAlign.Center,
        modifier = Modifier
          .fillMaxWidth()
          .padding(8.dp),
      )
    }
  }
}

@Composable
private fun RowView(
  title: String,
  subtitle: String,
) {
  Column(modifier = Modifier.fillMaxWidth()) {
    Column(Modifier.padding(8.dp)) {
      Text(
        text = title,
        style = MaterialTheme.typography.caption,
        color = Color.Gray,
      )
      Text(
        text = subtitle,
        style = MaterialTheme.typography.body1,
      )
    }
    Divider()
  }
}

@Preview(showSystemUi = true)
@Composable
private fun RowViewPreview() {
  LazyColumn {
    items(5) {
      RowView(
        title = "Title",
        subtitle = "Subtitle",
      )
    }
  }
}
