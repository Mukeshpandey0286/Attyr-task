package com.mdev.attyrtask.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mdev.attyrtask.ui.screens.ChatHistoryScreen
import com.mdev.attyrtask.ui.screens.ChatScreen
import com.mdev.attyrtask.ui.screens.HomeScreen
import com.mdev.attyrtask.ui.theme.Pink

// Navigation routes
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Chat : Screen("chat")
    object ChatHistory : Screen("chat_history")
    object Profile : Screen("profile")
    object Likes : Screen("likes")
    object Bag : Screen("bag")
}

@Composable
fun ShoppingNavHost(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(Screen.Chat.route) {
                ChatScreen(navController)
            }

            composable(Screen.ChatHistory.route) {
                ChatHistoryScreen(navController)
            }

            // Add placeholder screens for other routes if needed
            composable(Screen.Profile.route) {
                // ProfileScreen implementation
                Box(modifier = Modifier.fillMaxSize()) {
                    Text("Profile Screen", modifier = Modifier.align(Alignment.Center))
                }
            }

            composable(Screen.Likes.route) {
                // LikesScreen implementation
                Box(modifier = Modifier.fillMaxSize()) {
                    Text("Likes Screen", modifier = Modifier.align(Alignment.Center))
                }
            }

            composable(Screen.Bag.route) {
                // BagScreen implementation
                Box(modifier = Modifier.fillMaxSize()) {
                    Text("Bag Screen", modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination

        // Shop item
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Shop"
                )
            },
            label = { Text("Shop") },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Home.route } == true,
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

        // Bag item
        NavigationBarItem(
            icon = {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Pink, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "1",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            },
            label = { Text("Bag") },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Bag.route } == true,
            onClick = {
                navController.navigate(Screen.Bag.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

        // AI Chat item (in the center)
        NavigationBarItem(
            icon = {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Pink, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "AI",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            },
            label = null,
            selected = currentDestination?.hierarchy?.any {
                it.route == Screen.Chat.route || it.route == Screen.ChatHistory.route
            } == true,
            onClick = {
                navController.navigate(Screen.Chat.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

        // Likes item
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Likes"
                )
            },
            label = { Text("Likes") },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Likes.route } == true,
            onClick = {
                navController.navigate(Screen.Likes.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

        // Profile item
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile"
                )
            },
            label = { Text("Profile") },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Profile.route } == true,
            onClick = {
                navController.navigate(Screen.Profile.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}