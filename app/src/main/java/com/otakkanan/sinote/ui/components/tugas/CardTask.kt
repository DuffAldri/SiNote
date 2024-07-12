package com.otakkanan.sinote.ui.components.tugas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_primary2_400
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_primary_600
import com.otakkanan.sinote.ui.theme.color_tugas_olahraga
import com.otakkanan.sinote.ui.theme.color_tugas_pekerjaan
import com.otakkanan.sinote.ui.theme.color_tugas_progress
import com.otakkanan.sinote.ui.theme.color_tugas_sekolah

@Composable
fun CardTask(
    cardTaskData: CardTaskData,
    modifier: Modifier = Modifier
) {
    val cat_color =
        if(cardTaskData.category == "Pekerjaan") {
            color_tugas_pekerjaan
        } else if(cardTaskData.category == "Sekolah") {
            color_tugas_sekolah
        } else {
            color_tugas_olahraga
        }
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = cardTaskData.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
//                modifier = Modifier.fillMaxWidth()
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier
                .offset(y = (-2).dp)
                .size(10.dp)
                .clip(CircleShape)
                .background(cat_color)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = cardTaskData.date,
                style = MaterialTheme.typography.bodyMedium,
                color = color_primary2_400
            )
            Text(
                text = cardTaskData.time,
                style = MaterialTheme.typography.bodyMedium,
                color = color_primary2_400
            )
        }
        if(cardTaskData.memberImages.isNotEmpty()) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                cardTaskData.memberImages.forEachIndexed { index, avatarId ->
                    Box(
                        modifier = Modifier
                            .offset(x = (index * -5).dp) // Controls the overlap; adjust the multiplier as needed
                            .size(25.dp) // Adjust size as necessary
                            .clip(CircleShape) // Ensures the image has circular shape
                    ) {
                        Image(
                            painter = painterResource(id = avatarId),
                            contentDescription = "Avatar $index",
                            contentScale = ContentScale.Crop // Ensures the image fills the box, cropping if necessary
                        )
                    }
                }
            }
        }
        if(cardTaskData.isProgress) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                val percentage = (cardTaskData.progress * 100).toInt()

                LinearProgressIndicator(
                    progress = cardTaskData.progress,
                    color = color_tugas_progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .height(8.dp)
                        .clip(RoundedCornerShape(16.dp)),
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "$percentage%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = color_primary2_400
                )
            }
        }
    }
}

@Preview
@Composable
fun CardTaskPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            CardTask(
                cardTaskData =
                    CardTaskData(
                        title = "Memulai Pemrograman dengan Kotlin Kotlin Kotlin",
                        date = "Rabu, 24 Agustus 2022",
                        time = "22.15 WIB",
                        category = "Pekerjaan",
                        isProgress = true,
                        progress = 0.8f,
                        memberImages = listOf(R.drawable.member_image, R.drawable.member_image, R.drawable.member_image)
                    )
            )
        }
    }
}

data class CardTaskData(
    val title: String,
    val date: String,
    val time: String,
    val isProgress: Boolean,
    val progress: Float,
    val category: String,
//    val memberImages: List<Int> = listOf(R.drawable.member_image, R.drawable.member_image, R.drawable.member_image), // Bisa disesuaikan nantinya
    val memberImages: List<Int> = listOf(), // Bisa disesuaikan nantinya
)