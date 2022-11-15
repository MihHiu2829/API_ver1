package com.example.api_ver2.View.FRg;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.api_ver2.API.res.SessionRes;
import com.example.api_ver2.ViewModel.m000_mainVM;
import com.example.api_ver2.databinding.M000MainBinding;
import com.example.api_ver2.onMainCallBack;

public class m000_main extends base_Frg<M000MainBinding, m000_mainVM> {
    public static final String KEY_SESSION_ID = "KEY_SESSION_ID";

    @Override
    public void setCallBack(onMainCallBack callBack) {
                this.callBack = callBack ;
    }

    @Override
    protected void initViews() {
            binding.btLogin.setOnClickListener(view -> viewModel.getAuthen(
                    binding.edtUn.getText().toString() ,
                    binding.edtPass.getText().toString()
            ));
    }

    @Override
    protected Class<m000_mainVM> ClassVM() {
        return m000_mainVM.class;
    }

    @Override
    protected M000MainBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M000MainBinding.inflate(inflater,container,false);
    }

    @Override
    public void apiError(String key, int code, Object data) {
                    if(code == 401)
                        Toast.makeText(context, "Tai khoan hoac mat khau khong phu hop.", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(context, "Error: "+ code +", "+ data, Toast.LENGTH_SHORT).show();
                    }
    }

    @Override
    public void apiSuccess(String key, Object data) {
        if(key.equals(m000_mainVM.KEY_API_CREATE_SESSIONID))
        {
            SessionRes res = (SessionRes) data ;
            Toast.makeText(context, "Login is successful", Toast.LENGTH_SHORT).show();
            //save sessionID to sharepreference
        }
    }
}
