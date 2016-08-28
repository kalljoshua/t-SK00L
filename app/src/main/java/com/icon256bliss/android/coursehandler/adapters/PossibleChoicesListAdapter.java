package com.icon256bliss.android.coursehandler.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icon256bliss.android.coursehandler.R;
import com.icon256bliss.android.coursehandler.appModels.PossibleChoice;

import java.util.List;

/**
 * Created by Kall on 8/8/2016.
 */
public class PossibleChoicesListAdapter
        extends RecyclerView.Adapter<PossibleChoicesListAdapter.ViewHolder> {

    private final List<PossibleChoice> mValues;

    public PossibleChoicesListAdapter(List<PossibleChoice> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.processedchoices_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).universityName);
        holder.mContentView.setText(mValues.get(position).courseName);

            /*holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(ProcessedChoicesDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        ProcessedChoicesDetailFragment fragment = new ProcessedChoicesDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.processedchoices_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, ProcessedChoicesDetailActivity.class);
                        intent.putExtra(ProcessedChoicesDetailFragment.ARG_ITEM_ID, holder.mItem.id);

                        context.startActivity(intent);
                    }
                }
            });*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public PossibleChoice mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.uname);
            mContentView = (TextView) view.findViewById(R.id.cname);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}


