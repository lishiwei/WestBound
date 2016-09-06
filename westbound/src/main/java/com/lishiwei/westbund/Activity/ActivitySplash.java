package com.lishiwei.westbund.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lishiwei.westbund.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ActivitySplash extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private static final String TAG = ActivitySplash.class.getSimpleName();
    private final Handler mHideHandler = new Handler();
    @Bind(R.id.fullscreen_content)
    ImageView fullscreenContent;
    @Bind(R.id.fl_SplashActivity_Back)
    FrameLayout flSplashActivityBack;
    @Bind(R.id.iv_ActivitySplashWhiteBack)
    ImageView ivActivitySplashWhiteBack;
    private View mContentView;


    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        }

    };


    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        final AlphaAnimation displayAnimation = new AlphaAnimation(0.1f, 1.0f);
        displayAnimation.setDuration(1000);
        displayAnimation.setInterpolator(new LinearInterpolator());
        fullscreenContent.setVisibility(View.INVISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fullscreenContent.startAnimation(displayAnimation);
            }
        }, 500);


        displayAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "onAnimationEnd: ");

                //白色消失
                AlphaAnimation whiteDismissnimation = new AlphaAnimation(1.0f, 0.1f);
                whiteDismissnimation.setDuration(3000);
                whiteDismissnimation.setInterpolator(new BounceInterpolator());
                ivActivitySplashWhiteBack.startAnimation(whiteDismissnimation);

                //放大动画一直存在
                ScaleAnimation scaleAnimation = new ScaleAnimation(1, 1.2f, 1, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(3000);

                flSplashActivityBack.setAnimation(scaleAnimation);
//
//                final AnimationSet animationSet = new AnimationSet(true);
//                animationSet.addAnimation(scaleAnimation);




                //白色出现
                final AlphaAnimation whiteDisplayAnimationEnd = new AlphaAnimation(0.1f, 1.0f);
                whiteDisplayAnimationEnd.setDuration(1000);
                whiteDisplayAnimationEnd.setStartOffset(2000);
                ivActivitySplashWhiteBack.setAnimation(whiteDisplayAnimationEnd);
//logo消失
                AlphaAnimation ContentDismissnimationEnd = new AlphaAnimation(1.0f, 0.1f);
                fullscreenContent.setAnimation(ContentDismissnimationEnd);
                ContentDismissnimationEnd.setStartOffset(1000);
                ContentDismissnimationEnd.setDuration(2000);


                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.d(TAG, "onAnimationStart: animationSet");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.d(TAG, "onAnimationEnd:animationSet ");

                        mHideHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(ActivitySplash.this, MainActivity.class));        // Schedule a runnable to remove the status and navigation bar after a delay
                                finish();
                            }
                        });
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


}
