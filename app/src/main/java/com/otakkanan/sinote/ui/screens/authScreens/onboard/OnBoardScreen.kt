package com.otakkanan.sinote.ui.screens.authScreens.onboard

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.components.SinglePage
import com.otakkanan.sinote.ui.components.mockNavController
import com.otakkanan.sinote.ui.components.pages
import com.otakkanan.sinote.ui.navigations.Screen
import com.otakkanan.sinote.ui.theme.SiNoteTheme
import com.otakkanan.sinote.ui.theme.color_primary2_200
import com.otakkanan.sinote.ui.theme.color_primary_600
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardScreen(navController: NavController) {
    val pagerState: PagerState = rememberPagerState(pageCount = { pages.size })
    val coroutineScope = rememberCoroutineScope()

    var box1State by remember { mutableStateOf(true) }
    var box2State by remember { mutableStateOf(false) }
    var box3State by remember { mutableStateOf(false) }

    LaunchedEffect(pagerState) {
        while(true) {
            yield()
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % pages.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            when(page) {
                0 -> {
                    box1State = true
                    box2State = false
                    box3State = false
                }
                1 -> {
                    box1State = false
                    box2State = true
                    box3State = false
                }
                2 -> {
                    box1State = false
                    box2State = false
                    box3State = true
                }
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 64.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalPager(
                state = pagerState
            ) { pageIndex ->
                SinglePage(page = pages[pageIndex])
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .height(IntrinsicSize.Max)
        ) {
            val box1Width by animateDpAsState(if (box1State) 30.dp else 8.dp, label = "Box1 width change")
            val box1Color by animateColorAsState(if (box1State) color_primary_600 else color_primary2_200, label = "Box1 color change")
            val box2Width by animateDpAsState(if (box2State) 30.dp else 8.dp, label = "Box2 width change")
            val box2Color by animateColorAsState(if (box2State) color_primary_600 else color_primary2_200, label = "Box2 color change")
            val box3Width by animateDpAsState(if (box3State) 30.dp else 8.dp, label = "Box3 width change")
            val box3Color by animateColorAsState(if (box3State) color_primary_600 else color_primary2_200, label = "Box3 color change")

            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .height(8.dp)
                    .width(box1Width)
                    .clip(CircleShape)
                    .background(box1Color)
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .height(8.dp)
                    .width(box2Width)
                    .clip(CircleShape)
                    .background(box2Color)
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .height(8.dp)
                    .width(box3Width)
                    .clip(CircleShape)
                    .background(box3Color)
            )
        }
        Button(
            onClick = {
                navController.navigate(Screen.Login.route)
            },
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .padding(top = 8.dp)
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
        ) {
            Text(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                text = stringResource(id = R.string.lanjut)
            )
        }

        Button(
            onClick = {
                navController.navigate("catatan_route") {
                    popUpTo("catatan_route") {
                        inclusive = true
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
        ) {
            Text(
                text = AnnotatedString(stringResource(id = R.string.lewati)),
                style = TextStyle(
                    color = color_primary_600,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .height(IntrinsicSize.Max)
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardScreenPreview() {
    SiNoteTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            OnBoardScreen(navController = mockNavController())
        }
    }
}