package com.codepath.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Backing list for the wishlist. Shared by reference with the adapter,
    // so mutations here (or in the adapter) are reflected on screen once we
    // notify the adapter.
    private val wishlist: MutableList<WishlistItem> = mutableListOf()
    private lateinit var adapter: WishlistAdapter

    private lateinit var nameEt: EditText
    private lateinit var priceEt: EditText
    private lateinit var urlEt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Look up the RecyclerView in the layout
        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)

        // Create the adapter, passing in our (currently empty) list of items.
        // The trailing lambda runs whenever an item is removed via long-press.
        adapter = WishlistAdapter(wishlist) { removedItem ->
            Toast.makeText(this, getString(R.string.item_removed, removedItem.name), Toast.LENGTH_SHORT).show()
        }

        // Attach the adapter to the RecyclerView to populate items
        wishlistRv.adapter = adapter
        // Set layout manager to position the items in a vertical scrolling list
        wishlistRv.layoutManager = LinearLayoutManager(this)

        // Look up the input fields and submit button
        nameEt = findViewById(R.id.nameEt)
        priceEt = findViewById(R.id.priceEt)
        urlEt = findViewById(R.id.urlEt)
        val submitBtn = findViewById<Button>(R.id.submitBtn)

        submitBtn.setOnClickListener {
            addItemFromInput()
        }
    }

    /**
     * Reads the current values out of the input fields, validates them, and
     * -- if everything looks good -- adds a new [WishlistItem] to the list,
     * updates the RecyclerView, and clears the inputs for the next entry.
     */
    private fun addItemFromInput() {
        val name = nameEt.text.toString().trim()
        val priceText = priceEt.text.toString().trim()
        val url = urlEt.text.toString().trim()

        if (name.isEmpty()) {
            nameEt.error = getString(R.string.error_name_required)
            return
        }

        val price = priceText.toDoubleOrNull()
        if (price == null) {
            priceEt.error = getString(R.string.error_price_required)
            return
        }

        if (url.isEmpty()) {
            urlEt.error = getString(R.string.error_url_required)
            return
        }

        // Add the new item to our existing list of items
        val newItem = WishlistItem(name, price, url)
        wishlist.add(newItem)
        // Notify the adapter there's a new item so the RecyclerView layout is updated
        adapter.notifyItemInserted(wishlist.size - 1)

        // Clear the inputs so the user can add another item
        nameEt.text.clear()
        priceEt.text.clear()
        urlEt.text.clear()
        nameEt.requestFocus()
    }
}
