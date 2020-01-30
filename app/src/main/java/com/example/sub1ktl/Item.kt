package com.example.sub1ktl

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val name : String?, val id: Int?, val image : Int?, val desc: String?) : Parcelable
