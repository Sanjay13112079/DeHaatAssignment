package com.dehaat.dehaatassignment.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val AUTHORS_DATA_ID="authors_data_id"

class AuthorsData {

    data class Data(
            @SerializedName("data") val authors: List<Author>?
    )

    data class Author(
                   @SerializedName("author_name") val author_name: String?,
                   @SerializedName("author_bio") val author_bio: String?,
                   @SerializedName("books") val books: List<Book>?
    )
    data class Book(
            @SerializedName("title") val title: String?,
            @SerializedName("description") val description: String?,
            @SerializedName("publisher") val publisher: String?,
            @SerializedName("published_date") val published_date: String?,
            @SerializedName("price") val price: String?
    )
}