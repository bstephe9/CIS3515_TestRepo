package com.example.cis3515_testrepo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Defining the array of images in the ImageFragment (probably better to pass it in)
        val images = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
        )

        /* Retrieve the image view from the layout, setOnClickListener to display random image */
//        // Inflate the layout for this fragment
//        val layout = inflater.inflate(R.layout.fragment_image, container, false)
//        val imageView = layout.findViewById<ImageView>(R.id.imageView)
//        return layout

        // Using scope functions instead
        return inflater.inflate(R.layout.fragment_image, container, false).apply {
            findViewById<ImageView>(R.id.imageView).setOnClickListener {
                (it as ImageView).setImageResource(images.random())
            }
        }
    }
}
