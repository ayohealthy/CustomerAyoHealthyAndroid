package com.devatacreative.ayohealthy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GoogleCredsModel (
    val secret: String
): Parcelable