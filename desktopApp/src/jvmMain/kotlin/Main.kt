
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
  Window(
    title = "Organize",
    state = WindowState(width = 300.dp, height = 450.dp),
    icon = BitmapPainter(
      useResource(
        "ic_launcher.png",
        ::loadImageBitmap
      )
    ),
    resizable = true,
    onCloseRequest = ::exitApplication,
  ) {
    DesktopMaterialTheme {
      Box(modifier = Modifier.fillMaxSize()) {
        Text("Hello Organize", modifier = Modifier.align(Alignment.Center))
      }
    }
  }
}