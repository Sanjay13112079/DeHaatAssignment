package com.dehaat.dehaatassignment.ui.viewholders

import android.view.View
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.data.AuthorsData
import com.dehaat.dehaatassignment.recyclerview_utils.GenericVH
import kotlinx.android.synthetic.main.layout_authors_vh.view.*

class AuthorsVH(iteView :View): GenericVH<AuthorsData.Author>(iteView){

    var itemView1 :View

    init {
        itemView1=itemView
    }

    override fun bindData(data: AuthorsData.Author?) {

        itemView1?.author_name?.text=data?.author_name

        itemView1?.setTag(R.id.author_tag,data)
        itemView1?.authors_vh_root?.setOnClickListener(clickListner)



    }
}