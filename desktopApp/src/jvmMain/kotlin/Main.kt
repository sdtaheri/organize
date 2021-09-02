
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.raywenderlich.organize.initKoin
import org.koin.core.Koin
import ui.AppScaffold

lateinit var koin: Koin

fun main() {
  koin = initKoin().koin

  return application {
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
        AppScaffold()
      }
    }
  }
}