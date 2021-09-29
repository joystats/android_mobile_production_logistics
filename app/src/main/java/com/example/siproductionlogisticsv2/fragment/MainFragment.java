package com.example.siproductionlogisticsv2.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.adapter.OrderAdapter;
import com.example.siproductionlogisticsv2.adapter.PalletAdapter;
import com.example.siproductionlogisticsv2.dao.OrderItemCollectionDao;
import com.example.siproductionlogisticsv2.dao.OrderItemDao;
import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;
import com.example.siproductionlogisticsv2.dao.PalletItemDao;
import com.example.siproductionlogisticsv2.manager.ForkliftOutBound;
import com.example.siproductionlogisticsv2.manager.HttpManager;
import com.example.siproductionlogisticsv2.manager.LoginZone;
import com.example.siproductionlogisticsv2.manager.OrderManager;
import com.example.siproductionlogisticsv2.manager.PalletManager;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    /*******
     * Variables zone
     */
    View rootView;
    private OrderAdapter orderAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    List<String> zone = new ArrayList<>();
    List<String> forklift_outbound_zone = new ArrayList<>();
    String zoneString;
    String forkliftOutboundZoneString;
    SearchView svSearch;

    /********
     * Functions zone
     */

    public interface FragmentListener {
        void onOrderItemClicked(OrderItemDao dao, int position);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstance(rootView);

        return rootView;
    }

    @Override
    public void onResume() {
        getZone();
        Call<OrderItemCollectionDao> call = HttpManager.getInstance().getService().getOrderWithZone(zoneString, forkliftOutboundZoneString);
        call.enqueue(new OrderCallback(OrderCallback.NEW_LOAD));

        orderAdapter.notifyDataSetChanged();
        super.onResume();
    }

    private void initInstance(View rootView) {
        orderAdapter = new OrderAdapter();
        orderAdapter.setDao(OrderManager.getInstance().getCollectionDao());
        ListView listView = rootView.findViewById(R.id.listView);
        swipeRefreshLayout = rootView.findViewById(R.id.swipeRefreshLayout);
        listView.setAdapter(orderAdapter);
        svSearch = rootView.findViewById(R.id.svSearch);

        //Call<PalletItemCollectionDao> call = HttpManager.getInstance().getService().loadPallet();
        //List<String> zone = new ArrayList<>();
        //zone.add("A1");
        //zone.add("A2");
        //zone.add("F");
        //zone.add("OEM");
        //:TODO แก้ให้เป็น zone จาก LoginZone
        getZone();

        Call<OrderItemCollectionDao> call = HttpManager.getInstance().getService().getOrderWithZone(zoneString, forkliftOutboundZoneString);
        call.enqueue(new OrderCallback(OrderCallback.NEW_LOAD));

        listView.setOnItemClickListener(itemClickListener);

        swipeRefreshLayout.setOnRefreshListener(listener);

        svSearch.setOnQueryTextListener(queryTextListener);

    }

    private void getZone() {

        if (LoginZone.getInstance().getZoneA1()) {
            zone.add("A1");
        }
        if (LoginZone.getInstance().getZoneA2()) {
            zone.add("A2");
        }
        if (LoginZone.getInstance().getZoneB()) {
            zone.add("B");
        }
        if (LoginZone.getInstance().getZoneC()) {
            zone.add("C");
        }
        if (LoginZone.getInstance().getZoneD()) {
            zone.add("D");
        }
        if (LoginZone.getInstance().getZoneE()) {
            zone.add("E");
        }
        if (LoginZone.getInstance().getZoneF()) {
            zone.add("F");
        }
        if (LoginZone.getInstance().getZoneG()) {
            zone.add("G");
        }
        if (LoginZone.getInstance().getZoneGMP()) {
            zone.add("GMP");
        }
        if (LoginZone.getInstance().getZoneH()) {
            zone.add("H");
        }
        if (LoginZone.getInstance().getZoneI()) {
            zone.add("I");
        }
        if (LoginZone.getInstance().getZoneJ()) {
            zone.add("J");
        }
        if (LoginZone.getInstance().getZoneK()) {
            zone.add("K");
        }
        if (LoginZone.getInstance().getZoneOEM()) {
            zone.add("OEM");
        }
        if (LoginZone.getInstance().getZoneFG()) {
            zone.add("FG");
        }
        zoneString = "'" + TextUtils.join("','", zone) + "'";

        /**forflift ourbound**/
        if (ForkliftOutBound.getInstance().getZoneA1()) {
            forklift_outbound_zone.add("A1");
        }
        if (ForkliftOutBound.getInstance().getZoneA2()) {
            forklift_outbound_zone.add("A2");
        }
        if (ForkliftOutBound.getInstance().getZoneB()) {
            forklift_outbound_zone.add("B");
        }
        if (ForkliftOutBound.getInstance().getZoneC()) {
            forklift_outbound_zone.add("C");
        }
        if (ForkliftOutBound.getInstance().getZoneD()) {
            forklift_outbound_zone.add("D");
        }
        if (ForkliftOutBound.getInstance().getZoneE()) {
            forklift_outbound_zone.add("E");
        }
        if (ForkliftOutBound.getInstance().getZoneF()) {
            forklift_outbound_zone.add("F");
        }
        if (ForkliftOutBound.getInstance().getZoneG()) {
            forklift_outbound_zone.add("G");
        }
        if (ForkliftOutBound.getInstance().getZoneGMP()) {
            forklift_outbound_zone.add("GMP");
        }
        if (ForkliftOutBound.getInstance().getZoneH()) {
            forklift_outbound_zone.add("H");
        }
        if (ForkliftOutBound.getInstance().getZoneI()) {
            forklift_outbound_zone.add("I");
        }
        if (ForkliftOutBound.getInstance().getZoneJ()) {
            forklift_outbound_zone.add("J");
        }
        if (ForkliftOutBound.getInstance().getZoneK()) {
            forklift_outbound_zone.add("K");
        }
        if (ForkliftOutBound.getInstance().getZoneOEM()) {
            forklift_outbound_zone.add("OEM");
        }
        if (ForkliftOutBound.getInstance().getZoneFG()) {
            forklift_outbound_zone.add("FG");
        }
        forkliftOutboundZoneString = "'" + TextUtils.join("','", forklift_outbound_zone) + "'";
    }


    /************
     * Listener zone
     */

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            FragmentListener fragmentListener = (FragmentListener) getActivity();
            assert fragmentListener != null;
            if (orderAdapter.getDao().getData().get(position) != null) {
                //:TODO
                fragmentListener.onOrderItemClicked(orderAdapter.getDao().getData().get(position), position);
            } else {
                Toast.makeText(getContext(), "ไม่มีรายการ", Toast.LENGTH_SHORT).show();
            }
        }
    };

    SwipeRefreshLayout.OnRefreshListener listener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            swipeRefreshLayout.setRefreshing(false);
            getZone();
            Call<OrderItemCollectionDao> call = HttpManager.getInstance().getService().getOrderWithZone(zoneString, forkliftOutboundZoneString);
            call.enqueue(new OrderCallback(OrderCallback.NEW_LOAD));
        }
    };

    SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {

            String jobId = svSearch.getQuery().toString();

            Call<OrderItemCollectionDao> call = HttpManager.getInstance().getService().searchJob(jobId, zoneString, forkliftOutboundZoneString);
            call.enqueue(new OrderCallback(OrderCallback.NEW_LOAD));

            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    /***********
     *Inner zone
     */

    class OrderCallback implements Callback<OrderItemCollectionDao> {
        public static final int NEW_LOAD = 1;

        int mode;

        public OrderCallback(int mode) {
            this.mode = mode;
        }

        @Override
        public void onResponse(Call<OrderItemCollectionDao> call, Response<OrderItemCollectionDao> response) {
            zone.clear();
            forklift_outbound_zone.clear();
            //svSearch.setQuery("", false);
            svSearch.clearFocus();
            svSearch.setFocusable(false);
            if (response.isSuccessful()) {
                OrderItemCollectionDao dao = response.body();
                if (dao != null) {
                    if (dao.getData().size() == 0) {
                        Snackbar snack = Snackbar.make(rootView, "ไม่พบข้อมูล", BaseTransientBottomBar.LENGTH_SHORT);
                        //View view = snack.getView();
                        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
                        //params.gravity = Gravity.TOP;
                        //view.setLayoutParams(params);
                        snack.show();
                        //Toast.makeText(getContext(), "ไม่พบข้อมูล", Toast.LENGTH_LONG).show();
                    } else {
                        OrderManager.getInstance().setCollectionDao(dao);
                        orderAdapter.setDao(OrderManager.getInstance().getCollectionDao());
                        orderAdapter.notifyDataSetChanged();
                    }
                }

            } else {
                try {
                    Toast.makeText(getContext(), response.errorBody().string(), Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onFailure(Call<OrderItemCollectionDao> call, Throwable t) {
            zone.clear();
            forklift_outbound_zone.clear();
            Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
        }
    }

}
