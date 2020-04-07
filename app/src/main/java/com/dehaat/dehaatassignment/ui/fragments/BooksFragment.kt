package com.dehaat.dehaatassignment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.data.AuthorsData
import com.dehaat.dehaatassignment.recyclerview_utils.FeedItem
import com.dehaat.dehaatassignment.recyclerview_utils.GenericRVAdapter
import com.dehaat.dehaatassignment.viewmodel_repo_interface.AuthorsVM
import kotlinx.android.synthetic.main.fragment_books.*

class BooksFragment : Fragment(), View.OnClickListener {

    lateinit var mViewModel: AuthorsVM
    lateinit var mAdapter: GenericRVAdapter
    lateinit var mFeedItemList: ArrayList<FeedItem<AuthorsData.Book>>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        setUpGithubRepoObserver()

    }

    fun initViews() {
        mViewModel = ViewModelProvider(activity?.viewModelStore!!, ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application!!)).get(AuthorsVM::class.java)
        mFeedItemList = ArrayList()
        mAdapter = GenericRVAdapter(mFeedItemList, this)
        var layoutManger = LinearLayoutManager(this.activity)
        books_rv?.layoutManager = layoutManger
        books_rv?.adapter = mAdapter
    }


    fun setUpGithubRepoObserver() {
        mViewModel.clikedAuthorData.observe(this, Observer<AuthorsData.Author> { it ->
            mapAuthors(it)
        })
    }


    fun mapAuthors(clikedAuthorData: AuthorsData.Author?) {
        if (clikedAuthorData == null || clikedAuthorData.books == null || clikedAuthorData.books.isEmpty()) return
        mFeedItemList.clear()
        mFeedItemList.addAll(mViewModel.getFeedBooksItemList(clikedAuthorData.books))
        mAdapter.notifyDataSetChanged()

    }

    override fun onClick(v: View?) {
    }



    override fun onDestroy() {
        super.onDestroy()
        mFeedItemList.clear()
    }

}