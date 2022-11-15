package com.example.api_ver2.View.FRg;

import android.content.Context;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.example.api_ver2.OnAPICallBack;
import com.example.api_ver2.ViewModel.Common_VM;
import com.example.api_ver2.onMainCallBack;

public abstract class base_Frg <T extends ViewBinding,M extends Common_VM>
        extends  Fragment implements View.OnClickListener, OnAPICallBack {
   public T binding ;
   public M viewModel ;
        Object data ;
        onMainCallBack callBack ;
        Context context ;


    public void setData(Object data) {
        this.data = data;
    }

    public abstract  void setCallBack(onMainCallBack callBack) ;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context ;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = initViewBinding(inflater,container) ;
        viewModel = new ViewModelProvider(this).get(ClassVM());
        viewModel.setCallBack(this);
        initViews();
        return binding.getRoot() ;
    }

    protected abstract void initViews();

    @Override
    public void onClick(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
        DoClick( view);
    }

    private void DoClick(View view) {
    }

    protected abstract Class<M> ClassVM();

    protected abstract T initViewBinding(LayoutInflater inflater, ViewGroup container);

    @Override
    public void apiSuccess(String key, Object data) {
        // do nothing
    }

    @Override
    public void apiError(String key, int code, Object data) {

    }
}
