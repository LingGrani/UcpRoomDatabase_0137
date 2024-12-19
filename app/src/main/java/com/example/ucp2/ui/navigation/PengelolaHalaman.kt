package com.example.ucp2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2.ui.view.MainView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
){
    NavHost(
        navController = navController,
        startDestination = DestinasiMain.route
    ){
        composable(
            route = DestinasiMain.route
        ) {
            MainView(
                isDarkTheme = isDarkTheme,
                onThemeChange = onThemeChange,
            )
        }
    }
}
