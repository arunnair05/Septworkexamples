package org.arun.basic.Septworkexamples.api.pojo;

import java.util.UUID;

public class BodyLoanAppSecret {
	private UUID loanAppUuid;
	private boolean skipSideEffects;

	public UUID getLoanAppUuid() {
		return loanAppUuid;
	}

	public void setLoanAppUuid(UUID loanAppUuid) {
		this.loanAppUuid = loanAppUuid;
	}

	public boolean isSkipSideEffects() {
		return skipSideEffects;
	}

	public void setSkipSideEffects(boolean skipSideEffects) {
		this.skipSideEffects = skipSideEffects;
	}

}
