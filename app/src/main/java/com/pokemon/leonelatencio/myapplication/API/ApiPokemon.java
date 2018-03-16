package com.pokemon.leonelatencio.myapplication.API;

import com.pokemon.leonelatencio.myapplication.Model.PokemonFeed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiPokemon {
    /*
    These methods defines our API endpoints.
    All REST methods such as GET,POST,UPDATE,DELETE can be stated in here.
    */

    @GET("pokemon")
    Call<PokemonFeed> getPokemonFeed(
    );

}

