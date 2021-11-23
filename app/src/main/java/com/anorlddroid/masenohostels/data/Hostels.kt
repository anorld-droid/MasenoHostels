package com.anorlddroid.masenohostels.data

import androidx.compose.runtime.Immutable
import com.anorlddroid.masenohostels.R

@Immutable
data class MasenoHostels(
    val name: String,
    val imageUrl: Int,
)

val Masenohostels = listOf(
    MasenoHostels("Imani Hostels", R.drawable.hostel_one),
    MasenoHostels("Executive Hostels", R.drawable.hostel_two),
    MasenoHostels("Mama Florida Hostels", R.drawable.hostel_three),
    MasenoHostels("Kilimanjaro Hostels", R.drawable.hostel_one),
    MasenoHostels("Sunrise Hostels", R.drawable.hostel_two),
    MasenoHostels("Equator Hostels", R.drawable.hostel_three),
    MasenoHostels("Imani Hostels", R.drawable.hostel_one),
    MasenoHostels("Executive Hostels", R.drawable.hostel_two),
    MasenoHostels("Mama Florida Hostels", R.drawable.hostel_three),
    MasenoHostels("Kilimanjaro Hostels", R.drawable.hostel_one),
    MasenoHostels("Sunrise Hostels", R.drawable.hostel_two),
    MasenoHostels("Equator Hostels", R.drawable.hostel_three),
)

fun getHostels() = Masenohostels