package com.example.perfilesacero

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.perfilesacero.ui.screens.LoginScreen
import com.example.perfilesacero.ui.screens.ProductDetailScreen
import com.example.perfilesacero.ui.screens.ProductScreen
import com.example.perfilesacero.ui.screens.UserProfileScreen
import com.example.perfilesacero.ui.theme.PerfilesaceroTheme
import com.example.perfilesacero.ui.viewmodels.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createNotificationChannel()
        setContent {
            PerfilesaceroTheme {
                AppNavigation()
            }
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Product Notifications"
            val descriptionText = "Notifications for product updates"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("PRODUCT_CHANNEL", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val productViewModel: ProductViewModel = viewModel()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("user_profile") { UserProfileScreen(navController) }
        composable("products") { ProductScreen(navController, productViewModel) }
        composable("product_detail") { ProductDetailScreen(navController, productViewModel) }
    }
}
