package com.anorlddroid.masenohostels.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.anorlddroid.masenohostels.R
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsDivider
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsScaffold
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsSurface
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@Composable
fun Home(coroutineScope: CoroutineScope, scaffoldState: ScaffoldState) {
    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    MasenoHostelsScaffold(
        topBar = {
            HomeTopBar(
                coroutineScope = coroutineScope,
                bottomSheetState = bottomSheetState,
                scaffoldState = scaffoldState
            )
        },
        content = {
            HomeContent()
        }
    )
}

@ExperimentalMaterialApi
@Composable
fun HomeTopBar(scaffoldState: ScaffoldState, coroutineScope: CoroutineScope, bottomSheetState: ModalBottomSheetState) {
    Column(
        modifier = Modifier.statusBarsPadding()
    ) {
        TopAppBar(
            backgroundColor = MasenoHostelsTheme.colors.uiBackground,
            contentColor = MasenoHostelsTheme.colors.textSecondary,
            elevation = 5.dp, // No shadow needed
            actions = {
                IconButton(onClick = {
                    coroutineScope.launch { bottomSheetState.show() }
                }) {
                    Icon(
                        Icons.Outlined.AutoAwesome,
                        tint = MasenoHostelsTheme.colors.brand,
                        contentDescription = "Bottom Sheet"
                    )
                }
            },
            title = {
                Text(
                    text = "Hostels",
                    style = MaterialTheme.typography.h5,
                    color = MasenoHostelsTheme.colors.textSecondary,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f)
                        .align(Alignment.CenterHorizontally)
                )
            },
            navigationIcon = {
                NavIcon(scaffoldState = scaffoldState, scope = coroutineScope)
            }
        )
        MasenoHostelsDivider()
    }
}

@Composable
fun HomeContent(){

}

@Composable
fun NavIcon(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ"

    MasenoHostelsSurface(
        color = Color.LightGray,
        shape = CircleShape,
        modifier = Modifier
            .padding(8.dp)
            .size(40.dp)
    ) {

        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    crossfade(true)
                    placeholder(drawableResId = R.drawable.placeholder)
                }
            ),
            modifier = Modifier
                .clickable(onClick = {
//                    scope.launch {
//                        scaffoldState.drawerState.open()
//                    }
                })
                .fillMaxSize()
                .background(
                    color = Color.Transparent,
                    shape = CircleShape
                ),
            contentDescription = "Navigation Drawer",
            contentScale = ContentScale.Crop,
        )

    }

}