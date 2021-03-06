### Facilitates the reuse of many fine grained objects, making the utilization of large numbers of objects more efficient.


#### Important information
 * It is a Structural Design Pattern and one of the Gang of Four design patterns. 
 * It is used to minimize the memory usage by sharing as much data as possible with other similar objects.
 * It provides a way to reduce the number of objects created and to decrease memory footprint and increase performance.
 * It tries to reuse already existing similar kind objects by storing them in a collection which act like a cache and creates new object when no matching object is found.
 * The Flyweight objects we create as immutable. This means that they cannot be modified once they have been constructed. Making flyweight objects as immutable helps while sharing them with other objects. 
 * The data structures for graphical representation of characters in a Word Processor is a very good classical example of Flyweight pattern.
 * The String Interning is another very good example of Flyweight pattern.
 * It helps us avoiding having large number of objects and allow us to effectively used the created objects by reusing them as much as possible.
 * The Flyweight object essentially has two different kind of attributes – 
   * Intrinsic - An intrinsic (invariant) state attribute is stored and shared in the flyweight object. It is independent of flyweight’s context. So, as the best practice we should make intrinsic states immutable.
   * Extrinsic - An extrinsic (variant) state attribute does not store and share in the flyweight object because it depends on flyweight’s context and varies as context change. Generally, we store and maintain the extrinsic state in the Client objects. We need to pass this extrinsic state to the flyweight object for object creation and processing.


#### When to use:
 * Many similar objects are used and storage cost is high.
 * The majority of each object's state can be made extrinsic.
 * A few shared objects can replace many unshared ones.
 * The identity of each object does not matter.
 
 
#### Effect of concurrency on flyweights

Similar to singleton pattern, if we create flyweight objects in concurrent environment, we may end up having multiple instances of same flyweight object which is not desirable.
To fix this, we need to use double checked locking as used in singleton pattern while creating flyweights.


#### Advantages & Disadvantages
 * Reduce memory consumption of heavy objects that can be controlled identically.
 * Reduce the total number of “complete but similar objects” in the system.
 * Provide a centralized mechanism to control the states of many “virtual” objects.
 * We need to take the time to configure these flyweights. The design time and skills can be overhead, initially.
 * To create flyweights, we extract a common template class from the existing objects. This additional layer of programming can be tricky and sometimes hard to debug and maintain.
 * The flyweight pattern is often combined with singleton factory implementation and to guard the singularity, additional cost is required.
 * One of the drawbacks of this pattern is that all instances of the class are related, so single instances of the class will not be able to behave independently from other instances.
