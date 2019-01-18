package com.example.manojsoni.interview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.manojsoni.interview.network.Movie
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class BlankViewModel : ViewModel() {
    // TODO: Implement the ViewModel


     val movieListLiveData = MutableLiveData<List<Movie>>()

    fun loadMovies() {
        DataManager.getMovieList()
            .subscribeOn(Schedulers.io())
            .subscribe (object : Observer<List<Movie>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: List<Movie>) {
                    Log.d(TAG, "Movie Size = ${t.size}")
                    movieListLiveData.postValue(t)
                }

                override fun onError(e: Throwable) {

                }

            })
    }

    companion object {
        private val TAG : String = BlankViewModel::class.java.simpleName
    }
}
