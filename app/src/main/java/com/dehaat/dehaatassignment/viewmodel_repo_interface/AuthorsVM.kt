package com.dehaat.dehaatassignment.viewmodel_repo_interface

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dehaat.dehaatassignment.data.AuthorsData
import com.dehaat.dehaatassignment.data.Resource
import com.dehaat.dehaatassignment.recyclerview_utils.FeedItem
import com.dehaat.dehaatassignment.recyclerview_utils.ItemTypeHandler

class AuthorsVM :ViewModel() {

    var authorsData : MutableLiveData<Resource<AuthorsData.Data?>>?
    var clikedAuthorData : MutableLiveData<AuthorsData.Author>

    var repo : AuthorsRepo

    init {
        repo= AuthorsRepo()
        authorsData=repo.authorsData
        clikedAuthorData=MutableLiveData()

    }

    fun getAuthors()
    {
        repo.getAuthors()
    }





    fun getFeedAuthorsItemList(authorList :List<AuthorsData.Author>) :List<FeedItem<AuthorsData.Author>>
    {
        var feedList=ArrayList<FeedItem<AuthorsData.Author>>()

        for( item in authorList)
        {
            feedList.add(FeedItem(item,ItemTypeHandler.ItemViewType.AUTHORS_VH))
        }

        return feedList
    }


    fun getFeedBooksItemList(bookList:List<AuthorsData.Book>) :List<FeedItem<AuthorsData.Book>>
    {
        var feedList=ArrayList<FeedItem<AuthorsData.Book>>()

        for( item in bookList)
        {
            feedList.add(FeedItem(item,ItemTypeHandler.ItemViewType.BOOKS_VH))
        }

        return feedList
    }



    fun setClikedAuthorData(author : AuthorsData.Author)
    {
        clikedAuthorData.value=author
    }





}