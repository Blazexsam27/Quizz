package Quizz.corporation.blaze.oppositequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class main_menu extends AppCompatActivity {
    private Button start;
    private Button exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        start=findViewById(R.id.Exit_button);
        exit=findViewById(R.id.start_button);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final Intent intent =new Intent(main_menu.this,categoryselect.class);
            startActivity(intent);

            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
