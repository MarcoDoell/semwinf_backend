package semwinf.model;

import org.springframework.data.annotation.Id;

public class TreeVM {

    @Id
    private String treeid;
    private String caption;
    private String startStepId;

    public TreeVM() {

    }

    public TreeVM(String treeid, String caption, String startStepId) {
        this.caption = caption;
        this.treeid = treeid;
        this.startStepId = startStepId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTreeid() {
        return treeid;
    }

    public void setTreeid(String treeid) {
        this.treeid = treeid;
    }

    public String getStartStepId() {
        return startStepId;
    }

    public void setStartStepId(String startStepId) {
        this.startStepId = startStepId;
    }
}
