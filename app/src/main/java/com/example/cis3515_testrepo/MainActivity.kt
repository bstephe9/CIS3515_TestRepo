package com.example.cis3515_testrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // Inflate resource into the menu object.
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Add functionality for each menu item
        when (item.itemId) {
            R.id.action_take_picture ->
                Toast.makeText(this, "Taking picture...", Toast.LENGTH_SHORT).show()

            R.id.action_delete_picture -> {
                AlertDialog.Builder(this)
                    .setTitle("Delete confirmation")
                    .setMessage("Are you sure you would like to delete this image?")
                    .setPositiveButton("Yes") { dialog, _ ->
                        Toast.makeText(this, "Deleting...", Toast.LENGTH_SHORT).show() }
                    .setNegativeButton("Never mind") { dialog, _ -> dialog.cancel()}
                    .setCancelable(false)
                    .show()
            }

            R.id.action_settings ->
                Toast.makeText(this, "Showing settings...", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}