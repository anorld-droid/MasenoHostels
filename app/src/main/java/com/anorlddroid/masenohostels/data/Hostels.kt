package com.anorlddroid.masenohostels.data

import androidx.compose.runtime.Immutable
import com.anorlddroid.masenohostels.R

@Immutable
data class MasenoHostels(
    val id : Long,
    val name: String,
    val imageUrl: Int,
    val photos: List<Int>,
    val location: String,
    val price: Long,
    val features: String,
    val roomsAvailable: Int
)

val Masenohostels = listOf(
    MasenoHostels(
        id = 1L,
        name = "Imani Hostels",
        imageUrl = R.drawable.hostel_one,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout" +
                " except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive" +
                " Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, " +
                "R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, " +
                "R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two," +
                "listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one," +
                " R.drawable.hostel_two, R.drawable.hostel_three))" + "Self contained rooms, High level of security, Water is available throughout" +
                " except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive" +
                " Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, " +
                "R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, " +
                "R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two," +
                "listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one," +
                " R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,

        ),
    MasenoHostels(
        2L,
        name = "Executive Hostels",
        imageUrl = R.drawable.hostel_two,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        3L,
        name = "Mama Florida Hostels",
        imageUrl = R.drawable.hostel_three,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        4L,
        name = "Kilimanjaro Hostels",
        imageUrl = R.drawable.hostel_one,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        5L,
        name = "Sunrise Hostels",
        imageUrl = R.drawable.hostel_two,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        6L,
        name = "Equator Hostels",
        imageUrl = R.drawable.hostel_three,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        7L,
        name = "Imani Hostels",
        imageUrl = R.drawable.hostel_one,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        8L,
        name = "Executive Hostels",
        imageUrl = R.drawable.hostel_two,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        9L,
        name = "Mama Florida Hostels",
       imageUrl =  R.drawable.hostel_three,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        10L,
        name = "Kilimanjaro Hostels",
        imageUrl = R.drawable.hostel_one,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        11L,
        name = "Sunrise Hostels",
        imageUrl = R.drawable.hostel_two,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
    MasenoHostels(
        id = 12L,
        name = "Equator Hostels",
        imageUrl = R.drawable.hostel_three,
        photos = listOf(
            R.drawable.hostel_two,
            R.drawable.hostel_three,
            R.drawable.hostel_one,
            R.drawable.hostel_two,
            R.drawable.hostel_three
        ),
        location = "Close to Maseno Club",
        price = 34000,
        features = "Self contained rooms, High level of security, Water is available throughout except during dry season, Presence of cyber and a cafe MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))MasenoHostels(\"Executive Hostels\", R.drawable.hostel_two, listOf(R.drawable.hostel_two, R.drawable.hostel_three, R.drawable.hostel_one, R.drawable.hostel_two, R.drawable.hostel_three))",
        roomsAvailable = 49,
    ),
)

fun getHostels() = Masenohostels