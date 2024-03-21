package com.example.cis3515_testrepo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

const val IMAGE_ARRAY_KEY = "image_array_key"

class ImageFragment : Fragment() {

    private val CURRENT_IMAGE_KEY = "currentImage"
    private var currentImageId = 0

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

        // Verify savedInstanceState value to see whether or not we have a current image id
        savedInstanceState?.run {
            currentImageId = getInt(CURRENT_IMAGE_KEY, 0)

            if (currentImageId == 0)
                changeImage()
            else
                changeImage(currentImageId)
        }

        changeImage()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Store image id in outState
        outState.putInt(CURRENT_IMAGE_KEY, currentImageId)
    }

    fun changeImage() {
        // When changeImage() is called, store image id and display image
        currentImageId = images.random()
        changeImage(currentImageId)
    }

    fun changeImage(imageID: Int) {
        imageView.setImageResource(imageID)
    }

    companion object {
        fun newInstance(images: IntArray) = ImageFragment().apply {
            arguments = Bundle().apply { putIntArray(IMAGE_ARRAY_KEY, images) }
        }
    }
}