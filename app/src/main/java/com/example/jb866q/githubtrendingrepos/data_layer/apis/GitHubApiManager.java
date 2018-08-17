package com.example.jb866q.githubtrendingrepos.data_layer.apis;

import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.GitHubRepos;
import com.example.jb866q.githubtrendingrepos.utils.Callback;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jb866q on 8/16/18.
 */

public class GitHubApiManager {
    private static final String BASE_URL = "https://api.github.com/";
    private Retrofit retrofit;
    private GitHubApiService apiService;

    public GitHubApiManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(GitHubApiService.class);
    }

    public void getAndroidRepos(final Callback<GitHubRepos> responseCallback, int page){
        apiService.getAndroidRepos(page).enqueue(new retrofit2.Callback<GitHubRepos>() {
            @Override
            public void onResponse(Call<GitHubRepos> call, Response<GitHubRepos> response) {
                if(response.isSuccessful() && response.body() != null) {
                    responseCallback.onResponse(response.body());
                }else{
                    onFailure(call, new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<GitHubRepos> call, Throwable t) {
                responseCallback.onFailure(new Exception(t.getMessage()));
            }
        });
    }
}
