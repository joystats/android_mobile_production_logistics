package com.example.siproductionlogisticsv2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.siproductionlogisticsv2.R;

public class OrderListItem extends FrameLayout {

    CardView cardViewLayout;
    private TextView jobId;
    private TextView jobName;
    private TextView partName;
    private TextView sig;
    private TextView outBound;
    private TextView inBound;
    private TextView amount;
    private TextView waitTime;
    private TextView orderCode;

    public OrderListItem(@NonNull Context context) {
        super(context);
        initInflate();
        initInstance();
    }

    public OrderListItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstance();
    }

    public OrderListItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstance();
    }

    public OrderListItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstance();
    }

    private void initInstance() {
        cardViewLayout = findViewById(R.id.cardVIewLayout);
        jobId = findViewById(R.id.jobId);
        jobName = findViewById(R.id.jobName);
        partName = findViewById(R.id.partName);
        sig = findViewById(R.id.sig);
        outBound = findViewById(R.id.outBound);
        inBound = findViewById(R.id.inBound);
        amount = findViewById(R.id.amount);
        waitTime = findViewById(R.id.waitTime);
        orderCode = findViewById(R.id.order_code);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.order_list_item, this);
    }

    public void setJobId(String txt) {
        this.jobId.setText(txt.toUpperCase());
    }
    public void setJobName(String jobName) {
        this.jobName.setText(jobName);
    }

    public void setPartName(String partName) {
        this.partName.setText(partName);
    }

    public void setOrderCode(String orderCode) {
        this.orderCode.setText(orderCode);
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

    public void setAmount(String amount) {
        this.amount.setText(amount + " พาเลท");
    }


    public void setWaitTime(int waitTime) {
        this.waitTime.setText(waitTime + " นาที");
    }
}
