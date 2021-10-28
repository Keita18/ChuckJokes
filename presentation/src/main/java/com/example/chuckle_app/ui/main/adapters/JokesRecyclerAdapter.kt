package com.example.chuckle_app.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chuckle_app.R
import com.example.domain.model.Joke
import kotlinx.android.synthetic.main.list_item.view.*


class JokesRecyclerAdapter(context: Context) :
    ListAdapter<Joke, JokesRecyclerAdapter.JokeViewHolder>(DIFF_CALLBACK) {


    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Joke?> =
            object : DiffUtil.ItemCallback<Joke?>() {

                override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
                    return oldItem == newItem
                }
            }
    }

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val itemView = inflater.inflate(R.layout.list_item, parent, false)
        return JokeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    internal fun getJokeAt(position: Int) : Joke {
        return getItem(position)
    }

    inner class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(joke: Joke) {
            itemView.joke_text.text = joke.text
        }
    }

}