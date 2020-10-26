package com.kotlin.shoppinglist.ui.shopping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.shoppinglist.R
import com.kotlin.shoppinglist.model.ShoppingItem
import kotlinx.android.synthetic.main.layout_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    val viewmodel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder>() {

    inner class ViewHolder(itetmView: View) : RecyclerView.ViewHolder(itetmView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPosition = items[position]

        holder.itemView.apply {
            item_txt_title.text = currentPosition.name
            item_txt_count.text = currentPosition.amount.toString()

            item_img_remove.setOnClickListener {
                viewmodel.delete(currentPosition)
            }

            item_img_add.setOnClickListener {
                currentPosition.amount += 1
                viewmodel.upsert(currentPosition)
            }

            item_img_minus.setOnClickListener {
                if(currentPosition.amount <= 1){
                    viewmodel.delete(currentPosition)
                } else {
                    currentPosition.amount--
                    viewmodel.upsert(currentPosition)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}