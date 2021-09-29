package com.example.siproductionlogisticsv2.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.dao.OrderItemDao;
import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;
import com.example.siproductionlogisticsv2.dao.PalletScanDao;
import com.example.siproductionlogisticsv2.fragment.MoreInfoFragment;
import com.example.siproductionlogisticsv2.manager.HttpManager;
import com.example.siproductionlogisticsv2.manager.LoginManager;
import com.example.siproductionlogisticsv2.manager.OrderManager;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoreInfoActivity extends AppCompatActivity {
    OrderItemDao dao;
    Toolbar toolbar;
    int position;
    private TextView jobId;
    private TextView jobName;
    private TextView partName;
    private TextView sig;
    private TextView outBound;
    private TextView inBound;
    private TextView amount;
    private TextView waitTime;
    private TextView orderCode;
    Button btnAccept;
    String empId;
    View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        parentLayout = findViewById(R.id.cardVIewLayout);
        position = getIntent().getIntExtra("position", 0);
        dao = OrderManager.getInstance().getCollectionDao().getData().get(position);

        initInstance();
    }

    private void initInstance() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("สแกนขนย้ายออก");

        empId = LoginManager.getInstance().getLoginDao().getEmpId();

        btnAccept = findViewById(R.id.btnAccept);

        jobId = findViewById(R.id.jobId);
        jobName = findViewById(R.id.jobName);
        partName = findViewById(R.id.partName);
        sig = findViewById(R.id.sig);
        outBound = findViewById(R.id.outBound);
        inBound = findViewById(R.id.inBound);
        amount = findViewById(R.id.amount);
        waitTime = findViewById(R.id.waitTime);
        orderCode = findViewById(R.id.order_code);

        partName.setText(dao.getPartName());
        jobId.setText(dao.getJobId().toUpperCase());
        jobName.setText(dao.getJobName());
        sig.setText(dao.getSig());
        outBound.setText(dao.getOutBound());
        inBound.setText(dao.getInBound());
        amount.setText(dao.getAmount() + " พาเลท");
        waitTime.setText(dao.getWaitTime() + " นาที");
        orderCode.setText(dao.getOrderCode());

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(MoreInfoActivity.this);

                intentIntegrator.setPrompt("กดปุ่มเพิ่มเสียง เมื่อต้องการเปิดแฟลช");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String cleanPalletCode(String palletCode) {
        return palletCode.substring(0, 11);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult.getContents() != null) {
            String palletCode = cleanPalletCode(intentResult.getContents());
            btnAccept.setText("กำลังบันทึกข้อมูล...");
            btnAccept.setBackgroundColor(Color.parseColor("#607d8b"));
            Call<PalletScanDao> call = HttpManager.getInstance().getService().scanPalletTransfer(dao.getOrderCode(), palletCode, empId);
            call.enqueue(new Callback<PalletScanDao>() {
                @Override
                public void onResponse(Call<PalletScanDao> call, Response<PalletScanDao> response) {
                    if (response.body().getSuccess()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MoreInfoActivity.this);
                        builder.setTitle("แจ้งเพื่อทราบ");
                        builder.setMessage("สแกนขนย้ายออกสำเร็จ");
                        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                btnAccept.setText("เริ่มสแกนขนย้ายออก");
                                //btnAccept.setBackgroundColor(Color.parseColor("#1fa67a"));
                                dialog.dismiss();

                                if(response.body().getFinishTransfer()){
                                    finish();
                                }

                                //Call<PalletItemCollectionDao> call = HttpManager.getInstance().getService().loadAccept(empId);
                                //call.enqueue(new activedItem.PalletCallback());
                            }
                        });
                        builder.show();
                    } else {
                        btnAccept.setText("เริ่มสแกนขนย้ายออก");
                        //btnAccept.setBackgroundColor(Color.parseColor("#ED5E54"));
                        Snackbar.make(parentLayout, "พาเลทไม่ถูกต้อง/พาเลทขนย้ายออกแล้ว", BaseTransientBottomBar.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<PalletScanDao> call, Throwable t) {
                    btnAccept.setText("เริ่มสแกนขนย้ายออก");
                    //btnAccept.setBackgroundColor(Color.parseColor("#ED5E54"));
                    Snackbar.make(parentLayout, t.toString(), BaseTransientBottomBar.LENGTH_LONG).show();
                }
            });


        }
    }
}