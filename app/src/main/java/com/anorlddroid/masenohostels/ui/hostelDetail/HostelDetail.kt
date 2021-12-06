package com.anorlddroid.masenohostels.ui.hostelDetail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Backup
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.anorlddroid.masenohostels.R
import com.anorlddroid.masenohostels.data.MasenoHostels
import com.anorlddroid.masenohostels.data.getHostels
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme
import com.anorlddroid.masenohostels.ui.theme.Neutral8
import com.anorlddroid.masenohostels.ui.theme.gradientColor1
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsButton
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsDivider
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsScaffold
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsSurface
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import me.onebone.toolbar.AppBarContainer
import me.onebone.toolbar.CollapsingToolbar
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarState


@Composable
fun HostelDetails(hostelId: Long, upPress: () -> Unit) {
    val hostel = remember(hostelId) { getHostels().find { it.id == hostelId }!! }
    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header(hostel)
        DetailsBody(hostels = hostel, scroll)
        Up(upPress = upPress, hostel = hostel)
        CartBottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
private fun Header(hostel: MasenoHostels) {
    Box {
        Image(
            painter = painterResource(id = hostel.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun DetailsBody(hostels: MasenoHostels, scroll: ScrollState) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(58.dp)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(Modifier.height(180.dp))
            MasenoHostelsSurface(Modifier.fillMaxWidth()) {
                Column {
                    Text(
                        text = "Location",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(vertical = 6.dp, horizontal = 4.dp)
                    )
                    Text(
                        text = hostels.location,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 24.dp, end = 8.dp)
                    )
                    Text(
                        text = "Rooms Available",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(vertical = 3.dp, horizontal = 4.dp)
                    )
                    Text(
                        text = hostels.roomsAvailable.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 24.dp, end = 8.dp)
                    )
                    Text(
                        text = "Features",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(vertical = 3.dp, horizontal = 4.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    var seeMore by remember { mutableStateOf(true) }
                    Text(
                        text = hostels.features,
                        style = MaterialTheme.typography.subtitle1,
                        maxLines = if (seeMore) 3 else Int.MAX_VALUE,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 24.dp, end = 8.dp)
                    )
                    val textButton = if (seeMore) {
                        stringResource(id = R.string.see_more)
                    } else {
                        stringResource(id = R.string.see_less)
                    }
                    Text(
                        text = textButton,
                        style = MaterialTheme.typography.button,
                        textAlign = TextAlign.Center,
                        color = MasenoHostelsTheme.colors.textLink,
                        modifier = Modifier
                            .heightIn(20.dp)
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 20.dp)
                            .clickable {
                                seeMore = !seeMore
                            }
                    )
                    Text(
                        text = "Price per Semester",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(vertical = 2.dp, horizontal = 4.dp)
                    )
                    Text(
                        text = "Ksh.${hostels.price.toString()}",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 24.dp, end = 8.dp)
                    )
                    LazyRow {
                        items(hostels.photos) { it ->
                            Image(
                                painter = painterResource(id = it),
                                contentDescription = "Photos for the hostel",
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(250.dp)
                                    .padding(horizontal = 6.dp)
                            )
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(bottom = 40.dp)
                            .navigationBarsPadding(start = false, end = false)
                            .height(4.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Up(upPress: () -> Unit, hostel: MasenoHostels) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        IconButton(
            onClick = upPress,
            modifier = Modifier
                .size(36.dp)
                .background(
                    color = MasenoHostelsTheme.colors.brand.copy(alpha = 0.32f),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                tint = MasenoHostelsTheme.colors.iconInteractive,
                contentDescription = stringResource(R.string.label_back)
            )
        }
        Text(
            text = hostel.name,
            style = MaterialTheme.typography.h6,
            color = gradientColor1,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

    }
}

@Composable
private fun CartBottomBar(modifier: Modifier = Modifier) {
    MasenoHostelsSurface(modifier) {
        Column {
            MasenoHostelsDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .navigationBarsPadding(start = false, end = false)
                    .then(Modifier.padding(horizontal = 24.dp))
                    .heightIn(min = 56.dp)
            ) {
                Spacer(Modifier.width(16.dp))
                MasenoHostelsButton(
                    onClick = { /* todo */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Book A Room",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

