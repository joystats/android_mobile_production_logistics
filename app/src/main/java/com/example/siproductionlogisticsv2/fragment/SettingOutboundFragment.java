package com.example.siproductionlogisticsv2.fragment;

import android.os.Bundle;

import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.manager.ForkliftOutBound;

public class SettingOutboundFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.forklift_outbound_preference);

        CheckBoxPreference zoneA1 = (CheckBoxPreference) findPreference("forklift_zone_a1");
        zoneA1.setChecked(ForkliftOutBound.getInstance().getZoneA1());
        CheckBoxPreference zoneA2 = (CheckBoxPreference) findPreference("forklift_zone_a2");
        zoneA2.setChecked(ForkliftOutBound.getInstance().getZoneA2());
        CheckBoxPreference zoneB = (CheckBoxPreference) findPreference("forklift_zone_b");
        zoneB.setChecked(ForkliftOutBound.getInstance().getZoneB());
        CheckBoxPreference zoneC = (CheckBoxPreference) findPreference("forklift_zone_c");
        zoneC.setChecked(ForkliftOutBound.getInstance().getZoneC());
        CheckBoxPreference zoneD = (CheckBoxPreference) findPreference("forklift_zone_d");
        zoneD.setChecked(ForkliftOutBound.getInstance().getZoneD());
        CheckBoxPreference zoneE = (CheckBoxPreference) findPreference("forklift_zone_e");
        zoneE.setChecked(ForkliftOutBound.getInstance().getZoneE());
        CheckBoxPreference zoneF = (CheckBoxPreference) findPreference("forklift_zone_f");
        zoneF.setChecked(ForkliftOutBound.getInstance().getZoneF());
        CheckBoxPreference zoneG = (CheckBoxPreference) findPreference("forklift_zone_g");
        zoneG.setChecked(ForkliftOutBound.getInstance().getZoneG());
        CheckBoxPreference zoneGMP = (CheckBoxPreference) findPreference("forklift_zone_gmp");
        zoneGMP.setChecked(ForkliftOutBound.getInstance().getZoneGMP());
        CheckBoxPreference zoneH = (CheckBoxPreference) findPreference("forklift_zone_h");
        zoneH.setChecked(ForkliftOutBound.getInstance().getZoneH());
        CheckBoxPreference zoneI = (CheckBoxPreference) findPreference("forklift_zone_i");
        zoneI.setChecked(ForkliftOutBound.getInstance().getZoneI());
        CheckBoxPreference zoneJ = (CheckBoxPreference) findPreference("forklift_zone_j");
        zoneJ.setChecked(ForkliftOutBound.getInstance().getZoneJ());
        CheckBoxPreference zoneK = (CheckBoxPreference) findPreference("forklift_zone_k");
        zoneK.setChecked(ForkliftOutBound.getInstance().getZoneK());
        CheckBoxPreference zoneOEM = (CheckBoxPreference) findPreference("forklift_zone_oem");
        zoneOEM.setChecked(ForkliftOutBound.getInstance().getZoneOEM());
        CheckBoxPreference zoneFG = (CheckBoxPreference) findPreference("forklift_zone_fg");
        zoneFG.setChecked(ForkliftOutBound.getInstance().getZoneFG());
    }
}
