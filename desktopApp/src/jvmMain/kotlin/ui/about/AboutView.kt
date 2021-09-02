package ui.about

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.raywenderlich.organize.presentation.AboutViewModel
import koin

@Composable
fun AboutView(
  viewModel: AboutViewModel = koin.get(),
  onUpButtonClick: () -> Unit
) {
  Column {
    Toolbar(onUpButtonClick = onUpButtonClick)
    ContentView(
      items = viewModel.items,
      footer = "This page was first opened ${viewModel.firstOpen * 1000}",
    )
  }
}

@Composable
private fun Toolbar(
  onUpButtonClick: () -> Unit,
) {
  TopAppBar(
    title = { Text(text = "About Device") },
    navigationIcon = {
      IconButton(onClick = onUpButtonClick) {
        Icon(
          imageVector = Icons.Default.ArrowBack,
          contentDescription = "Up Button",
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
        modifier = Modifier.fillMaxWidth().padding(8.dp),
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
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(8.dp)
    ) {
      Text(
        text = title,
        style = MaterialTheme.typography.caption,
        color = Color.Gray,
        modifier = Modifier.weight(1f)
      )
      Text(
        text = subtitle,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(8.dp)
      )
    }
    Divider()
  }
}

@Preview
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
