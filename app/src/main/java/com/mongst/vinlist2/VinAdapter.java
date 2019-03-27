package com.mongst.vinlist2;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class VinAdapter extends RecyclerView.Adapter<VinAdapter.ViewHolder> {

    List<Vin> vins;

    public VinAdapter(List<Vin> vins) {
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
        holder.createVin.setText(vins.get(position).getCreateVin());
        holder.notesVin.setText(vins.get(position).getNotesVin());
    }

    @Override
    public int getItemCount() {
        return vins.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView createVin;
        public TextView notesVin;

        public ViewHolder(View itemView){
            super(itemView);
            createVin = itemView.findViewById(R.id.enter_vin);
            notesVin = itemView.findViewById(R.id.notes_vin);
        }
    }

}
