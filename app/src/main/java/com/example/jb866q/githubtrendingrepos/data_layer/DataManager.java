package com.example.jb866q.githubtrendingrepos.data_layer;

import android.util.Log;

import com.example.jb866q.githubtrendingrepos.data_layer.apis.GitHubApiManager;
import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.GitHubRepos;
import com.example.jb866q.githubtrendingrepos.data_layer.local_database.RealmManager;
import com.example.jb866q.githubtrendingrepos.utils.Callback;

/**
 * Created by jb866q on 8/16/18.
 */

public class DataManager {
    private static DataManager single_instance = null;

    private GitHubApiManager githubApiManager;
    private RealmManager realmManager;

    // private constructor restricted to this class itself
    private DataManager()
    {
        githubApiManager = new GitHubApiManager();
        realmManager = new RealmManager();
    }

    // static method to create instance of Singleton class
    public static DataManager getInstance()
    {
        if (single_instance == null)
            single_instance = new DataManager();

        return single_instance;
    }



    public void fetchGitHubAndroidRepos(){
        //This would be a great place to implement Pagination. Androids new Paging library provides
        // a good solution for this.
        int numberOfpages = 10;
        Callback<GitHubRepos> responseCallback = new Callback<GitHubRepos>() {
            @Override
            public void onResponse(GitHubRepos repos) {
                getInstance().realmManager.updateGitHubRepos(repos.getItems());
            }

            @Override
            public void onFailure(Exception e) {
                Log.e(DataManager.class.getName(), "error fetching Android repos.");
            }
        };

        getInstance().githubApiManager.getAndroidRepos(responseCallback, numberOfpages);
    }
}
