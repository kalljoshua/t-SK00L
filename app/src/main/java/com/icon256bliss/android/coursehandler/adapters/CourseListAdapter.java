package com.icon256bliss.android.coursehandler.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icon256bliss.android.coursehandler.CoursesListDetailActivity;
import com.icon256bliss.android.coursehandler.CoursesListDetailFragment;
import com.icon256bliss.android.coursehandler.R;
import com.icon256bliss.android.coursehandler.appModels.Course;

import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {

    private final List<Course> mValues;
    private Intent colIntent ;

    public CourseListAdapter(List<Course> items,Intent i) {
        mValues = items;
        colIntent = i;
        Log.d("Adapter", "College in adapter: " + items.get(0).name);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Log.d("Binding", "Courses in binding: " + holder.mItem.name);
        holder.mContentView.setText(holder.mItem.name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                Intent i = new Intent(c, CoursesListDetailActivity.class);
                i.putExtra(CoursesListDetailFragment.ARG_ITEM_ID,holder.mItem.id);
                i.putExtra("INDEX",colIntent.getIntExtra("INDEX", 0));
                i.putExtra("COL_NAME",colIntent.getStringExtra("COL_NAME"));
                Log.d("ID",String.valueOf(holder.mItem.id));
                c.startActivity(i);

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
        public Course mItem;

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
