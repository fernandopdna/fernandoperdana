package com.example.eratani.task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Transaction(
    var ket_barang: String? = "",
    var qty_barang: Int? = null,
    var tgl_barang: String? = null
) : Parcelable