package com.materialdesign.vn.dummy;

import android.support.annotation.DrawableRes;

import com.materialdesign.vn.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 12;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        switch (position) {
            case 1:
                return new DummyItem(String.valueOf(position), "Android N", makeDetails(position), R.drawable.android_n);
            case 2:
                return new DummyItem(String.valueOf(position), "Android M", makeDetails(position), R.drawable.android_marshmallow);
            case 3:
                return new DummyItem(String.valueOf(position), "Android L", makeDetails(position), R.drawable.android_l);
            case 4:
                return new DummyItem(String.valueOf(position), "Android K", makeDetails(position), R.drawable.android_kitkat);
            case 5:
                return new DummyItem(String.valueOf(position), "Android J", makeDetails(position), R.drawable.android_jellybean);
            case 6:
                return new DummyItem(String.valueOf(position), "Android I", makeDetails(position), R.drawable.android_ice_cream);
            case 7:
                return new DummyItem(String.valueOf(position), "Android H", makeDetails(position), R.drawable.android_honeycomb);
            case 8:
                return new DummyItem(String.valueOf(position), "Android G", makeDetails(position), R.drawable.android_gingerbread);
            case 9:
                return new DummyItem(String.valueOf(position), "Android F", makeDetails(position), R.drawable.android_froyo);
            case 10:
                return new DummyItem(String.valueOf(position), "Android E", makeDetails(position), R.drawable.android_e);
            case 11:
                return new DummyItem(String.valueOf(position), "Android D", makeDetails(position), R.drawable.android_donut);
            case 12:
                return new DummyItem(String.valueOf(position), "Android C", makeDetails(position), R.drawable.android_cupcake);
        }
        return null;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;
        public final int idDrawable;

        public DummyItem(String id, String content, String details, @DrawableRes int idDrawable) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.idDrawable = idDrawable;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
