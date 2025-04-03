package com.mdev.attyrtask.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mdev.attyrtask.model.CategoryItem
import com.mdev.attyrtask.model.FeaturedItem
import com.mdev.attyrtask.ui.components.CategoryCard
import com.mdev.attyrtask.ui.components.CategoryChip
import com.mdev.attyrtask.ui.components.FeaturedCard
import com.mdev.attyrtask.ui.theme.*
import com.mdev.attyrtask.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    // State for the search text
    var searchText by remember { mutableStateOf("") }
    // State for the selected category chip
    var selectedChipIndex by remember { mutableStateOf(0) }

    // Sample data matching the screenshot
    val categoryChips = listOf(
        "🌸 Floral Midi Dresses",
        "🌞 Boho Summer Tops",
        "👗 Evening Wear"
    )

    val featuredItems = listOf(
        FeaturedItem(1, "Luxury Essentials", "Premium wardrobe staples", Pink),
        FeaturedItem(2, "Statement Pieces", "Bold fashion elements", Blue),
        FeaturedItem(3, "New Arrivals", "Just landed this week", Green)
    )

    val categoryItems = listOf(
        CategoryItem(1, "Summer Breezy Essentials", "Linen dresses, crop tops, maxi skirts", R.drawable.category1),
        CategoryItem(2, "Wedding Glam Galore", "Sequined lehengas, silk sarees, jewelry", R.drawable.category2),
        CategoryItem(3, "Office Elegance Edit", "Tailored kurtas, stitched salwars, block prints", R.drawable.category1),
        CategoryItem(4, "Weekend Casual Vibes", "Denim shorts, graphic tees, casual wear", R.drawable.category2),
        CategoryItem(5, "Campus Trendy Threads", "Printed kurtas, denims, tees, trendy tops", R.drawable.category1),
        CategoryItem(6, "Beachy Goa Getaways", "Flowy sundresses, shades, hats, coverups", R.drawable.category2),
        CategoryItem(7, "Kashmir Escape Essentials", "Wool sweaters, embroidery shawls, flannel layers", R.drawable.category1),
        CategoryItem(8, "Traditional Diwali", "Designer sarees, heavy embroidery, festive looks", R.drawable.category2)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        // App Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "SHOPP",
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Your personal fashion stylist",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Magenta
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .clip(Shapes.medium),
            placeholder = { Text("Search for an outfit or tag someone", style = MaterialTheme.typography.bodyLarge) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Gray
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Filter",
                    tint = Color.Gray
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Category Chips - matching the screenshot
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(categoryChips) { chip ->
                val index = categoryChips.indexOf(chip)
                CategoryChip(
                    text = chip,
                    isSelected = index == selectedChipIndex,
                    onClick = { selectedChipIndex = index }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Recommended For You Section - matches the screenshot
        Text(
            text = "Recommended for you",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Featured Cards Carousel
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.height(180.dp)
        ) {
            items(featuredItems) { item ->
                FeaturedCard(
                    featuredItem = item,
                    onClick = { /* Handle click */ }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Browse by Category - matches the screenshot
        Text(
            text = "Browse by Category",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Category Grid - matches the screenshot layout
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            items(categoryItems) { category ->
                CategoryCard(
                    categoryItem = category,
                    onClick = { /* Handle click */ }
                )
            }
        }
    }
}