package com.example.responsi.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi.model.kasus.ContentItem;
import com.example.responsi.R;
import com.example.responsi.model.rujukan.DataItem;

import java.util.ArrayList;

public class RujukanDiscoverAdapter extends RecyclerView.Adapter<RujukanDiscoverAdapter.ViewHolder> {
    private ArrayList<DataItem> dataItems = new ArrayList<>();
    private Context context;

    public RujukanDiscoverAdapter(Context context){
        this.context =context;
    }

    public void setData(ArrayList<DataItem> items){
        dataItems.clear();
        dataItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public RujukanDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_rs, parent,false);
        return new RujukanDiscoverAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RujukanDiscoverAdapter.ViewHolder holder, int position) {

        holder.tvNamaRS.setText(dataItems.get(position).getNama());
        holder.tvAlamatRS.setText(dataItems.get(position).getAlamat());
        holder.btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri IntentUri = Uri.parse("geo:0,0?q="+ Uri.encode(dataItems.get(position).getNama()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, IntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaRS, tvAlamatRS;
        CardView cvItem;
        Button btnMaps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvItem = itemView.findViewById(R.id.itemlist_rs_cv);
            btnMaps = itemView.findViewById(R.id.btn_maps);

            tvNamaRS = itemView.findViewById(R.id.tv_nama_rs);
            tvAlamatRS = itemView.findViewById(R.id.tv_alamat);

        }
    }
}
