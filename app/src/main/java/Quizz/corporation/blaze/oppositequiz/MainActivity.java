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

public class MainActivity extends AppCompatActivity {
    private TextView QuestionView;
    private TextView Timer;
    private TextView PointsView;
    private RadioGroup Rdgroup;
    private RadioButton Rd1;
    private RadioButton Rd2;
    private RadioButton Rd3;
    private RadioButton Rd4;
    private List<Questions> questionlist;
    private ColorStateList textcolordefault;
    private int points3;
    private boolean answered;
    private Questions currentQuestion;
    private int questionCounter;
    private int questionCountTotal;
    private Button ConfirmButton;
    private long backValue;
     private Button Hintbutton;
     private int HintPoints=40;
     private static final long COUNT_DOWN_TIMER_MILLIS=16000;
     private ColorStateList textcolorcountdown;
     private long countdowntimerleft;
     private CountDownTimer countdowntimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_3);//page set to level 3.
        //linking buttons.
        QuestionView=findViewById(R.id.Question);
        ConfirmButton=findViewById(R.id.confirm_button);
        Timer = findViewById(R.id.Timer3);
        PointsView = findViewById(R.id.Points_view);
        Rdgroup=findViewById(R.id.radioGroup2);
        Rd1=findViewById(R.id.Button_option1);
        Rd2= findViewById(R.id.Button_option_2);
        Rd3= findViewById(R.id.Button_option3);
        Rd4= findViewById(R.id.Button_option4);
        Hintbutton = findViewById(R.id.hint_Button3);


        quiz_database_helper_level_3 DatabaseHelper=new quiz_database_helper_level_3(this);

        DatabaseHelper.getAllQuestions();
        Hintbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(HintPoints<20){
                    Toast.makeText(getApplicationContext(),"You can use only 2 hints per game!",Toast.LENGTH_SHORT).show();
                }
                else{
                    HintPoints=HintPoints-20;
                    QuestionView.setText(currentQuestion.getAnswer()+"     1,2,3,4 are options");
                }
            }
        });



        questionlist=DatabaseHelper.getAllQuestions();
        textcolordefault=Rd1.getTextColors();
        textcolorcountdown=Timer.getTextColors();
        questionCountTotal=questionlist.size();


        Collections.shuffle(questionlist);
        showNextQuestion();
        ConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered) {
                    if (Rd1.isChecked() || Rd2.isChecked() || Rd3.isChecked() || Rd4.isChecked()) {

                        checkAnswer();
                    } else {
                        Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    showNextQuestion();
                }
            }
        });
    }
        public void showNextQuestion()
        {
            Rd1.setTextColor(textcolordefault);
            Rd2.setTextColor(textcolordefault);
            Rd3.setTextColor(textcolordefault);
            Rd4.setTextColor(textcolordefault);
            Rdgroup.clearCheck();

            if(questionCounter < questionCountTotal)
            {
                currentQuestion = questionlist.get(questionCounter);
                QuestionView.setText(currentQuestion.getQuestion());
                Rd1.setText(currentQuestion.getOption1());
                Rd2.setText(currentQuestion.getOption2());
                Rd3.setText(currentQuestion.getOption3());
                Rd4.setText(currentQuestion.getOption4());
                questionCounter++;
                ConfirmButton.setText("Confirm");
                answered=false;

                countdowntimerleft=COUNT_DOWN_TIMER_MILLIS;
                startCountdown();
            }
            else{
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
        int minutes =(int) (countdowntimerleft/1000)/60;
        int seconds=(int)(countdowntimerleft/1000)%60;
        String timeformatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        Timer.setText(timeformatted);
        if(countdowntimerleft<10000){
            Timer.setTextColor(Color.RED);
        }else{
            Timer.setTextColor(textcolordefault);
        }

        }


            private void checkAnswer()
            {
                answered=true;
                countdowntimer.cancel();
                RadioButton rbselected=findViewById(Rdgroup.getCheckedRadioButtonId());
                int answerNr=Rdgroup.indexOfChild(rbselected)+1;
                if(answerNr==currentQuestion.getAnswer())
                {
                    points3=points3+10;
                    PointsView.setText("Points :" + points3);
                }
                showSolution();
            }
            private void showSolution()
            {
                Rd1.setTextColor(Color.RED);
                Rd2.setTextColor(Color.RED);
                Rd3.setTextColor(Color.RED);
                Rd4.setTextColor(Color.RED);

                switch (currentQuestion.getAnswer()){
                    case 1:Rd1.setTextColor(Color.GREEN);
                        QuestionView.setText("Answer 1 is correct");
                        break;
                    case 2:Rd2.setTextColor(Color.GREEN);
                        QuestionView.setText("Answer 2 is correct");
                        break;
                    case 3:Rd3.setTextColor(Color.GREEN);
                        QuestionView.setText("Answer 3 is correct");
                        break;
                    case 4:Rd4.setTextColor(Color.GREEN);
                        QuestionView.setText("Answer 4 is correct");
                        break;
                }
                if(questionCounter<questionCountTotal)
                {
                    ConfirmButton.setText("NEXT");
                }else
                {
                   ConfirmButton.setText("FINISH");
                }

            }
    private void finishQuiz()
    {
        finish();
    }

    @Override
    public void onBackPressed() {
        if(backValue + 2000>System.currentTimeMillis()){
            finishQuiz();}

        else(Toast.makeText(this,"PRESS BACK AGAIN TO EXIT",Toast.LENGTH_SHORT)).show();
        backValue=System.currentTimeMillis();

    }   public void alertDialog(){
        AlertDialog.Builder builder= new  AlertDialog.Builder(this);
        builder.setMessage("YOUR POINTS :" + points3).setTitle("HighScore!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
