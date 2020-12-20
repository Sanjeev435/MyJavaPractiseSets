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


#### When to use:
 * The only difference between many related classes is their behavior.
 * Multiple versions or variations of an algorithm are required.
 * Algorithms access or utilize data that calling code shouldn't be exposed to.
 * The behavior of a class should be defined at runtime.
 * Conditional statements are complex and hard to maintain.
 * Used where you want to choose the algorithm to use at runtime. 
 * A good use would be saving files in different formats, running various sorting algorithms, or file compression. 
 * It provides a way to define a family of algorithms, encapsulate each one as an object, and make them interchangeable.
 * Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.
	 * The Strategy pattern lets you indirectly alter the object’s behavior at runtime by associating it with different sub-objects which can perform specific sub-tasks in different ways.
 * Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.
	 * The Strategy pattern lets you extract the varying behavior into a separate class hierarchy and combine the original classes into one, thereby reducing duplicate code.
 * Use the pattern to isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.
	 * The Strategy pattern lets you isolate the code, internal data, and dependencies of various algorithms from the rest of the code. Various clients get a simple interface to execute the algorithms and switch them at runtime.
 * Use the pattern when your class has a massive conditional operator that switches between different variants of the same algorithm.
	 * The Strategy pattern lets you do away with such a conditional by extracting all algorithms into separate classes, all of which implement the same interface. The original object delegates execution to one of these objects, instead of implementing all variants of the algorithm.


#### Advantages & Disadvantages
 ✔ You can swap algorithms used inside an object at runtime. <br/>
 ✔ You can isolate the implementation details of an algorithm from the code that uses it. <br/>
 ✔ You can replace inheritance with composition. <br/>
 ✔ Open/Closed Principle. You can introduce new strategies without having to change the context. <br/>
 ❌ If you only have a couple of algorithms and they rarely change, there’s no real reason to overcomplicate the program with new classes and interfaces that come along with the pattern. <br/>
 ❌ Clients must be aware of the differences between strategies to be able to select a proper one. <br/>
 ❌ A lot of modern programming languages have functional type support that lets you implement different versions of an algorithm inside a set of anonymous functions. Then you could use these functions exactly as you’d have used the strategy objects, but without bloating your code with extra classes and interfaces. <br/>
 
 
#### Relations with Other Patterns
 * Bridge, State, Strategy (and to some degree Adapter) have very similar structures. Indeed, all of these patterns are based on composition, which is delegating work to other objects. However, they all solve different problems. A pattern isn’t just a recipe for structuring your code in a specific way. It can also communicate to other developers the problem the pattern solves.
 * Command and Strategy may look similar because you can use both to parameterize an object with some action. However, they have very different intents.
	 * You can use Command to convert any operation into an object. The operation’s parameters become fields of that object. The conversion lets you defer execution of the operation, queue it, store the history of commands, send commands to remote services, etc.
	 * On the other hand, Strategy usually describes different ways of doing the same thing, letting you swap these algorithms within a single context class.
 * Decorator lets you change the skin of an object, while Strategy lets you change the guts.
 * Template Method is based on inheritance: it lets you alter parts of an algorithm by extending those parts in subclasses. Strategy is based on composition: you can alter parts of the object’s behavior by supplying it with different strategies that correspond to that behavior. Template Method works at the class level, so it’s static. Strategy works on the object level, letting you switch behaviors at runtime.
 * State can be considered as an extension of Strategy. Both patterns are based on composition: they change the behavior of the context by delegating some work to helper objects. Strategy makes these objects completely independent and unaware of each other. However, State doesn’t restrict dependencies between concrete states, letting them alter the state of the context at will.