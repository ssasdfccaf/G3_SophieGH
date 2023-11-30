package com.example.androidscaffolding.ui.Main.MyPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.example.androidscaffolding.R


class MySteing : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.setings,rootKey)


        val idPreferences :EditTextPreference? = findPreference("id")
        val colorPreference: ListPreference? = findPreference("test")

        // 컬러 색상 전체적으로 바꾸는 코드  ->   글자 크기 바꾸는 코드로 변경해야함.
        colorPreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
    }

}