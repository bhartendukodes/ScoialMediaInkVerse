package com.app.ecriture.dummydata

data class Genere(
    val id:Int,
    val genereType:String
)
{
    data class WriteUpPage(
        val id: Int,
        val name:String,
        val date:String,
        val profilePicture: Int,
        val data:String,
        val hashTagData:String,
        )
}
