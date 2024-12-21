package com.example.ucp2.ui.view.matakuliah

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp2.ui.widget.TopAppBar

@Composable
fun HomeMatakuliah(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    add: () -> Unit = {},
    onBack: () -> Unit = {},
){
    Scaffold(
        topBar = {
            TopAppBar(
                judul = "Daftar Matakuliah",
                showBackButton = true,
                isDarkTheme = isDarkTheme,
                onThemeChange = onThemeChange,
                onBack = onBack
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = add,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Dosen"
                )
            }
        }
    ){
        innerPadding ->
        BodyHomeMkView(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun BodyHomeMkView(
    modifier: Modifier
){
    Column(
        modifier = modifier.padding(16.dp)
            .padding(bottom = 60.dp)
            .verticalScroll(rememberScrollState())
    ) {
        CardMk()
        CardMk()
        CardMk()
    }
}

@Composable
fun CardMk(){
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Test123qydewvcwveycqevcqgwqliudgvhuiugfcghuhghjigfvbjugvbjhb",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    "Kode",
                    modifier = Modifier.weight(4f)
                )
                val test = "qwerty"
                Text(
                    text = "mhs.nim${test}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(7f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    "Dosen Pengampu",
                    modifier = Modifier.weight(4f),
                )
                Text(
                    text = "mhs.nimafefqfq2453h6442t53g23r24fwet3t53",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(7f)
                )
            }
        }
    }
}