package com.codility.multiplelanguage.model

import java.io.Serializable

/**
 * Created by Govind on 5/16/2018.
 */
class Language(name: String, code: String) : Serializable {

    var name: String? = name
    var code: String? = code

    companion object {

        fun getLanguageList(): ArrayList<Language> {
            val list = ArrayList<Language>()
            list.add(Language("Select Language", "lang"))
            list.add(Language("English", "en"))
            list.add(Language("Hindi", "hi"))
            list.add(Language("Bengali", "bn"))
            list.add(Language("Nepali", "ne"))
            list.add(Language("Swedish", "sv"))
            return list
        }
    }
}