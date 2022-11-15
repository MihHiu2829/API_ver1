package com.example.api_ver2.View.FRg;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.api_ver2.ViewModel.Common_VM;
import com.example.api_ver2.databinding.M001FlashBinding;
import com.example.api_ver2.onMainCallBack;

public class m0001_flash extends base_Frg<M001FlashBinding, Common_VM> {
    @Override
    public void setCallBack(onMainCallBack callBack) {
        this.callBack = callBack ;
    }

    @Override
    protected void initViews() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    callBack.ShowFragment(m000_main.class.getName(),null,false);
            }
        },1000);
    }

    @Override
    protected Class<Common_VM> ClassVM() {
        return Common_VM.class;
    }

    @Override
    protected M001FlashBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return M001FlashBinding.inflate(inflater,container,false);
    }
}
