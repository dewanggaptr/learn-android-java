package com.example.androidrecyclerview;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrecyclerview.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private ArrayList<FootballData> footballList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFootballList();
        @NonNull ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        mRecyclerView = findViewById(R.id.recyclerview);
        FootballAdapter footballAdapter = new FootballAdapter(MainActivity.this, footballList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(footballAdapter);
        footballAdapter.setOnItemClickListener(onItemClickListener);
    }

    private void setFootballList() {
        footballList = new ArrayList<>();
        FootballData data;
        data = new FootballData(getString(R.string.arema_name), getString(R.string.arema_description), R.drawable.arema, getString(R.string.arema_details));
        footballList.add(data);
        data = new FootballData(getString(R.string.persebaya_name), getString(R.string.persebaya_description), R.drawable.persebaya, getString(R.string.persebaya_details));
        footballList.add(data);
        data = new FootballData(getString(R.string.persija_name), getString(R.string.persija_description), R.drawable.persija, getString(R.string.persija_details));
        footballList.add(data);
        data = new FootballData(getString(R.string.persib_name), getString(R.string.persib_description), R.drawable.persib, getString(R.string.persib_details));
        footballList.add(data);
        data = new FootballData(getString(R.string.psis_name), getString(R.string.psis_description), R.drawable.psis, getString(R.string.psis_details));
        footballList.add(data);
        data = new FootballData(getString(R.string.pss_name), getString(R.string.pss_description), R.drawable.pss, getString(R.string.pss_details));
        footballList.add(data);
        data = new FootballData(getString(R.string.persita_name), getString(R.string.persita_description), R.drawable.persita, getString(R.string.persita_details));
        footballList.add(data);
        data = new FootballData(getString(R.string.psm_name), getString(R.string.psm_description), R.drawable.psm, getString(R.string.psm_details));
        footballList.add(data);
        data = new FootballData(getString(R.string.persipura_name), getString(R.string.persipura_description), R.drawable.persipura, getString(R.string.persipura_details));
        footballList.add(data);
    }

    public void openDetailActivity(int imageId, String details){
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("image", imageId);
        intent.putExtra("details", details);
        startActivity(intent);
    }

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            FootballData thisFootball = footballList.get(position);
            openDetailActivity(thisFootball.getImage(), thisFootball.getDetails());
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}