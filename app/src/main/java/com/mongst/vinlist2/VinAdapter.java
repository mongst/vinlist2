package com.mongst.vinlist2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class VinAdapter extends RecyclerView.Adapter<VinAdapter.ViewHolder> {

    ArrayList<String> vins;

    public VinAdapter(ArrayList<String> vins) {
        this.vins = vins;
    }
// in the section of code below I replaced "parent" with "viewGroup" and the error went away.
    @Override
    public VinAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vin_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VinAdapter.ViewHolder holder, int position) {
        holder.createVin.setText(vins.get(position));
    }

    @Override
    public int getItemCount() {
        return vins.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView createVin;

        public ViewHolder(View itemView){
            super(itemView);
            createVin = itemView.findViewById(R.id.enter_vin);
        }
    }
}
