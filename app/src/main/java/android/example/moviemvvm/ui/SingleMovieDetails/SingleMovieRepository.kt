package android.example.moviemvvm.SingleMovieDetails

import android.example.moviemvvm.data.api.MovieDB
import android.example.moviemvvm.data.repository.MovieDetailNetworkDataSource
import android.example.moviemvvm.data.repository.NetworkState
import androidx.lifecycle.LiveData
import com.oxcoding.moviemvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class SingleMovieRepository(private val apiService:MovieDB) {

    lateinit var movieDetailNetworkDataSource: MovieDetailNetworkDataSource

    fun fetchSingleMovie(compositeDisposable: CompositeDisposable,movie_id:Int): LiveData<MovieDetails> {
        movieDetailNetworkDataSource = MovieDetailNetworkDataSource(apiService,compositeDisposable)
        movieDetailNetworkDataSource.fetchMovieDetail(movie_id)
        return movieDetailNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailNetworkDataSource.networkState
    }

}