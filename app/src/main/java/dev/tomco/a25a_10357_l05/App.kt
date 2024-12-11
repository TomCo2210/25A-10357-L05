package dev.tomco.a25a_10357_l05

import android.app.Application
import dev.tomco.a25a_10357_l05.utilities.ImageLoader
import dev.tomco.a25a_10357_l05.utilities.SharedPreferencesManagerV3
import dev.tomco.a25a_10357_l05.utilities.SignalManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferencesManagerV3.init(this)
        SignalManager.init(this)
        ImageLoader.init(this)
    }
}