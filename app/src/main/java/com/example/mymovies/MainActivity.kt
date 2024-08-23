package com.example.mymovies

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mymovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        //Log.d("MainActivity", "onCreate")

        // forma clásica de acceder a los elementos de un layout
        // setContentView(R.layout.activity_main)
        //val message = findViewById<TextView>(R.id.message)
        //message.text = "Hello Android"

        // forma más reciente: recomendada; necesitas en build.gradle poner viewBinding a true
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // en este caso binding.root es el FrameLayout de activity_main.xml

        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie("Title 1", "https://loremflickr.com/320/240?lock=1"),
                Movie("Title 2", "https://loremflickr.com/320/240?lock=2"),
                Movie("Title 3", "https://loremflickr.com/320/240?lock=3"),
                Movie("Title 4", "https://loremflickr.com/320/240?lock=4"),
                Movie("Title 5", "https://loremflickr.com/320/240?lock=5"),
                Movie("Title 6", "https://loremflickr.com/320/240?lock=6")
            ),
            {
                Toast.makeText(this@MainActivity, it.title, Toast.LENGTH_SHORT).show()
            }
        )
}

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}