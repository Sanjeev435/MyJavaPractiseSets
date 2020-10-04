## --------------------------------------------------------------------------------------------------------
## ------------------------------------  **Creating and Destroying Objects** ------------------------------
## --------------------------------------------------------------------------------------------------------


### Consider a builder when faced with many constructor parameters.
## -----------------------------------------------------------------------------------------
* Abstract classes have abstract builders; concrete classes have concrete builders.

* The Builder pattern simulates named optional parameters.

* The Builder pattern is well suited to class hierarchies.

* Abstract builders can also be written for classes.

* The telescoping constructor pattern works, but it is hard to write client code when there are many parameters, 
  and harder still to read it.

* The Builder pattern is a good choice when designing classes whose constructors or static factories would have more 
  than a handful of parameters, especially if many of the parameters are optional or of identical type.
  

**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### Enforce the singleton property with a private constructor or an enum type.
## -----------------------------------------------------------------------------------------
* A singleton is simply a class that is instantiated exactly once.
  Singletons typically represent either a stateless object such as a function or a system component that is intrinsically 
  unique.

* Making a class a singleton can make it difficult to test its clients because it’s impossible to substitute a mock
  implementation for a singleton unless it implements an interface that serves as its type.

* A single-element enum type is often the best way to implement a singleton.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### Enforce noninstantiability with a private constructor.
## -----------------------------------------------------------------------------------------
* Do not use a singleton or static utility class to implement a class that depends on one or more underlying resources 
  whose behavior affects that of the class, and do not have the class create these resources directly. Instead, pass the 
  resources, or factories to create them, into the constructor (or static factory or builder). This practice, known as 
  dependency injection, will greatly enhance the flexibility, reusability, and testability of a class.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### Avoid creating unnecessary objects
## -----------------------------------------------------------------------------------------
* Reuse can be both faster and more stylish. An object can always be reused if it is immutable. For e.g: Strings

* We can often avoid creating unnecessary objects by using static factory methods in preference to constructors on 
  immutable classes that provide both.

* Try to create objects with literals instead of using new keyword.
  String s = "test"
  String s == new String("test"); // Not advisable where this will be called multiple times.

* While String.matches is the easiest way to check if a string matches a regular expression, it’s not suitable for 
  repeated use in performance-critical situations.
  The problem is that it internally creates a Pattern instance for the regular expression and uses it only once, after 
  which it becomes eligible for garbage collection. Creating a Pattern instance is expensive because it requires compiling 
  the regular expression into a finite state machine.
  To improve the performance, explicitly compile the regular expression into a Pattern instance (which is immutable) as part 
  of class initialization, cache it, and reuse the same instance for every invocation.

* Autoboxing blurs but does not erase the distinction between primitive and boxed primitive types.

* Always prefer primitives to boxed primitives, and watch out for unintentional autoboxing. For e.g: try to use int instead 
  Integer or use long instead Long. Boxed primitives(i.e: Integer, Long etc.) should only be used where it is really required.

* Don’t create a new object when you should reuse an existing one.
  Don’t reuse an existing object when you should create a new one.
  Note that the penalty for reusing an object when defensive copying is called for is far greater than the penalty for 
  needlessly creating a duplicate object. Failing to make defensive copies where required can lead to insidious bugs and 
  security holes; creating objects unnecessarily merely affects style and performance.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### Eliminate obsolete object references 
## -----------------------------------------------------------------------------------------

* Always derefrence object with null which are not required.
  Nulling out object references should be the exception rather than the norm.

* Whenever a class manages its own memory, the programmer should be alert for memory leaks. Whenever an element is freed, 
  any object references contained in the element should be nulled out.

* Another common source of memory leaks is caches. Use WeakHashMap for caches as the keys will be automattically garbage 
  collected.

* For more sophisticated caches, you may need to use java.lang.ref directly.

* A third common source of memory leaks is listeners and other callbacks.
  If you implement an API where clients register callbacks but don’t deregister them explicitly, they will accumulate unless 
  you take some action. One way to ensure that callbacks are garbage collected promptly is to store only weak references to 
  them, for instance, by storing them only as keys in a WeakHashMap.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### Avoid finalizers and cleaners 
## -----------------------------------------------------------------------------------------
* Finalizers are unpredictable, often dangerous, and generally unnecessary. Their use can cause erratic behavior, poor 
  performance, and portability problems.

* The Java 9 replacement for finalizers is cleaners. Cleaners are less dangerous than finalizers, but still unpredictable,
  slow, and generally unnecessary.
  A try-with-resources or try-finally block is used for this purpose.

* We should never do anything time-critical in a finalizer or cleaner.
  For example, it is a grave error to depend on a finalizer or cleaner to close files because open file descriptors are a 
  limited resource. If many files are left open as a result of the system’s tardiness in running finalizers or cleaners, 
  a program may fail because it can no longer open files.

* Cleaners are a bit better than finalizers in this regard because class authors have control over their own cleaner 
  threads, but cleaners still run in the background, under the control of the garbage collector, so there can be no 
  guarantee of prompt cleaning.

* It is entirely possible, even likely, that a program terminates without running them on some objects that are no longer 
  reachable. As a consequence, you should never depend on a finalizer or cleaner to update persistent state. 
  For example, depending on a finalizer or cleaner to release a persistent lock on a shared resource such as a database 
  is a good way to bring your entire distributed system to a grinding halt.

* Don’t be seduced by the methods System.gc and System.runFinalization. They may increase the odds of finalizers or 
  cleaners getting executed, but they don’t guarantee it.

* There is a severe performance penalty for using finalizers and cleaners. It may be 50 times slower more then try with 
  resource.

* Finalizers have a serious security problem: they open your class up to finalizer attacks.
  To protect nonfinal classes from finalizer attacks, write a final finalize method that does nothing.

* Throwing an exception from a constructor should be sufficient to prevent an object from coming into existence; in the
  presence of finalizers, it is not.

* They have perhaps two legitimate uses of cleaners and finalizers. 
  One is to act as a safety net in case the owner of a resource neglects to call its close method.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### Prefer try-with-resources to try-finally 
## -----------------------------------------------------------------------------------------
* To be usable with this construct, a resource must implement the AutoCloseable interface, which consists of a single 
  void-returning close method. Many classes and interfaces in the Java libraries and in third-party libraries now implement 
  or extend AutoCloseable. 
  If you write a class that represents a resource that must be closed, your class should implement AutoCloseable too.

* Always use try-with-resources in preference to tryfinally when working with resources that must be closed. 
  The resulting code is shorter and clearer, and the exceptions that it generates are more useful. 
  The trywith-resources statement makes it easy to write correct code using resources that must be closed, which was 
  practically impossible using try-finally.

