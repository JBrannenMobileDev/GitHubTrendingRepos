package com.example.jb866q.githubtrendingrepos.data_layer.apis;

import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.GitHubRepos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jb866q on 8/16/18.
 */

public interface GitHubApiService {
    /**
     * I chose to fetch repositories that had a topic of "Android" and
     * i sorted them by the start_count for determining the trending repositories.
     *
     *
     */
    @GET("search/repositories?q=android&sort=stars&order=desc&per_page=100")
    Call<GitHubRepos> getAndroidRepos(@Query("page_count") int page_count);
}
