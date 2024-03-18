package com.example.cis3515_testrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dessert_images = intArrayOf(
            R.drawable.ccf_caramelapple,
            R.drawable.ccf_celebration,
            R.drawable.ccf_chocolatecaramelicious,
            R.drawable.ccf_cinnaboncinnamoncwirl,
            R.drawable.ccf_coconutcreampie,
            R.drawable.ccf_freshstrawberry,
            R.drawable.ccf_godiva,
            R.drawable.ccf_lowlicious,
            R.drawable.ccf_original,
            R.drawable.ccf_pineappleupsidedown,
            R.drawable.ccf_saltedcaramel,
            R.drawable.ccf_verycherryghirardellichocolate
        )

        val fragment1 = ImageListFragment.newInstance(dessert_images)
        val fragment2 = ImageDisplayFragment.newInstance(R.drawable.ccf_caramelapple)

        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.imageFragmentContainer1, fragment1)
                .add(R.id.imageFragmentContainer2, fragment2)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
    }
}