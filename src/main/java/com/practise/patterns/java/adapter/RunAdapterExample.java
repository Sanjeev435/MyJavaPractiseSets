package com.practise.patterns.java.adapter;

import com.practise.patterns.java.adapter.PayD;
import com.practise.patterns.java.adapter.Xpay;

/**
 * 
 * The problem that arises here is that the site is attached to the Xpay payment
 * gateway which takes an Xpay type of object. The new vendor, PayD, only allows
 * the PayD type of objects to allow the process. Max doesn’t want to change the
 * whole set of 100 of classes which have reference to an object of type XPay.
 * This also raises the risk on the project, which is already running on the
 * production. Neither he can change the 3rd party tool of the payment gateway.
 * The problem has occurred due to the incompatible interfaces between the two
 * different parts of the code. In order to get the process work, Max needs to
 * find a way to make the code compatible with the vendor’s provided API.
 * 
 * PayD is new payment gateway which will replace XPay payment gateway. Current
 * code is not compatible with PayD interface. If they change the whole code
 * then it would be a lot of work.
 * 
 * Sometimes, there could be a scenario when two objects don’t fit together, as
 * they should in-order to get the work done. This situation could arise when we
 * are trying to integrate a legacy code with a new code, or when changing a 3rd
 * party API in the code. This is due to incompatible interfaces of the two
 * objects which do not fit together.
 * 
 * The Adapter pattern lets you to adapt what an object or a class exposes to
 * what another object or class expects. It converts the interface of a class
 * into another interface the client expects. It lets classes work together that
 * couldn’t otherwise because of incompatible interfaces. It allows to fix the
 * interface between the objects and the classes without modifying the objects
 * and the classes directly. You can think of an Adapter as a real world adapter
 * which is used to connect two different pieces of equipment that cannot be
 * connected directly. An adapter sits in-between these equipments, it gets the
 * flow from the equipment and provides it to the other equipment in the form it
 * wants, which otherwise, is impossible to get due to their incompatible
 * interfaces.
 * 
 * An adapter uses composition to store the object it is supposed to adapt, and
 * when the adapter’s methods are called, it translates those calls into
 * something the adapted object can understand and passes the calls on to the
 * adapted object. The code that calls the adapter never needs to know that it’s
 * not dealing with the kind of object it thinks it is, but an adapted object
 * instead.
 * 
 * Important Note:
 * 
 * There are two types of adapters, the object adapter, and the class adapter.
 * So far, we have seen the example of the object adapter which use object’s
 * composition, whereas, the class adapter relies on multiple inheritance to
 * adapt one interface to another. As Java does not support multiple
 * inheritance, we cannot show you an example of multiple inheritance, but you
 * can keep this in mind and may implement it in one of your favorite Object
 * Oriented Language like c++ which supports multiple inheritance
 * 
 * @author Sanjeev
 */
public class RunAdapterExample {

	/**
	 * The Adapter pattern should be used when:
	 * 
	 * There is an existing class, and its interface does not match the one you
	 * need.
	 * 
	 * You want to create a reusable class that cooperates with unrelated or
	 * unforeseen classes, that is, classes that don’t necessarily have
	 * compatible interfaces.
	 * 
	 * There are several existing subclasses to be use, but it’s impractical to
	 * adapt their interface by subclassing every one. An object adapter can
	 * adapt the interface of its parent class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Object for Xpay
		Xpay xpay = new XpayImpl();
		xpay.setCreditCardNo("4789565874102365");
		xpay.setCustomerName("Max Warner");
		xpay.setCardExpMonth("09");
		xpay.setCardExpYear("25");
		xpay.setCardCVVNo((short) 235);
		xpay.setAmount(2565.23);

		PayD payD = new XpayToPayDAdapter(xpay);
		testPayD(payD);
	}

	private static void testPayD(PayD payD) {

		System.out.println(payD.getCardOwnerName());
		System.out.println(payD.getCustCardNo());
		System.out.println(payD.getCardExpMonthDate());
		System.out.println(payD.getCVVNo());
		System.out.println(payD.getTotalAmount());
	}

}
