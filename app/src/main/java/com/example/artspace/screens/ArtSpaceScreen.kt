package com.example.artspace.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.R
import com.example.artspace.components.ArtWorkDescriptor
import com.example.artspace.components.ArtWorkWall
import com.example.artspace.components.DisplayController
import com.example.artspace.ui.theme.ArtSpaceTheme
import kotlin.math.sign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceScreen() {
    Scaffold(
        topBar = {
             CenterAlignedTopAppBar(
                title = { Text("Kaustubh Deshpande", style =  MaterialTheme.typography.headlineMedium, fontStyle = FontStyle.Italic) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                )
            )
        }
    ) { innerPadding ->

        var currentIndex by remember { mutableStateOf(0)}
//        var descriptionOfImage by remember { mutableStateOf(currentIndex) }
//        var dateOfImage by remember { mutableStateOf(currentIndex) }
        val descriptionOfImage = listOf<String>(
            "A month before going to Kota on his birthday"
            ,"During his early days in Kota"
            ,"Winter of Kota and during his Practical submissions"
            ,"His last board exam"
            ,"In his present time"
        )
        val dateOfImage = listOf(
            "Feb,15,2022"
            ,"Aug,12,2022"
            ,"Jan,06,2023"
            ,"March,13,2023"
            ,"June,02,2024"
        )
        val currentImage = listOf(
            R.drawable.photo_kaustubh_before_going_to_kota,
            R.drawable.photo_kaustubh_during_his_stay_in_kota,
            R.drawable.photo_kaustubh_during_practical,
            R.drawable.photo_kaustubh_last_exam,
            R.drawable.photo_kaustubh
        )
        
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ArtWorkWall(
                modifier = Modifier.weight(0.5f),
                picture = currentImage[currentIndex]
            )
            Spacer(modifier = Modifier.height(10.dp))
            ArtWorkDescriptor(
                modifier = Modifier.weight(0.3f),
                descriptionOfImage = descriptionOfImage[currentIndex],
                dateOfImage = dateOfImage[currentIndex]
            )
            Spacer(modifier = Modifier.height(10.dp))
            DisplayController(
                modifier = Modifier.weight(0.1f),
                onNextClick = {currentIndex = (currentIndex + 1) % currentImage.size}, // also possible currentIndex = (currentIndex + 1).coerceAtMost(images.size - 1)
                onPreviousClick = {currentIndex = (currentIndex -1 + currentImage.size) % currentImage.size} // also possible currentIndex = (currentIndex - 1).coerceAtLeast(0)}
            )
        }
    }
}

@Preview
@Composable
fun ArtSpaceScreenPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}
