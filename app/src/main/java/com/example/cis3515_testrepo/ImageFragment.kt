package com.example.cis3515_testrepo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ImageFragment : Fragment() {

    // Variables to be accessible in changeImage()
    private lateinit var images: Array<Int>
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        images = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
        )

        return inflater.inflate(R.layout.fragment_image, container, false).apply {
            // Make the imageView call changeImage() instead
            imageView = findViewById<ImageView>(R.id.imageView).apply {
                setOnClickListener { changeImage() }
            }
        }
    }

    // A function to change the fragment's current image. The main reason for this function is that
    // it is accessible in MainActivity.
    fun changeImage() {
        imageView.setImageResource(images.random())
    }
}
