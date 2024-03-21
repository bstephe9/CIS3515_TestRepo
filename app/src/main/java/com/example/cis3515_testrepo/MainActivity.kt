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

        val fragment1 = ImageFragment.newInstance(letter_images)
        val fragment2 = ImageFragment.newInstance(number_images)

        /**
         * savedInstanceState is null where there is no fragment attached to
         * the parent activity.
         * Therefore, we want this block to run on the first call of
         * onCreate() only.
         */
        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.imageFragmentContainer1, fragment1)
                .add(R.id.imageFragmentContainer2, fragment2)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit()

        findViewById<Button>(R.id.button).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.imageFragmentContainer1, ImageFragment.newInstance(letter_images))
                .add(R.id.imageFragmentContainer2, ImageFragment.newInstance(number_images))
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit()
        }
    }
}