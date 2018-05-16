package com.codility.multiplelanguage

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import com.codility.multiplelanguage.adapter.MyAdapter
import com.codility.multiplelanguage.model.Language
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

@Suppress("DEPRECATION")
/**
 * Created by Govind on 5/16/2018.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSpinner()

        btExit.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun setSpinner() {
        val myAdapter = MyAdapter(this, Language.getLanguageList())
        spinner.adapter = myAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                val language = adapterView.adapter.getItem(position) as Language
                if (position != 0) {
                    setLocale(language.code)
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }
    }

    fun setLocale(lang: String?) {
        val myLocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}