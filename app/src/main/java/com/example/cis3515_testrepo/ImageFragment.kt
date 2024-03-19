package com.example.cis3515_testrepo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

const val IMAGE_ARRAY_KEY = "image_array_key"

class ImageFragment : Fragment() {

    private lateinit var images: IntArray
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getIntArray(IMAGE_ARRAY_KEY)?.run {
            images = this
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_image, container, false).apply {
            imageView = findViewById<ImageView>(R.id.imageView).apply {
                setOnClickListener { changeImage() }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeImage()
    }

    fun changeImage() {
        imageView.setImageResource(images.random())
    }

    companion object {
        fun newInstance(images: IntArray) = ImageFragment().apply {
            arguments = Bundle().apply { putIntArray(IMAGE_ARRAY_KEY, images) }
        }
    }
}