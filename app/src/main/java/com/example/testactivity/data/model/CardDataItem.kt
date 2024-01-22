package com.example.testactivity.data.model

data class CardDataItem(
    val apiUrl: String,
    val badgeUrl: String,
    val dateCreated: String,
    val description: String,
    val hex: String,
    val hsv: Hsv,
    val id: Int,
    val imageUrl: String,
    val numComments: Int,
    val numHearts: Int,
    val numViews: Int,
    val numVotes: Int,
    val rank: Int,
    val rgb: Rgb,
    val title: String,
    val url: String,
    val userName: String
)