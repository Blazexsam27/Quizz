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

public class level_1_activity extends AppCompatActivity {
    private TextView QuestionView1;
    private TextView Timer1;
    private TextView PointsView;
    private RadioGroup Rdgroup1;
    private RadioButton rd1;
    private RadioButton rd2;
    private RadioButton rd3;
    private RadioButton rd4;
    private Button mConfirmButton;
    private List<Questions_level_1> questionslist;
    private ColorStateList textcolordefault1;
    private int Points1;
    private boolean Answered;
    private Questions_level_1 currentQuestion1;
    private int questionCounter1;
    private int questionCountTotal1;
    private int hintpoints=40;
    private Button Hintbutton1;
    private static final long COUNT_DOWN_TIMER_MILLIS1=16000;
    private ColorStateList textcolorcountdown1;
    private long countdowntimerleft1;
    private CountDownTimer countdowntimer1;
    private long backvalue;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_1);
        QuestionView1 = findViewById(R.id.Question1);
        mConfirmButton = findViewById(R.id.confirm_button);
        Timer1 = findViewById(R.id.Timer);
        PointsView = findViewById(R.id.Points_view1);
        Rdgroup1 = findViewById(R.id.radioGroup);
        rd1 = findViewById(R.id.Button_option_1);
        rd2 = findViewById(R.id.Button_option2);
        rd3 = findViewById(R.id.Button_option_3);
        rd4 = findViewById(R.id.Button_option_4);
        Hintbutton1=findViewById(R.id.hint_Button1);

        quiz_database_helper_level_1 Databasehelper1 = new quiz_database_helper_level_1(this);
        Databasehelper1.Getallquestions();
        Hintbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hintpoints<20){
                    Toast.makeText(getApplicationContext(),"You can use only 2 hints per game!",Toast.LENGTH_SHORT).show();
                }
                else{
                    hintpoints=hintpoints-20;
                    QuestionView1.setText(currentQuestion1.getAnswer1()+ "    (1,2,3,4 are options)");
                }
            }
        });

        questionslist=Databasehelper1.Getallquestions();
        textcolordefault1 = rd1.getTextColors();
        questionCountTotal1 =questionslist.size();
        textcolorcountdown1=Timer1.getTextColors();
        Collections.shuffle(questionslist);

        Show_next_question();

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Answered) {
                    if (rd1.isChecked() || rd2.isChecked() || rd3.isChecked() || rd4.isChecked()) {

                        Checkanswer();
                    } else {
                        Toast.makeText(level_1_activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Show_next_question();
                }
            }
        });

    }


    public void Show_next_question() {
        rd1.setTextColor(textcolordefault1);
        rd2.setTextColor(textcolordefault1);
        rd3.setTextColor(textcolordefault1);
        rd4.setTextColor(textcolordefault1);
        Rdgroup1.clearCheck();

        if (questionCounter1 < questionCountTotal1) {
            currentQuestion1 = questionslist.get(questionCounter1);
            QuestionView1.setText(currentQuestion1.getQuestion1());
            rd1.setText(currentQuestion1.getOption1());
            rd2.setText(currentQuestion1.getOption2());
            rd3.setText(currentQuestion1.getOption3());
            rd4.setText(currentQuestion1.getOption4());
            questionCounter1++;
            mConfirmButton.setText("Confirm");
            Answered = false;
            countdowntimerleft1 = COUNT_DOWN_TIMER_MILLIS1;
            startCountdown1();

        } else {
            alertDialog1();

        }
    }
        private void startCountdown1(){
        countdowntimer1=new CountDownTimer(countdowntimerleft1,1000) {
            @Override
            public void onTick(long l) {
                countdowntimerleft1=l;//this is L .
                updateText();
            }

            @Override
            public void onFinish() {
                countdowntimerleft1=0;
                updateText();
                Checkanswer();
            }
        }.start();

    }
    private void updateText(){
        int minutes=(int) (countdowntimerleft1/1000)/60;
        int seconds = (int) (countdowntimerleft1/1000)%60;
        String timeformatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        Timer1.setText(timeformatted);
        if(countdowntimerleft1<10000){
            Timer1.setTextColor(Color.RED);
        }else{
            Timer1.setTextColor(textcolordefault1);
        }
    }

   private void Checkanswer()
   {
       Answered=true;
       countdowntimer1.cancel();
       RadioButton rbutton=findViewById(Rdgroup1.getCheckedRadioButtonId());
       int answernumber=Rdgroup1.indexOfChild(rbutton)+1;
       if (answernumber==currentQuestion1.getAnswer1())
       {

           Points1=Points1+10;
           PointsView.setText("Points : "+Points1);
       }
       ShowSolution();

   }

    @Override
    public void onBackPressed(){
        if(backvalue+2000>System.currentTimeMillis())
        {
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"Press again to exit ",Toast.LENGTH_SHORT).show();
            backvalue=System.currentTimeMillis();
        }
    }

    private void ShowSolution()
    {
        rd1.setTextColor(Color.RED);
        rd2.setTextColor(Color.RED);
        rd3.setTextColor(Color.RED);
        rd4.setTextColor(Color.RED);

        switch (currentQuestion1.getAnswer1()){

            case 1: rd1.setTextColor(Color.GREEN);
                QuestionView1.setText("Answer 1 is correct");
                break;
            case 2: rd2.setTextColor(Color.GREEN);
                QuestionView1.setText("Answer 2 is correct");
                break;
            case 3: rd3.setTextColor(Color.GREEN);
                QuestionView1.setText("Answer 3 is correct");
                break;
            case 4: rd4.setTextColor(Color.GREEN);
                QuestionView1.setText("Answer 4 is correct");
                break;
        }
        if(questionCounter1 < questionCountTotal1)
        {
            mConfirmButton.setText("NEXT");
        }else
        {
            mConfirmButton.setText("FINISH");
        }



    }
    public void alertDialog1(){
        AlertDialog.Builder builder= new  AlertDialog.Builder(this);
        builder.setMessage("YOUR POINTS :" + Points1).setTitle("HighScore!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countdowntimer1!=null){
            countdowntimer1.cancel();
        }
    }
}