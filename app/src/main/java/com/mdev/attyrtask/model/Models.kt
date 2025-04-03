package com.mdev.attyrtask.model

data class CategoryItem(
    val id: Int,
    val title: String,
    val description: String,
    val imageResId: Int
)

data class FeaturedItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val backgroundColor: androidx.compose.ui.graphics.Color
)

data class ChatHistoryItem(
    val id: Int,
    val message: String,
    val timestamp: String,
    val isImage: Boolean = false
)