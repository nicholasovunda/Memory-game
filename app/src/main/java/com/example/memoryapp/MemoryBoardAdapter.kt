package com.example.memoryapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class MemoryBoardAdapter(private val context: Context, private val numPieces: Int) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    companion object {
        private const val MARGIN_SIZE = 10
        private const val TAG = "MemoryBoardAdapter"
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageButton =  itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
    imageButton.setOnClickListener{
        Log.i(TAG,"Clicked on position $position")
    }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardHeight = parent.height / 4 - (2 * MARGIN_SIZE)
        val cardWidth = parent.width /  2 - (2 * MARGIN_SIZE )
        val cardSideLength = min(cardWidth, cardHeight)
     val view :View =LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)

        val layOutParams : ViewGroup.MarginLayoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layOutParams.height = cardSideLength
        layOutParams.width = cardSideLength
        layOutParams.setMargins(MARGIN_SIZE)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int = numPieces

}
