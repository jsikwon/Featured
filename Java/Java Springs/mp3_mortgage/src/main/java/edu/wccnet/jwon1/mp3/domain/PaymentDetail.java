package edu.wccnet.jwon1.mp3.domain;

public class PaymentDetail {
	private int monthNo;
	private double outstanding;
	private double principalPaid;
	private double interestPaid;
	public int getMonthNo() {
		return monthNo;
	}
	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}
	public double getOutstanding() {
		return outstanding;
	}
	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}
	public double getPrincipalPaid() {
		return principalPaid;
	}
	public void setPrincipalPaid(double principalPaid) {
		this.principalPaid = principalPaid;
	}
	public double getInterestPaid() {
		return interestPaid;
	}
	public void setInterestPaid(double interestPaid) {
		this.interestPaid = interestPaid;
	}

	
}
