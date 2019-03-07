package semwinf.model;

public class Answer {
	private String answer;
	private String stepid;
	private String resultid;
	private String placeholderresult;
	private String placeholderstep;
	
	public Answer() {
		
	}
	
	public Answer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStepid() {
		return stepid;
	}
	public void setStepid(String stepid) {
		this.stepid = stepid;
	}

	public String getResultid() {return resultid;}
	public void setResultid(String resultid) {this.resultid = resultid;}

	public String getPlaceholderresult() {
		return placeholderresult;
	}

	public void setPlaceholderresult(String placeholderresult) {
		this.placeholderresult = placeholderresult;
	}

	public String getPlaceholderstep() {
		return placeholderstep;
	}

	public void setPlaceholderstep(String placeholderstep) {
		this.placeholderstep = placeholderstep;
	}
}
