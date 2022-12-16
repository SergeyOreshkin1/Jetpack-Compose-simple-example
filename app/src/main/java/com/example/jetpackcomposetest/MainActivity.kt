package com.example.jetpackcomposetest

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DimenRes
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.*
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetest.navigation.NavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationGraph(navController = navController)
        }
    }
}

fun showMessage(context: Context, message: Int) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

@OptIn(ExperimentalUnitApi::class)
@Composable
@ReadOnlyComposable
fun textSizeResource(@DimenRes id: Int): TextUnit {
    val context = LocalContext.current
    val density = LocalDensity.current
    val pxValue = context.resources.getDimension(id)
    return TextUnit(pxValue / density.density, TextUnitType.Sp)
}
