package com.example.virginmoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.virginmoney.navigation.BottomNavigationBar
import com.example.virginmoney.navigation.NavigationGraph
import com.example.virginmoney.ui.theme.PrimaryColor
import com.example.virginmoney.ui.theme.VirginMoneyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VirginMoneyTheme {
                val navController = rememberNavController()
                Scaffold (
                    contentColor = PrimaryColor,
                    bottomBar = { BottomNavigationBar(navController) }
                ) { paddingValues ->
                    NavigationGraph(navController)
                }
            }
        }
        }
    }

@Preview(showBackground = true)
@Composable
fun NavigationGraphPreview() {
    NavigationGraph(rememberNavController())
}