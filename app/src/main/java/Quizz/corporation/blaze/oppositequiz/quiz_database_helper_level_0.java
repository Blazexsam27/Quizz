package Quizz.corporation.blaze.oppositequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Quizz.corporation.blaze.oppositequiz.Quiz_database_level_0.*;

public class quiz_database_helper_level_0 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="QuestionLEVEL0.db";
    private static final int VERSION=1;
    private SQLiteDatabase db0;
    public quiz_database_helper_level_0(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db0) {
        this.db0=db0;
        final String SQL_DATABASE_LEVEL_0=" Create Table " +
                QuestionTableLevel0.TABLE_NAME + " ( " +
                QuestionTableLevel0._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTableLevel0.COLUMN_QUESTION + " TEXT, " +
                QuestionTableLevel0.OPTION_1 + " TEXT, " +
                QuestionTableLevel0.OPTION_2 + " TEXT, "+
                QuestionTableLevel0.ANSWER + " INTEGER " +
                " ) ";
        db0.execSQL(SQL_DATABASE_LEVEL_0);
        fillinQuestiontable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db0, int i, int i1) {
        db0.execSQL("DROP TABLE IF EXISTS " + QuestionTableLevel0.TABLE_NAME);
        onCreate(db0);

    }
    private void fillinQuestiontable(){
        Questions_level_0_getandset Q1 = new Questions_level_0_getandset("Which toxic element present in automobile exhausts?","Lead","Nitrogen",1);
        addquestions0(Q1);
        Questions_level_0_getandset Q2 =new Questions_level_0_getandset("Which metal is used in the making of microchips?","LED","Silicon",2);
        addquestions0(Q2);
        Questions_level_0_getandset Q3 = new Questions_level_0_getandset("Which element is a liquid at ordinary temperature?","Mercury","Gallium",1);
        addquestions0(Q3);
        Questions_level_0_getandset Q4 =new Questions_level_0_getandset("Which ocean is deepest ?","Pacific ocean","Arctic ocean",1);
        addquestions0(Q4);
        Questions_level_0_getandset Q5 =new Questions_level_0_getandset("Which country has not fought a war since 1814 ?","Hong Kong","Sweden",2);
        addquestions0(Q5);
        Questions_level_0_getandset Q6 =new Questions_level_0_getandset("What's the most common disease in the world?","tooth decay","eye sight loss",1);
        addquestions0(Q6);
        Questions_level_0_getandset Q7 =new Questions_level_0_getandset("Which colors do colorblind people have trouble distinguishing?","Red","White",1);
        addquestions0(Q7);
        Questions_level_0_getandset Q8 =new Questions_level_0_getandset("Which bird is used as the sign of peace?","African parrot","dove",2);
        addquestions0(Q8);
        Questions_level_0_getandset Q9=new Questions_level_0_getandset("What is the diatmeter of planet Earth ?","6400km","12,742km",2);
        addquestions0(Q9);
        Questions_level_0_getandset Q10 =new Questions_level_0_getandset("How many elements are there in periodic table ?","108","118",2);
        addquestions0(Q10);
        Questions_level_0_getandset Q11 =new Questions_level_0_getandset("Fullform of Wi-Fi is ","Wireless Fidelity","Wired Fidelity",1);
        addquestions0(Q11);
        Questions_level_0_getandset Q12 =new Questions_level_0_getandset("Which game is the most played game of all time ","PUBG","Crossfire",2);
        addquestions0(Q12);
    }
    private void addquestions0(Questions_level_0_getandset questiongetset0){
        ContentValues cv0= new ContentValues();
        cv0.put(QuestionTableLevel0.COLUMN_QUESTION,questiongetset0.getQuestions0());
        cv0.put(QuestionTableLevel0.OPTION_1,questiongetset0.getOption10());
        cv0.put(QuestionTableLevel0.OPTION_2,questiongetset0.getOption20());
        cv0.put(QuestionTableLevel0.ANSWER,questiongetset0.getAnswer0());
        db0.insert(QuestionTableLevel0.TABLE_NAME,null,cv0);
    }
    public List<Questions_level_0_getandset> getallquestions0(){
        List<Questions_level_0_getandset> questionslist0= new ArrayList<>();
        db0=getReadableDatabase();
        Cursor c0= db0.rawQuery(" SELECT*FROM " + QuestionTableLevel0.TABLE_NAME,null);
        if (c0.moveToFirst()){
            do{
                Questions_level_0_getandset question0 = new Questions_level_0_getandset();
                question0.setQuestions0(c0.getString(c0.getColumnIndex(QuestionTableLevel0.COLUMN_QUESTION)));
                question0.setOption10(c0.getString(c0.getColumnIndex(QuestionTableLevel0.OPTION_1)));
                question0.setOption20(c0.getString(c0.getColumnIndex(QuestionTableLevel0.OPTION_2)));
                question0.setAnswer0(c0.getInt(c0.getColumnIndex(QuestionTableLevel0.ANSWER)));
                questionslist0.add(question0);
            }while(c0.moveToNext());
        }
        c0.close();
        return questionslist0;
    }


}
