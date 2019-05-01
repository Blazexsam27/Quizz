package Quizz.corporation.blaze.oppositequiz;

public class Questions_level_2 {
    private String Question;
    private int answer;

    public Questions_level_2()
    {

    }

    public Questions_level_2(String question,int answer) {
        Question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
