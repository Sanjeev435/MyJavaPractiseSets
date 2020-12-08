### Identifies the framework of an algorithm, allowing implementing classes to define the actual behavior.


#### Implementation
1. Mark template method as final so that implementing class can’t override and change the order of steps.
2. In base class, implement all the methods with default implementation so the derived classes need not to define them.
3. Mark all methods abstract which derived classes must implement.


#### Usage examples: 
 * A parent class, InstantMessage, will likely have all the methods required to handle sending a message. However, the actual serialization of the data to send may vary depending on the implementation. A video message and a plain text message will require different algorithms in order to serialize the data correctly. Subclasses of InstantMessage can provide their own implementation of the serialization method, allowing the parent class to work with them without understanding their implementation details.
 


#### When to use:
 * A single abstract implementation of an algorithm is needed.
 * Common behavior among subclasses should be localized to a common class.
 * Parent classes should be able to uniformly invoke behavior in their subclasses.
 * Most or all subclasses need to implement the behavior.



#### Advantages & Disadvantages
 * Difficult to maintain over a long period of time
 * Our base classes tend to get cluttered up with a lot of seemingly unrelated code. 
 * Program flow is a little more difficult to follow - without the help of stepping through the code with a debugger