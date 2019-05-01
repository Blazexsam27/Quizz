package Quizz.corporation.blaze.oppositequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import Quizz.corporation.blaze.oppositequiz.Quiz_database.*;

import java.util.ArrayList;
import java.util.List;

public class quiz_database_helper_level_3 extends SQLiteOpenHelper {
    private static final String Database_Name="Quizz_database.db";
    private static final int Version=1;
    private SQLiteDatabase db;

    public quiz_database_helper_level_3(Context context) {
        super(context,Database_Name,null,Version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        final String SQL_DATABASE_CREATE_QUESTIONS_TABLE=" Create Table "+
                QuestionTable.TABLE_NAME +" ( "+
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.OPTION_1 + " TEXT, " +
                QuestionTable.OPTION_2 + " TEXT, " +
                QuestionTable.OPTION_3 + " TEXT, " +
                QuestionTable.OPTION_4 + " TEXT, " +
                QuestionTable.ANSWER + " INTEGER " +
                        " ) ";
        db.execSQL(SQL_DATABASE_CREATE_QUESTIONS_TABLE);
        fillQuestionTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ QuestionTable.TABLE_NAME);
        onCreate(db);
    }
    private void fillQuestionTable()//Questions for level 3.
    {
        Questions Q1=new Questions("1,2,5 are examples of ","composite number","even + odd number","irrational number","odd+ prime numbers",3);
        addQuestion(Q1);
        Questions Q2=new Questions("Earth lie","before mars","between venus and mars","fifth planet from last","between saturn and mars",4);
        addQuestion(Q2);
        Questions Q3=new Questions("Which of them is incorrect ?","this one is incorrect","this one is correct","this one is false","this one is Corect",2);
        addQuestion(Q3);
        Questions Q4=new Questions("If + equal to - then what is 15+17 ?","positive 32","positive 64/2","positive 24+16/2","positive 16+48/2",4);
        addQuestion(Q4);
        Questions Q5=new Questions("Water have two elements in large quantity","nitrogen,hydrogen","oxygen,hydrogen","nitrogen,carbon","carbon,oxygen",3);
        addQuestion(Q5);
        Questions Q6=new Questions("If A equals 1 but not 2 then which of them is incorrect?","A+A+A=3","A+A-A=2","A+A*A=5","A+A=2",2);
        addQuestion(Q6);
        Questions Q7=new Questions("How will you say 'I AM EATING' in opposite form?","I AM EATING","I AM NOT EATING","I AM DRINKING","I AM EATEN",1);
        addQuestion(Q7);
        Questions Q8=new Questions("Which of the following is simplest element?","Helium","Hydrogen","Uranium","Tritium",3);
        addQuestion(Q8);
        Questions Q9=new Questions("If hell is not heaven but heaven is hell then what is Heaven?","Heaven","Hell and Heaven both","Hell","None of them",2);
        addQuestion(Q9);
        Questions Q10=new Questions("Which element is most common ?","Titinium","Helium","Platinum","Gold",2);
        addQuestion(Q10);
        Questions Q11=new Questions("If horizontal is not vertical and vertical are not horizontal then longitudes are","vertical","horizontal","verticle and horizontal","verticle",2);
        addQuestion(Q11);
        Questions Q12=new Questions("In your exams which option will you choose?","The correct one","That one which looks correct","wrong one","all options if possible",3);
        addQuestion(Q12);
        Questions Q13=new Questions("If january have equal days as february but april have not as march then number of days in april are","30","29","31","both 30 and 31",4);
        addQuestion(Q13);
        Questions Q14=new Questions("Which of these things,a plant requires the most?","carbondioxode,sunlight","carbon,nitrogen","green color from white light","oxygen",3);
        addQuestion(Q14);
        Questions Q15=new Questions("What happens if we expose soduim in air ?","It produces smoke","It catches fire ","nothing will happen","all of them",3);
        addQuestion(Q15);
        Questions Q16=new Questions("White color represents ","Peace","Voilence","NoVoilence","All of them",2);
        addQuestion(Q16);
        Questions Q17=new Questions("An hydrogen atom contains","1 proton,1 nuetron,1 electron","all of them","1 electron,1 proton","2/2 proton,1*1/2*2 electron",1);
        addQuestion(Q17);
        Questions Q18=new Questions("If A is not equal to 3 & B is not equal to 4A then 2A+3B is not equal to","42-2+4","(30+10-5)/5","(60-43+3)/5+38","(12+30+7)/3",3);
        addQuestion(Q18);
        Questions Q19=new Questions("If 'anything' does not means 'nothing in opposite then what will be 'everything' in opposite?","anything","nothing","not that thing","not those things",1);
        addQuestion(Q19);
        Questions Q20=new Questions("π (pi) is ","an irrational number","a real number","an integer and a rational number","a real number and and irrational number",3);
        addQuestion(Q20);
        Questions Q21=new Questions("Which of the following is correct ?","Their are total 11 dimensions","One day on Earth equals 24hrs","'g' represents gravitational force","Android gingerbread was 3.0",1);
        addQuestion(Q21);
        Questions Q22=new Questions("Which of them is correct ?","electron is the smallest thing","fourth dimension represents time","ozone is harmful for humans","195 is the total no of country presentis the world",1);
        addQuestion(Q22);
        Questions Q23=new Questions("What does 'g' denotes ?","accelaration due to gravity","gravitational force","acceleration","accelaration due to Earth's gravity",2);
        addQuestion(Q23);
        Questions Q24=new Questions("'Idiot','Moron' are not ","abusive terms","sceintific terms","bad words","good words",2);
        addQuestion(Q24);
        Questions Q25=new Questions("Which of the following is correct ?","0 is not a natural number","process occurs in sun is nuclear fusion","LED stands for light emmiting device","1/2+2/3 is an odd number",3);
        addQuestion(Q25);
        Questions Q26=new Questions("Which of the following is incorrect ?","human eye lens is of 576M megapixels","infinity and undefined are same","heart is the only oragan having no bones","C,C++ are use for web designing",1);
        addQuestion(Q26);
        Questions Q27=new Questions("HTML and XML stands for","Hypertext markuplanguage and extensible markuplanguage","Hypertext markuplanguage and xtensible markuplanguage","both (1)and (2)","none of them",2);
        addQuestion(Q27);
        Questions Q28=new Questions("Direction of flow of negative charge means ","direction of current","direction of voltage","direction of protons","direction of magnetic field",1);
        addQuestion(Q28);
        Questions Q29=new Questions("Number of months having more than 30 days ","3 months"," month","all months","6 months",2);
        addQuestion(Q29);
        Questions Q30=new Questions("Which one is correct ?","Rainbow have 7 colours","Googol is a search engine","LCD stands for liquid crystal display","1/0 is undefined",2);
        addQuestion(Q30);
    }
    private void addQuestion(Questions question)
    {
        ContentValues cv= new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.OPTION_1,question.getOption1());
        cv.put(QuestionTable.OPTION_2,question.getOption2());
        cv.put(QuestionTable.OPTION_3,question.getOption3());
        cv.put(QuestionTable.OPTION_4,question.getOption4());
        cv.put(QuestionTable.ANSWER,question.getAnswer());
        db.insert(QuestionTable.TABLE_NAME,null,cv);
    }
    public List<Questions> getAllQuestions()
    {
        List<Questions> questionlist= new ArrayList<>();
        db=getReadableDatabase();
        Cursor c= db.rawQuery(" SELECT * FROM " + QuestionTable.TABLE_NAME,null);
        if(c.moveToFirst())
        {
            do{
                Questions questions = new Questions();
                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questions.setOption1(c.getString(c.getColumnIndex(QuestionTable.OPTION_1)));
                questions.setOption2(c.getString(c.getColumnIndex(QuestionTable.OPTION_2)));
                questions.setOption3(c.getString(c.getColumnIndex(QuestionTable.OPTION_3)));
                questions.setOption4(c.getString(c.getColumnIndex(QuestionTable.OPTION_4)));
                questions.setAnswer(c.getInt(c.getColumnIndex(QuestionTable.ANSWER)));
                questionlist.add(questions);
            }while(c.moveToNext());
        }
        c.close();
        return questionlist;
    }
}
