package com.nhvn.forecastmvvm.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.nhvn.forecastmvvm.R

/**
 * Author: NGUYENHOANGVANNHA
 * Date: 9/15/2019
 * Project: Forecast MVVM
 */
class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}