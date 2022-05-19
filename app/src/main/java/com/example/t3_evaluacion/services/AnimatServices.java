package com.example.t3_evaluacion.services;
import com.example.t3_evaluacion.entidades.Animes;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimatServices {

    @GET("/v3/8bdddde8-543f-4561-97d9-5000c610c138")
    Call<List<Animes>> getContacts();

}
