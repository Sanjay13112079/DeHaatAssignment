package com.dehaat.dehaatassignment.ui.fragments

import android.content.res.Configuration
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
import com.dehaat.dehaatassignment.data.Resource
import com.dehaat.dehaatassignment.data.Status
import com.dehaat.dehaatassignment.recyclerview_utils.FeedItem
import com.dehaat.dehaatassignment.recyclerview_utils.GenericRVAdapter
import com.dehaat.dehaatassignment.navigation.AppNavigator
import com.dehaat.dehaatassignment.viewmodel_repo_interface.AuthorsVM
import kotlinx.android.synthetic.main.fragment_authors.*

class AuthorsFragment : Fragment(), View.OnClickListener{

    lateinit var mViewModel : AuthorsVM
    lateinit var mAdapter : GenericRVAdapter
    lateinit var mFeedItemList :ArrayList<FeedItem<AuthorsData.Author>>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_authors,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        setUpGithubRepoObserver()
        mViewModel.getAuthors()

    }

    fun initViews()
    {
        mViewModel= ViewModelProvider(activity?.viewModelStore!!, ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application!!)).get(AuthorsVM::class.java)
        mFeedItemList=ArrayList()
        mAdapter= GenericRVAdapter(mFeedItemList,this)
        var layoutManger= LinearLayoutManager(this.activity)
        authors_rv?.layoutManager=layoutManger
        authors_rv?.adapter=mAdapter
    }


    fun setUpGithubRepoObserver()
    {
        mViewModel.authorsData?.observe(this, Observer<Resource<AuthorsData.Data?>> {
            it ->
            when(it?.status)
            {
                Status.LOADING ->{
                }

                Status.ERROR ->{
                }

                Status.SUCCESS ->{
                    mapAuthors(it?.data)
                }
            }

        })
    }


    fun mapAuthors(authorsData : AuthorsData.Data?)
    {
        if(authorsData==null || authorsData.authors==null || authorsData.authors.isEmpty()) return
        mFeedItemList.clear()
        mFeedItemList.addAll(mViewModel.getFeedAuthorsItemList(authorsData.authors))
        mAdapter.notifyDataSetChanged()
        mViewModel.setClikedAuthorData(authorsData.authors.get(0))

    }

    override fun onClick(v: View?) {

        when(v?.id)
        {
            R.id.authors_vh_root -> {

                var data=v?.getTag(R.id.author_tag) as AuthorsData.Author
                mViewModel.setClikedAuthorData(data)

                if(activity?.resources?.configuration?.orientation==Configuration.ORIENTATION_PORTRAIT) AppNavigator.navigateToFragment(R.id.authors_books_container, BooksFragment(), activity, true)
            }
        }


    }


    override fun onDestroy() {
        super.onDestroy()
        mFeedItemList.clear()
    }
}