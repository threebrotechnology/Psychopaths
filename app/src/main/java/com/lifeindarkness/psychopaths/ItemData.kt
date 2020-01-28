package com.lifeindarkness.psychopaths

import androidx.annotation.IntRange

data class ItemData(
    @IntRange(from = 0, to = 11)
    val index: Int,
    val type0_1: String,
    val type1_2: String,
    val type2_3: String,
    val type3_4: String,
    val type4_5: String,
    val type5_6: String,
    val type6_7: String,
    val type7_8: String,
    val type8_9: String,
    val type9_10: String,
    val type10_11: String
)