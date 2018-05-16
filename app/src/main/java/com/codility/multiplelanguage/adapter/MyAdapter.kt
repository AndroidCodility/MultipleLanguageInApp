package com.codility.multiplelanguage.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.codility.multiplelanguage.model.Language
import com.codility.multiplelanguage.R

/**
 * Created by Govind on 5/16/2018.
 */
class MyAdapter(var context: Context, private var languageList: ArrayList<Language>) : BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val language = languageList.get(position)
        val row = (context as Activity).layoutInflater.inflate(R.layout.list_item, viewGroup, false)
        val tvName = row.findViewById(R.id.tvName) as TextView
        tvName.text = language.name
        return row
    }

    override fun getItem(i: Int): Any {
        return languageList[i]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return languageList.size
    }
}