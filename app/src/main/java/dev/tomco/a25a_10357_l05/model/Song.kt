package dev.tomco.a25a_10357_l05.model

data class Song private constructor(
    val name: String,
    val artist: String,
    val durationInSeconds: Int,
    val releaseDate: Long,
    val rating: Float,
    val tags: List<String>
) {
    class Builder(
        var name: String = "",
        var artist: String = "",
        var durationInSeconds: Int = 0,
        var releaseDate: Long = 0L,
        var rating: Float = 0.0F,
        var tags: List<String> = mutableListOf()
    ) {
        fun name(name: String) = apply { this.name = name }
        fun artist(artist: String) = apply { this.artist = artist }
        fun durationInSeconds(durationInSeconds: Int) =
            apply { this.durationInSeconds = durationInSeconds }
        fun releaseDate(releaseDate: Long) = apply { this.releaseDate = releaseDate }
        fun rating(rating: Float) = apply { this.rating = rating }
        fun tags(tags: List<String>) = apply { this.tags = tags }
        fun build() = Song(
            name, artist, durationInSeconds, releaseDate, rating, tags
        )
    }

}