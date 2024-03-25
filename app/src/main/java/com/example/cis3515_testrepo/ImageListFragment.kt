package com.example.cis3515_testrepo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val IMAGE_ARRAY_KEY = "imagearraykey"

class ImageListFragment : Fragment() {
    private lateinit var images: IntArray

    lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getIntArray(IMAGE_ARRAY_KEY)?.let {
                images = it
            }
        }

        /**
         * We want to scope this fragment against the activity to which this fragment is attached.
         * Instantiate ViewModel in onCreate() (since we can reference the activity here) and use
         * requireActivity() to get that activity.
         *
         * Specify which view model to instantiate against this scope using
         * [ImageViewModel::class.java].
         */
        imageViewModel = ViewModelProvider(requireActivity())[ImageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (view as RecyclerView) {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = CustomRecyclerAdapter(images) {
                // Update LiveData in ViewModel when user clicks an image
                imageViewModel.setSelectedImage(it)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(images: IntArray) =
            ImageListFragment().apply {
                arguments = Bundle().apply {
                    putIntArray(IMAGE_ARRAY_KEY, images)
                }
            }
    }
}

class CustomRecyclerAdapter(private val items: IntArray, private val callback: (Int)->Unit)
        : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView) {
        init {
            imageView.setOnClickListener { callback(items[adapterPosition]) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        // Create a runtime ImageView
        MyViewHolder(ImageView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(450, 450)
            setPadding(20, 0, 20, 0)
        })

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.setImageResource((items[position]))
    }

    override fun getItemCount() = items.size
}
