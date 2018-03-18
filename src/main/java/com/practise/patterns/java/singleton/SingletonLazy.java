package com.practise.patterns.java.singleton;

/**
 * The problem with SingletonEager class was its static initialization.
 * SingletonEager class got initialized at the time of loading of classes even
 * though if that class was not used or invoked because of its static nature.
 * 
 * This behavior can be overcome by the below way.
 * 
 * It’s always a good approach that an object should get created when it is
 * required. So, we will create an object on the first call and then will return
 * the same object on other successive calls.
 * 
 * In the getInstance() method, we check if the static variable sc is null, then
 * instantiate the object and return it. So, on the first call when sc would be
 * null the object gets created and on the next successive calls it will return
 * the same object.
 * 
 * This surely looks good. But this code will fail in a multi-threaded
 * environment. Imagine two threads concurrently accessing the class, thread t1
 * gives the first call to the getInstance() method, it checks if the static
 * variable sc is null and then gets interrupted due to some reason. Another
 * thread t2 calls the getInstance() method successfully passes the if check and
 * instantiates the object. Then, thread t1 gets awake and it also creates the
 * object. At this time, there would be two objects of this class.
 * 
 * @author Sanjeev
 *
 */
public class SingletonLazy {

	private static SingletonLazy sc = null;

	private SingletonLazy() {
	}

	public static SingletonLazy getInstance() {
		if (sc == null) {
			sc = new SingletonLazy();
		}
		return sc;
	}
}
