package com.example.anisimov.vlad.task1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        ImageView mImage;

        PersonViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.rv_image);
        }
    }

    List<Integer> mImageIds;

    RVAdapter(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item, viewGroup, false);
        PersonViewHolder mPvh = new PersonViewHolder(v);
        return mPvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.mImage.setImageResource(mImageIds.get(i));
    }

    @Override
    public int getItemCount() {
        return mImageIds.size();
    }
}
