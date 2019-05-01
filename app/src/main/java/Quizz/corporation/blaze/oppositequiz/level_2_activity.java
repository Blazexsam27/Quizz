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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class level_2_activity extends AppCompatActivity {
    private Button True_button;
    private Button False_button;
    private Button hint_button;
    private TextView QuestionView;
    private TextView Timer2;
    private TextView PointsView;
    private List<Questions_level_2> questionlist;
    private int Points2;
    private Questions_level_2 currentQuestion;
    private int QuestionCounter;
    private int QuestionCountTotal;
    int hintpoint=40;
    private static final long COUNT_DOWN_TIMER_MILLIS2=16000;
    private ColorStateList textcolorcountdown2;
    private long countdowntimerleft2;
    private CountDownTimer countdowntimer2;
    private long backvalue;
    private ColorStateList textcolordefault2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_2);
        True_button=findViewById(R.id.True);
        False_button=findViewById(R.id.False);
        hint_button=findViewById(R.id.hint_Button2);
        QuestionView=findViewById(R.id.Question2);
        Timer2=findViewById(R.id.Timer2);
        PointsView=findViewById(R.id.Points_view2);

        quiz_database_helper_level_2 DatabaseHelper=new quiz_database_helper_level_2(this);
        DatabaseHelper.Getallquestions();

        questionlist=DatabaseHelper.Getallquestions();
        textcolorcountdown2=Timer2.getTextColors();
        QuestionCountTotal=questionlist.size();
        textcolordefault2=QuestionView.getTextColors();

              hint_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hintpoint <20){
                    Toast.makeText(getApplicationContext(),"You can use only 2 hints per game!", Toast.LENGTH_SHORT).show();
                }
                else{
                    hintpoint=hintpoint-20;
                    QuestionView.setText(currentQuestion.getAnswer()+"    (1=true and 0=false)");
                }
            }
        });
        Collections.shuffle(questionlist);
        ShownextQuestion();
         True_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 checkAnswerlevel2(1);

                 ShownextQuestion();

             }
         });
         False_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                    checkAnswerlevel2(0);
                 ShownextQuestion();

             }
         });
    }
    public void ShownextQuestion()
    {
        if (QuestionCounter<QuestionCountTotal)
        {
            currentQuestion=questionlist.get(QuestionCounter);
            QuestionView.setText(currentQuestion.getQuestion());
            QuestionCounter++;
            countdowntimerleft2=COUNT_DOWN_TIMER_MILLIS2;
            startCountdowntimer();
        }
        else{

           alertDialog2();

        }
    }

    private void startCountdowntimer(){
        countdowntimer2 = new CountDownTimer(countdowntimerleft2,1000) {
            @Override
            public void onTick(long l) {
                countdowntimerleft2=l;//this is L .
                updateText();
            }

            @Override
            public void onFinish() {
                countdowntimerleft2=0;
                updateText();
                ShownextQuestion();

            }
        }.start();
    }

    private void updateText(){
        int minutes = (int) (countdowntimerleft2/1000)/60;
        int seconds = (int) (countdowntimerleft2/1000)%60;
        String timeformatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        Timer2.setText(timeformatted);
        if(countdowntimerleft2<10000){
            Timer2.setTextColor(Color.RED);
        }else{
            Timer2.setTextColor(textcolordefault2);
        }
    }
    public void checkAnswerlevel2(int y){
        int x;
        countdowntimer2.cancel();
        x=currentQuestion.getAnswer();
        if(x==y)
        {
            Points2=Points2+10;
            PointsView.setText("Points :" +Points2);
            Toast.makeText(this,"CORRECT!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"INCORRECT!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if(backvalue +2000>System.currentTimeMillis()){
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"Press again to exit",Toast.LENGTH_SHORT).show();
            backvalue=System.currentTimeMillis();
        }

    }

    public void alertDialog2(){
        AlertDialog.Builder builder= new  AlertDialog.Builder(this);
        builder.setMessage("YOUR POINTS :" + Points2).setTitle("HighScore!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countdowntimer2!=null){
            countdowntimer2.cancel();
        }
    }
}
