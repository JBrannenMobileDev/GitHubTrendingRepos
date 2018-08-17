package com.example.jb866q.githubtrendingrepos.view_layer.activities.main;

import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.RepoItem;
import java.util.List;

/**
 * Created by jb866q on 8/16/18.
 */

public interface MainViewInterface {
    void initRecyclerView(List<RepoItem> repos);
}
