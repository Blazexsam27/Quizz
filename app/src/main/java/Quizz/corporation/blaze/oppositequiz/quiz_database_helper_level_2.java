package Quizz.corporation.blaze.oppositequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Quizz.corporation.blaze.oppositequiz.Quiz_database_level_2.*;

public class quiz_database_helper_level_2 extends SQLiteOpenHelper {

    private static final String Database_Name="quiz_Database_level2.db";
    private static final  int Version=1;
    private SQLiteDatabase Db;

    public quiz_database_helper_level_2(Context context) {
        super(context,Database_Name,null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase Db) {
        this.Db=Db;
        final String SQL_DATABASE_QUESTION_TABLE2 = "Create Table "+
                QuestionTableLevel2.TableName+ " ( "+
                QuestionTableLevel2._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                QuestionTableLevel2.ColumnQuestion+ " TEXT, " +
                QuestionTableLevel2.Answer + " INTEGER " +
                ")";
        Db.execSQL(SQL_DATABASE_QUESTION_TABLE2);

        FillquestionTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int i, int i1) {
        Db.execSQL(" DROP TABLE IF EXISTS " + Quiz_database_level_2.QuestionTableLevel2.TableName);
        onCreate(Db);

    }

    private void FillquestionTable()
    {   //true=1,false=0.

        Questions_level_2 Q1 = new Questions_level_2("Humans have 2 eyes",0);
        addquestions(Q1);
        Questions_level_2 Q2= new Questions_level_2("Sun is not a star",1);
        addquestions(Q2);
        Questions_level_2 Q3 = new Questions_level_2("If false is true and true is false then what is false ?",0);
        addquestions(Q3);
        Questions_level_2 Q4 = new Questions_level_2("Latitudes are vertical",1);
        addquestions(Q4);
        Questions_level_2 Q5= new Questions_level_2("Apple is not a fruit",1);
        addquestions(Q5);
        Questions_level_2 Q6 = new Questions_level_2("addition of two odd numbers give an even number",0);
        addquestions(Q6);
        Questions_level_2 Q7 = new Questions_level_2("Apple seeds are edible ",1);
        addquestions(Q7);
        Questions_level_2 Q8= new Questions_level_2("0^0 (zero raise to power zero) is equal to 1",0);
        addquestions(Q8);
        Questions_level_2 Q9 = new Questions_level_2("One day on Earth is of 24hrs.",1);
        addquestions(Q9);
        Questions_level_2 Q10 = new Questions_level_2("∞ (infinity) means only positive numbers",0);
        addquestions(Q10);
        Questions_level_2 Q11= new Questions_level_2("If true means false and false means false then what is true",1);
        addquestions(Q11);
        Questions_level_2 Q12 = new Questions_level_2("If '/' means '-' and '*' means '+' then 21/7*41=55",0);
        addquestions(Q12);
        Questions_level_2 Q13 = new Questions_level_2("1kg iron is heavier than 1kg cotton",1);
        addquestions(Q13);
        Questions_level_2 Q14= new Questions_level_2("Calorie is unit of energy",0);
        addquestions(Q14);
        Questions_level_2 Q15 = new Questions_level_2("Water has its own color",1);
        addquestions(Q15);
    }
    private void addquestions(Questions_level_2 questions2)
    {
        ContentValues cv2=new ContentValues();
        cv2.put(QuestionTableLevel2.ColumnQuestion, questions2.getQuestion());
        cv2.put(QuestionTableLevel2.Answer,questions2.getAnswer());
        Db.insert(QuestionTableLevel2.TableName,null,cv2);
    }


    public List<Questions_level_2> Getallquestions() {

        List<Questions_level_2> questionslist2 = new ArrayList<>();
        Db=getReadableDatabase();
        Cursor c1=Db.rawQuery(" SELECT * FROM " + QuestionTableLevel2.TableName,null);
        if(c1.moveToFirst())
        {
            do{
                Questions_level_2 questions_2 = new Questions_level_2();
                questions_2.setQuestion(c1.getString(c1.getColumnIndex(QuestionTableLevel2.ColumnQuestion)));
                questions_2.setAnswer(c1.getInt(c1.getColumnIndex(QuestionTableLevel2.Answer)));
                questionslist2.add(questions_2);


            }while(c1.moveToNext());
        }
        c1.close();
        return questionslist2;
    }
}
