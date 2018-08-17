package com.example.jb866q.githubtrendingrepos.view_layer.activities.main;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.jb866q.githubtrendingrepos.R;
import com.example.jb866q.githubtrendingrepos.data_layer.data_models.github_repo.RepoItem;
import com.example.jb866q.githubtrendingrepos.utils.RecyclerItemClickListener;

import java.util.List;

/**
 * Created by jb866q on 8/16/18.
 */

class RepoRecyclerAdapter extends RecyclerView.Adapter<RepoRecyclerAdapter.ViewHolder> {
    List<RepoItem> items;
    RecyclerItemClickListener<RepoItem> clickListener;

    public RepoRecyclerAdapter(List<RepoItem> repos,
                               RecyclerItemClickListener<RepoItem> clickListener) {
        this.items = repos;
        this.clickListener = clickListener;
    }

    @Override
    public RepoRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RepoItem repo = items.get(position);
        ViewHolder mHolder = holder;
        mHolder.bind(repo);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView repoName, starCount;
        FrameLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            repoName = itemView.findViewById(R.id.repo_name);
            starCount = itemView.findViewById(R.id.star_count);
            itemLayout = itemView.findViewById(R.id.repo_item_fl);

            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClicked(items.get(getLayoutPosition()));
                }
            });
        }

        public void bind(RepoItem repo) {
            repoName.setText(repo.geFull_Name());
            starCount.setText(String.valueOf(repo.getStargazers_count()));
        }
    }
}