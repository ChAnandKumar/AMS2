package com.bartronics.ams2.ui.home;

/**
 * Created by anand.chandaliya on 08-03-2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartronics.ams2.R;
import com.bartronics.ams2.data.db.model.PModel;

import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<PModel> profileList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, designation, workLocation;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name_tv);
            designation = (TextView) view.findViewById(R.id.designation_tv);
            workLocation = (TextView) view.findViewById(R.id.work_location_tv);
        }
    }


    public HomeAdapter(List<PModel> profileList) {
        this.profileList = profileList;
    }

    public void addProfileDataInList(List<PModel> profileList){
        this.profileList = profileList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PModel movie = profileList.get(position);
        holder.name.setText(movie.getEmpName());
        holder.designation.setText(movie.getEmpDesignaiton());
        holder.workLocation.setText(movie.getEmpWorkLocation());
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }
}