package com.example.ucp2.ui.view.dosen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.ui.viewmodel.dosen.DosenEvent
import com.example.ucp2.ui.viewmodel.dosen.DosenVm
import com.example.ucp2.ui.viewmodel.dosen.FormErrorState
import com.example.ucp2.ui.widget.TopAppBar
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun FormDosen(
    dosenEvent: DosenEvent = DosenEvent(),
    onValueChange: (DosenEvent) -> Unit = {},
    errorState: FormErrorState = FormErrorState(),
    modifier: Modifier = Modifier
){
    val jenisKelamin = listOf("Laki-laki", "Perempuan")

    Column (
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = dosenEvent.nama,
            onValueChange = {
                onValueChange(dosenEvent.copy(nama = it))
            },
            label = { Text(text = "Nama") },
            isError = errorState.nama != null,
            placeholder = { Text(text = "Masukkan nama") },
        )
        Text(
            text = errorState.nama ?: "",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = dosenEvent.nidn,
            onValueChange = {
                onValueChange(dosenEvent.copy(nidn = it))
            },
            label = { Text(text = "NIDN") },
            isError = errorState.nidn != null,
            placeholder = { Text(text = "Masukkan NIDN") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(
            text = errorState.nidn ?: "",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Jenis Kelamin")
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            jenisKelamin.forEach { jk ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    RadioButton(
                        selected = dosenEvent.jenisKelamin == jk,
                        onClick = {
                            onValueChange(dosenEvent.copy(jenisKelamin = jk))
                        }
                    )
                    Text(text = jk)
                }
            }
        }
    }
}

@Composable
fun AddDosenView(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    onBack: () -> Unit = {},
    onClick: () -> Unit = {}
){

    Scaffold (
        modifier = modifier,
        topBar = {TopAppBar(
            onBack = onBack,
            showBackButton = true,
            judul = "Tambah Dosen",
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange
        )}
    ){ padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ){
            //isi Body
            FormDosen(
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simpan")
            }
        }
    }
}