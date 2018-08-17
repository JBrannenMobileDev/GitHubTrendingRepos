package com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jb866q on 8/16/18.
 */

public class RepoItem extends RealmObject{

    @PrimaryKey
    private long id;
    private long stargazers_count;
    private long watchers_count;
    private long forks_count;
    private String full_name;
    private String language;
    private String description;
    private License license;

    public RepoItem() {
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(long stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public long getWatchers_count() {
        return watchers_count;
    }

    public void setWatchers_count(long watchers_count) {
        this.watchers_count = watchers_count;
    }

    public long getForks_count() {
        return forks_count;
    }

    public void setForks_count(long forks_count) {
        this.forks_count = forks_count;
    }

    public String geFull_Name() {
        return full_name;
    }

    public void setFull_Name(String name) {
        this.full_name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
