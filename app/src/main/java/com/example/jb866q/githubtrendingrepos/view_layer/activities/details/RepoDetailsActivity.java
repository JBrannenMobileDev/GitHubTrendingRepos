package com.example.jb866q.githubtrendingrepos.view_layer.activities.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jb866q.githubtrendingrepos.R;
import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.License;

public class RepoDetailsActivity extends AppCompatActivity implements RepoDetailsInterface{

    private RepoDetailsPresenterInterface presenter;
    private TextView repoDescription;
    private TextView starCount;
    private TextView watchCount;
    private TextView forkCount;
    private TextView language;
    private TextView licenseName;
    private TextView licenseUrl;
    private TextView noDataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        setTitle("");

        repoDescription = findViewById(R.id.description);
        starCount = findViewById(R.id.stars_count);
        watchCount = findViewById(R.id.watchers_count);
        forkCount = findViewById(R.id.forks_count);
        language = findViewById(R.id.language);
        licenseName = findViewById(R.id.license_name);
        licenseUrl = findViewById(R.id.license_url);
        noDataView = findViewById(R.id.no_data_view);

        presenter = new RepoDetailsPresenter(this);
        presenter.initRepoDetails(getIntent().getLongExtra(getResources().getString(R.string.repo_id), -1));
    }

    @Override
    public void setRepoStarCount(String count) {
        starCount.setText(count);
    }

    @Override
    public void setWatchersCount(String count) {
        watchCount.setText(count);
    }

    @Override
    public void setDescription(String description) {
        repoDescription.setText(description);
    }

    @Override
    public void setLanguage(String language) {
        this.language.setText(language);
    }

    @Override
    public void setLicenseInfo(License license) {
        licenseName.setText(license.getName());
        licenseUrl.setText(license.getUrl());
    }

    @Override
    public void setForkCount(String forks_count) {
        forkCount.setText(forks_count);
    }

    @Override
    public void setDataUnavailableState() {
        noDataView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setActivityTitle(String title) {
        setTitle(title);
    }
}
