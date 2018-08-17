package com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jb866q on 8/16/18.
 */

public class GitHubRepos extends RealmObject{
    public static final String GITHUBREPOS_KEY = "gitHubRepos_key";

    @PrimaryKey
    private String key = GITHUBREPOS_KEY;
    private RealmList<RepoItem> items;

    public GitHubRepos() {
    }

    public RealmList<RepoItem> getItems() {
        return items;
    }

    public void setItems(RealmList<RepoItem> items) {
        this.items = items;
    }
}
