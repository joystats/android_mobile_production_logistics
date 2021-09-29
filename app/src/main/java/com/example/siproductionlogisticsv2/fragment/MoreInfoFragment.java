package com.example.siproductionlogisticsv2.fragment;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.adapter.PalletAdapter;
import com.example.siproductionlogisticsv2.dao.PalletAcceptDao;
import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;
import com.example.siproductionlogisticsv2.dao.PalletItemDao;
import com.example.siproductionlogisticsv2.manager.HttpManager;
import com.example.siproductionlogisticsv2.manager.LoginManager;
import com.example.siproductionlogisticsv2.manager.PalletManager;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoreInfoFragment extends Fragment {
    PalletItemCollectionDao collectionDao;
    PalletItemDao dao;
    PalletAdapter palletAdapter;
    int position;
    TextView palletCode;
    private TextView jobId;
    private TextView partName;
    private TextView sig;
    private TextView outBound;
    private TextView inBound;
    private TextView waitTime;
    Button btnAccept;
    String empId;


    public interface MoreInfoListener {
        void onCloseActivity();
    }

    public MoreInfoFragment(PalletItemDao dao, int position) {
        this.dao = dao;
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_more_info, container, false);
        initInstance(rootView);
        return rootView;
    }

    private void initInstance(View rootView) {

        //SharedPreferences pref = getContext().getSharedPreferences("dummy", Context.MODE_PRIVATE);
        //empId = pref.getString("empId", null);
        empId = LoginManager.getInstance().getLoginDao().getEmpId();

        btnAccept = rootView.findViewById(R.id.btnAccept);

        palletCode = rootView.findViewById(R.id.palletCode);
        jobId = rootView.findViewById(R.id.jobId);
        partName = rootView.findViewById(R.id.partName);
        sig = rootView.findViewById(R.id.sig);
        outBound = rootView.findViewById(R.id.outBound);
        inBound = rootView.findViewById(R.id.inBound);
        waitTime = rootView.findViewById(R.id.waitTime);

        palletCode.setText(dao.getPalletCode());
        partName.setText(dao.getPartName());
        jobId.setText(dao.getJobId());
        sig.setText(dao.getSig());
        outBound.setText(dao.getOutBound());
        inBound.setText(dao.getInBound());
        waitTime.setText(dao.getWaitTime() + " นาที");
        if (dao.getWaitTime() > 10) {
            waitTime.setTextColor(Color.parseColor("#b51e1e"));
        }

        collectionDao = PalletManager.getInstance().getCollectionDao();
        palletAdapter = new PalletAdapter();

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("แจ้งเตือน");
                builder.setMessage("กด \"ตกลง\" หากต้องการรับงาน\nกด \"ยกเลิก\" หากไม่รับงาน");
                builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Call<PalletAcceptDao> call = HttpManager.getInstance().getService().acceptPalletTransfer(dao.getPalletCode(), empId);
                        call.enqueue(new Callback<PalletAcceptDao>() {
                            @Override
                            public void onResponse(Call<PalletAcceptDao> call, Response<PalletAcceptDao> response) {
                                if (response.body().getSuccess()) {
                                    dialog.dismiss();
                                    collectionDao.getData().remove(position);
                                    PalletManager.getInstance().setCollectionDao(collectionDao);
                                    MoreInfoListener moreInfoListener = (MoreInfoListener) getActivity();
                                    moreInfoListener.onCloseActivity();
                                    Toast.makeText(getContext(), "บันทึกรับงานเรียบร้อยแล้ว", Toast.LENGTH_LONG).show();
                                } else {
                                    // Toast.makeText(getContext(),"กรุณาลองใหม่", Toast.LENGTH_LONG).show();
                                    Snackbar.make(rootView, "กรุณาลองใหม่1", BaseTransientBottomBar.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<PalletAcceptDao> call, Throwable t) {
                                //Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
                                Snackbar.make(rootView, t.toString(), BaseTransientBottomBar.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                /*EditText input = new EditText(getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                builder.setView(input);*/
                builder.show();
            }
        });
    }

}
