package com.practise.patterns.java.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * The following class shows how we can protect our class from getting
 * instantiated more than once.
 * 
 * Implementing the readResolve() and writeReplace() methods in our singleton
 * class and return the same object through them.
 * 
 * We should also implement the clone() method and throw an exception so that
 * the singleton cannot be cloned.
 * 
 * An "if condition" inside the constructor can prevent the singleton from
 * getting instantiated more than once using reflection.
 * 
 * To prevent the singleton getting instantiated from different class loaders,
 * you can implement the getClass() method. The above getClass() method
 * associates the classloader with the current thread; if that classloader is
 * null, the method uses the same classloader that loaded the singleton class.
 * 
 * @author Sanjeev
 *
 */
public class Singleton implements Serializable {

	private static final long serialVersionUID = -1093810940935189395L;
	private static Singleton sc = new Singleton();

	private Singleton() {
		if (sc != null) {
			throw new IllegalStateException("Already created.");
		}
	}

	public static Singleton getInstance() {
		return sc;
	}

	private Object readResolve() throws ObjectStreamException {
		return sc;
	}

	private Object writeReplace() throws ObjectStreamException {
		return sc;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton, cannot be clonned");
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private static Class getClass(String classname)
			throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null)
			classLoader = Singleton.class.getClassLoader();
		return (classLoader.loadClass(classname));
	}

}
