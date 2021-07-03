package com.example.responsi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi.model.kasus.ContentItem;
import com.example.responsi.model.kasus.KasusDiscoverResponse;
import com.example.responsi.model.rujukan.DataItem;
import com.example.responsi.model.rujukan.RujukanDiscoverResponse;
import com.example.responsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RujukanViewModel extends ViewModel{

    private ApiMain apiMain;
    private MutableLiveData<ArrayList<DataItem>> listDiscoverRujukan = new MutableLiveData<>();

    public void setRujukanDiscover(){

        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKasus().getRujukanDiscover().enqueue(new Callback<RujukanDiscoverResponse>() {
            @Override
            public void onResponse(Call<RujukanDiscoverResponse> call, Response<RujukanDiscoverResponse> response) {
                RujukanDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getData() != null){
                    ArrayList<DataItem> rujukanDiscoverItems = responseDiscover.getData();
                    listDiscoverRujukan.postValue(rujukanDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<RujukanDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<DataItem>> getRujukanDiscover(){
        return listDiscoverRujukan;
    }

}
