package com.otakkanan.sinote.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.otakkanan.sinote.R
import com.otakkanan.sinote.ui.theme.color_primary2_700
import com.otakkanan.sinote.ui.theme.color_primary_800

class Page(
    @DrawableRes val image: Int,
    @StringRes val text1: Pair<Int, Color>,
    @StringRes val text2: Pair<Int, Color>
)

val pages = listOf(
    Page(
        image = R.drawable.onboarding_1,
        text1 = Pair(R.string.onboard_description_1_red, color_primary_800),
        text2 = Pair(R.string.onboard_description_1_black, color_primary2_700)
    ),
    Page(
        image = R.drawable.onboarding_2,
        text1 = Pair(R.string.onboard_description_2_red, color_primary_800),
        text2 = Pair(R.string.onboard_description_2_black, color_primary2_700)
    ),
    Page(
        image = R.drawable.onboarding_3,
        text1 = Pair(R.string.onboard_description_3_black, color_primary2_700),
        text2 = Pair(R.string.onboard_description_3_red, color_primary_800)
    ),
)