package com.app.ecriture.dummydata

data class SearchList(
    val id:Int,
    val name: String,
    val profileImage:Int,
    val caption:String,
    val image:Int
)


data class ProfileList(
    val id:Int,
    val profileImage: Int
)