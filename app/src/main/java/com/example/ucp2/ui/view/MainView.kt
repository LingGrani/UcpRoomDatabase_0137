package com.example.ucp2.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp2.R
import com.example.ucp2.ui.widget.TopAppBar

@Composable
fun MainView(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    onItemClick: (String) -> Unit
){
    val menuItems = listOf(
        MenuItem(
            text = "Dosen",
            painter = painterResource(id = R.drawable.lecture),
            route = "Dosen"
        ),
        MenuItem(
            text = "Matakuliah",
            painter = painterResource(id = R.drawable.book),
            route = "Matakuliah"
        )
    )
    Scaffold(
        topBar = {
            TopAppBar(
                isDarkTheme = isDarkTheme,
                onThemeChange = onThemeChange,
                showBackButton = false,
                judul = "Home",
                onBack = {}
            )
        }
    ){
            innerPadding ->
        LazyColumn (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
        ){
            items(menuItems) { menuItem ->
                MainIcon(
                    painter = menuItem.painter,
                    text = menuItem.text,
                    click = {
                        onItemClick(menuItem.route)
                    }
                )
            }
        }
    }

}

@Composable
fun MainIcon(
    painter: Painter,
    modifier: Modifier = Modifier,
    text: String = "",
    click: () -> Unit = {}
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(24.dp))
            .clickable {
                click()
            }
            .padding(16.dp)
    ){
        Box (
            modifier = Modifier
                .padding(end = 16.dp)
                .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(24.dp))
        ){
            Icon(painter,
                contentDescription = "",
                modifier = Modifier.size(84.dp).padding(8.dp),
                tint = MaterialTheme.colorScheme.surface
            )
        }
        Text(
            text,
            fontSize = 48.sp,
            lineHeight = 48.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium
        )
    }
}

data class MenuItem(
    val text: String,
    val painter: Painter,
    val route: String
)