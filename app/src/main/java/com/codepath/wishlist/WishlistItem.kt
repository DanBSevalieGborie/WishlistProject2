package com.codepath.wishlist

/**
 * Model representing a single item on the user's wishlist.
 *
 * @property name the name of the item, e.g. "Llama Mug"
 * @property price the price of the item, e.g. 14.75
 * @property url a link to where the item can be purchased
 */
data class WishlistItem(
    val name: String,
    val price: Double,
    val url: String
)
