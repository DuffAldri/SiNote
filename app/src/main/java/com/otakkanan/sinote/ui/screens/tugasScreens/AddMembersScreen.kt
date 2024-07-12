package com.otakkanan.sinote.ui.screens.tugasScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.tugas.MemberDataClass
import com.otakkanan.sinote.ui.components.tugas.membersDummy
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_primary2_200
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_primary_600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMembersScreen(navController: NavController) {
    var numMembers by remember { mutableStateOf(0) }
    val members = membersDummy
    val checkedState = remember { mutableStateMapOf<String, Boolean>().apply {
        members.forEach { this[it.name] = false }
    } }
    var allCheckedState by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    text = "Tambah Anggota ($numMembers)",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = color_primary2_700,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                actions = {
                    Text(
                        text = "Selesai",
                        color = color_primary_600,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            )
        },
        modifier = Modifier
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(intrinsicSize = IntrinsicSize.Min).padding(start = 16.dp, end = 8.dp)
                ) {
                    Text(text = "Pilih semua")
                    Spacer(modifier = Modifier.width(8.dp))
                    Checkbox(
                        checked = allCheckedState,
                        onCheckedChange = {newAllCheck ->
                                          checkedState.keys.forEach {
                                              allCheckedState = newAllCheck
                                              checkedState[it] = allCheckedState
                                          }
                          },
//                        colors = CheckboxDefaults.colors(
//                            uncheckedColor = color_primary_600,
//                            checkedColor = color_primary_600
//                        ),
                    )

                }
            }
            items(members) { member ->
                MemberCard(
                    memberDataClass = member,
                    isChecked = checkedState[member.name] ?: false,
                    onCheckedChange = { isChecked ->
                        checkedState[member.name] = isChecked
                        allCheckedState = false
                        numMembers = checkedState.count {it.value}
                    }
                )
            }
        }
    }
}

@Composable
fun MemberCard(
    memberDataClass: MemberDataClass,
    isChecked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 16.dp, end = 8.dp)
    ) {
        Image(
            painter = painterResource(id = memberDataClass.picture),
            contentDescription = "${memberDataClass.name}'s profile picture",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = memberDataClass.name,
            modifier = Modifier.weight(1f),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Checkbox(
            checked = isChecked,
            onCheckedChange = { onCheckedChange(it) },
            colors = CheckboxDefaults.colors(
                uncheckedColor = color_primary_600,
                checkedColor = color_primary_600
            ),
        )
    }
    Divider(
        thickness = 0.5.dp,
        color = color_primary2_200,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Preview
@Composable
fun MemberCardPreview() {
    SiNoteTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize()
        ) {
            MemberCard(membersDummy[0])
        }
    }
}

@Preview
@Composable
fun AddMembersScreenPreview() {
    SiNoteTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize()
        ) {
            AddMembersScreen(navController = mockNavController())
        }
    }
}