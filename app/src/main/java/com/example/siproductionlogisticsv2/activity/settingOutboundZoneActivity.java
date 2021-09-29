package com.example.siproductionlogisticsv2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.fragment.SettingOutboundFragment;
import com.example.siproductionlogisticsv2.manager.ForkliftOutBound;

public class settingOutboundZoneActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    Toolbar toolbar;
    Boolean zoneCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_outbound_zone);

        initInstance();
        setupSharedPreferences();

        if (findViewById(R.id.contentContainer) != null) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.contentContainer, new SettingOutboundFragment(), "SettingOutbound")
                        .commit();
            }
        }
    }

    private void initInstance() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("โซน Outbound รับผิดชอบ");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("forklift_zone_a1")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_a1", false);
            ForkliftOutBound.getInstance().setZoneA1(zoneCheck);
        }
        if (key.equals("forklift_zone_a2")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_a2", false);
            ForkliftOutBound.getInstance().setZoneA2(zoneCheck);
        }
        if (key.equals("forklift_zone_b")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_b", false);
            ForkliftOutBound.getInstance().setZoneB(zoneCheck);
        }
        if (key.equals("forklift_zone_c")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_c", false);
            ForkliftOutBound.getInstance().setZoneC(zoneCheck);
        }
        if (key.equals("forklift_zone_d")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_d", false);
            ForkliftOutBound.getInstance().setZoneD(zoneCheck);
        }
        if (key.equals("forklift_zone_e")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_e", false);
            ForkliftOutBound.getInstance().setZoneE(zoneCheck);
        }
        if (key.equals("forklift_zone_f")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_f", false);
            ForkliftOutBound.getInstance().setZoneF(zoneCheck);
        }
        if (key.equals("forklift_zone_g")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_g", false);
            ForkliftOutBound.getInstance().setZoneG(zoneCheck);
        }
        if (key.equals("forklift_zone_gmp")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_gmp", false);
            ForkliftOutBound.getInstance().setZoneGMP(zoneCheck);
        }
        if (key.equals("forklift_zone_h")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_h", false);
            ForkliftOutBound.getInstance().setZoneH(zoneCheck);
        }
        if (key.equals("forklift_zone_i")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_i", false);
            ForkliftOutBound.getInstance().setZoneI(zoneCheck);
        }
        if (key.equals("forklift_zone_j")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_j", false);
            ForkliftOutBound.getInstance().setZoneJ(zoneCheck);
        }
        if (key.equals("forklift_zone_k")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_k", false);
            ForkliftOutBound.getInstance().setZoneK(zoneCheck);
        }
        if (key.equals("forklift_zone_oem")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_oem", false);
            ForkliftOutBound.getInstance().setZoneOEM(zoneCheck);
        }
        if (key.equals("forklift_zone_fg")) {
            zoneCheck = sharedPreferences.getBoolean("forklift_zone_fg", false);
            ForkliftOutBound.getInstance().setZoneFG(zoneCheck);
        }
    }
}