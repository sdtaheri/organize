import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.raywenderlich.organize.presentation.Screen
import ui.about.AboutView
import ui.reminders.RemindersView

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
  var screenState by remember { mutableStateOf<Screen>(Screen.Reminders) }

  when (val screen = screenState) {
    is Screen.Reminders ->
      RemindersView(
        onAboutIconClick = { screenState = Screen.AboutDevice }
      )

    is Screen.AboutDevice ->
      AboutView(
        onUpButtonClick = { screenState = Screen.Reminders }
      )
  }
}
