package com.otakkanan.sinote.ui.components.inspirasi

import com.otakkanan.sinote.R
import kotlin.random.Random

data class InspirasiDataClass(
    val name: String,
    val username: String,
    val post: String,
    val likeCount: Int,
    val viewCount: Int,
    val postImage: Int?,
    val profilePicture: Int = R.drawable.member_image,
)

// Sample data for names and usernames
val sampleNames = listOf("Alice", "Bob", "Charlie", "Diana", "Evan")
val sampleUsernames = listOf("@alice", "@bob", "@charlie", "@diana", "@evan")
val samplePosts = listOf(
    "Here's a beautiful scene from my latest adventure!",
    "Daily inspiration: Keep pushing forward.",
    "Nothing beats a sunset on the beach.",
    "Exploring the mountains is always a good idea!",
    "Throwback to last summer's road trip."
)

// Function to create random dummy data
fun createRandomInspirasiData(count: Int): List<InspirasiDataClass> {
    return List(count) {
        val rand = Random.nextInt(0, 100)
        InspirasiDataClass(
            name = sampleNames.random(),
            username = sampleUsernames.random(),
            post = samplePosts.random(),
            likeCount = Random.nextInt(0, 1000),  // Random like count from 0 to 999
            viewCount = Random.nextInt(0, 10000), // Random view count from 0 to 9999
            postImage = if(rand%4 == 0) R.drawable.post_image else null
            // Images are using default values as specified in the class definition
        )
    }
}

val inspirasiDataDummy = InspirasiDataClass(
    "Ginanjar Shomat",
    "@ginanjar12",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
    20,
    354,
    postImage = R.drawable.post_image
)