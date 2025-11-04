package com.example.msd25_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.msd25_android.ui.theme.MSD25_AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MSD25_AndroidTheme {
                MSD25_AndroidApp()
            }
        }
    }
}

@Composable
fun MSD25_AndroidApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary,   // #2E6930
                contentColor = MaterialTheme.colorScheme.onPrimary    // #0F2310
            ) {
                AppDestinations.entries.forEach { destination ->
                    NavigationBarItem(
                        selected = destination == currentDestination,
                        onClick = { currentDestination = destination },
                        icon = {
                            Icon(
                                destination.icon,
                                contentDescription = destination.label,
                                tint = if (destination == currentDestination)
                                    MaterialTheme.colorScheme.onPrimary
                                else
                                    MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f)
                            )
                        },
                        label = {
                            Text(
                                destination.label,
                                color = if (destination == currentDestination)
                                    MaterialTheme.colorScheme.onPrimary
                                else
                                    MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f)
                            )
                        }
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background // #CCE7C9
    ) { innerPadding ->
        Greeting(
            name = "Julius",
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    FRIENDS("Friends", Icons.Default.Groups),
    HOME("Home", Icons.Default.Home),
    PROFILE("Profile", Icons.Default.AccountBox),
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MSD25_AndroidTheme {
        Greeting("Android")
    }
}
