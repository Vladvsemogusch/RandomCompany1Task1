package com.example.anisimov.vlad.task1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        ImageView mImage; //[Comment] Wrong name, wrong visibility modifier

        PersonViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.rv_image);
        }
    }

    List<Integer> mImageIds; //[Comment] Wrong visibility modifier

    RVAdapter(List<Integer> mImageIds) { //[Comment] Wrong visibility modifier
        this.mImageIds = mImageIds; //[Comment] Without this
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView); //[Comment] What is doing this method?? Unnecessary method
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item, viewGroup, false);
        PersonViewHolder mPvh = new PersonViewHolder(v); //[Comment] mPvh not informative name
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
