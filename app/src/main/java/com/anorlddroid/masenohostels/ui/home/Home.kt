package com.anorlddroid.masenohostels.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.anorlddroid.masenohostels.MainDestinations
import com.anorlddroid.masenohostels.R
import com.anorlddroid.masenohostels.data.MasenoHostels
import com.anorlddroid.masenohostels.data.getHostels
import com.anorlddroid.masenohostels.ui.components.VerticalGrid
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsDivider
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsScaffold
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsSurface
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.max


@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun Home(coroutineScope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavHostController) {
    val hostels = getHostels()
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
            LazyColumn {
                item {
                    HomeContent(hostels = hostels, navController)
                }
            }
        }
    )
}

@ExperimentalMaterialApi
@Composable
fun HomeTopBar(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    bottomSheetState: ModalBottomSheetState
) {
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

@ExperimentalCoilApi
@Composable
fun HomeContent(hostels: List<MasenoHostels>, navController: NavHostController) {
    Column(modifier = Modifier.padding(1.dp)) {
        VerticalGrid(Modifier.padding(horizontal = 1.dp)) {
            hostels.forEach { hostel ->
                HomeItem(
                    modifier = Modifier.padding(3.dp),
                    hostel = hostel,
                    navController = navController
                )
            }
        }
        Spacer(Modifier.height(2.dp))
    }
}

private val MinImageSize = 134.dp
private val HostelCardShape = RoundedCornerShape(10.dp)
private const val HostelNameProportion = 0.55f

@ExperimentalCoilApi
@Composable
fun HomeItem(
    modifier: Modifier = Modifier,
    hostel: MasenoHostels,
    gradient: List<Color> = MasenoHostelsTheme.colors.gradient2_3,
    navController: NavHostController
) {
    Layout(
        modifier = modifier
            .aspectRatio(1.45f)
            .shadow(elevation = 2.dp, shape = HostelCardShape)
            .clip(HostelCardShape)
            .background(Brush.horizontalGradient(gradient))
            .clickable { navigateToHostelDetail(hostelId = hostel.id, navController = navController) },
        content = {
            Text(
                text = hostel.name,
                style = MaterialTheme.typography.subtitle1,
                color = MasenoHostelsTheme.colors.textSecondary,
                modifier = Modifier
                    .padding(4.dp)
                    .padding(start = 8.dp)
            )
            HostelImage(
                imageUrl = hostel.imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    ) { measurables, constraints ->
        // Text given a set proportion of width (which is determined by the aspect ratio)
        val textWidth = (constraints.maxWidth * HostelNameProportion).toInt()
        val textPlaceable = measurables[0].measure(Constraints.fixedWidth(textWidth))

        // Image is sized to the larger of height of item, or a minimum value
        // i.e. may appear larger than item (but clipped to the item bounds)
        val imageSize = max(MinImageSize.roundToPx(), constraints.maxHeight)
        val imagePlaceable = measurables[1].measure(Constraints.fixed(imageSize, imageSize))
        layout(
            width = constraints.maxWidth,
            height = constraints.minHeight
        ) {
            textPlaceable.placeRelative(
                x = 0,
                y = (constraints.maxHeight - textPlaceable.height) / 2 // centered
            )
            imagePlaceable.placeRelative(
                // image is placed to end of text i.e. will overflow to the end (but be clipped)
                x = textWidth,
                y = (constraints.maxHeight - imagePlaceable.height) / 2 // centered
            )
        }
    }
}


@ExperimentalCoilApi
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

@ExperimentalCoilApi
@Composable
fun HostelImage(
    imageUrl: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    MasenoHostelsSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = imageUrl),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )
    }
}

fun navigateToHostelDetail(hostelId: Long, navController: NavHostController) {
    navController
        .navigate(
            "${MainDestinations.HOSTEL_DETAIL_ROUTE}/$hostelId"
        ) {
            launchSingleTop = true
            restoreState = true
        }
}