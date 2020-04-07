package com.dehaat.dehaatassignment.ui.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View

import com.dehaat.dehaatassignment.R
import com.dehaat.dehaatassignment.navigation.AppNavigator
import com.dehaat.dehaatassignment.ui.fragments.AuthorsFragment
import com.dehaat.dehaatassignment.ui.fragments.BooksFragment
import com.dehaat.dehaatassignment.SharedPrefUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        // the user in portrait mode
        if(resources.configuration?.orientation==Configuration.ORIENTATION_PORTRAIT)
        {
             navigateToAuhorFragment()
        }
        // the user is in lanndscape mode
        else
        {
          setUpTheFragments()
        }

    }



    private fun initViews() {
        logoutBtn?.setOnClickListener(this)
    }


    private fun navigateToAuhorFragment()
    {
        AppNavigator.navigateToFragment(R.id.authors_books_container, AuthorsFragment(), this, false)
    }


    private fun setUpTheFragments()
    {
        AppNavigator.navigateToFragment(R.id.authors_container, AuthorsFragment(), this, false)

        AppNavigator.navigateToFragment(R.id.books_container, BooksFragment(), this, false)
    }



    override fun onClick(v: View) {

        when (v.id) {
            R.id.logoutBtn -> {
                SharedPrefUtils.clear()
                AppNavigator.navigateTo(this, LoginActivity::class.java, null)
                finish()
            }
        }
    }
}
