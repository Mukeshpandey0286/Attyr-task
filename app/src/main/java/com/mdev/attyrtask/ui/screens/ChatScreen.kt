package com.mdev.attyrtask.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mdev.attyrtask.navigation.Screen
import com.mdev.attyrtask.ui.components.PrimaryButton
import com.mdev.attyrtask.ui.components.SecondaryButton
import com.mdev.attyrtask.ui.theme.LightPink
import com.mdev.attyrtask.ui.theme.Pink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navController: NavController) {
    var messageText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(0.dp)
    ) {
        // Top App Bar
        TopAppBar(
            title = {
                Text("Chat with stylist", color = Color.Black, style = MaterialTheme.typography.headlineLarge)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            ),
            actions = {
                IconButton(onClick = { /* Refresh */ }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh",
                        tint = Color.DarkGray
                    )
                }
                IconButton(onClick = { navController.navigate(Screen.ChatHistory.route) }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.DarkGray
                    )
                }
            }
        )

        Box(
            modifier = Modifier
//                .weight(.1f)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Chat content area
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                // User query chip
                Box(
                    modifier = Modifier
                        .align(Alignment.End)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Pink)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "jeans",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Assistant response (hidden)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, LightPink, RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Text(
                        text = "TEXT HIDDEN",
                        color = Pink,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.TopStart)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Response buttons
                PrimaryButton(
                    text = "That's perfect! Search the products",
                    onClick = { /* Handle click */ }
                )

                Spacer(modifier = Modifier.height(8.dp))

                SecondaryButton(
                    text = "Not quite right. Let me provide my inputs",
                    onClick = { /* Handle click */ }
                )
            }
        }

        // Message input
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Add attachment */ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add attachment",
                    tint = Color.DarkGray
                )
            }

            TextField(
                value = messageText,
                onValueChange = { messageText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Type a message...") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            IconButton(onClick = { /* Voice message */ }) {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "Voice message",
                    tint = Color.DarkGray
                )
            }

            IconButton(onClick = { /* Send message */ }) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send message",
                    tint = Color.DarkGray
                )
            }
        }
    }
}