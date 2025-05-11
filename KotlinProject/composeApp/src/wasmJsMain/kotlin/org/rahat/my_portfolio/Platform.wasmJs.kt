package org.rahat.my_portfolio

import kotlinx.browser.window

class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()

actual fun openLink(url: String) {
    window.open(url, "_blank")
}