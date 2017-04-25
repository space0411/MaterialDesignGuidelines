package com.materialdesign.vn.dummy;

import android.support.annotation.DrawableRes;

import com.materialdesign.vn.R;

import java.io.Serializable;
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
        switch (position) {
            case 1:
                return "Android \"Nougat\" (codenamed N in-development) is the major 7.0 release of the Android operating system. It was first released as a developer preview on March 9, 2016, with factory images for current Nexus devices, as well as with the new \"Android Beta Program\" which allows supported devices to be upgraded directly to the Android Nougat beta via over-the-air update. Final release was on August 22, 2016. The final preview build was released on July 18, 2016,[223] with the build number NPD90G.";
            case 2:
                return "Android 6.0 \"Marshmallow\" was unveiled under the codename \"Android M\" during Google I/O on May 28, 2015, for the Nexus 5 and Nexus 6 phones, Nexus 9 tablet, and Nexus Player set-top box, under the build number MPZ44Q.[203] The third developer preview (MPA44G) was released on August 17, 2015 for the Nexus 5, Nexus 6, Nexus 9 and Nexus Player devices,[204] and was updated to MPA44I that brought fixes related to Android for Work profiles.[205]";
            case 3:
                return "Android 5.0 \"Lollipop\" was unveiled under the codename \"Android L\" on June 25, 2014, during Google I/O. It became available as official over-the-air (OTA) updates on November 12, 2014, for select devices that run distributions of Android serviced by Google, including Nexus and Google Play edition devices. Its source code was made available on November 3, 2014.[174][175]\n" +
                        "Lollipop features a redesigned user interface built around a responsive design language referred to as \"material design\". Other changes include improvements to the notifications, which can be accessed from the lockscreen and displayed within applications as top-of-the-screen banners. Furthermore, Google made internal changes to the platform, with the Android Runtime (ART) officially replacing Dalvik for improved application performance, and with changes intended to improve and optimize battery usage, known internally as Project Volta.[176][177][178][179]";
            case 4:
                return "Google announced Android 4.4 KitKat on September 3, 2013. Although initially under the \"Key Lime Pie\" (\"KLP\") codename, the name was changed because \"very few people actually know the taste of a key lime pie.\"[143] Some technology bloggers also expected the \"Key Lime Pie\" release to be Android 5.[144] KitKat debuted on Google's Nexus 5 on October 31, 2013, and was optimized to run on a greater range of devices than earlier Android versions, having 512 MB of RAM as a recommended minimum; those improvements were known as \"Project Svelte\" internally at Google.[145] The required minimum amount of RAM available to Android is 340 MB, and all devices with less than 512 MB of RAM must report themselves as \"low RAM\" devices.[146]";
            case 5:
                return "Google announced Android 4.1 (Jelly Bean) at the Google I/O conference on June 27, 2012. Based on Linux kernel 3.0.31, Jelly Bean was an incremental update with the primary aim of improving the functionality and performance of the user interface. The performance improvement involved \"Project Butter\", which uses touch anticipation, triple buffering, extended vsync timing and a fixed frame rate of 60 fps to create a fluid and \"buttery-smooth\" UI.[109] Android 4.1 Jelly Bean was released to the Android Open Source Project on July 9, 2012,[110] and the Nexus 7 tablet, the first device to run Jelly Bean, was released on July 13, 2012.";
            case 6:
                return "The SDK for Android 4.0.1 (Ice Cream Sandwich), based on Linux kernel 3.0.1,[92] was publicly released on October 19, 2011.[93] Google's Gabe Cohen stated that Android 4.0 was \"theoretically compatible\" with any Android 2.3.x device in production at that time.[94] The source code for Android 4.0 became available on November 14, 2011.[95] Ice Cream Sandwich was the last version to officially support Adobe Systems' Flash player.[96] The update introduced numerous new features:[97][98][99]";
            case 7:
                return "On February 22, 2011, the Android 3.0 (Honeycomb) SDK – the first tablet-only Android update – was released, based on Linux kernel 2.6.36.[79][80][81][82] The first device featuring this version, the Motorola Xoom tablet, was released on February 24, 2011.[83] The update's features included:[79]";
            case 8:
                return "On December 6, 2010, the Android 2.3 (Gingerbread) SDK was released, based on Linux kernel 2.6.35.[65][66] Changes included:[65]";
            case 9:
                return "On May 20, 2010, the SDK for Android 2.2 (Froyo, short for frozen yogurt) was released, based on Linux kernel 2.6.32.[56]";
            case 10:
                return "On October 26, 2009, the Android 2.0 SDK was released, based on Linux kernel 2.6.29 and codenamed Eclair.[51] Changes include the ones listed below.[52]";
            case 11:
                return "On September 15, 2009, Android 1.6 – dubbed Donut – was released, based on Linux kernel 2.6.29.[48][49][50] Included in the update were numerous new features:[48]";
            case 12:
                return "On April 27, 2009, the Android 1.5 update was released, based on Linux kernel 2.6.27.[44][45] This was the first release to officially use a codename based on a dessert item (\"Cupcake\"), a theme which would be used for all releases henceforth. The update included several new features and UI amendments:[46]";
        }
        return null;
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem implements Serializable {
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
