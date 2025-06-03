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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.components.ArtWorkDescriptor
import com.example.artspace.components.ArtWorkWall
import com.example.artspace.components.DisplayController
import com.example.artspace.ui.theme.ArtSpaceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceScreen() {
    Scaffold(
        topBar = {
             CenterAlignedTopAppBar(
                title = { Text("ArtSpace", style =  MaterialTheme.typography.headlineMedium) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ArtWorkWall(modifier = Modifier.weight(0.5f))
            Spacer(modifier = Modifier.height(10.dp))
            ArtWorkDescriptor(modifier = Modifier.weight(0.3f))
            Spacer(modifier = Modifier.height(10.dp))
            DisplayController(modifier = Modifier.weight(0.1f))
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
