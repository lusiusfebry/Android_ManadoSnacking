package com.dicoding.manadosnacking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView rvKuliner;
    private ArrayList<Kuliner> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inisiasi RecyclerView
        rvKuliner = findViewById(R.id.rv_kuliner);
        rvKuliner.setHasFixedSize(true);

        list.addAll(KulinerData.getListData());
        showRecyclerList();
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        setMode (item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.menu_about:showAbout();break;
        }
    }

    public void showAbout(){
        Intent about = new Intent(MainActivity.this,AboutActivity.class);
        startActivity(about);
    }


    private void showRecyclerList() {
        rvKuliner.setLayoutManager(new LinearLayoutManager(this));
        ListSnackingAdapter listSnackingAdapter = new ListSnackingAdapter(list,this);
        rvKuliner.setAdapter(listSnackingAdapter);
        listSnackingAdapter.setOnItemClickCallback(new ListSnackingAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Kuliner data) {
                showSelected(data);
            }
        });
    }
    private void showSelected (Kuliner kuliner){
        Toast.makeText(this,kuliner.getPhoto(),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,kuliner.getNama(),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,kuliner.getKeterangan(),Toast.LENGTH_SHORT).show();
    }





}
