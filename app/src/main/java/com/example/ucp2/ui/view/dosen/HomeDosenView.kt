package com.example.ucp2.ui.view.dosen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
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
fun HomeDosenView (
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    add: () -> Unit = {},
    onBack: () -> Unit = {},
){
    Scaffold(
        topBar = {
            TopAppBar(
                judul = "Daftar Dosen",
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
    ) { innerPadding ->
        BodyHomeMhsView(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun BodyHomeMhsView(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = Modifier.padding(16.dp)
    ){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "NIDN",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = "Nama",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(1.3f)
            )
            Text(
                text = "JK",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(0.2f)
            )
        }
        Divider(
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth()
        )
        ListDosen(
            modifier = Modifier
        )
    }
}

@Composable
fun ListDosen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(top = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "0011223344",
                fontSize = 20.sp,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = "0011223344",
                fontSize = 20.sp,
                modifier = Modifier.weight(1.3f)
            )
            Text(
                text = "L",
                fontSize = 20.sp,
                modifier = Modifier.weight(0.2f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "0011223344",
                fontSize = 20.sp,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = "0011223344",
                fontSize = 20.sp,
                modifier = Modifier.weight(1.3f)
            )
            Text(
                text = "L",
                fontSize = 20.sp,
                modifier = Modifier.weight(0.2f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "0011223344",
                fontSize = 20.sp,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = "0011223344",
                fontSize = 20.sp,
                modifier = Modifier.weight(1.3f)
            )
            Text(
                text = "L",
                fontSize = 20.sp,
                modifier = Modifier.weight(0.2f)
            )
        }
    }
}