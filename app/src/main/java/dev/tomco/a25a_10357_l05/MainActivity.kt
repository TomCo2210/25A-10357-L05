package dev.tomco.a25a_10357_l05

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.gson.Gson
import dev.tomco.a25a_10357_l05.model.Playlist
import dev.tomco.a25a_10357_l05.utilities.Constants
import dev.tomco.a25a_10357_l05.utilities.DataManager
import dev.tomco.a25a_10357_l05.utilities.ImageLoader
import dev.tomco.a25a_10357_l05.utilities.SharedPreferencesManagerV1
import dev.tomco.a25a_10357_l05.utilities.SharedPreferencesManagerV2
import dev.tomco.a25a_10357_l05.utilities.SharedPreferencesManagerV3
import dev.tomco.a25a_10357_l05.utilities.SignalManager

class MainActivity : AppCompatActivity() {


    private lateinit var main_IMG_background: AppCompatImageView

    private lateinit var main_BTN_toastAndVibrate: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferencesExamples()

        findViews()
        initViews()


    }

    private fun findViews() {
        main_IMG_background = findViewById(R.id.main_IMG_background)
        main_BTN_toastAndVibrate = findViewById(R.id.main_BTN_toastAndVibrate)
    }

    private fun initViews() {
        main_BTN_toastAndVibrate.setOnClickListener { toastAndVibrate() }
        ImageLoader
            .getInstance()
            .loadImage(
                "https://images.newscientist.com/wp-content/uploads/2022/12/01182812/SEI_135903350.jpg",
                main_IMG_background
            )
    }

    private fun toastAndVibrate() {
        SignalManager.getInstance().toast("🌍 Hello World!")
        SignalManager.getInstance().vibrate()
    }


    private fun sharedPreferencesExamples() {
        // Create the playlist:
        //val playlist = DataManager.generatePlaylist()

        // convert playlist to JSON:
        val gson = Gson()
        //val playlistAsJson: String = gson.toJson(playlist)

        //Log.d("playlistAsJson", "playlistAsJson: $playlistAsJson")

        //Save with v1:
        //SharedPreferencesManagerV1.putString(this, Constants.SP_keys.PLAYLIST_KEY, playlistAsJson)

        //Load with v1:
        //val playlistAsJsonFromSP = SharedPreferencesManagerV1.getString(
        //    this, Constants.SP_keys.PLAYLIST_KEY, ""
        //)
        //Log.d("playlistAsJsonFromSP", "playlistAsJsonFromSP: $playlistAsJsonFromSP")

        //Load with v2:
        //val playlistAsJsonFromSP = SharedPreferencesManagerV2(this).getString(
        //    Constants.SP_keys.PLAYLIST_KEY, ""
        //)
        //Log.d("playlistAsJsonFromSP", "playlistAsJsonFromSP: $playlistAsJsonFromSP")

        //Load With v3:
        val playlistAsJsonFromSP = SharedPreferencesManagerV3.getInstance().getString(
            Constants.SP_keys.PLAYLIST_KEY, ""
        )
        Log.d("playlistAsJsonFromSP", "playlistAsJsonFromSP: $playlistAsJsonFromSP")

        val playlistFromSP = gson.fromJson(playlistAsJsonFromSP, Playlist::class.java)
        Log.d("playlistFromSP", "playlistFromSP: $playlistFromSP")

    }
}