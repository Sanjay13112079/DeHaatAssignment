package com.dehaat.dehaatassignment.ui.viewholders

import android.view.View
import com.dehaat.dehaatassignment.data.AuthorsData
import com.dehaat.dehaatassignment.recyclerview_utils.GenericVH
import kotlinx.android.synthetic.main.layout_books_vh.view.*

class BooksVH(itemView :View) :GenericVH<AuthorsData.Book>(itemView) {

    var itemView1 :View

    init {
        itemView1=itemView
    }


    override fun bindData(data: AuthorsData.Book?) {

        itemView1?.book_title?.text="title : "+data?.title
        itemView1?.book_descriptionn?.text="description : "+data?.description


    }
}