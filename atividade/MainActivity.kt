package com.example.composenavigationapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.composenavigationapp.ui.theme.ComposeNavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "screen_a"
    ) {
        composable("screen_a") {
            ScreenA(navController)
        }
        composable("screen_b") {
            ScreenB(navController, "Olá da Tela A")
        }
    }
}


@Composable
fun ScreenA(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "bem vindos a página inicial do nosso site")
        Button(onClick = { navController.navigate("screen_b") }) {
            Text("entrar")
        }
    }
}

@Composable
fun ScreenB(navController: NavController, message: String?) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Esta é a Tela B")
        message?.let { Text(text = "seja bem vindo: $it") }
        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar para pagina inicial")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    ScreenA(rememberNavController())
}


@Preview(showBackground = true)
@Composable
fun ScreenBPreview() {
    ScreenB(rememberNavController(), "Olá da Tela A")
}
    
