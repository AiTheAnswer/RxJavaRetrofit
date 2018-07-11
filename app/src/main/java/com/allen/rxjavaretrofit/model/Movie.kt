package com.allen.rxjavaretrofit.model

import java.io.Serializable

class Movie : Serializable {
    var rating: RatingBean? = null
    var title: String? = null
    var collect_count: Int = 0
    var original_title: String? = null
    var subtype: String? = null
    var year: String? = null
    var images: Avatars? = null
    var alt: String? = null
    var id: String? = null
    var genres: List<String>? = null
    var casts: List<Cast>? = null
    var directors: List<Cast>? = null


    class RatingBean {
        var max: Int = 0
        var average: Double = 0.0
        var stars: String? = null
        var min: Int? = 0
        override fun toString(): String {
            return "RatingBean(max=$max, average=$average, stars=$stars, min=$min)"
        }

    }

    class Cast {
        private var id: String? = null
        private var name: String? = null
        private var alt: String? = null
        private var avatars: Avatars? = null
        override fun toString(): String {
            return "Cast(id=$id, name=$name, alt=$alt, avatars=$avatars)"
        }

    }

    class Avatars {
        private var small: String? = null
        private var medium: String? = null
        private var larger: String? = null
        override fun toString(): String {
            return "Avatars(small=$small, medium=$medium, larger=$larger)"
        }

    }

    override fun toString(): String {
        return "Movie(rating=$rating, title=$title, collect_count=$collect_count, original_title=$original_title, subtype=$subtype, year=$year, images=$images, alt=$alt, id=$id, genres=$genres, casts=$casts, directors=$directors)"
    }
}


