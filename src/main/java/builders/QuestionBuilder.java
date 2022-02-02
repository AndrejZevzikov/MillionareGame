package builders;

import QA.Answers;
import QA.Question;
import enumai.GameDifficult;

import java.util.HashSet;
import java.util.Set;

public class QuestionBuilder {

    private String question;
    private Set<Answers> answers = new HashSet<>();
    private GameDifficult difficult;

    public QuestionBuilder setQuestion(String question){
        this.question = question;
        return this;
    }

    public QuestionBuilder setDifficult(GameDifficult difficult){
        this.difficult = difficult;
        return this;
    }

    public QuestionBuilder setAnswer(String answer,boolean isCorrect){
        answers.add(new Answers(answer,isCorrect));
        return this;
    }

    public Question build(){
        return new Question(question,answers,difficult);
    }

}
