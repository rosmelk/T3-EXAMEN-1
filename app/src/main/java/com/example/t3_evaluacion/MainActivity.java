package com.example.t3_evaluacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.t3_evaluacion.adapter.AnimeAdapter;
import com.example.t3_evaluacion.entidades.Animes;
import com.example.t3_evaluacion.services.AnimatServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Animes> animess = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimatServices service = retrofit.create(AnimatServices.class);
        Call<List<Animes>> call = service.getContacts();

        call.enqueue(new Callback<List<Animes>>() {
            @Override
            public void onResponse(Call<List<Animes>> call, Response<List<Animes>> response) {
                if(!response.isSuccessful()) {
                    Log.e("APP_VJ20202", "Error de aplicación");
                } else {
                    Log.i("APP_VJ20202", "Respuesta Correcta");
                    animess= response.body();
                    AnimeAdapter adapter = new AnimeAdapter(animess);

                    RecyclerView rv = findViewById(R.id.rvAnime);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    //rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Animes>> call, Throwable t) {
                Log.e("APP_VJ20202", "No hubo conectividad con el servicio web");
            }
        });

    }
}