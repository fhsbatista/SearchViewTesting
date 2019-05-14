package com.fbatista.searchviewtesting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Called when the user clicks on the search view to type something
        searchView.setOnSearchClickListener {
            showToast("OnSearchClickListener")
        }

        //Called whenever the user clicks on the "close" ("x") button
        searchView.setOnCloseListener {
            showToast("OnCloseListener")
            true
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //Called whenever the user clicks on the "search" button of keyboard
            override fun onQueryTextSubmit(p0: String?): Boolean {
                showToast("OnQueryTextListener - onQueryTextSubmit !")
                return true
            }
            //Called whenever the user types something on the view
            override fun onQueryTextChange(p0: String?): Boolean {
                showToast("OnQueryTextListener - onQueryTextChange !")
                return true
            }
        })


    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
