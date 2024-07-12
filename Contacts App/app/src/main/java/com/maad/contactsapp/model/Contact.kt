package com.maad.contactsapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Contact(
    @DrawableRes val pic: Int,
    @StringRes val name: Int,
    val phoneNumber: String,
)