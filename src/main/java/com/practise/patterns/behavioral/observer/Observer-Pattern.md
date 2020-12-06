### The Observer pattern lets one or more objects be notified of state changes in other objects within the system. It define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.


#### Implementation
The observer pattern has four participants.
 * Subject – interface or abstract class defining the operations for attaching and de-attaching observers to the subject.
 * ConcreteSubject – concrete Subject class. It maintain the state of the object and when a change in the state occurs it notifies the attached Observers.
 * Observer – interface or abstract class defining the operations to be used to notify this object.
 * ConcreteObserver – concrete Observer implementations.


#### Usage examples: 
This pattern can be found in almost every GUI environment. When buttons, text, and other fields are placed in applications the application typically registers as a listener for those controls. When a user triggers an event, such as clicking a button, the control iterates through its registered observers and sends a notification to each.

#### Java 8 Observer Pattern: 
The java API provides one class and one inteface for implementing observer pattern.
 * java.util.Observable-class
 	* java.util.Observable: For being observed,class must extend this class. The subclass becomes observable and override methods of  java.util.Observable and other objects can "observe" changes in state of this object.
 * java.util.Observer-interface
 	* The class that performs the "observing" must implement the java.util.Observer interface. There is a single update method which must be implemented.


#### When to use:
 * State changes in one or more objects should trigger behavior in other objects
 * Broadcasting capabilities are required.
 * An understanding exists that objects will be blind to the expense of notification.
 * We want to use this pattern to reduce coupling. If we have an object that needs to share it's state with others, without knowing who those objects are, the Observer is exactly what we need.


#### Advantages & Disadvantages
To pass data onto the observers, our subject doesn't need to know who needs to know. Instead, everything is done through a common interface, and the notify method just calls all the objects out there that have registered their interest. This is a very powerful decoupling - meaning that any object can simply implement the Observer interface and get updates from the Subject.