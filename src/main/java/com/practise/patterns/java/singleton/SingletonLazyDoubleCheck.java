package com.practise.patterns.java.singleton;

/**
 * The slowness experienced in SingletonLazyMultithreaded class due to
 * synchronized keyword can be avoid by using the below technique.
 * 
 * The below technique known as “double-checked locking” to reduce the use of
 * synchronization. With the double-checked locking, we first check to see if an
 * instance is created, and if not, then we synchronize. This way, we only
 * synchronize the first time.
 * 
 * @author Sanjeev
 *
 */
public class SingletonLazyDoubleCheck {

	private volatile static SingletonLazyDoubleCheck sc = null;

	private SingletonLazyDoubleCheck() {
	}

	public static SingletonLazyDoubleCheck getInstance() {
		if (sc == null) {
			synchronized (SingletonLazyDoubleCheck.class) {
				if (sc == null) {
					sc = new SingletonLazyDoubleCheck();
				}
			}
		}
		return sc;
	}
}
