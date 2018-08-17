package com.example.jb866q.githubtrendingrepos.view_layer.activities.details;

import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.License;
import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.RepoItem;

import java.util.List;

/**
 * Created by jb866q on 8/16/18.
 */

public interface RepoDetailsInterface {
    void setRepoStarCount(String count);
    void setWatchersCount(String count);
    void setDescription(String description);
    void setLanguage(String language);
    void setLicenseInfo(License license);
    void setForkCount(String forks_count);
    void setDataUnavailableState();
    void setActivityTitle(String title);
}
