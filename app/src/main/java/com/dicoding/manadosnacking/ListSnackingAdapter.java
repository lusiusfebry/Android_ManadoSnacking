package com.dicoding.manadosnacking;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class ListSnackingAdapter extends RecyclerView.Adapter<ListSnackingAdapter.ListViewHolder> {
    private ArrayList<Kuliner> listKuliner;
    private Context context;
    private OnItemClickCallback onItemClickCallback;



    public ListSnackingAdapter(ArrayList<Kuliner> listKuliner, Context context) {
        this.listKuliner = listKuliner;
        this.context = context;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListSnackingAdapter(ArrayList<Kuliner> list){
        this.listKuliner = list;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Kuliner data);
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_kuliner,parent,false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Kuliner kuliner = listKuliner.get(position);
        final String images = kuliner.getPhoto();
        final String title = kuliner.getNama();
        final String isi = kuliner.getKeterangan();
        holder.imgPhoto.setImageURI(Uri.parse(images));
        holder.tvName.setText(title);
        holder.tvKeterangan.setText(isi);

        Glide.with (holder.itemView.getContext())
                .load(kuliner.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        //holder.tvName.setText(kuliner.getNama());
        //holder.tvKeterangan.setText(kuliner.getKeterangan());
        //holder.imgPhoto.setImageURI(Uri.parse(images));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail(title,isi,images)
                ;
            }
        });
    }
    private void openDetail(String... details) {
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra("TITLE_KEY", details[0]);
        i.putExtra("ISI_KEY", details[1]);
        i.putExtra("IMAGES_KEY", details[2]);
        context.startActivity(i);

    }
    @Override
    public int getItemCount() {
        return listKuliner.size();
    }
    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName,tvKeterangan;
        //LinearLayout relativeLayout;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvKeterangan = itemView.findViewById(R.id.tv_item_deskripsi);
            //relativeLayout = itemView.findViewById(R.id.sv_main);
            //activeMain = itemView.findViewById(R.id.row_detail);
        }
    }


}
