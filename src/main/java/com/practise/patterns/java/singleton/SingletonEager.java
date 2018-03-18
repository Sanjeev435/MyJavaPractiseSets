package com.practise.patterns.java.singleton;

/**
 * By keeping the constructor private, no other class can instantiate this
 * class. The only way to get the object of this class is using the sc static
 * variable which ensures only one object is there.
 * 
 * But as we know, providing a direct access to a class member is not a good
 * idea. We will provide a method through which the sc variable will get access,
 * not directly.
 * 
 * So, this is our singleton class which makes sure that only one object of the
 * class gets created and even if there are several requests, only the same
 * instantiated object will be returned.
 * 
 * The one problem with this approach is that, the object would get created as
 * soon as the class gets loaded into the JVM. If the object is never requested,
 * there would be an object useless inside the memory.
 * 
 * @author Sanjeev
 *
 */
public class SingletonEager {
	private static SingletonEager sc = new SingletonEager();

	private SingletonEager() {
	}

	public static SingletonEager getInstance() {
		return sc;
	}
}
