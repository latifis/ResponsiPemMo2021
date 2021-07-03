package com.example.responsi.model.rujukan;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RujukanDiscoverResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<DataItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<DataItem> data){
		this.data = data;
	}

	public ArrayList<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RujukanDiscoverResponse{" + 
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}