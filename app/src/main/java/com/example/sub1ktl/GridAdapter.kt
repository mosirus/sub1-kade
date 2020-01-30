package com.example.sub1ktl

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext

class GridAdapter(private  val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<GridAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ListItemAnko().createView(AnkoContext.create(parent.context)))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {

        fun bindItem(items: Item, listener: (Item) -> Unit ) {

                val name = itemView.findViewById<TextView>(ListItemAnko.nameItem)
                val image = itemView.findViewById<ImageView>(ListItemAnko.imageItem)

                name.text = items.name
                Glide.with(itemView.context).load(items.image).into(image)

                itemView.setOnClickListener { listener(items) }
            }
    }
}