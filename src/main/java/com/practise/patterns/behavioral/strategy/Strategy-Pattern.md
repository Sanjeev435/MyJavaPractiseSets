### The Strategy pattern defines a set of encapsulated algorithms that can be swapped to carry out a specific behavior.


#### Implementation
 * ISocialMediaStrategy – The interface which abstract the operation.
 * SocialMediaContext – The context which determines the implementation.
 * Implementations – Various implementations of ISocialMediaStrategy. E.g. FacebookStrategy, GooglePlusStrategy and TwitterStrategy.

#### Usage examples: 
 * Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to  * switch from one algorithm to another during runtime.
	 * The Strategy pattern lets you indirectly alter the object’s behavior at runtime by associating it with different sub-objects which can perform specific sub-tasks in different ways.
 * Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.
	 * The Strategy pattern lets you extract the varying behavior into a separate class hierarchy and combine the original classes into one, thereby reducing duplicate code.
 * Use the pattern to isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.
	 * The Strategy pattern lets you isolate the code, internal data, and dependencies of various algorithms from the rest of the code. Various clients get a simple interface to execute the algorithms and switch them at runtime.
 * Use the pattern when your class has a massive conditional operator that switches between different variants of the same algorithm.
	 * The Strategy pattern lets you do away with such a conditional by extracting all algorithms into separate classes, all of which implement the same interface. The original object delegates execution to one of these objects, instead of implementing all variants of the algorithm.


#### Mediator Pattern Example in JDK
 * javax.swing.text.JTextComponent class provides an undo support mechanism.
 * javax.swing.undo.UndoManager can act as a caretaker, an implementation of javax.swing.undo.UndoableEdit can act like a memento, and an implementation of javax.swing.text.Document can act like an originator.


#### When to use:
 * The only difference between many related classes is their behavior.
 * Multiple versions or variations of an algorithm are required.
 * Algorithms access or utilize data that calling code shouldn't be exposed to.
 * The behavior of a class should be defined at runtime.
 * Conditional statements are complex and hard to maintain.
 


#### Advantages & Disadvantages
 ✔ You can swap algorithms used inside an object at runtime. <br/>
 ✔ You can isolate the implementation details of an algorithm from the code that uses it. <br/>
 ✔ You can replace inheritance with composition. <br/>
 ✔ Open/Closed Principle. You can introduce new strategies without having to change the context. <br/>
 ❌ If you only have a couple of algorithms and they rarely change, there’s no real reason to overcomplicate the program with new classes and interfaces that come along with the pattern. <br/>
 ❌ Clients must be aware of the differences between strategies to be able to select a proper one. <br/>
 ❌ A lot of modern programming languages have functional type support that lets you implement different versions of an algorithm inside a set of anonymous functions. Then you could use these functions exactly as you’d have used the strategy objects, but without bloating your code with extra classes and interfaces. <br/>
 
 
#### Relations with Other Patterns
 * You can use Command and Memento together when implementing “undo”. In this case, commands are responsible for performing various operations over a target object, while mementos save the state of that object just before a command gets executed.
 * You can use Memento along with Iterator to capture the current iteration state and roll it back if necessary.
 * Sometimes Prototype can be a simpler alternative to Memento. This works if the object, the state of which you want to store in the history, is fairly straightforward and doesn’t have links to external resources, or the links are easy to re-establish.

