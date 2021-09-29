package com.example.siproductionlogisticsv2.manager;

import com.example.siproductionlogisticsv2.dao.LoginCollectionDao;
import com.example.siproductionlogisticsv2.dao.OrderItemCollectionDao;
import com.example.siproductionlogisticsv2.dao.PalletAcceptDao;
import com.example.siproductionlogisticsv2.dao.PalletItemCollectionDao;
import com.example.siproductionlogisticsv2.dao.PalletScanDao;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("list")
    Call<PalletItemCollectionDao> loadPallet();

    @GET("list_with_zone/{zone}")
    Call<PalletItemCollectionDao> loadPalletWithZone(@Path("zone") String zone);

    @GET("get_order_with_zone/{zone}/{out_zone}")
    Call<OrderItemCollectionDao> getOrderWithZone(@Path("zone") String zone, @Path("out_zone") String outzone);

    @GET("search_pallet/{pallet_code}")
    Call<PalletItemCollectionDao> searchPallet(@Path("pallet_code") String palletCode);

    @GET("search_job/{job_id}/{zone}/{out_zone}")
    Call<OrderItemCollectionDao> searchJob(@Path("job_id") String jobId, @Path("zone") String zone, @Path("out_zone") String outzone);

    @GET("accept/{emp_id}")
    Call<PalletItemCollectionDao> loadAccept(@Path("emp_id") String empId);

    @GET("finish/{emp_id}")
    Call<PalletItemCollectionDao> loadFinish(@Path("emp_id") String empId);

    @GET("accept_pallet/{pallet_code}/{emp_id}")
    Call<PalletAcceptDao> acceptPalletTransfer(@Path("pallet_code") String palletCode, @Path("emp_id") String empId);

    @GET("scan_pallet_transfer/{order_code}/{pallet_code}/{emp_id}")
    Call<PalletScanDao> scanPalletTransfer(@Path("order_code") String orderCode, @Path("pallet_code") String palletCode, @Path("emp_id") String empId);

    @GET("scan/{pallet_code}/{emp_id}")
    Call<PalletScanDao> scanPalletTransferFromAcceptPage(@Path("pallet_code") String palletCode, @Path("emp_id") String empId);

    @POST("login")
    Call<LoginCollectionDao> loginWithCredentials(@Body LoginCredentials data);
}
