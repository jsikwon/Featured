package edu.wccnet.jwon1.mp3.domain;

import java.util.ArrayList;

public class Mortgage {
	private double principal;
	private double downPayment;
	private double interestRate;
	private int loanTerm;
	private double monthlyPayment;
	private ArrayList<PaymentDetail> paymentList;
	
	
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public ArrayList<PaymentDetail> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(ArrayList<PaymentDetail> paymentList) {
		this.paymentList = paymentList;
	}
	
	public void calcMonthly() {
		monthlyPayment =(principal-downPayment)*(interestRate/12*Math.pow(1+interestRate/12, loanTerm*12)
				/ (Math.pow(1+interestRate/12, loanTerm *12) - 1));
	}
	public void populatePaymentList() {
		paymentList = new ArrayList<>();
		
		double outstanding, pPaid;
		outstanding = principal-downPayment;
		int count = 0;
		PaymentDetail paymentDetail;
		while(outstanding > 0) {
			paymentDetail = new PaymentDetail();
			paymentDetail.setMonthNo(++count);
			if(outstanding < monthlyPayment) {
				paymentDetail.setPrincipalPaid(outstanding);
				paymentDetail.setOutstanding(0);
				paymentDetail.setInterestPaid(0);
				outstanding = 0;
			}else {
				pPaid = monthlyPayment - (outstanding * (interestRate/12));
				paymentDetail.setInterestPaid(outstanding * (interestRate/12));
				paymentDetail.setPrincipalPaid(pPaid);
				outstanding -= pPaid;
				paymentDetail.setOutstanding(outstanding);
			}
			paymentList.add(paymentDetail);
		}
	}
	public static void main(String[] args) {
		Mortgage m = new Mortgage();
		m.principal = 300_000;
		m.interestRate = 0.05;
		m.loanTerm = 30;
		m.calcMonthly();
		System.out.println(m.monthlyPayment);
		m.populatePaymentList();
		for (PaymentDetail paymentDetail : m.paymentList) {
			System.out.println(paymentDetail);
		}

	}
}


