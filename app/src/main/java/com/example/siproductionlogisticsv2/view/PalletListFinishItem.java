package com.example.siproductionlogisticsv2.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

import com.example.siproductionlogisticsv2.R;

public class PalletListFinishItem extends FrameLayout {
    private TextView palletCode;
    CardView cardViewLayout;
    private TextView jobId;
    private TextView partName;
    private TextView sig;
    private TextView outBound;
    private TextView inBound;
    private TextView finishTime;
    private TextView statusName;

    public PalletListFinishItem(@NonNull Context context) {
        super(context);
        initInflate();
        iniIntance();
    }

    public PalletListFinishItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        iniIntance();
    }

    public PalletListFinishItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        iniIntance();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PalletListFinishItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        iniIntance();
    }

    private void initInflate() {
        inflate(getContext(), R.layout.pallet_finish_item, this);
    }

    private void iniIntance() {
        this.palletCode = findViewById(R.id.palletCode);
        cardViewLayout = findViewById(R.id.cardVIewLayout);

        this.jobId = findViewById(R.id.jobId);
        this.partName = findViewById(R.id.partName);
        this.sig = findViewById(R.id.sig);
        this.outBound = findViewById(R.id.outBound);
        this.inBound = findViewById(R.id.inBound);
        this.finishTime = findViewById(R.id.finishTime);
        this.statusName = findViewById(R.id.statusName);
    }

    public void setCardViewLayoutRed() {
        cardViewLayout.setCardBackgroundColor(Color.rgb(255, 200, 200));
    }

    public void setPalletCode(String code) {
        this.palletCode.setText(code);
    }

    public void setJobId(String txt) {
        this.jobId.setText(txt);
    }

    public void setPartName(String partName) {
        this.partName.setText(partName);
    }

    public void setSig(String sig) {
        this.sig.setText(sig);
    }

    public void setOutBound(String outBound) {
        this.outBound.setText(outBound);
    }

    public void setInBound(String inBound) {
        this.inBound.setText(inBound);
    }
    public void setFinishTime(String finishTime) {
        this.finishTime.setText(finishTime);
    }

    public void setStatusName(String statusName) {
        this.statusName.setText(statusName);
    }
}
