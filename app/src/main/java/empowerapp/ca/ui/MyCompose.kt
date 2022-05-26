package empowerapp.ca.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import empowerapp.ca.ui.theme.EmpowerTheme


@Composable
fun MyCustomView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) { // <-- provide modifier
        Text("test") // <-- use the data class to populate

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmpowerTheme {
        Greeting("Android")
    }
}
