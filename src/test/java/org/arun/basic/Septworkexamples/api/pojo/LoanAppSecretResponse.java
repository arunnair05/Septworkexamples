package org.arun.basic.Septworkexamples.api.pojo;

import java.util.List;

public class LoanAppSecretResponse {
	private LoanAppResumptionInfo loanAppResumptionInfo;
	private List<Object> offers;
	private Object selectedOffer;
	private List<Object> requiredAgreements;
	private List<String> resetOptions;
	private Object originalLoanApp;

	public LoanAppResumptionInfo getLoanAppResumptionInfo() {
		return loanAppResumptionInfo;
	}

	public void setLoanAppResumptionInfo(LoanAppResumptionInfo loanAppResumptionInfo) {
		this.loanAppResumptionInfo = loanAppResumptionInfo;
	}

	public List<Object> getOffers() {
		return offers;
	}

	public void setOffers(List<Object> offers) {
		this.offers = offers;
	}

	public Object getSelectedOffer() {
		return selectedOffer;
	}

	public void setSelectedOffer(Object selectedOffer) {
		this.selectedOffer = selectedOffer;
	}

	public List<Object> getRequiredAgreements() {
		return requiredAgreements;
	}

	public void setRequiredAgreements(List<Object> requiredAgreements) {
		this.requiredAgreements = requiredAgreements;
	}

	public List<String> getResetOptions() {
		return resetOptions;
	}

	public void setResetOptions(List<String> resetOptions) {
		this.resetOptions = resetOptions;
	}

	public Object getOriginalLoanApp() {
		return originalLoanApp;
	}

	public void setOriginalLoanApp(Object originalLoanApp) {
		this.originalLoanApp = originalLoanApp;
	}

}
