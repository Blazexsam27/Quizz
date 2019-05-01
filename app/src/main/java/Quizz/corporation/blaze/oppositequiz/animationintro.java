package Quizz.corporation.blaze.oppositequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class animationintro extends AppCompatActivity {
    private ImageView logo;
    private TextView immortalCreations;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);
        immortalCreations=findViewById(R.id.Immortal_creations);
        immortalCreations.setAlpha(1/10);
        logo=findViewById(R.id.Logo);
        logo.setAlpha((float) 0.1);
        imageanimation();

    }
    private  void imageanimation(){
        logo.setAlpha((float) 1.0);
        Animation animationfade=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        logo.startAnimation(animationfade);
        animationfade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textanimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    private  void textanimation(){
        immortalCreations.setAlpha(1);
        Animation animationfadeimc=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeintext);
        immortalCreations.startAnimation(animationfadeimc);
        animationfadeimc.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                gonext();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    private void gonext(){
        Intent intent = new Intent(animationintro.this,main_menu.class);
        finish();
        overridePendingTransition(R.anim.slidetoright,R.anim.slideoutleft);

        startActivity(intent);
    }
}
