package com.example.angguncaksono

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Character(
    val name: String,
    val description: String,
    val photo: Int,
    val rarity: String,
    val path: String,
    val faction: String,
    val detail: String
): Parcelable
