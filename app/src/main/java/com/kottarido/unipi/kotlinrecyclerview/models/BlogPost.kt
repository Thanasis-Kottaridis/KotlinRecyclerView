package com.kottarido.unipi.kotlinrecyclerview.models

import android.text.SpannableStringBuilder

// ftiaxnoume mia data class kai vazoume ta properties tis
data class BlogPost (
    var title: String,
    var body: String,
    // apothikeuei to url tis eikonas pou tha provalei sto post
    var image: String,
    // apothikeuei to username tou xtisti pou kanei to post
    var username: String
){
}