package com.mdev.attyrtask.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mdev.attyrtask.model.ChatHistoryItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatHistoryScreen(navController: NavHostController) {
    // Sample data based on the screenshot
    val chatHistory = listOf(
        ChatHistoryItem(1, "jeans", "15:34"),
        ChatHistoryItem(2, "jeans", "15:34"),
        ChatHistoryItem(3, "jeans", "15:33"),
        ChatHistoryItem(4, "jeans", "15:32"),
        ChatHistoryItem(5, "jeans", "14:44"),
        ChatHistoryItem(6, "tank top", "04:01"),
        ChatHistoryItem(7, "Uploaded an image", "04:01", true),
        ChatHistoryItem(8, "Uploaded an image", "04:00", true),
        ChatHistoryItem(9, "jeans", "03:59")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top App Bar
        TopAppBar(
            title = {
                Text("Chat History", color = Color.Black, style = MaterialTheme.typography.headlineMedium,)
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            )
        )

        // Chat history list
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(chatHistory) { item ->
                ChatHistoryItem(item)
                Divider(
                    color = Color.LightGray,
                    thickness = 0.5.dp,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
        }
    }
}

@Composable
fun ChatHistoryItem(item: ChatHistoryItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.message,
            color = Color.Black
        )
        Text(
            text = item.timestamp,
            color = Color.Gray
        )
    }
}