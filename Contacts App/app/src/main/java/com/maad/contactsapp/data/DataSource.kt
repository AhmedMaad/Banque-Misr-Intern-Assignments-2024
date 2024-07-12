package com.maad.contactsapp.data

import com.maad.contactsapp.R
import com.maad.contactsapp.model.Contact

class DataSource {

    fun getContacts() = mutableListOf(
        Contact(R.drawable.auntie, R.string.auntie, "+201012345678"),
        Contact(R.drawable.brother, R.string.brother, "+201123456789"),
        Contact(R.drawable.daughter, R.string.daughter, "+201234567890"),
        Contact(R.drawable.friend_1, R.string.friend_1, "+201345678901"),
        Contact(R.drawable.friend_2, R.string.friend_2, "+201456789012"),
        Contact(R.drawable.grandfather, R.string.grandfather, "+201567890123"),
        Contact(R.drawable.granny, R.string.granny, "+201678901234"),
        Contact(R.drawable.neighbour, R.string.neighbour, "+201789012345"),
        Contact(R.drawable.sister, R.string.sister, "+201890123456"),
        Contact(R.drawable.son, R.string.son, "+201901234567"),
        Contact(R.drawable.uncle, R.string.uncle, "+201101234567")
    )

}