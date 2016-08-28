package com.icon256bliss.android.coursehandler.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.icon256bliss.android.coursehandler.CollegeListActivity;
import com.icon256bliss.android.coursehandler.R;
import com.icon256bliss.android.coursehandler.appModels.University;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UniversityGridAdapter extends RecyclerView.Adapter<UniversityGridAdapter.MyViewHolder>{
    private Context mContext;
    private List<University> universities = null;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public UniversityGridAdapter(Context c, List<University> universities) {
        mContext = c;
        this.universities = universities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_main_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final University university = universities.get(position);
        holder.title.setText(university.name);

        Picasso.with(mContext)
                .load(university.imageUrl)
                .resize(500, 500)
                .centerCrop()
                .into(holder.thumbnail);



        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();

                Intent i = new Intent(context, CollegeListActivity.class);
                int uniId = university.id;
                i.putExtra("INDEX",uniId);
                i.putExtra("UNI_NAME",university.name);
                context.startActivity(i);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_details:
                    Toast.makeText(mContext, "University details", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }


    @Override
    public int getItemCount() {
        return universities.size();
    }
}