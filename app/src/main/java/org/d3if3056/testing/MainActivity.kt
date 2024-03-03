package org.d3if3056.testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import org.d3if3056.testing.ui.theme.TestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun HitungButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Hitung + 1")
    }
}

@Composable
fun MainScreen() {
    var hitung = 0
    Column {
        HitungButton { Column
            hitung++
        }
        Text(text = "Hasil hitungan: $hitung")
    }
}
