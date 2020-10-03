package com.practise.patterns.adapter;

import com.practise.patterns.adapter.Xpay;

/**
 * 
 * It contains set of setters and getter method used to get the information
 * about the credit card and customer name.
 * 
 * This Xpay interface is implemented in the code which is used to instantiate
 * an object of this type, and exposes the object to the vendor's API. The
 * following class defines the implementation to the Xpay interface.
 * 
 * @author Sanjeev
 *
 */
public class XpayImpl implements Xpay {

	private String creditCardNo;
	private String customerName;
	private String cardExpMonth;
	private String cardExpYear;
	private Short cardCVVNo;
	private Double amount;

	
	public String getCreditCardNo() {
		return creditCardNo;
	}

	@Override
	public String getCustomerName() {
		return customerName;
	}

	@Override
	public String getCardExpMonth() {
		return cardExpMonth;
	}

	@Override
	public String getCardExpYear() {
		return cardExpYear;
	}

	@Override
	public Short getCardCVVNo() {
		return cardCVVNo;
	}

	@Override
	public Double getAmount() {
		return amount;
	}

	@Override
	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	@Override
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public void setCardExpMonth(String cardExpMonth) {
		this.cardExpMonth = cardExpMonth;
	}

	@Override
	public void setCardExpYear(String cardExpYear) {
		this.cardExpYear = cardExpYear;
	}

	@Override
	public void setCardCVVNo(Short cardCVVNo) {
		this.cardCVVNo = cardCVVNo;
	}

	@Override
	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
