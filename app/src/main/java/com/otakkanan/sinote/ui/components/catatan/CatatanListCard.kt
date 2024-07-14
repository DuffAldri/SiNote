package com.otakkanan.sinote.ui.components.catatan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otakkanan.sinote.ui.components.PreviewTemplateMaxSize
import com.otakkanan.sinote.ui.components.PreviewTemplateMaxWidth

@Composable
fun CatatanListCard(
    catatanDataClass: CatatanDataClass
) {
    Column(
        modifier = Modifier
            .clickable {

            }
            .clip(RoundedCornerShape(8.dp))
            .height(224.dp)
            .background(color = catatanDataClass.priority.bgColor)
            .fillMaxWidth()
    ) {
        Column (
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = catatanDataClass.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = catatanDataClass.content,
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis
            )
        }
        if(catatanDataClass.priority != CatatanPriority.NONE) {
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(color = catatanDataClass.priority.priorityColor)
                    .padding(horizontal = 8.dp)
                    .height(32.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = catatanDataClass.priority.priority,
                    style = MaterialTheme.typography.bodySmall,
                    color = catatanDataClass.priority.priorityTextColor
                )
            }
        }
    }
}

@Preview
@Composable
fun CatatanListCardPreview() {
    PreviewTemplateMaxSize {
        Row {
            CatatanListCard(catatanDataClass = CatatanDataDummies.catatanList[0])
        }
    }
}