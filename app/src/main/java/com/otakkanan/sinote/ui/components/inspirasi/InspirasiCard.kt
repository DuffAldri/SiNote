package com.otakkanan.sinote.ui.components.inspirasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.theme.color_primary2_200

@Composable
fun InspirasiCard(
    inspirasiDataClass: InspirasiDataClass
) {
    Column {


        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Column(
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = inspirasiDataClass.profilePicture),
                    contentDescription = "${inspirasiDataClass.name}'s profile picture",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(
                        text = inspirasiDataClass.name,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = inspirasiDataClass.username,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Light
                    )
                }
                Row() {
                    Text(
                        text = inspirasiDataClass.post,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    inspirasiDataClass.postImage?.let { painterResource(id = it) }?.let {
                        Image(
                            painter = it,
                            contentDescription = "Image post",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(5.dp))
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(onClick = {}, modifier = Modifier.size(32.dp).offset(x=-6.dp)) {
                        Icon(painterResource(id = R.drawable.share), contentDescription = null)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(onClick = {}, modifier = Modifier.size(32.dp)) {
                            Icon(
                                painterResource(id = R.drawable.thumbs_up),
                                contentDescription = null
                            )
                        }
                        Text(
                            text = inspirasiDataClass.likeCount.toString(),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(onClick = {}, modifier = Modifier.size(32.dp)) {
                            Icon(painterResource(id = R.drawable.view), contentDescription = null)
                        }
                        Text(
                            text = inspirasiDataClass.viewCount.toString(),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

            }
        }
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Divider(
                thickness = 0.5.dp,
                color = color_primary2_200,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun InspirasiCardPreview() {
    MaterialTheme {
        Surface (
            modifier = Modifier.fillMaxSize()
        ) {
            InspirasiCard(inspirasiDataDummy)
        }
    }
}