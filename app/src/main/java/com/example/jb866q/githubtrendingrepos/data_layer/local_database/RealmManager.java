package com.example.jb866q.githubtrendingrepos.data_layer.local_database;
import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.RepoItem;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by Jonathan Brannen on 8/16/18.
 */

public class RealmManager {

    public void updateGitHubRepos(final RealmList<RepoItem> repos) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                for(RepoItem item : repos){
                    bgRealm.copyToRealmOrUpdate(item);
                }
            }
        });
        realm.close();
    }
}
