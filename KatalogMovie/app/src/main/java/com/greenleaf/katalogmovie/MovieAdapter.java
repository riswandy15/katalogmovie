package com.greenleaf.katalogmovie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.greenleaf.katalogmovie.model.Movie;
import com.greenleaf.katalogmovie.model.ResultsItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    private static final String TAG = MovieAdapter.class.getSimpleName();

    private Context context;
    private List<Movie> list;
    private AdapterCallback mAdapterCallback;

    public MovieAdapter(Context context, List<Movie> list, AdapterCallback adapterCallback){
        this.context = context;
        this.list = list;
        this.mAdapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie item = list.get(position);

        String title = item.getTitle();
        String description = item.getDescription();
        String date = item.getDate();

        holder.tv_title.setText(title);
        holder.tv_description.setText(description);
        holder.tv_date.setText(date);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear(){
        int size = this.list.size();
        this.list.clear();
        notifyItemRangeRemoved(0, size);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_description)
        TextView tv_description;
        @BindView(R.id.tv_date)
        TextView tv_date;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface AdapterCallback{
        void onRowClicked(int positon);
    }
}
