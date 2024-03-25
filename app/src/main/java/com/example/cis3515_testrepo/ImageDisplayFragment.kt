package com.example.cis3515_testrepo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider

const val ORIGINAL_IMAGE_KEY = "imageToDisplay"
class ImageDisplayFragment : Fragment() {

    private val CURRENT_IMAGE_KEY = "currentImage"
    private var currentImageId = 0

    private lateinit var imageView: ImageView

    lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageViewModel = ViewModelProvider(requireActivity())[ImageViewModel::class.java]

        if (savedInstanceState == null) {
            arguments?.run {
                currentImageId = getInt(ORIGINAL_IMAGE_KEY)
            }
        } else {
            currentImageId = savedInstanceState.getInt(CURRENT_IMAGE_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_display, container, false).apply {
            imageView = findViewById(R.id.imageView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.run {
            currentImageId = getInt(CURRENT_IMAGE_KEY)
            if (currentImageId == 0) changeImage(currentImageId)
        }

        changeImage(currentImageId)

        // Get LiveData from ViewModel
        imageViewModel.getSelectedImage().observe(requireActivity()) {
            changeImage(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENT_IMAGE_KEY, currentImageId)
    }

    fun changeImage(imageID: Int) {
        imageView.setImageResource(imageID)
    }

    companion object {
        fun newInstance(image: Int) = ImageDisplayFragment().apply {
            arguments = Bundle().apply { putInt(ORIGINAL_IMAGE_KEY, image) }
        }
    }
}