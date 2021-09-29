package com.example.siproductionlogisticsv2.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.adapter.PalletActiveAdapter;
import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;
import com.example.siproductionlogisticsv2.dao.PalletItemDao;
import com.example.siproductionlogisticsv2.dao.PalletScanDao;
import com.example.siproductionlogisticsv2.manager.HttpManager;
import com.example.siproductionlogisticsv2.manager.LoginManager;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activedItem extends AppCompatActivity {
    ListView listView;
    PalletActiveAdapter palletActiveAdapter;
    PalletItemDao dao;
    SwipeRefreshLayout swipeRefreshLayout;
    String empId;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actived_item);
        initInstance();
    }

    private void initInstance() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("รอย้ายเข้าปลายทาง");


        //SharedPreferences pref = getSharedPreferences("dummy", Context.MODE_PRIVATE);
        //empId = pref.getString("empId", null);
        empId = LoginManager.getInstance().getLoginDao().getEmpId();

        listView = findViewById(R.id.listView);
        palletActiveAdapter = new PalletActiveAdapter();
        listView.setAdapter(palletActiveAdapter);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Call<PalletItemCollectionDao> call = HttpManager.getInstance().getService().loadAccept(LoginManager.getInstance().getLoginDao().getEmpId());
                call.enqueue(new PalletCallback());
            }
        });

        Call<PalletItemCollectionDao> call = HttpManager.getInstance().getService().loadAccept(LoginManager.getInstance().getLoginDao().getEmpId());
        call.enqueue(new PalletCallback());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dao = palletActiveAdapter.getDao().getData().get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(activedItem.this);
                builder.setTitle("สแกนรับงาน");
                builder.setMessage("กด \"ตกลง\" เพื่อเริ่มสแกนพาเลท");
                builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        IntentIntegrator intentIntegrator = new IntentIntegrator(activedItem.this);

                        intentIntegrator.setPrompt("กดปุ่มเพิ่มเสียง เมื่อต้องการเปิดแฟลช");
                        intentIntegrator.setBeepEnabled(true);
                        intentIntegrator.setOrientationLocked(true);
                        intentIntegrator.setCaptureActivity(Capture.class);
                        intentIntegrator.initiateScan();
                    }
                });
                builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.active_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        /*if (item.getItemId() == R.id.scan) {
            IntentIntegrator intentIntegrator = new IntentIntegrator(activedItem.this);

            intentIntegrator.setPrompt("กดปุ่มเพิ่มเสียง เมื่อต้องการเปิดแฟลช");
            intentIntegrator.setBeepEnabled(true);
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.setCaptureActivity(Capture.class);
            intentIntegrator.initiateScan();
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

    public String cleanPalletCode(String palletCode) {
        return palletCode.substring(0, 11);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult.getContents() != null) {
            String palletCode = cleanPalletCode(intentResult.getContents());

            if (palletCode.equals(dao.getPalletCode())) {

                Call<PalletScanDao> call = HttpManager.getInstance().getService().scanPalletTransferFromAcceptPage(palletCode, empId);
                call.enqueue(new Callback<PalletScanDao>() {
                    @Override
                    public void onResponse(Call<PalletScanDao> call, Response<PalletScanDao> response) {
                        if (response.body().getSuccess()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(activedItem.this);
                            builder.setTitle("แจ้งเพื่อทราบ");
                            builder.setMessage("สแกนขนย้ายพาเลทสำเร็จ");
                            builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();

                                    Call<PalletItemCollectionDao> call = HttpManager.getInstance().getService().loadAccept(empId);
                                    call.enqueue(new PalletCallback());
                                }
                            });
                            builder.show();
                        } else {
                            //  Toast.makeText(activedItem.this, "กรุณาลองใหม่", Toast.LENGTH_LONG).show();
                            Snackbar.make(listView, "กรุณาลองใหม่", BaseTransientBottomBar.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PalletScanDao> call, Throwable t) {
                        //Toast.makeText(activedItem.this, t.toString(), Toast.LENGTH_LONG).show();
                        Snackbar.make(listView, t.toString(), BaseTransientBottomBar.LENGTH_LONG).show();
                    }
                });


            } else {
                //  Toast.makeText(activedItem.this, "รหัสพาเลทไม่ถูกต้อง", Toast.LENGTH_LONG).show();
                Snackbar.make(listView, "รหัสพาเลทไม่ถูกต้อง", BaseTransientBottomBar.LENGTH_LONG).show();
            }


        }
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
                palletActiveAdapter.setDao(dao);
                palletActiveAdapter.notifyDataSetChanged();

            } else {
                try {
                    Toast.makeText(activedItem.this, response.errorBody().string(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onFailure(Call<PalletItemCollectionDao> call, Throwable t) {
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(activedItem.this, t.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}