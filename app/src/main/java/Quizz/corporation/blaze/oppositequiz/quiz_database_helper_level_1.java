package Quizz.corporation.blaze.oppositequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Quizz.corporation.blaze.oppositequiz.Quiz_database.*;

public class quiz_database_helper_level_1 extends SQLiteOpenHelper {
    private static final String Database_Name = "QuizzDatabase1.db";
    private static final int Version = 1;
    private SQLiteDatabase db2;

    public quiz_database_helper_level_1(Context context) {
        super(context, Database_Name, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db2) {
        this.db2 = db2;
        final String SQL_DATABASES_CREATE_QUESTION_TABLE = " Create Table " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.OPTION_1 + " TEXT, " +
                QuestionTable.OPTION_2 + " TEXT, " +
                QuestionTable.OPTION_3 + " TEXT, " +
                QuestionTable.OPTION_4 + " TEXT, " +
                QuestionTable.ANSWER + " INTEGER " +
                " ) ";


        db2.execSQL(SQL_DATABASES_CREATE_QUESTION_TABLE);
        fillQuestionTable();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int oldversion, int newversion) {
        db2.execSQL(" DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db2);

    }

    private void fillQuestionTable() {
        Questions_level_1 Q1 = new Questions_level_1("Which of them is poisonous ?", "Snake", "frog", "plants", "cactus", 1);
        addQuestions(Q1);
        Questions_level_1 Q2 = new Questions_level_1("If a star color is red that doesn't mean","It has high tempreture","It has low tempreture","It is very old","It is very small",2);
        addQuestions(Q2);
        Questions_level_1 Q3=new Questions_level_1("A large body from space enters Earth atmosphere is not a ","asteroid","meteoroid","meteor","all of them",3);
        addQuestions(Q3);
        Questions_level_1 Q4=new Questions_level_1("Which of them is correct","Chocolate tastes bitter","Snakes are venomous","meteoroid are larger than asteroid","1/2 comes before 3/4",3);
        addQuestions(Q4);
        Questions_level_1 Q5=new Questions_level_1("A bird's egg is not a ","Shell","Single cell","Multi cell","none of them",2);
        addQuestions(Q5);
        Questions_level_1 Q6=new Questions_level_1("If 1 is not equal to 2 but 2 is equal to 1 then 2*1+2*1+2 is not equal to ","16/2","10+12-14","10/2-2","24/3+1-2",4);
        addQuestions(Q6);
        Questions_level_1 Q7 = new Questions_level_1("Which of them is incorrect ?","area of square is 4*side","Earth is circle in shape","Natural color of Sun is white","Natural color of Sun is yellow",3);
        addQuestions(Q7);
        Questions_level_1 Q8=new Questions_level_1("If right does not means wrong but wrong means right then what is right","right","wrong or right","wrong","all of them",1);
        addQuestions(Q8);
        Questions_level_1 Q9=new Questions_level_1("There are ______ continents","7","(14+14)/4","(19-2)/17 +5","(14+12)/13+5",3);
        addQuestions(Q9);
        Questions_level_1 Q10=new Questions_level_1("Choose the incorrect answer","Answer","answer","AnsWer","Answers",2);
        addQuestions(Q10);
        Questions_level_1 Q11=new Questions_level_1("Which one is correct","1 comes after 0.9","Traingle is strongest shape","This option is correct","This option is incorrect",4);
        addQuestions(Q11);
        Questions_level_1 Q12=new Questions_level_1("plane mirror shows","refraction","reflection","both (1) and (2)","none",1);
        addQuestions(Q12);
    }

    private void addQuestions(Questions_level_1 questions1) {
        ContentValues cv1 = new ContentValues();
        cv1.put(QuestionTable.COLUMN_QUESTION, questions1.getQuestion1());
        cv1.put(QuestionTable.OPTION_1, questions1.getOption1());
        cv1.put(QuestionTable.OPTION_2, questions1.getOption2());
        cv1.put(QuestionTable.OPTION_3, questions1.getOption3());
        cv1.put(QuestionTable.OPTION_4, questions1.getOption4());
        cv1.put(QuestionTable.ANSWER, questions1.getAnswer1());
        db2.insert(QuestionTable.TABLE_NAME, null, cv1);
    }


    public List<Questions_level_1> Getallquestions() {
        List<Questions_level_1> questionslist = new ArrayList<>();
        db2=getReadableDatabase();
        Cursor c1=db2.rawQuery(" SELECT * FROM " + QuestionTable.TABLE_NAME,null);
        if(c1.moveToFirst())
        {
            do{
                Questions_level_1 questions_1 = new Questions_level_1();
                questions_1.setQuestion1(c1.getString(c1.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questions_1.setOption1(c1.getString(c1.getColumnIndex(QuestionTable.OPTION_1)));
                questions_1.setOption2(c1.getString(c1.getColumnIndex(QuestionTable.OPTION_2)));
                questions_1.setOption3(c1.getString(c1.getColumnIndex(QuestionTable.OPTION_3)));
                questions_1.setOption4(c1.getString(c1.getColumnIndex(QuestionTable.OPTION_4)));
                questions_1.setAnswer(c1.getInt(c1.getColumnIndex(QuestionTable.ANSWER)));
                questionslist.add(questions_1);


            }while(c1.moveToNext());
        }
        c1.close();
        return questionslist;
    }

}
