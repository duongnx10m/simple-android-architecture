package com.duongnx.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duongnx.mvp.R;
import com.duongnx.mvp.data.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by duongnx on 3/21/2017.
 */

public class AdapterTasks extends RecyclerView.Adapter<AdapterTasks.VhTask> {

    private List<Task> tasks;
    private Context mContext;

    public AdapterTasks(Context context) {
        this.mContext = context;
    }

    public void setTasks(@NonNull List<Task> tasks) {
        this.tasks = checkNotNull(tasks);
    }

    @Override
    public VhTask onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_item_task, parent, false);

        return new VhTask(view);
    }

    @Override
    public void onBindViewHolder(VhTask holder, int position) {
        holder.setData(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        if (tasks == null)
            return 0;
        else return tasks.size();
    }

    public class VhTask extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public VhTask(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(Task task) {
            tvTitle.setText(task.getTitle());
        }
    }
}
