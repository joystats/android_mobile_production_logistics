package com.example.siproductionlogisticsv2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.dao.LoginCollectionDao;
import com.example.siproductionlogisticsv2.dao.LoginDao;
import com.example.siproductionlogisticsv2.dao.OrderItemDao;
import com.example.siproductionlogisticsv2.dao.PalletItemDao;
import com.example.siproductionlogisticsv2.fragment.MainFragment;
import com.example.siproductionlogisticsv2.manager.LoginManager;

public class MainActivity extends AppCompatActivity implements MainFragment.FragmentListener {
    LoginDao loginDao;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    Button logout;
    TextView empName;
    TextView empId;
    TextView zoneName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, new MainFragment(), "MainFragment")
                    .commit();
        }

    }

    private void initInstance() {

        //SharedPreferences pref = getSharedPreferences("dummy", Context.MODE_PRIVATE);
        // loginEmpName = pref.getString("empName", null);
        // loginEmpId = pref.getString("empId", null);

        LoginCollectionDao dao = LoginManager.getInstance().getLoginDao();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open_menu, R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();


        logout = (Button) findViewById(R.id.logout);
        empName = (TextView) findViewById(R.id.empName);
        empName.setText(dao.getEmpName());
        empId = (TextView) findViewById(R.id.empId);
        empId.setText(dao.getEmpId());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.setting_outbound_zone) {
            startActivity(new Intent(MainActivity.this, settingOutboundZoneActivity.class));
        }
        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }
        if (item.getItemId() == R.id.activedItem) {
            startActivity(new Intent(MainActivity.this, activedItem.class));
            return true;
        }
        if (item.getItemId() == R.id.logout) {
            finishAffinity();
            return true;
        }
        if (item.getItemId() == R.id.finishedItem) {
            startActivity(new Intent(MainActivity.this, FinishedItemActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onOrderItemClicked(OrderItemDao dao, int position) {
        Intent intent = new Intent(MainActivity.this, MoreInfoActivity.class);
        //intent.putExtra("dao", dao);
        intent.putExtra("position", position);
        Log.d("aaaa", "Clicked: " + position + "");
        startActivity(intent);
    }
}