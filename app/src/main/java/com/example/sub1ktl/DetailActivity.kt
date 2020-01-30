package com.example.sub1ktl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getParcelableExtra<Item>(MainActivity.PARCELABLE_ITEM)
        DetailAnkoUI(item).setContentView(this)
    }

    class DetailAnkoUI(val item : Item) : AnkoComponent<DetailActivity>{
        companion object {
            const val image_league = 1
            const val name_league = 2
            const val desc_league= 3
        }
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout{
                padding = dip(16)
                imageView {
                    id = image_league
                    Glide.with(this)
                        .load(item.image)
                        .into(this)
                }.lparams(width = matchParent, height = dip(200)){
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView {
                    id = name_league
                    text = item.name
//                    textSize = 20f
                    textSize = sp(8).toFloat()
                }.lparams(width = wrapContent, height = wrapContent ){
                    topMargin = dip(10)
                    horizontalMargin = dip(15)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView {
                    id = desc_league
                    text = item.desc
                }.lparams(width = matchParent, height = wrapContent){
                    topMargin = dip(10)
                    horizontalMargin = dip(15)
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }
        }
    }
}

