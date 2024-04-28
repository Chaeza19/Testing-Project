package org.d3if3056.testing.ui.screen

import android.content.res.Configuration
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.d3if3056.testing.R
import org.d3if3056.testing.ui.theme.TestingTheme

@Composable
fun DisplayAlertDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit
){
    if (openDialog){
        AlertDialog(
            text = { Text(text = stringResource(id = R.string.pesan_hapus))},
            confirmButton = {
                TextButton(onClick = { onConfirmation() }) {
                    Text(text = stringResource(id = R.string.tombol_hapus))
                }
            },
            dismissButton ={
                TextButton(onClick = { onDismissRequest() }) {
                    Text(stringResource(R.string.tombol_batal))
                }
            },
            onDismissRequest = {onDismissRequest()}
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true) // Untuk Dark Mode (uiMode)
@Composable
fun DialogPreview() {
    TestingTheme {
        DisplayAlertDialog(
            openDialog = true,
            onDismissRequest = { /*TODO*/ },
            onConfirmation = {}
        )
    }
}