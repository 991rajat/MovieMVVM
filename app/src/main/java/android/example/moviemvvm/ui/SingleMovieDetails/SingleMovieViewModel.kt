package android.example.moviemvvm.ui.SingleMovieDetails

import android.example.moviemvvm.data.repository.NetworkState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oxcoding.moviemvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(private val movieRepository: SingleMovieRepository,private val movie_id:Int) : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    val movieDetails : LiveData<MovieDetails> by lazy { movieRepository.fetchSingleMovie(compositeDisposable,movie_id) }

    val networkState : LiveData<NetworkState> by lazy { movieRepository.getMovieDetailsNetworkState() }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}

