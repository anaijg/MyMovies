package com.example.mymovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovies.databinding.ViewMovieItemBinding

interface MovieClickListener {
    fun onMovieClicked(movie: Movie) // (Movie) -> Unit
}

class MoviesAdapter(
    private val movies: List<Movie>,
    private val movieClickListener: (Movie) -> Unit
): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    // crea una nueva vista cuando el adapter se lo pida
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    // aclualiza la vista cuando el adapter se lo pida
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movies[position])
        holder.itemView.setOnClickListener { movieClickListener(movie) }
    }


    override fun getItemCount(): Int = movies.size

    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.title.text = movie.title
            Glide
                .with(binding.root.context)
                .load(movie.cover)
                .into(binding.cover)
        }
    }

}