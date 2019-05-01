package Quizz.corporation.blaze.oppositequiz;

public class Questions_level_1 {
    private String Question;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private int Answer;

    public Questions_level_1()
    {

    }

    public Questions_level_1(String question1, String option1, String option2, String option3, String option4, int answer) {
        Question = question1;
        this.Option1 = option1;
        this.Option2 = option2;
        this.Option3 = option3;
        this.Option4 = option4;
        this.Answer = answer;
    }

    public String getQuestion1() {
        return Question;
    }

    public void setQuestion1(String question1) {
        Question = question1;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public int getAnswer1() {
        return Answer;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }
}

