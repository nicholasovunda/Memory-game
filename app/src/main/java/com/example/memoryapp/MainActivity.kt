package com.example.memoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memoryapp.models.BoardSize
import com.example.memoryapp.models.MemoryCard
import com.example.memoryapp.models.MemoryGame
import com.example.memoryapp.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {

    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs : TextView
    companion object{
        private const val TAG = "MainActivity"
    }

    private var boardSize: BoardSize = BoardSize.HARD
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)
        val memoryGame = MemoryGame(boardSize)

        rvBoard.adapter = MemoryBoardAdapter(this, boardSize, memoryGame.cards,
            object  : MemoryBoardAdapter.CardClickListener  {
                override fun onCardClicked(position: Int) {
                    Log.i(TAG,"Card Clicked $position")
                }
            })
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager =GridLayoutManager(this, boardSize.getWidth())
    }

}