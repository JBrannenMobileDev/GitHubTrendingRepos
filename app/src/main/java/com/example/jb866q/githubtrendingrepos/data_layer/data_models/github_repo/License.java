package com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jb866q on 8/16/18.
 */

public class License extends RealmObject{

    @PrimaryKey
    private String key;
    private String name;
    private String spdx_id;
    private String url;
    private String node_id;

    public License() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpdx_id() {
        return spdx_id;
    }

    public void setSpdx_id(String spdx_id) {
        this.spdx_id = spdx_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }
}
