package com.codepath.wishlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

/**
 * RecyclerView.Adapter that binds a mutable list of [WishlistItem]s to
 * [item_wishlist.xml] rows.
 *
 * Stretch features implemented here:
 *  - Tapping an item opens its URL in the browser.
 *  - Long-pressing an item deletes it from the wishlist.
 */
class WishlistAdapter(
    private val items: MutableList<WishlistItem>,
    private val onItemDeleted: (WishlistItem) -> Unit
) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTv)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTv)
        val urlTextView: TextView = itemView.findViewById(R.id.urlTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val itemView = inflater.inflate(R.layout.item_wishlist, parent, false)
        // Return a new holder instance
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items[position]

        // Set item views based on views and data model
        holder.nameTextView.text = item.name
        holder.priceTextView.text = String.format(Locale.US, "%.2f", item.price)
        holder.urlTextView.text = item.url

        // Stretch feature: tapping an item opens its URL in the phone's browser
        holder.itemView.setOnClickListener {
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                holder.itemView.context.startActivity(browserIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(holder.itemView.context, "Invalid URL for " + item.name, Toast.LENGTH_LONG).show()
            }
        }

        // Stretch feature: long-pressing an item deletes it from the wishlist
        holder.itemView.setOnLongClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                val removedItem = items.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                onItemDeleted(removedItem)
            }
            true
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
