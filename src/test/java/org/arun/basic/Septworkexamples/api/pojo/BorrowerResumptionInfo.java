package org.arun.basic.Septworkexamples.api.pojo;

public class BorrowerResumptionInfo {
	private String firstName;
	private String maskedEmail;
	private boolean ssnRequired;
	private String state;
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMaskedEmail() {
		return maskedEmail;
	}

	public void setMaskedEmail(String maskedEmail) {
		this.maskedEmail = maskedEmail;
	}

	public boolean isSsnRequired() {
		return ssnRequired;
	}

	public void setSsnRequired(boolean ssnRequired) {
		this.ssnRequired = ssnRequired;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
