package com.example.jb866q.githubtrendingrepos.view_layer.activities.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jb866q.githubtrendingrepos.R;
import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.RepoItem;
import com.example.jb866q.githubtrendingrepos.utils.RecyclerItemClickListener;
import com.example.jb866q.githubtrendingrepos.view_layer.activities.details.RepoDetailsActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemClickListener<RepoItem>, MainViewInterface{
    private RecyclerView reposRv;
    private RepoRecyclerAdapter recyclerAdapter;
    private MainPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reposRv = findViewById(R.id.repos_rv);
        presenter = new MainPresenter(this);
        presenter.initMainView();
    }

    @Override
    public void onItemClicked(RepoItem repo) {
        Intent detailsPageIntent = new Intent(getApplicationContext(), RepoDetailsActivity.class);
        detailsPageIntent.putExtra(getResources().getString(R.string.repo_id), repo.getId());
        startActivity(detailsPageIntent);
    }

    @Override
    public void initRecyclerView(List<RepoItem> repos) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        reposRv.setLayoutManager(mLayoutManager);
        reposRv.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));
        recyclerAdapter = new RepoRecyclerAdapter(repos,this);
        reposRv.setAdapter(recyclerAdapter);
    }
}
