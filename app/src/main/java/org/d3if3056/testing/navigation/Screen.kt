package org.d3if3056.testing.navigation

import org.d3if3056.testing.ui.screen.KEY_ID_MAHASISWA

sealed class Screen(val route: String){
    data object Home: Screen("mainScreen")
    data object FormMahasiswa: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_MAHASISWA}"){
        fun withId(id: Long) = "detailScreen/$id"
    }
}