package com.example.anisimov.vlad.task1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {
    private List<Integer> mImageIds;

    public RVAdapter(List<Integer> ImageIds) {
        mImageIds = ImageIds;
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        PersonViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.rv_image);
        }
    }


    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item, viewGroup, false);
        PersonViewHolder personViewHolder = new PersonViewHolder(v);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.mImageView.setImageResource(mImageIds.get(i));
    }

    @Override
    public int getItemCount() {
        return mImageIds.size();
    }
}
