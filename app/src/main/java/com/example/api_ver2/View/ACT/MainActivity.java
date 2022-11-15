package com.example.api_ver2.View.ACT;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.api_ver2.R;
import com.example.api_ver2.View.FRg.m0001_flash;
import com.example.api_ver2.ViewModel.Common_VM;
import com.example.api_ver2.databinding.ActivityMainBinding;

public class MainActivity extends base_Act<ActivityMainBinding, Common_VM> {


    @Override
    protected int GetMainID() {
        return R.id.Ln_Main ;  
    }

    @Override
    protected Class<Common_VM> ClassVM() {
        return Common_VM.class;
    }

    @Override
    protected void initViews() {
            ShowFragment(m0001_flash.class.getName(),null,false);
    }



    @Override
    protected ActivityMainBinding initViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}