package com.example.cis3515_testrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val letter_images = intArrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
        )

        val number_images = intArrayOf(
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
        )

        val fragment1 = ImageFragment()
        val fragment2 = ImageFragment()

        // Create bundles to pass image array into each ImageFragment's arguments
        val bundle1 = Bundle()
        bundle1.putIntArray(IMAGE_ARRAY_KEY, letter_images)
        fragment1.arguments = bundle1

        val bundle2 = Bundle()
        bundle2.putIntArray(IMAGE_ARRAY_KEY, number_images)
        fragment2.arguments = bundle2

        supportFragmentManager
            .beginTransaction()
            .add(R.id.imageFragmentContainer1, fragment1)
            .add(R.id.imageFragmentContainer2, fragment2)
            .commit()

        findViewById<Button>(R.id.button).setOnClickListener {
            fragment1.changeImage()
            fragment2.changeImage()
        }
    }
}