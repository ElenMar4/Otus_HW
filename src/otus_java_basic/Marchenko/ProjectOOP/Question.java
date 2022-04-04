package otus_java_basic.Marchenko.ProjectOOP;

public class Question {
    private String description;
    private Answer answer;

    public Question(String description, Answer answer){
        this.answer = answer;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Answer getAnswer() {
        return answer;
    }
}
