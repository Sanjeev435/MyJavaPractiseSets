package com.practise.patterns.java.facade;

/**
 * A Facade same as an Adapter can wrap multiple classes, but a facade is used
 * to an interface to simplify the use of the complex interface, whereas, an
 * adapter is used to convert the interface to an interface the client expects.
 * 
 * Use the Facade Pattern, when: 
 * 1. You want to provide a simple interface to a
 * complex subsystem. Subsystems often get more complex as they evolve. Most
 * patterns, when applied, result in more and smaller classes. This makes the
 * subsystem more reusable and easier to customize, but it also becomes harder
 * to use for clients that don’t need to customize it. A facade can provide a
 * simple default view of the subsystem that is good enough for most clients.
 * Only clients needing more customizability will need to look beyond the
 * facade. 
 * 2. There are many dependencies between clients and the implementation
 * classes of an abstraction. Introduce a facade to decouple the subsystem from
 * clients and other subsystems, thereby promoting subsystem independence and
 * portability. 
 * 3. You can layer your subsystems. Use a facade to define an
 * entry point to each subsystem level. If subsystems are dependent, then you
 * can simplify the dependencies between them by making them communicate with
 * each other solely through their facades.
 */
public class TestFacade {

	public static void main(String[] args) {

		ScheduleServer scheduleServer = new ScheduleServer();
		ScheduleServerFacade facadeServer = new ScheduleServerFacade(
				scheduleServer);
		facadeServer.startServer();

		System.out.println("Start working......");
		System.out.println("After work done.........");

		facadeServer.stopServer();
	}

}
