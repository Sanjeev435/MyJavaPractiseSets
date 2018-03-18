package com.practise.patterns.java.adapter;

import com.practise.patterns.java.adapter.PayD;
import com.practise.patterns.java.adapter.Xpay;

/**
 * We have created below an adapter which will be of type PayD, and it wraps an
 * Xpay object (the type it supposes to be adapted).
 * 
 * In the above code, we have created an Adapter(XpayToPayDAdapter). The adapter
 * implements the PayD interface, as it is required to mimic like a PayD type of
 * object. The adapter uses object composition to hold the object, it�s supposed
 * to be adapting, an Xpay type of object. The object is passed into the adapter
 * through its constructor.
 * 
 * Now, please note that we have two incompatible types of interfaces, which we
 * need to fit together using an adapter in order to make the code work. These
 * two interfaces have a different set of methods. But the sole purpose of these
 * interfaces is very much similar, i.e. to provide the customer and credit card
 * info to their specific vendors.
 * 
 * The setProp() method of the above class is used to set the xpay�s properties
 * into the payD�s object. We set the methods which are similar in work in both
 * the interfaces. However, there is only single method in PayD interface to set
 * the month and the year of the credit card, as opposed to two methods in the
 * Xpay interface. We joined the result of the two methods of the Xpay object
 * (this.xpay.getCardExpMonth()+"/"+this.xpay.getCardExpYear()) and sets it into
 * the setCardExpMonthDate() method.
 * 
 * @author Sanjeev
 *
 */
public class XpayToPayDAdapter implements PayD {

	private String custCardNo;
	private String cardOwnerName;
	private String cardExpMonthDate;
	private Integer cVVNo;
	private Double totalAmount;

	private final Xpay xpay;

	public XpayToPayDAdapter(Xpay xpay) {
		this.xpay = xpay;
		setProp();
	}

	@Override
	public String getCustCardNo() {
		return custCardNo;
	}

	@Override
	public String getCardOwnerName() {
		return cardOwnerName;
	}

	@Override
	public String getCardExpMonthDate() {
		return cardExpMonthDate;
	}

	@Override
	public Integer getCVVNo() {
		return cVVNo;
	}

	@Override
	public Double getTotalAmount() {
		return totalAmount;
	}

	@Override
	public void setCustCardNo(String custCardNo) {
		this.custCardNo = custCardNo;
	}

	@Override
	public void setCardOwnerName(String cardOwnerName) {
		this.cardOwnerName = cardOwnerName;
	}

	@Override
	public void setCardExpMonthDate(String cardExpMonthDate) {
		this.cardExpMonthDate = cardExpMonthDate;
	}

	@Override
	public void setCVVNo(Integer cVVNo) {
		this.cVVNo = cVVNo;
	}

	@Override
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	private void setProp() {
		setCardOwnerName(this.xpay.getCustomerName());
		setCustCardNo(this.xpay.getCreditCardNo());
		setCardExpMonthDate(this.xpay.getCardExpMonth() + "/"
				+ this.xpay.getCardExpYear());
		setCVVNo(this.xpay.getCardCVVNo().intValue());
		setTotalAmount(this.xpay.getAmount());
	}

}
