package Quizz.corporation.blaze.oppositequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class start_game extends AppCompatActivity {

    Button LEVEL_3;
    Button LEVEL_1;
    Button LEVEL_2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_level);

        LEVEL_1=findViewById(R.id.Level_1);
        LEVEL_2=findViewById(R.id.Level_2);
        LEVEL_3=findViewById(R.id.Level_3);


        // Link level 0 button.
        LEVEL_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(start_game.this,level_1_activity.class);

                startActivity(intent);
            }
        });
        LEVEL_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent Newintent= new Intent(start_game.this,level_2_activity.class);
                startActivity(Newintent);
            }
        });
        LEVEL_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             final Intent newintent=new Intent(start_game.this,MainActivity.class);

             startActivity(newintent);

            }
        });

    }
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slidetoleft,R.anim.slideoutright);
    }


}
