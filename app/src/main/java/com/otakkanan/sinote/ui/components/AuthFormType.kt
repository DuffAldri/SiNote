package com.otakkanan.sinote.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.ui.text.input.KeyboardType
import com.otakkanan.sinote.R

enum class AuthFormType(
    val title: String,
    val placeholder: String,
    @DrawableRes val leadingIconId: Int,
    val keyboardType: KeyboardType
) {
    NAME("Nama Lengkap", "Masukkan nama lengkap anda", R.drawable.name_icon, KeyboardType.Text),
    EMAIL("Email", "Masukkan email anda", R.drawable.email_icon, KeyboardType.Email),
    PASSWORD("Kata Sandi", "Masukkan kata sandi anda", R.drawable.password_icon, KeyboardType.Password),
    REPEAT_PASSWORD("Ulangi Kata Sandi", "Masukkan ulang kata sandi anda", R.drawable.password_icon, KeyboardType.Password),
}