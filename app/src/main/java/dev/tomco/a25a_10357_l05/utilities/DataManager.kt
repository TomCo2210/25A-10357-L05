package dev.tomco.a25a_10357_l05.utilities

import dev.tomco.a25a_10357_l05.model.Playlist
import dev.tomco.a25a_10357_l05.model.Song
import java.time.LocalDate
import java.util.Arrays

object DataManager {
    fun generatePlaylist(): Playlist{
        return Playlist
            .Builder()
            .name("Top Three!")
            .addSong(
                Song
                    .Builder()
                    .name("Stairway To Heaven")
                    .artist("Led Zeppelin")
                    .durationInSeconds(482)
                    .releaseDate(LocalDate.of(1971,11,8).toEpochDay())
                    .rating(4.9F)
                    .tags(listOf("Rock", "Classic Rock", "Hard Rock"))
                    .build()
            ).addSong(
                Song
                    .Builder()
                    .name("Bohemian Rhapsody")
                    .artist("Queen")
                    .durationInSeconds(359)
                    .releaseDate(LocalDate.of(1975,10,31).toEpochDay())
                    .rating(4.8F)
                    .tags(listOf("Rock", "Pop", "Progressive Rock"))
                    .build()
            ).addSong(
                Song
                    .Builder()
                    .name("Hotel California")
                    .artist("The Eagles")
                    .durationInSeconds(391)
                    .releaseDate(LocalDate.of(1977,12,8).toEpochDay())
                    .rating(4.7F)
                    .tags(listOf("Rock", "Classic Rock", "Soft Rock"))
                    .build()
            ).build()
    }
}