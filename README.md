# Wishlist

Submitted by: **Dan Sevalie-Gborie**

**Wishlist** is an Android app that helps the user keep track of items they want to buy online. Users can add an item's name, price, and URL to a running list, and the list updates immediately.

Time spent: **X** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] User can add an item to the wishlist
  - [x] An item includes: Name, Price, URL
- [x] User can see their list of items based on previously inputted items
  - [x] New items are added to the list
  - [x] If items go past the screen's edge, the list is scrollable

The following **optional** features are implemented:

- [x] Wishlist app is customized with a theme to match a favorite online store
- [x] User can delete an item by long pressing on the item
- [x] User can open an item's URL by clicking on the item

The following **additional** features are implemented:

- [x] Inline validation errors on the input fields (name, price, URL) if the user tries to submit incomplete info
- [x] Tapping Submit clears the input fields and refocuses the Item Name field so multiple items can be added quickly

## Video Walkthrough

<!--
Record a video/GIF walkthrough of the app and add the link here so it
animates when this README is viewed, e.g.:
![Video Walkthrough](https://i.imgur.com/your-gif-id.gif)
-->

Here's a walkthrough of implemented user stories:

<img src='' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](https://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app, e.g.:

- Getting new items to show up in the `RecyclerView` after tapping Submit required calling `notifyItemInserted()` on the adapter after adding the item to the backing list.
- Made sure each row's height in `item_wishlist.xml` was set to `wrap_content` (not `match_parent`) so multiple rows can be visible at once.

## License

    Copyright [2006] [Dan Sevalie-Gborie]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
