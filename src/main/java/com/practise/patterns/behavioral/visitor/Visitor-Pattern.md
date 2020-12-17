### The Visitor pattern allows for one or more operations to be applied to a set of objects at runtime, decoupling the operations from the object structure.


#### Implementation
 * Visitor – This is an interface or an abstract class used to declare the visit operations for all the types of visitable classes.
 * ConcreteVisitor – For each type of visitor all the visit methods, declared in abstract visitor, must be implemented. Each Visitor will be responsible for different operations.
 * Visitable – is an interface which declares the accept operation. This is the entry point which enables an object to be “visited” by the visitor object.
 * ConcreteVisitable – Those classes implements the Visitable interface or class and defines the accept operation. The visitor object is passed to this object using the accept operation.


#### When to use:
 * An object structure must have many unrelated operations performed upon it.
 * The object structure can't change but operations performed on it can.
 * Operations must be performed on the concrete classes of an object structure.
 * Exposing internal state or operations of the object structure is acceptable.
 * Operations should be able to operate on multiple object structures that implement the same interface sets.
 * Use the Visitor when you need to perform an operation on all elements of a complex object structure (for example, an object tree).
	 * The Visitor pattern lets you execute an operation over a set of objects with different classes by having a visitor object implement several variants of the same operation, which correspond to all target classes.
 * Use the Visitor to clean up the business logic of auxiliary behaviors.
	 * The pattern lets you make the primary classes of your app more focused on their main jobs by extracting all other behaviors into a set of visitor classes.
 * Use the pattern when a behavior makes sense only in some classes of a class hierarchy, but not in others.
	 * You can extract this behavior into a separate visitor class and implement only those visiting methods that accept objects of relevant classes, leaving the rest empty.


#### Advantages & Disadvantages
 ✔ Open/Closed Principle. You can introduce a new behavior that can work with objects of different classes without changing these classes. <br/>
 ✔ Single Responsibility Principle. You can move multiple versions of the same behavior into the same class. <br/>
 ✔ A visitor object can accumulate some useful information while working with various objects. This might be handy when you want to traverse some complex object structure, such as an object tree, and apply the visitor to each object of this structure. <br/>
 ❌ You need to update all visitors each time a class gets added to or removed from the element hierarchy. <br/>
 ❌ Visitors might lack the necessary access to the private fields and methods of the elements that they’re supposed to work with. <br/>
 
 
#### Relations with Other Patterns
 * You can treat Visitor as a powerful version of the Command pattern. Its objects can execute operations over various objects of different classes.
 * You can use Visitor to execute an operation over an entire Composite tree.
 * You can use Visitor along with Iterator to traverse a complex data structure and execute some operation over its elements, even if they all have different classes.
