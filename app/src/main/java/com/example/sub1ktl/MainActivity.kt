package com.example.sub1ktl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    companion object{
        const val PARCELABLE_ITEM ="Parcelable_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI(items).setContentView(this)

        initData()

    }

    private fun initData() {
        val id = resources.getIntArray(R.array.league_id)
        val name = resources.getStringArray(R.array.league_name)
        val image = resources.obtainTypedArray(R.array.league_image)
        val desc = resources.getStringArray(R.array.league_desc)

        items.clear()

        for (i in name.indices) {
            items.add(Item(name[i], id[i], image.getResourceId(i,0), desc[i]))
        }

        image.recycle()
    }

    class MainActivityUI(val items : List<Item>) : AnkoComponent<MainActivity> {

        override fun createView(ui: AnkoContext<MainActivity>) =  with(ui) {
            verticalLayout {
                padding = dip(16)
                recyclerView {
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = GridAdapter(context, items) {
                        startActivity<DetailActivity>(PARCELABLE_ITEM to it)
                        val toast = Toast.makeText(context, it.name, Toast.LENGTH_SHORT)
                        toast.show()
                    }
                }.lparams(width = matchParent, height = matchParent)
            }
        }
    }
}
