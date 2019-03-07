package semwinf.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Tree {

	@Id
	private String treeid;
	private TreeState state;
	private String caption;
	private String startStepId;
	private boolean isFinished = false;
	private ArrayList<Step> steps;
	
	public Tree() {
		
	}
	
	public Tree(String treeid, String caption, String startStepId) {
		this.treeid = treeid;
		this.caption = caption;
		this.startStepId = startStepId;
		this.state = TreeState.EDIT;
	}

	public String getTreeid() {
		return treeid;
	}

	public void setTreeid(String treeid) {
		this.treeid = treeid;
	}

	public TreeState getState() {
		return state;
	}

	public void setState(TreeState state) {
		this.state = state;
	}

	public ArrayList<Step> getSteps() {
		return steps;
	}

	public void addStep(Step s) {
		this.steps.add(s);
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getStartStepId() {
		return startStepId;
	}

	public void setStartStepId(String startStepId) {
		this.startStepId = startStepId;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean finished) {
		isFinished = finished;
	}
}
