package semwinf.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection = "steps")

public class StepVM {

    /*@Field("treeid")
    private String treeid;
    @Field
    private String question;
    @Field
    private String caption;
    @Field
    private InputType type;
    @Field
    private ArrayList<Answer> answers;

    public StepVM(String question, String caption, InputType type, String treeid, ArrayList<Answer> answers) {
        this.question = question;
        this.caption = caption;
        this.type = type;
        this.treeid = treeid;
        this.answers = answers;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public InputType getType() {
        return type;
    }
    public void setType(InputType type) {
        this.type = type;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer a) {
        this.answers.add(a);
    }

    public String getTreeid() {
        return treeid;
    }

    public void setTreeid(String treeid) {
        this.treeid = treeid;
    }*/
}
