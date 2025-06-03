package com.example.artspace.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.R
import com.example.artspace.ui.theme.ArtSpaceTheme


@Composable
fun ArtWorkDescriptor(
    modifier: Modifier = Modifier,
    descriptionOfImage: String,
    dateOfImage: String
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(Color.White)
    ){
        Box(
           contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.card_to_write_text_on),
                contentDescription = "Descriptor Card",
                modifier = Modifier
                    .padding(16.dp)
                    .width(358.dp)
                    .height(222.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .padding(top = 9.dp,bottom = 123.dp, start = 29.dp)
                    .width(358.dp)
                    .height(90.dp)
            ) {
                Text(
                    text = descriptionOfImage,
                    color = Color(0xFFFFFFFF),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    dateOfImage,
                    color = Color(0xFFFFFFFF),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
fun DisplayController(
    modifier: Modifier = Modifier,
    onNextClick:() -> Unit,
    onPreviousClick:() -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {onPreviousClick()},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFF4F2EF)),
            modifier = Modifier.padding(start = 16.dp)

        ) {
            Text("Previous", color = Color.Black)
        }
        Button(
            onClick = {onNextClick()},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFEAE2C4)),
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Text("Next", color = Color.Black)
        }
    }
}

@Composable
fun ArtWorkWall(
    modifier: Modifier = Modifier,
    picture: Int
) {
    val softBeige = Color(0xFFE9DED5) // Muted beige shade
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(start = 48.dp, end = 48.dp)
            .background(color = softBeige),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(3.dp, Color(0xFFD4AF37)), // Gold-like frame
            elevation = CardDefaults.elevatedCardElevation(),
            modifier = Modifier.padding(16.dp).wrapContentSize()
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFFE9DED5)) // Soft beige backdrop
                    .padding(8.dp)
                    .wrapContentSize()
            ) {
                Image(
                    painter = painterResource(id = picture),
                    contentDescription = "Artwork",
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtSpaceComponentPreview() {
    ArtSpaceTheme {
        ArtWorkWall(
//            modifier = TODO(),
            picture = R.drawable.photo_kaustubh
        )
    }
}