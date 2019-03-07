package semwinf.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;


@Document(collection = "results")
public class Result {

    @Id
    private String resultid;

    @Field("treeid")
    private String treeid;

    @Field
    private String result;


    public String getResultid() {
        return resultid;
    }

    public void setResultid(String resultid) {
        this.resultid = resultid;
    }

    public String getTreeid() {
        return treeid;
    }

    public void setTreeid(String treeid) {
        this.treeid = treeid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}