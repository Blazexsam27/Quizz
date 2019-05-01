package Quizz.corporation.blaze.oppositequiz;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class level_0_activity extends AppCompatActivity {
        private TextView QuestionView0;
        private Button hintbutton;
        private int hintpoints=40;
        private TextView Timer0;
        private RadioGroup Rdgroup;
        private RadioButton r1;
        private RadioButton r2;
        private TextView PointsView;
        private int Points;
        private List<Questions_level_0_getandset> questionslist0;
        private Questions_level_0_getandset currentquestion;
        private int questioncounter;
        private int questiontotalcount;
        private Button ConfirmButton;
        private ColorStateList textcolordefault0;
        private boolean answered0;
        private ColorStateList textcolortimer;
        private long countdowntimerleft;
        private CountDownTimer countdowntimer;
        private static final long COUNT_DOWN_TIMER_MILLIS=16000;
        private long backvalue;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_0);
        QuestionView0=findViewById(R.id.QuestionView0);
        hintbutton=findViewById(R.id.Hint_button0);
        Timer0 =findViewById(R.id.timer0);
        Rdgroup=findViewById(R.id.radioGroup0);
        r1=findViewById(R.id.radioButton10);
        r2=findViewById(R.id.radioButton20);
        PointsView=findViewById(R.id.Points0);
        ConfirmButton=findViewById(R.id.confirm_button0);

        quiz_database_helper_level_0 Databasehelper0=new quiz_database_helper_level_0(this);
        Databasehelper0.getallquestions0();

        hintbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hintpoints<20){
                    Toast.makeText(level_0_activity.this,"YOU CAN USE ONLY 2 HINTS PER GAME!",Toast.LENGTH_SHORT).show();
                }else{
                    hintpoints=hintpoints-20;
                    QuestionView0.setText(currentquestion.getAnswer0()+"   1,2 are option serial number!");
                }

            }
        });
        questionslist0=Databasehelper0.getallquestions0();
        textcolordefault0=r1.getTextColors();
        questiontotalcount=questionslist0.size();
        textcolortimer= Timer0.getTextColors();

        Collections.shuffle(questionslist0);
        showNextquestion();

        ConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answered0){
                    if(r1.isChecked()||r2.isChecked()){
                        //checkanswer
                        checkAnswer();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please select an option",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    showNextquestion();
                }

            }
        });

    }
    public void showNextquestion(){
        r1.setTextColor(textcolordefault0);
        r2.setTextColor(textcolordefault0);
        Rdgroup.clearCheck();
        if(questioncounter<questiontotalcount){
            currentquestion=questionslist0.get(questioncounter);
            QuestionView0.setText(currentquestion.getQuestions0());
            r1.setText(currentquestion.getOption10());
            r2.setText(currentquestion.getOption20());
            questioncounter++;

            ConfirmButton.setText("CONFIRM");
            answered0=false;
            countdowntimerleft = COUNT_DOWN_TIMER_MILLIS;
            startCountdown();
        }else{
            alertDialog();
        }
    }

        private void startCountdown(){
        countdowntimer=new CountDownTimer(countdowntimerleft,1000) {
            @Override
            public void onTick(long l) {
                countdowntimerleft=l;//this is L .
                updateText();

            }

            @Override
            public void onFinish() {
                countdowntimerleft=0;
                updateText();
                checkAnswer();
            }
        }.start();
        }
        private void updateText(){
        int minutes=(int) (countdowntimerleft/1000)/60;
        int seconds=(int) (countdowntimerleft/1000)%60;
            String timeformatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

            Timer0.setText(timeformatted);
            if(countdowntimerleft<10000){
                Timer0.setTextColor(Color.RED);
            }else{
                Timer0.setTextColor(textcolordefault0);
            }
        }

    private void checkAnswer(){
        answered0=true;
        countdowntimer.cancel();
        RadioButton rdbutton=findViewById(Rdgroup.getCheckedRadioButtonId());
        int answerNr=Rdgroup.indexOfChild(rdbutton)+1;
        if(answerNr==currentquestion.getAnswer0()){
            Points=Points+10;
            PointsView.setText("Points:" +Points);
        }
        showSolution();
    }

    private void showSolution()
    {
        r1.setTextColor(Color.RED);
        r2.setTextColor(Color.RED);

        switch (currentquestion.getAnswer0()){
            case 1:r1.setTextColor(Color.GREEN);
                QuestionView0.setText("Answer 1 is correct");
                break;
            case 2:r2.setTextColor(Color.GREEN);
                QuestionView0.setText("Answer 2 is correct");
                break;

        }
        if(questioncounter<questiontotalcount)
        {
            ConfirmButton.setText("NEXT");
        }else
        {
            ConfirmButton.setText("FINISH");
        }

    }

    @Override
    public void onBackPressed() {
       if(backvalue +2000>System.currentTimeMillis()){
           finish();
       }
       else{
           Toast.makeText(getApplicationContext(),"PRESS AGAIN TO EXIT",Toast.LENGTH_SHORT).show();
           backvalue=System.currentTimeMillis();
       }
    }

    private void alertDialog(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("YOUR POINTS :" +Points).setTitle("HIGHSCORE!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countdowntimer!=null){
            countdowntimer.cancel();
        }
    }
}
