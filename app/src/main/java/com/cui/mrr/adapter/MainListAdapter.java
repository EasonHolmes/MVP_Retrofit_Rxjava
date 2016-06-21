package com.cui.mrr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cui.mrr.R;
import com.cui.mrr.entity.ListEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuiyang on 16/6/20.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.Viewholder> {

    private ClickListener ItemclickListener;
    private ClickListener LongClickListener;
    private Context mContext;
    private List<ListEntity.ResultsEntity> list = new ArrayList<ListEntity.ResultsEntity>();

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        Glide.with(mContext).load(list.get(position).getUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setNewData(List<ListEntity.ResultsEntity> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyItemChanged(list.size());
    }
    public List<ListEntity.ResultsEntity> getData(){
        return list;
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private ImageView img;

        public Viewholder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_img);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ItemclickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            ItemclickListener.onLongClick(getAdapterPosition(), v);
            return true;
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.ItemclickListener = clickListener;
    }

    public void setOnLongClickListener(ClickListener clickListener) {
        this.LongClickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);

        void onLongClick(int position, View v);
    }
}
