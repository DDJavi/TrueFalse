package com.example.truefalse;

public class Quizz {
    private String question;
    private boolean answer;

    private Quizz(){}
    public Quizz(String question, boolean answer){
        this.question = question;
        this.answer = answer;
    }
    public String getQuestion(){ return question; }
    public void setQuestion(String question){ this.question=question; }
    public boolean answer(){ return answer; }
    public void setAnswer(boolean answer) { this.answer = answer; }

}
