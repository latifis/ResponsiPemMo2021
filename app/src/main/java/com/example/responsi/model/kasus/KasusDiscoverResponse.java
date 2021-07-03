package com.example.responsi.model.kasus;

import com.google.gson.annotations.SerializedName;

public class KasusDiscoverResponse {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private Data data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"KasusResponse{" +
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' +
			"}";
		}
}