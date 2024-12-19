package com.example.ucp2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2.ui.view.MainView
import com.example.ucp2.ui.view.dosen.HomeDosenView

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
                onItemClick = {
                    navController.navigate(it)
                }
            )
        }
        composable(
            route = DosenNavigasi.route
        ){
            HomeDosenView(
                isDarkTheme = isDarkTheme,
                onThemeChange = onThemeChange,
                onBack = {
                    navController.popBackStack()
                },
                add = {
                }
            )
        }
        composable(
            route = MatakuliahNavigasi.route
        ){

        }
    }
}
