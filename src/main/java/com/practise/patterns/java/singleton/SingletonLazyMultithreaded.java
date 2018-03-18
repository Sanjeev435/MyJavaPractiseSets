package com.practise.patterns.java.singleton;

/**
 * To overcome the SingletonLazy class multi-thread failure, we will use
 * synchronized key.
 * 
 * We have use the synchronized keyword to the getInstance() method. With this
 * way, we force every thread to wait its turn before it can enter the method.
 * So, no two threads will enter the method at the same time. The synchronized
 * comes with a price, it will decrease the performance, but if the call to the
 * getInstance() method isn’t causing a substantial overhead to our application,
 * forget about it. The other workaround is to move to eager instantiation
 * approach as shown in the SingletonLazy class.
 * 
 * @author Sanjeev
 *
 */
public class SingletonLazyMultithreaded {

	private static SingletonLazyMultithreaded sc = null;

	private SingletonLazyMultithreaded() {
	}

	public static synchronized SingletonLazyMultithreaded getInstance() {
		if (sc == null) {
			sc = new SingletonLazyMultithreaded();
		}
		return sc;
	}
}
