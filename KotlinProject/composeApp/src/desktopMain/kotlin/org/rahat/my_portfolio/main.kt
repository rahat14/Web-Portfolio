package org.rahat.my_portfolio

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.singleWindowApplication

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",
    ) {


    //    singleWindowApplication {
            App()
       // }



    }
}