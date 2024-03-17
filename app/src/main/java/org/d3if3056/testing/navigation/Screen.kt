package org.d3if3056.testing.navigation

sealed class Screen (val route: String){
    data object Home: Screen("mainScreen")
}