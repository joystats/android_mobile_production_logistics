package com.example.siproductionlogisticsv2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.adapter.PalletFinishAdapter;
import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;
import com.example.siproductionlogisticsv2.manager.HttpManager;
import com.example.siproductionlogisticsv2.manager.LoginManager;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinishedItemActivity extends AppCompatActivity {
    ListView listView;
    PalletFinishAdapter palletFinishAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    String empId;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_item);
        initInstance();
    }

    private void initInstance() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ขนย้ายเสร็จประจำวัน");

        empId = LoginManager.getInstance().getLoginDao().getEmpId();

        listView = findViewById(R.id.listView);
        palletFinishAdapter = new PalletFinishAdapter();
        listView.setAdapter(palletFinishAdapter);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Call<PalletItemCollectionDao> call = HttpManager.getInstance().getService().loadFinish(empId);
                call.enqueue(new PalletCallback());
            }
        });

        Call<PalletItemCollectionDao> call = HttpManager.getInstance().getService().loadFinish(empId);
        call.enqueue(new PalletCallback());
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /***********
     *Inner zone
     */

    class PalletCallback implements Callback<PalletItemCollectionDao> {

        @Override
        public void onResponse(Call<PalletItemCollectionDao> call, Response<PalletItemCollectionDao> response) {
            swipeRefreshLayout.setRefreshing(false);
            if (response.isSuccessful()) {
                PalletItemCollectionDao dao = response.body();
                palletFinishAdapter.setDao(dao);
                palletFinishAdapter.notifyDataSetChanged();
            } else {
                Snackbar.make(listView, "กรุณาลองใหม่", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<PalletItemCollectionDao> call, Throwable t) {
            swipeRefreshLayout.setRefreshing(false);
            //Toast.makeText(FinishedItemActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            Snackbar.make(listView, "เกิดข้อผิดพลาด", BaseTransientBottomBar.LENGTH_SHORT).show();
        }
    }
}