package com.hisoka.wetterapp.ui.setting

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.hisoka.wetterapp.R

class SettingsFragment : PreferenceFragmentCompat() {

				override fun onCreatePreferences(savedInstanceState : Bundle?, rootKey : String?) {
								setPreferencesFromResource(R.xml.root_preferences, rootKey)
				}
}