package com.materialdesign.vn;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesign.vn.dummy.DummyContent.DummyItem;

import java.util.List;


public class MyBookRecyclerViewAdapter extends RecyclerView.Adapter<MyBookRecyclerViewAdapter.ViewHolder> {
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DummyItem item, ViewHolder holder);
    }

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final Context mContext;

    public MyBookRecyclerViewAdapter(Context context, List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        DummyItem dummyItem = mValues.get(position);
        holder.mItem = dummyItem;
        holder.mIdView.setText(dummyItem.id);
        holder.mContentView.setText(dummyItem.content);
        holder.image.setImageDrawable(ContextCompat.getDrawable(mContext, dummyItem.idDrawable));

        holder.mView.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem, holder);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageView image;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            image = (ImageView) view.findViewById(R.id.image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
