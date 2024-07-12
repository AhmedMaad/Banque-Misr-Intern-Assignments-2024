package com.maad.contactsapp.data

import com.maad.contactsapp.R
import com.maad.contactsapp.model.Contact

class DataSource {

    fun getContacts() = mutableListOf(
        Contact(R.drawable.auntie, R.string.auntie, "+20100"),
        Contact(R.drawable.brother, R.string.brother, "+20111"),
        Contact(R.drawable.daughter, R.string.daughter, "+20122"),
        Contact(R.drawable.friend_1, R.string.friend_1, "+20133"),
        Contact(R.drawable.friend_2, R.string.friend_2, "+20144"),
        Contact(R.drawable.grandfather, R.string.grandfather, "+20155"),
        Contact(R.drawable.granny, R.string.granny, "+20166"),
        Contact(R.drawable.neighbour, R.string.neighbour, "+20177"),
        Contact(R.drawable.sister, R.string.sister, "+20188"),
        Contact(R.drawable.son, R.string.son, "+20199"),
        Contact(R.drawable.uncle, R.string.uncle, "+20110")
    )

}