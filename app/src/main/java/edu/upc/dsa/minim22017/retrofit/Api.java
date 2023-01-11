package edu.upc.dsa.minim22017.retrofit;

import java.util.List;

import edu.upc.dsa.minim22017.domain.Repositories;
import edu.upc.dsa.minim22017.domain.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    String URL = "https://api.github.com/users/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("{user}")
    Call<User> getUser(@Path("user") String user);

    @GET("{user}/repos")
    Call<List<Repositories>> getRepositories(@Path("user") String user);

    @GET("{user}/following")
    Call<List<User>> getFollowing(@Path("user") String user);

    @GET("{user}/followers")
    Call<List<User>> getFollowers(@Path("user") String user);
}
