package com.example.smartcompliance;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by 2ndgengod on 1/18/2021.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
private List<Data> dataList;
private Context mContext;
private RecyclerView mRecyclerV;


    // Provide a suitable constructor (depends on the kind of dataset)
    public DataAdapter(List<Data> myDataset, Context context, RecyclerView recyclerView) {
        dataList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }

    public void add(int position, Data data) {
        dataList.add(position, data);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.data_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Data data = dataList.get(position);
        holder.mValue.setText("Truck No: " + data.getmValue());
        holder.mHaulier.setText("Haulier: " + data.getmHaulier());
        holder.mDelivery.setText("Delivery No: " + data.getmDelivery());
        holder.mDestination.setText("Destination: " + data.getmDestination());
        holder.mVariance.setText("Variance: " + data.getmVariance());
        holder.mLoaded.setText("Loaded: " + data.getmLoaded());
        holder.mReplace.setText("Replace: " + data.getmReplace());
        holder.mUnderOver.setText("UnderOver: " + data.getmUnderOver());


        //listen to single view layout click
        /*holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Choose option");
                builder.setMessage("Update or delete data?");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //go to update activity
                        goToUpdateActivity(person.getId());

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PersonDBHelper dbHelper = new PersonDBHelper(mContext);
                        dbHelper.deletePersonRecord(person.getId(), mContext);

                        mPeopleList.remove(position);
                        mRecyclerV.removeViewAt(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, mPeopleList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });*/


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataList.size();
    }

   /* private void goToUpdateActivity(long personId){
        Intent goToUpdate = new Intent(mContext, UpdateRecordActivity.class);
        goToUpdate.putExtra("USER_ID", personId);
        mContext.startActivity(goToUpdate);
    }*/

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView mValue;
    public TextView mHaulier;
    public TextView mDelivery;
    public TextView mDestination;
    public TextView mVariance;
    public TextView mLoaded;
    public TextView mReplace;
    public TextView mUnderOver;
   // public Button shareBtn;


    public View layout;

    public ViewHolder(View v) {
        super(v);
        layout = v;
        mValue = (TextView) v.findViewById(R.id.mValue);
        mHaulier = (TextView) v.findViewById(R.id.mHaulier);
        mDelivery = (TextView) v.findViewById(R.id.mDelivery);
        mDestination = (TextView) v.findViewById(R.id.mDestination);
        mVariance = (TextView) v.findViewById(R.id.mVariance);
        mLoaded = (TextView) v.findViewById(R.id.mLoaded);
        mReplace = (TextView) v.findViewById(R.id.mReplace);
        mUnderOver = (TextView) v.findViewById(R.id.mUnderOver);
       // shareBtn = (Button) v.findViewById(R.id.shareBtn);
    }
}
}