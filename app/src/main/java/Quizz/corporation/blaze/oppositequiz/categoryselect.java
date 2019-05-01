package Quizz.corporation.blaze.oppositequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class categoryselect extends AppCompatActivity {
        private Button buttonc1;
        private Button buttonc2;
        private TextView info_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_select);
        buttonc1=findViewById(R.id.buttonc1);
        buttonc2=findViewById(R.id.buttonc2);
        info_text=findViewById(R.id.category_info);

        buttonc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(categoryselect.this,start_game.class);
                startActivity(intent);
            }
        });
        buttonc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(categoryselect.this,NormalLevels.class);
                startActivity(intent2);
            }
        });
    }
}
