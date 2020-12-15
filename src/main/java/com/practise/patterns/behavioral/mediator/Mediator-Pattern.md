### The Mediator pattern allows loose coupling by encapsulating the way disparate sets of objects interact and communicate with each other. Allows for the actions of each object set to vary independently of one another. It's used to manage algorithms, relationships and responsibilities between objects.In other words, it lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.


#### Implementation
 * Mediator – defines the interface for communication between Colleague objects
 * ConcreteMediator – implements the Mediator interface and coordinates communication between Colleague objects. It is aware of all of the Colleagues and their purposes with regards to inter-communication.
 * Colleague (User) – defines the interface for communication with other Colleagues through its Mediator
 * ConcreteColleague (UserImpl) – implements the Colleague interface and communicates with other Colleagues through its Mediator


#### Usage examples: 
 * A great real world example of mediator pattern is traffic control room at airports. If all flights will have to interact with each other for finding which flight is going to land next, it will create a big mess.
 * Rather flights only send their status to the tower. These towers in turn send the signals to conform which airplane can take-off or land. We must note that these towers do not control the whole flight. They only enforce constraints in the terminal areas.
 * Another good example of mediator pattern is a chat application. In a chat application we can have several participants. It’s not a good idea to connect each participant to all the others because the number of connections would be really high. The best solution is to have a hub where all participants will connect; this hub is just the mediator class.
 * In Java programming, the execute() method inside the java.util.concurrent.Executor interface follows this pattern. The different overloaded versions of various schedule() methods of the java.util.Timer class also can be considered to follow this pattern.
 * Aircraft pilots don’t talk to each other directly when deciding who gets to land their plane next. All communication goes through the control tower.


#### Mediator Pattern Example in JDK
* java.util.Timer class scheduleXXX() methods
* Java Concurrency Executor execute() method.
* java.lang.reflect.Method invoke() method.
    
    
#### When to use:
 * Communication between sets of objects is well defined and complex.
 * Too many relationships exist and common point of control or communication is needed


#### Advantages & Disadvantages
 ✔ Single Responsibility Principle. You can extract the communications between various components into a single place, making it easier to comprehend and maintain. <br/>
 ✔ Open/Closed Principle. You can introduce new mediators without having to change the actual components. <br/>
 ✔ You can reduce coupling between various components of a program. <br/>
 ✔ You can reuse individual components more easily. <br/>
 ✔ Mediator pattern is useful when the communication logic between objects is complex, we can have a central point of communication that takes care of communication logic. <br/>
 ✔ Using mediator pattern, we can reduce the complexity of communication between objects in a system. It promotes loose coupling and reduces number of subclasses in the system. <br/>
 ✔ Java Message Service (JMS) uses Mediator pattern along with Observer pattern to allow applications to subscribe and publish data to other applications. <br/>
 ✔ Mediator helps in replacing “many-to-many” relationship with “one-to-many” relationships, so it is much easier to read and understand. <br/>
 ❌ We should not use mediator pattern just to achieve lose-coupling because if the number of mediators will grow, then it will become hard to maintain them. <br/>
 ❌ Over time a mediator can evolve into a God Object. <br/>
 
 
#### Relations with Other Patterns
 * Chain of Responsibility, Command, Mediator and Observer address various ways of connecting senders and receivers of requests:
	 * Chain of Responsibility passes a request sequentially along a dynamic chain of potential receivers until one of them handles it.
	 * Command establishes unidirectional connections between senders and receivers.
	 * Mediator eliminates direct connections between senders and receivers, forcing them to communicate indirectly via a mediator object.
	 * Observer lets receivers dynamically subscribe to and unsubscribe from receiving requests.
 * Facade and Mediator have similar jobs: they try to organize collaboration between lots of tightly coupled classes.
	 * Facade defines a simplified interface to a subsystem of objects, but it doesn’t introduce any new functionality. The subsystem itself is unaware of the facade. Objects within the subsystem can communicate directly.
	 * Mediator centralizes communication between components of the system. The components only know about the mediator object and don’t communicate directly.
 * The difference between Mediator and Observer is often elusive. In most cases, you can implement either of these patterns; but sometimes you can apply both simultaneously. Let’s see how we can do that.
	 * The primary goal of Mediator is to eliminate mutual dependencies among a set of system components. Instead, these components become dependent on a single mediator object. The goal of Observer is to establish dynamic one-way connections between objects, where some objects act as subordinates of others.
	 * There’s a popular implementation of the Mediator pattern that relies on Observer. The mediator object plays the role of publisher, and the components act as subscribers which subscribe to and unsubscribe from the mediator’s events. When Mediator is implemented this way, it may look very similar to Observer.
	 * When you’re confused, remember that you can implement the Mediator pattern in other ways. For example, you can permanently link all the components to the same mediator object. This implementation won’t resemble Observer but will still be an instance of the Mediator pattern.
	 * Now imagine a program where all components have become publishers, allowing dynamic connections between each other. There won’t be a centralized mediator object, only a distributed set of observers.
 
