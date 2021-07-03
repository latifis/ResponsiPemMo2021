package com.example.responsi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi.model.kasus.ContentItem;
import com.example.responsi.model.kasus.KasusDiscoverResponse;
import com.example.responsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusViewModel extends ViewModel {

    private ApiMain apiMain;
    private MutableLiveData<ArrayList<ContentItem>> listDiscoverKasus = new MutableLiveData<>();

    public void setKasusDiscover(){

        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKasus().getKasusDiscover().enqueue(new Callback<KasusDiscoverResponse>() {
            @Override
            public void onResponse(Call<KasusDiscoverResponse> call, Response<KasusDiscoverResponse> response) {
                KasusDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getData() != null){
                    ArrayList<ContentItem> kasusDiscoverItems = responseDiscover.getData().getContent();
                    listDiscoverKasus.postValue(kasusDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<KasusDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<ContentItem>> getKasusDiscover(){
        return listDiscoverKasus;
    }

}
