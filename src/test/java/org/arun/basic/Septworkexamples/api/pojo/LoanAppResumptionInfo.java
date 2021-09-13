package org.arun.basic.Septworkexamples.api.pojo;

import java.util.List;

public class LoanAppResumptionInfo {
	private int loanAppId;
	private String loanAppUuid;
	private String referrer;
	private String status;
	private String productType;
	private String sourceSystem;
	private double desiredAmount;
	private BorrowerResumptionInfo borrowerResumptionInfo;
	private Object coBorrowerResumptionInfo;
	private boolean turnDown;
	private boolean hasLogin;
	private List<Object> availableAppImprovements;
	private Object cashOutAmount;
	private boolean canAddCollateral;
	private Object rewardProgramId;
	private Object rewardProgramCode;
	private Object addon;
	private Object isMobileDiscountApplied;
	private boolean checkingDiscountAvailable;

	public int getLoanAppId() {
		return loanAppId;
	}

	public void setLoanAppId(int loanAppId) {
		this.loanAppId = loanAppId;
	}

	public String getLoanAppUuid() {
		return loanAppUuid;
	}

	public void setLoanAppUuid(String loanAppUuid) {
		this.loanAppUuid = loanAppUuid;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public double getDesiredAmount() {
		return desiredAmount;
	}

	public void setDesiredAmount(double desiredAmount) {
		this.desiredAmount = desiredAmount;
	}

	public BorrowerResumptionInfo getBorrowerResumptionInfo() {
		return borrowerResumptionInfo;
	}

	public void setBorrowerResumptionInfo(BorrowerResumptionInfo borrowerResumptionInfo) {
		this.borrowerResumptionInfo = borrowerResumptionInfo;
	}

	public Object getCoBorrowerResumptionInfo() {
		return coBorrowerResumptionInfo;
	}

	public void setCoBorrowerResumptionInfo(Object coBorrowerResumptionInfo) {
		this.coBorrowerResumptionInfo = coBorrowerResumptionInfo;
	}

	public boolean isTurnDown() {
		return turnDown;
	}

	public void setTurnDown(boolean turnDown) {
		this.turnDown = turnDown;
	}

	public boolean isHasLogin() {
		return hasLogin;
	}

	public void setHasLogin(boolean hasLogin) {
		this.hasLogin = hasLogin;
	}

	public List<Object> getAvailableAppImprovements() {
		return availableAppImprovements;
	}

	public void setAvailableAppImprovements(List<Object> availableAppImprovements) {
		this.availableAppImprovements = availableAppImprovements;
	}

	public Object getCashOutAmount() {
		return cashOutAmount;
	}

	public void setCashOutAmount(Object cashOutAmount) {
		this.cashOutAmount = cashOutAmount;
	}

	public boolean isCanAddCollateral() {
		return canAddCollateral;
	}

	public void setCanAddCollateral(boolean canAddCollateral) {
		this.canAddCollateral = canAddCollateral;
	}

	public Object getRewardProgramId() {
		return rewardProgramId;
	}

	public void setRewardProgramId(Object rewardProgramId) {
		this.rewardProgramId = rewardProgramId;
	}

	public Object getRewardProgramCode() {
		return rewardProgramCode;
	}

	public void setRewardProgramCode(Object rewardProgramCode) {
		this.rewardProgramCode = rewardProgramCode;
	}

	public Object getAddon() {
		return addon;
	}

	public void setAddon(Object addon) {
		this.addon = addon;
	}

	public Object getIsMobileDiscountApplied() {
		return isMobileDiscountApplied;
	}

	public void setIsMobileDiscountApplied(Object isMobileDiscountApplied) {
		this.isMobileDiscountApplied = isMobileDiscountApplied;
	}

	public boolean isCheckingDiscountAvailable() {
		return checkingDiscountAvailable;
	}

	public void setCheckingDiscountAvailable(boolean checkingDiscountAvailable) {
		this.checkingDiscountAvailable = checkingDiscountAvailable;
	}

}
