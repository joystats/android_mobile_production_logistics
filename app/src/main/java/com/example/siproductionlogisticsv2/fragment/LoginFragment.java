package com.example.siproductionlogisticsv2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.activity.MainActivity;
import com.example.siproductionlogisticsv2.dao.LoginCollectionDao;
import com.example.siproductionlogisticsv2.manager.ForkliftOutBound;
import com.example.siproductionlogisticsv2.manager.HttpManager;
import com.example.siproductionlogisticsv2.manager.LoginCredentials;
import com.example.siproductionlogisticsv2.manager.LoginManager;
import com.example.siproductionlogisticsv2.manager.LoginZone;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    Button btnLogin;
    TextView empId;
    TextView password;

    public interface loginListener {
        void onFinishLogin();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        initInstance(rootView);
        return rootView;
    }

    public void initInstance(View rootView) {
        btnLogin = rootView.findViewById(R.id.login);
        empId = rootView.findViewById(R.id.emp_id);
        password = rootView.findViewById(R.id.password);
        btnLogin.setOnClickListener(clickListener);
    }

    /**********
     * Listener zone
     */

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Call<LoginCollectionDao> call = HttpManager.getInstance().getService().loginWithCredentials(new LoginCredentials(empId.getText().toString(), password.getText().toString()));
            call.enqueue(new Callback<LoginCollectionDao>() {
                @Override
                public void onResponse(Call<LoginCollectionDao> call, Response<LoginCollectionDao> response) {
                    if (response.isSuccessful()) {
                        LoginCollectionDao dao = response.body();
                        if (dao.getSuccess()) {

                            LoginManager.getInstance().setLoginDao(dao);
                            LoginZone.getInstance().clearZone();

                            ForkliftOutBound.getInstance().clearZone();
                            if (dao.getForkliftOutbound() != null) {
                                if (dao.getForkliftOutbound().size() > 0) {
                                    for (int i = 0; i < dao.getForkliftOutbound().size(); i++) {
                                        Log.d("forklift_outbound", dao.getForkliftOutbound().get(i).getZoneName());
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("a1")) {
                                            ForkliftOutBound.getInstance().setZoneA1(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("a2")) {
                                            ForkliftOutBound.getInstance().setZoneA2(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("b")) {
                                            ForkliftOutBound.getInstance().setZoneB(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("c")) {
                                            ForkliftOutBound.getInstance().setZoneC(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("d")) {
                                            ForkliftOutBound.getInstance().setZoneD(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("e")) {
                                            ForkliftOutBound.getInstance().setZoneE(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("f")) {
                                            ForkliftOutBound.getInstance().setZoneF(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("g")) {
                                            ForkliftOutBound.getInstance().setZoneG(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("gmp")) {
                                            ForkliftOutBound.getInstance().setZoneGMP(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("h")) {
                                            ForkliftOutBound.getInstance().setZoneH(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("i")) {
                                            ForkliftOutBound.getInstance().setZoneI(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("j")) {
                                            ForkliftOutBound.getInstance().setZoneJ(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("k")) {
                                            ForkliftOutBound.getInstance().setZoneK(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("oem")) {
                                            ForkliftOutBound.getInstance().setZoneOEM(true);
                                        }
                                        if (dao.getForkliftOutbound().get(i).getZoneName().equals("fg")) {
                                            ForkliftOutBound.getInstance().setZoneFG(true);
                                        }
                                    }
                                }
                            }
                            if (dao.getData() != null) {
                                if (dao.getData().size() > 0) {
                                    for (int i = 0; i < dao.getData().size(); i++) {
                                        Log.d("bb", dao.getData().get(i).getZoneName());
                                        if (dao.getData().get(i).getZoneName().equals("a1")) {
                                            LoginZone.getInstance().setZoneA1(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("a2")) {
                                            LoginZone.getInstance().setZoneA2(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("b")) {
                                            LoginZone.getInstance().setZoneB(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("c")) {
                                            LoginZone.getInstance().setZoneC(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("d")) {
                                            LoginZone.getInstance().setZoneD(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("e")) {
                                            LoginZone.getInstance().setZoneE(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("f")) {
                                            LoginZone.getInstance().setZoneF(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("g")) {
                                            LoginZone.getInstance().setZoneG(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("gmp")) {
                                            LoginZone.getInstance().setZoneGMP(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("h")) {
                                            LoginZone.getInstance().setZoneH(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("i")) {
                                            LoginZone.getInstance().setZoneI(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("j")) {
                                            LoginZone.getInstance().setZoneJ(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("k")) {
                                            LoginZone.getInstance().setZoneK(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("oem")) {
                                            LoginZone.getInstance().setZoneOEM(true);
                                        }
                                        if (dao.getData().get(i).getZoneName().equals("fg")) {
                                            LoginZone.getInstance().setZoneFG(true);
                                        }
                                    }
                                }
                            }

                            //SharedPreferences pref = getContext().getSharedPreferences("dummy", Context.MODE_PRIVATE);
                            //SharedPreferences.Editor editor = pref.edit();
                            //editor.putString("empName", dao.getEmpName());
                            //editor.putString("empId", dao.getEmpId());
                            //editor.apply();

                            startActivity(new Intent(getContext(), MainActivity.class));
                            LoginFragment.loginListener loginListener = (LoginFragment.loginListener) getActivity();
                            loginListener.onFinishLogin();
                        } else {
                            Snackbar snack = Snackbar.make(v, "เกิดข้อผิดพลาด", BaseTransientBottomBar.LENGTH_SHORT);
                            //View view = snack.getView();
                            //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
                            //params.gravity = Gravity.TOP;
                            //view.setLayoutParams(params);
                            snack.show();
                        }
                    } else {
                        Snackbar snack = Snackbar.make(v, "เกิดข้อผิดพลาด", BaseTransientBottomBar.LENGTH_SHORT);
                        //View view = snack.getView();
                        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
                        //params.gravity = Gravity.TOP;
                        //view.setLayoutParams(params);
                        snack.show();
                    }
                }

                @Override
                public void onFailure(Call<LoginCollectionDao> call, Throwable t) {
                    // Log.d("aa", t.toString());
                    Snackbar snack = Snackbar.make(v, t.toString(), BaseTransientBottomBar.LENGTH_SHORT);
                    //View view = snack.getView();
                    //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
                    //params.gravity = Gravity.TOP;
                    //view.setLayoutParams(params);
                    snack.show();
                }
            });
        }
    };
}
