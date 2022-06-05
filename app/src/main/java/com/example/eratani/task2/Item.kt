package com.example.eratani.task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    var key_item: String? = "",
    var jenis_barang: String? = null,
    var nama_barang: String? = null
) : Parcelable
