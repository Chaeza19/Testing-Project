package org.d3if3056.testing.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3056.testing.R
import org.d3if3056.testing.model.Mahasiswa
import org.d3if3056.testing.navigation.Screen
import org.d3if3056.testing.ui.theme.TestingTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {

    Scaffold(
        topBar = { //Untuk Bagian TopBar
            TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.FormMahasiswa.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(id = R.string.tambah_mahasiswa)
                )
            }
        }
    ) { padding ->
        ScreenContent(Modifier.padding(padding), navController)
    }
}

@Composable
fun ScreenContent(modifier: Modifier, navController: NavHostController){
    val viewModel: MainViewModel = viewModel()
    val data = viewModel.data
//    val data = emptyList<Catatan>() // jika datanya kosong

    if (data.isEmpty()){
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.list_kosong))
        }
    }
    else{
        LazyColumn (
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 84.dp)
        ){
            items(data){
                ListItem(mahasiswa = it){
                    navController.navigate(Screen.FormUbah.withId(it.id))
                }
                Divider()
            }
        }
    }

}

@Composable
fun ListItem(mahasiswa: Mahasiswa, onClick: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = mahasiswa.nama,
            maxLines = 1, //maxLines = maksimal 1 baris
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold //mempertebal tulisan
        )
        Text(text = mahasiswa.nim,
            maxLines = 2, //maxLines = maksimal 2 baris
            overflow = TextOverflow.Ellipsis
        )
        Text(text = mahasiswa.kelas)
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true) // Untuk Dark Mode (uiMode)
@Composable
fun GreetingPreview() {
    TestingTheme {
        MainScreen(rememberNavController())
    }
}