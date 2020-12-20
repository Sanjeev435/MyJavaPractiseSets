### The Iterator pattern allows for access to the elements of an aggregate object without allowing access to its underlying representation.


#### Implementation
 * Iterator: An interface to access or traverse the elements collection. Provide methods which concrete iterators must implement.
 * ConcreteIterator: implements the Iterator interface methods. It can also keep track of the current position in the traversal of the aggregate collection.
 * Aggregate: It is typically a collection interface which defines a method that can create an Iterator object.
 * ConcreteAggregate: It implements the Aggregate interface and its specific method returns an instance of ConcreteIterator.


#### Usage examples: 
The Java implementation of the iterator pattern allows users to traverse various types of data sets without worrying about the underlying implementation of the collection. Since clients simply interact with the iterator interface, collections are left to define the appropriate iterator for themselves. Some will allow full access to the underlying data set while others may restrict certain functionalities, such as removing items.


#### When to use:
 * Access to elements is needed without access to the entire representation.
 * Multiple or concurrent traversals of the elements are needed.
 * A uniform interface for traversal is needed.
 * Subtle differences exist between the implementation details of various iterators
 * Use the Iterator pattern when your collection has a complex data structure under the hood, but you want to hide its complexity from clients (either for convenience or security reasons).
	 * The iterator encapsulates the details of working with a complex data structure, providing the client with several simple methods of accessing the collection elements. While this approach is very convenient for the client, it also protects the collection from careless or malicious actions which the client would be able to perform if working with the collection directly.
 * Use the pattern to reduce duplication of the traversal code across your app.
	 * The code of non-trivial iteration algorithms tends to be very bulky. When placed within the business logic of an app, it may blur the responsibility of the original code and make it less maintainable. Moving the traversal code to designated iterators can help you make the code of the application more lean and clean.
 * Use the Iterator when you want your code to be able to traverse different data structures or when types of these structures are unknown beforehand.
	 * The pattern provides a couple of generic interfaces for both collections and iterators. Given that your code now uses these interfaces, it’ll still work if you pass it various kinds of collections and iterators that implement these interfaces.
 

#### Advantages & Disadvantages
 ✔ Single Responsibility Principle. You can clean up the client code and the collections by extracting bulky traversal algorithms into separate classes. <br/>
 ✔ Open/Closed Principle. You can implement new types of collections and iterators and pass them to existing code without breaking anything. <br/>
 ✔ You can iterate over the same collection in parallel because each iterator object contains its own iteration state. <br/>
 ✔ For the same reason, you can delay an iteration and continue it when needed. <br/>
 ✔ This pattern is useful when you want to provide a standard way to iterate over a collection and hide the implementation logic from client program. <br/>
 ✔ The logic for iteration is embedded in the collection itself and it helps client program to iterate over them easily. <br/>
 ❌ Applying the pattern can be an overkill if your app only works with simple collections. <br/>
 ❌ Using an iterator may be less efficient than going through elements of some specialized collections directly. <br/>


#### Relations with Other Patterns
 * We can use Iterators to traverse Composite trees.
 * We can use Factory Method along with Iterator to let collection subclasses return different types of iterators that are compatible with the collections.
 * We can use Memento along with Iterator to capture the current iteration state and roll it back if necessary.
 * We can use Visitor along with Iterator to traverse a complex data structure and execute some operation over its elements, even if they all have different classes.
