package Quizz.corporation.blaze.oppositequiz;

import android.provider.BaseColumns;

public final class Quiz_database  {
    public static class QuestionTable implements BaseColumns{
        public static final String TABLE_NAME="quiz_questions";
        public static final String COLUMN_QUESTION="question";
        public static final String OPTION_1="option_1";
        public static final String OPTION_2="option_2";
        public static final String OPTION_3="option_3";
        public static final String OPTION_4="option_4";
        public static final String ANSWER="answer";
    }
}
