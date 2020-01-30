package com.example.sub1ktl

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class ListItemAnko : AnkoComponent<Context> {

    lateinit var image: ImageView
    lateinit var name: TextView

    companion object{
        val imageItem = 1
        val nameItem = 2
    }

    override fun createView(ui: AnkoContext<Context>): View = with(ui){

        return verticalLayout {
            padding = dip(16)

            imageView {
                id = imageItem
            }.lparams(width = dip(50), height = dip(50)){
                gravity = Gravity.CENTER_HORIZONTAL
                margin = dip(10)
            }
            textView {
                id = nameItem
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER_HORIZONTAL
                margin = dip(10)
            }
        }

    }
}