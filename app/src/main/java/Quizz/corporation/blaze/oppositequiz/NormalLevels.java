package Quizz.corporation.blaze.oppositequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NormalLevels extends AppCompatActivity {
    Button button_normallevel_1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_levels);
        button_normallevel_1=findViewById(R.id.Level_1_normal);

        button_normallevel_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent nintent=new Intent(NormalLevels.this,level_0_activity.class);
                startActivity(nintent);
            }
        });
    }
}
