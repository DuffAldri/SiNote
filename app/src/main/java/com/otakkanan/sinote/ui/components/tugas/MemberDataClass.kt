package com.otakkanan.sinote.ui.components.tugas

import com.otakkanan.sinote.R

data class MemberDataClass(
    val name: String,
    val picture: Int = R.drawable.member_image
)

val membersDummy = listOf(
    MemberDataClass(name = "Annisa Agusti Andini"),
    MemberDataClass(name = "M Ginanjar Shomat I.S"),
    MemberDataClass(name = "M Ikhsan Romadhoni"),
    MemberDataClass(name = "Ciko Tegar Saputra"),
    MemberDataClass(name = "M Daffa Febrian"),
    MemberDataClass(name = "Fa’iq Arya Dewangga"),
    MemberDataClass(name = "Waezqorney Huanfarenzo"),
    MemberDataClass(name = "Achmad Faris Fadha’il"),
    MemberDataClass(name = "Fikri Maulana Aziz"),
    MemberDataClass(name = "Ananda Navisha"),
    MemberDataClass(name = "Virgy Ferdian Surya Firmansyah")
)