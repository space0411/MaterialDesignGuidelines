package com.materialdesign.vn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesign.vn.dummy.DummyContent;

public class BookDetailActivity extends AppCompatActivity {
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ImageView imageBanner = (ImageView) findViewById(R.id.image_banner);
        imageBanner.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.new_material_design_wallpaper_chrome));
        imageBanner.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                view.removeOnLayoutChangeListener(this);
                createCircularReveal(imageBanner, 700);
            }
        });
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.white));

        ImageView image = (ImageView) findViewById(R.id.image);
        final TextView detail = (TextView) findViewById(R.id.detail);
        if (getIntent() != null) {
            DummyContent.DummyItem data = (DummyContent.DummyItem) getIntent().getSerializableExtra("DummyItem");
            collapsingToolbarLayout.setTitle(data.content);
            image.setImageDrawable(ContextCompat.getDrawable(this, data.idDrawable));
            detail.setText(data.details);
            //scaleView(detail);
        }

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                view.removeOnLayoutChangeListener(this);
                createCircularReveal(fab, 1000);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.BOTTOM);
            slide.addTarget(R.id.description);
            slide.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.interpolator
                    .linear_out_slow_in));
            slide.setDuration(slideDuration);
            getWindow().setEnterTransition(slide);
        }
    }

    private void createCircularReveal(View myView, int duration) {
        if (myView.getVisibility() == View.VISIBLE) {
            myView.setVisibility(View.INVISIBLE);
        }
        // get the center for the clipping circle
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(myView.getWidth(), myView.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
        anim.setDuration(duration);
        // make the view visible and start the animation
        myView.setVisibility(View.VISIBLE);
        anim.start();
    }

    private void hideCircularReveal(final View myView) {
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;
        int initialRadius = myView.getWidth();
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                myView.setVisibility(View.INVISIBLE);
            }
        });
        anim.start();
    }

    public void scaleView(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        animation.setFillAfter(true);
        v.startAnimation(animation);
    }

    @Override
    public boolean onSupportNavigateUp() {
        fab.setVisibility(View.INVISIBLE);
        onBackPressed();
        return true;
    }
}
