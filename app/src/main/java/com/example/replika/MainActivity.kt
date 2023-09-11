package com.example.replika

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.replika.composables.DroneAssistScreen
import com.example.replika.ui.theme.ReplikaTheme
import com.example.replika.composables.HomeScreen
import com.example.replika.composables.WhatsAppScreen
import com.example.replika.composables.YnabScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReplikaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Replika()
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Ynab : Screen("YNAB")
    object WhatsApp : Screen("WhatsApp")
    object DroneAssist : Screen("Drone Assist")
}


@Composable
fun Replika() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.DroneAssist.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                ynabScreen = { navController.navigate(Screen.Ynab.route) },
                whatsAppScreen = { navController.navigate(Screen.WhatsApp.route) },
                droneAssistScreen = {navController.navigate(Screen.DroneAssist.route)}
                )
        }
        composable(Screen.Ynab.route) { YnabScreen({ navController.navigate(Screen.Home.route) }) }
        composable(Screen.WhatsApp.route) { WhatsAppScreen { navController.navigate(Screen.Home.route) } }
        composable(Screen.DroneAssist.route) {DroneAssistScreen{ navController.navigate(Screen.Home.route)}}
    }
}
