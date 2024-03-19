package com.example.cis3515_testrepo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

// Key for IntArray
const val IMAGE_ARRAY_KEY = "image_array_key"

class ImageFragment : Fragment() {

    // Variables to be accessible in changeImage()
    private lateinit var images: IntArray
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 'arguments' is a Bundle
        arguments?.getIntArray(IMAGE_ARRAY_KEY)?.run {
            // If IntArray found, define images to the IntArray
            images = this
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_image, container, false).apply {
            // Make the imageView call changeImage() instead
            imageView = findViewById<ImageView>(R.id.imageView).apply {
                setOnClickListener { changeImage() }
            }
        }
    }

    // When fragment is created, call changeImage() to display an initial image.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeImage()
    }

    // A function to change the fragment's current image. The main reason for this function is that
    // it is accessible in MainActivity.
    fun changeImage() {
        imageView.setImageResource(images.random())
    }
}
