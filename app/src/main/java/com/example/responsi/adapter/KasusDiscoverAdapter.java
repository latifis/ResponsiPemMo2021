package com.example.responsi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi.model.kasus.ContentItem;
import com.example.responsi.R;

import java.util.ArrayList;

public class KasusDiscoverAdapter extends RecyclerView.Adapter<KasusDiscoverAdapter.ViewHolder>{

    private ArrayList<ContentItem> contentItems = new ArrayList<>();
    private Context context;

    public KasusDiscoverAdapter(Context context){
        this.context =context;
    }

    public void setData(ArrayList<ContentItem> items){
        contentItems.clear();
        contentItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public KasusDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KasusDiscoverAdapter.ViewHolder holder, int position) {

        holder.tvTgl.setText(contentItems.get(position).getTanggal());
        holder.tvJumlahSembuh.setText(String.valueOf(contentItems.get(position).getConfirmationSelesai()) + " Kasus");
        holder.tvJumlahMeninggal.setText(String.valueOf(contentItems.get(position).getConfirmationMeninggal()) + " Kasus");
        holder.tvJumlahTerkonfirmasi.setText(String.valueOf(contentItems.get(position).getCONFIRMATION()) + " Kasus");
    }

    @Override
    public int getItemCount() {
        return contentItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvJumlahSembuh, tvJumlahMeninggal, tvJumlahTerkonfirmasi, tvJumlahTerkonfirmasiAtas, tvTgl;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTgl = itemView.findViewById(R.id.tv_tgl);
            cvItem = itemView.findViewById(R.id.itemlist_cv);

            tvJumlahSembuh = itemView.findViewById(R.id.tv_jumlah_sembuh);
            tvJumlahMeninggal = itemView.findViewById(R.id.tv_jumlah_meninggal);
            tvJumlahTerkonfirmasi = itemView.findViewById(R.id.tv_jumlah_terkonfirmasi);
            tvJumlahTerkonfirmasiAtas = itemView.findViewById(R.id.tv_jumlah_terkonfirmasi_atas);
        }
    }

}
