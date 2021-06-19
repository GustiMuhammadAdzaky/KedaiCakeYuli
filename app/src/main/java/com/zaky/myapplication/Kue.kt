package com.zaky.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kue(
    var name: String? = "",
    var detail: String? = "",
    var photo: Int? = 0
): Parcelable