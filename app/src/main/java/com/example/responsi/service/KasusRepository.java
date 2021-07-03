package com.example.responsi.service;

import com.example.responsi.model.kasus.KasusDiscoverResponse;
import com.example.responsi.model.rujukan.RujukanDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasusRepository {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<KasusDiscoverResponse> getKasusDiscover();

    @GET("sebaran_v2/jabar/faskes")
    Call<RujukanDiscoverResponse> getRujukanDiscover();
}
