package com.cg.wallet.dto;

public class WalletTransfer {
    
	private Integer fromId;
	private Integer toID;
	private Double fund;
	public Integer getFromId() {
		return fromId;
	}
	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}
	public Integer getToID() {
		return toID;
	}
	public void setToID(Integer toID) {
		this.toID = toID;
	}
	public Double getFund() {
		return fund;
	}
	public void setFund(Double fund) {
		this.fund = fund;
	}
	public WalletTransfer(Integer fromId, Integer toID, Double fund) {
		super();
		this.fromId = fromId;
		this.toID = toID;
		this.fund = fund;
	}
	@Override
	public String toString() {
		return "WalletTransfer [fromId=" + fromId + ", toID=" + toID + ", fund=" + fund + "]";
	}
	

}
