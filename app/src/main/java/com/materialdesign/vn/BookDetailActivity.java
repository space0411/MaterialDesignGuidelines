package com.materialdesign.vn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesign.vn.dummy.DummyContent;

public class BookDetailActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private AppBarLayout appBarLayout;
    private TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        // set an enter transition
        getWindow().setEnterTransition(new Slide());
        // set an exit transition
        getWindow().setExitTransition(new Slide());
        setContentView(R.layout.activity_book_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        setSupportActionBar(toolbar);
        final ImageView imageBanner = (ImageView) findViewById(R.id.image_banner);
        imageBanner.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.new_material_design_wallpaper_chrome));
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.white));
        ImageView image = (ImageView) findViewById(R.id.image);
        detail = (TextView) findViewById(R.id.detail);
        if (getIntent() != null) {
            DummyContent.DummyItem data = (DummyContent.DummyItem) getIntent().getSerializableExtra("DummyItem");
            collapsingToolbarLayout.setTitle(data.content);
            image.setImageDrawable(ContextCompat.getDrawable(this, data.idDrawable));
            detail.setText(data.details);
        }

        fab = (FloatingActionButton) findViewById(R.id.fab);
       /* fab.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                view.removeOnLayoutChangeListener(this);
                createCircularReveal(fab, 500);
            }
        });*/

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            public void run() {
                Animation bottomUp = AnimationUtils.loadAnimation(getBaseContext(), R.anim.bottom_up);
                detail.startAnimation(bottomUp);
                detail.setVisibility(View.VISIBLE);
            }}, 500);
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
