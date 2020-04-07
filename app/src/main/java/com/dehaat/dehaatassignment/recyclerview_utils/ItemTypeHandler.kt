package com.dehaat.dehaatassignment.recyclerview_utils
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.ui.viewholders.AuthorsVH
import com.dehaat.dehaatassignment.ui.viewholders.BooksVH

class ItemTypeHandler {

    //using enum to classify viewholder types
     enum class ItemViewType(id :Int)
     {
         AUTHORS_VH(0), BOOKS_VH(1);

         var id :Int?=null

         init {
             this.id=id
         }
     }

     companion object
     {

         fun getType(id :Int) :Int?
         {
             var itemtypeArray=
                 ItemViewType.values()
             for(itemType in itemtypeArray)
             {
                 if(itemType?.id==id) return itemType.id
             }

             return null
         }

     //create view holder for recycler view
     fun createViewHolder (inflater :LayoutInflater,parent :ViewGroup,type :Int? ): GenericVH<Any>?
     {

             if(type==null) return null
             var viewHolder : GenericVH<Any>?=null

             when(type)
             {
                 ItemViewType.AUTHORS_VH.id ->
                 {
                     viewHolder= AuthorsVH(
                             inflater.inflate(R.layout.layout_authors_vh, parent, false)
                     ) as GenericVH<Any>
                 }

                 ItemViewType.BOOKS_VH.id ->
                 {
                     viewHolder= BooksVH(
                             inflater.inflate(R.layout.layout_books_vh, parent, false)
                     ) as GenericVH<Any>
                 }

             }

             return viewHolder
         }
     }





}