package com.example.jb866q.githubtrendingrepos.view_layer.activities.main;

import com.example.jb866q.githubtrendingrepos.data_layer.DataManager;
import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.RepoItem;
import com.example.jb866q.githubtrendingrepos.utils.RealmUISingleton;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by jb866q on 8/16/18.
 */

public class MainPresenter implements MainPresenterInterface {

    private MainViewInterface activity;

    public MainPresenter(MainViewInterface activity){
        this.activity = activity;
    }

    @Override
    public void initMainView() {
        DataManager.getInstance().fetchGitHubAndroidRepos();
        initRealmListeners();
    }

    private void initRealmListeners() {
        Realm realm = RealmUISingleton.getInstance().getRealmInstance();
        RealmResults<RepoItem> repos = realm.where(RepoItem.class).findAll().sort("stargazers_count", Sort.DESCENDING);
        if(repos != null) activity.initRecyclerView(repos);

        repos.addChangeListener(new RealmChangeListener<RealmResults<RepoItem>>() {
            @Override
            public void onChange(RealmResults<RepoItem> repoItems) {
                if(repoItems != null) activity.initRecyclerView(repoItems);
            }
        });
    }
}
