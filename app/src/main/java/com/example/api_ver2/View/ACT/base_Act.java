package com.example.api_ver2.View.ACT;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.api_ver2.View.FRg.base_Frg;
import com.example.api_ver2.ViewModel.Common_VM;
import com.example.api_ver2.onMainCallBack;

import java.lang.reflect.Constructor;

public abstract class   base_Act <T extends ViewBinding, M extends ViewModel> extends AppCompatActivity implements onMainCallBack {
   public T binding ;
   public M viewModel ;


    @Override
    public void ShowFragment(String TAG, Object data, boolean isBack) {
        try{
                Class<?>  clazz = Class.forName(TAG) ;
            Constructor<?> cons = clazz.getConstructor() ;
            base_Frg<?,?> frg = (base_Frg<?, ?>) cons.newInstance();
            frg.setData(data);
            frg.setCallBack(this);
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction() ;
            if(isBack)
                trans.addToBackStack(null) ;
            trans.replace(GetMainID(),frg,TAG ).commit() ;  

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected abstract int GetMainID();

    @Override
    public void backToPreviouse() {
        onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding() ;
        viewModel = new ViewModelProvider(this).get(ClassVM()) ;
        initViews();
        setContentView(binding.getRoot());
    }

    protected abstract Class<M> ClassVM();

    protected abstract void initViews();


    protected abstract T initViewBinding();


}
