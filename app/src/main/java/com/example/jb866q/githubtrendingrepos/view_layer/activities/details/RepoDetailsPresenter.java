package com.example.jb866q.githubtrendingrepos.view_layer.activities.details;

import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.RepoItem;
import com.example.jb866q.githubtrendingrepos.utils.RealmUISingleton;

import io.realm.Realm;

/**
 * Created by jb866q on 8/16/18.
 */

public class RepoDetailsPresenter implements RepoDetailsPresenterInterface {

    private RepoDetailsInterface activity;

    public RepoDetailsPresenter(RepoDetailsInterface activity){
        this.activity = activity;
    }

    @Override
    public void initRepoDetails(long repoId) {
        Realm realm = RealmUISingleton.getInstance().getRealmInstance();
        RepoItem repo = realm.where(RepoItem.class).equalTo("id", repoId).findFirst();
        if(repo != null){
            activity.setActivityTitle(repo.geFull_Name());
            activity.setDescription(repo.getDescription());
            activity.setLanguage(repo.getLanguage());
            activity.setRepoStarCount("Starts: " + String.valueOf(repo.getStargazers_count()));
            activity.setWatchersCount("Watchers: " + String.valueOf(repo.getWatchers_count()));
            activity.setLicenseInfo(repo.getLicense());
            activity.setForkCount("Forks: " + String.valueOf(repo.getForks_count()));
        }else{
            activity.setDataUnavailableState();
        }
    }
}
