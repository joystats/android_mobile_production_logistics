package com.example.siproductionlogisticsv2.fragment;

import android.os.Bundle;

import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.manager.LoginZone;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preference);

        CheckBoxPreference zoneA1 = (CheckBoxPreference) findPreference("zone_a1");
        zoneA1.setChecked(LoginZone.getInstance().getZoneA1());
        CheckBoxPreference zoneA2 = (CheckBoxPreference) findPreference("zone_a2");
        zoneA2.setChecked(LoginZone.getInstance().getZoneA2());
        CheckBoxPreference zoneB = (CheckBoxPreference) findPreference("zone_b");
        zoneB.setChecked(LoginZone.getInstance().getZoneB());
        CheckBoxPreference zoneC = (CheckBoxPreference) findPreference("zone_c");
        zoneC.setChecked(LoginZone.getInstance().getZoneC());
        CheckBoxPreference zoneD = (CheckBoxPreference) findPreference("zone_d");
        zoneD.setChecked(LoginZone.getInstance().getZoneD());
        CheckBoxPreference zoneE = (CheckBoxPreference) findPreference("zone_e");
        zoneE.setChecked(LoginZone.getInstance().getZoneE());
        CheckBoxPreference zoneF = (CheckBoxPreference) findPreference("zone_f");
        zoneF.setChecked(LoginZone.getInstance().getZoneF());
        CheckBoxPreference zoneG = (CheckBoxPreference) findPreference("zone_g");
        zoneG.setChecked(LoginZone.getInstance().getZoneG());
        CheckBoxPreference zoneGMP = (CheckBoxPreference) findPreference("zone_gmp");
        zoneGMP.setChecked(LoginZone.getInstance().getZoneGMP());
        CheckBoxPreference zoneH = (CheckBoxPreference) findPreference("zone_h");
        zoneH.setChecked(LoginZone.getInstance().getZoneH());
        CheckBoxPreference zoneI = (CheckBoxPreference) findPreference("zone_i");
        zoneI.setChecked(LoginZone.getInstance().getZoneI());
        CheckBoxPreference zoneJ = (CheckBoxPreference) findPreference("zone_j");
        zoneJ.setChecked(LoginZone.getInstance().getZoneJ());
        CheckBoxPreference zoneK = (CheckBoxPreference) findPreference("zone_k");
        zoneK.setChecked(LoginZone.getInstance().getZoneK());
        CheckBoxPreference zoneOEM = (CheckBoxPreference) findPreference("zone_oem");
        zoneOEM.setChecked(LoginZone.getInstance().getZoneOEM());
        CheckBoxPreference zoneFG = (CheckBoxPreference) findPreference("zone_fg");
        zoneFG.setChecked(LoginZone.getInstance().getZoneFG());

    }
}
