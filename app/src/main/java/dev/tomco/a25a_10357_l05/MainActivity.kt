package dev.tomco.a25a_10357_l05

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import dev.tomco.a25a_10357_l05.model.Playlist
import dev.tomco.a25a_10357_l05.utilities.Constants
import dev.tomco.a25a_10357_l05.utilities.DataManager
import dev.tomco.a25a_10357_l05.utilities.SharedPreferencesManagerV1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the playlist:
        //val playlist = DataManager.generatePlaylist()

        // convert playlist to JSON:
        val gson = Gson()
        //val playlistAsJson: String = gson.toJson(playlist)

        //Log.d("playlistAsJson", "playlistAsJson: $playlistAsJson")

        //Save with v1:
        //SharedPreferencesManagerV1.putString(this, Constants.SP_keys.PLAYLIST_KEY, playlistAsJson)

        //Load with v1:
        val playlistAsJsonFromSP = SharedPreferencesManagerV1.getString(
            this, Constants.SP_keys.PLAYLIST_KEY, ""
        )
        Log.d("playlistAsJsonFromSP", "playlistAsJsonFromSP: $playlistAsJsonFromSP")

        val playlistFromSP = gson.fromJson(playlistAsJsonFromSP,Playlist::class.java)
        Log.d("playlistFromSP", "playlistFromSP: $playlistFromSP")

    }
}