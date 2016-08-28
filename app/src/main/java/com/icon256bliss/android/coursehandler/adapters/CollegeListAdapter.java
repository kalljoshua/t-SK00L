package com.icon256bliss.android.coursehandler.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icon256bliss.android.coursehandler.CoursesListListActivity;
import com.icon256bliss.android.coursehandler.R;
import com.icon256bliss.android.coursehandler.appModels.College;

import java.util.List;

public class CollegeListAdapter extends RecyclerView.Adapter<CollegeListAdapter.ViewHolder> {

    private final List<College> mValues;

    public CollegeListAdapter(List<College> items) {
        mValues = items;
        Log.d("Adapter", "College in adapter: " + items.get(0).name);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.college_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Log.d("Binding", "College in binding: " + holder.mItem.name);
        holder.mContentView.setText(holder.mItem.name);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "click: " + holder.mItem.id, Toast.LENGTH_SHORT).show();
                    Context context = v.getContext();
                    Intent intent = new Intent(context, CoursesListListActivity.class);
                    intent.putExtra("INDEX",holder.mItem.id);
                    intent.putExtra("COL_NAME",holder.mItem.name);
                    context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public College mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
