package com.pokemon.leonelatencio.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.pokemon.leonelatencio.myapplication.API.ApiClient;
import com.pokemon.leonelatencio.myapplication.API.ApiPokemon;
import com.pokemon.leonelatencio.myapplication.Model.PokemonFeed;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<PokemonFeed> data;
    private MainAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recicler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Call<PokemonFeed> call = ApiClient.get().getPokemonFeed();
        call.enqueue(new Callback<PokemonFeed>() {
            @Override
            public void onResponse(Call<PokemonFeed> call, Response<PokemonFeed> response) {
                switch (response.code()) {
                    case 200:
                        PokemonFeed data = response.body();
                        mAdapter = new MainAdapter(getApplicationContext(), data.getResults());
                        mRecyclerView.setAdapter(mAdapter);
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<PokemonFeed> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }
}
