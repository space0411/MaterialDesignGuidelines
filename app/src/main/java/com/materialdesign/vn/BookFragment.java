package com.materialdesign.vn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.materialdesign.vn.dummy.DummyContent;
import com.materialdesign.vn.dummy.DummyContent.DummyItem;

import java.io.Serializable;


public class BookFragment extends Fragment implements MyBookRecyclerViewAdapter.OnListFragmentInteractionListener {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    public BookFragment() {
    }

    @SuppressWarnings("unused")
    public static BookFragment newInstance(int columnCount) {
        BookFragment fragment = new BookFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyBookRecyclerViewAdapter(getContext(), DummyContent.ITEMS, this));
        }
        return view;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onListFragmentInteraction(DummyItem item, MyBookRecyclerViewAdapter.ViewHolder holder) {
        Intent intent = new Intent(getContext(), BookDetailActivity.class);
        intent.putExtra("DummyItem", item);
        View image = holder.image;
        View contentView = holder.mContentView;
        Pair<View, String> pair1 = Pair.create(image, holder.image.getTransitionName());
        Pair<View, String> pair2 = Pair.create(contentView, holder.mContentView.getTransitionName());
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(getActivity(), pair1, pair2);
        startActivity(intent, options.toBundle());
    }
}
