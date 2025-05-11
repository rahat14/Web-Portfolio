package org.rahat.my_portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun openLink(url: String)