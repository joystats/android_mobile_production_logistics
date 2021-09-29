package com.example.siproductionlogisticsv2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.fragment.SettingsFragment;
import com.example.siproductionlogisticsv2.manager.LoginZone;

public class SettingsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    Toolbar toolbar;
    Boolean zoneCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initInstance();
        setupSharedPreferences();

        if (findViewById(R.id.contentContainer) != null) {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.contentContainer, new SettingsFragment(), "Setting")
                        .commit();
            }
        }
    }

    private void initInstance() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("โซน Inbound รับผิดชอบ");
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
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SettingsActivity.this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        if (key.equals("zone_a1")) {
            zoneCheck = sharedPreferences.getBoolean("zone_a1", false);
            LoginZone.getInstance().setZoneA1(zoneCheck);
        }
        if (key.equals("zone_a2")) {
            zoneCheck = sharedPreferences.getBoolean("zone_a2", false);
            LoginZone.getInstance().setZoneA2(zoneCheck);
        }
        if (key.equals("zone_b")) {
            zoneCheck = sharedPreferences.getBoolean("zone_b", false);
            LoginZone.getInstance().setZoneB(zoneCheck);
        }
        if (key.equals("zone_c")) {
            zoneCheck = sharedPreferences.getBoolean("zone_c", false);
            LoginZone.getInstance().setZoneC(zoneCheck);
        }
        if (key.equals("zone_d")) {
            zoneCheck = sharedPreferences.getBoolean("zone_d", false);
            LoginZone.getInstance().setZoneD(zoneCheck);
        }
        if (key.equals("zone_e")) {
            zoneCheck = sharedPreferences.getBoolean("zone_e", false);
            LoginZone.getInstance().setZoneE(zoneCheck);
        }
        if (key.equals("zone_f")) {
            zoneCheck = sharedPreferences.getBoolean("zone_f", false);
            LoginZone.getInstance().setZoneF(zoneCheck);
        }
        if (key.equals("zone_g")) {
            zoneCheck = sharedPreferences.getBoolean("zone_g", false);
            LoginZone.getInstance().setZoneG(zoneCheck);
        }
        if (key.equals("zone_gmp")) {
            zoneCheck = sharedPreferences.getBoolean("zone_gmp", false);
            LoginZone.getInstance().setZoneGMP(zoneCheck);
        }
        if (key.equals("zone_h")) {
            zoneCheck = sharedPreferences.getBoolean("zone_h", false);
            LoginZone.getInstance().setZoneH(zoneCheck);
        }
        if (key.equals("zone_i")) {
            zoneCheck = sharedPreferences.getBoolean("zone_i", false);
            LoginZone.getInstance().setZoneI(zoneCheck);
        }
        if (key.equals("zone_j")) {
            zoneCheck = sharedPreferences.getBoolean("zone_j", false);
            LoginZone.getInstance().setZoneJ(zoneCheck);
        }
        if (key.equals("zone_k")) {
            zoneCheck = sharedPreferences.getBoolean("zone_k", false);
            LoginZone.getInstance().setZoneK(zoneCheck);
        }
        if (key.equals("zone_oem")) {
            zoneCheck = sharedPreferences.getBoolean("zone_oem", false);
            LoginZone.getInstance().setZoneOEM(zoneCheck);
        }
        if (key.equals("zone_fg")) {
            zoneCheck = sharedPreferences.getBoolean("zone_fg", false);
            LoginZone.getInstance().setZoneFG(zoneCheck);
        }
    }
}