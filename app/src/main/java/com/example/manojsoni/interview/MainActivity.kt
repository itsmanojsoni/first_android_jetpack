package com.example.manojsoni.interview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.manojsoni.interview.network.Movie

class MainActivity : AppCompatActivity(), BlankFragment.OnActivityCallback {

    private lateinit var fragment: BlankFragment
    private lateinit var detailFragment : DetailFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment()
    }

    private fun loadFragment() {
        fragment = BlankFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onItemClicked(movie: Movie) {

        detailFragment = DetailFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
}
