package com.example.ucp2.ui.navigation

interface AlamatNavigasi {
    val route: String
}
object DestinasiMain : AlamatNavigasi {
    override val route: String = "home"
}