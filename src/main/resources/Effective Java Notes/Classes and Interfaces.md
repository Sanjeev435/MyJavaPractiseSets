
## ------------------------------------  **Classes and Interfaces** ------------------------------


### 1. Minimize the accessibility of classes and members.

* The single most important factor that distinguishes a well-designed component from a poorly designed one is the 
  degree to which the component hides its internal data and other implementation details from other components. 
  A well-designed component hides all its implementation details, cleanly separating its API from its implementation. 
  Components then communicate only through their APIs and are oblivious to each others’ inner workings. This concept, 
  known as information hiding or encapsulation.

* Make each class or member as inaccessible as possible

* For members (fields, methods, nested classes, and nested interfaces), there are four possible access levels, listed 
  here in order of increasing accessibility:
  • Private—The member is accessible only from the top-level class where it is declared.
  • Package-private—The member is accessible from any class in the package where it is declared. Technically known as 
    default access, this is the access level you get if no access modifier is specified (except for interface members,
    which are public by default).
  • Protected—The member is accessible from subclasses of the class where it is declared and from any class in the
    package where it is declared.
  • Public—The member is accessible from anywhere.

* There is a key rule that restricts your ability to reduce the accessibility of methods. If a method overrides a 
  superclass method, it cannot have a more restrictive access level in the subclass than in the superclass.

* A special case of this rule is that if a class implements an interface, all of the class methods that are in the 
  interface must be declared public in the class.

* Instance fields of public classes should rarely be public.

* Classes with public mutable fields are not generally thread-safe.

* Note that a nonzero-length array is always mutable, so it is wrong for a class to have a public static final array 
  field, or an accessor that returns such a field.

* We can make the public array private and add a public immutable list:
  ``` 
  private static final Thing[] PRIVATE_VALUES = { ... };
    public static final List<Thing> VALUES =
           Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
  ```

* With the exception of public static final fields, which serve as constants, public classes should have no public 
  fields. Ensure that objects referenced by public static final fields are immutable.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 2. In public classes, use accessor methods, not public fields.

* Classes with public accessor should always be replaced by classes with private fields and public accessor methods 
  (getters) and, for mutable classes, mutators (setters).

* If a class is accessible outside its package, provide accessor methods.

* If a class is package-private or is a private nested class, there is nothing inherently wrong with exposing its 
  data fields.

* Public classes should never expose mutable fields. It is less harmful, though still questionable, for public 
  classes to expose immutable fields. It is, however, sometimes desirable for package-private or private nested 
  classes to expose fields, whether mutable or immutable.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 3. Minimize mutability

* To make a class immutable, follow these five rules:
  • Don’t provide methods that modify the object’s state (known as mutators).
  • Ensure that the class can’t be extended.
  • Make all fields final.
  • Make all fields private
  • Ensure exclusive access to any mutable components. 
    If our class has any fields that refer to mutable objects, ensure that clients of the class cannot obtain 
    references to these objects. Never initialize such a field to a client-provided object reference or return 
    the field from an accessor. Make defensive copies in constructors, accessors, and readObject methods.

* A pattern is known as the functional approach when methods return the result of applying a function to their 
  operand, without modifying it. Means the function will return the data without altering the class instance.

* The functional approach may appear unnatural if you’re not familiar with it, but it enables immutability, which 
  has many advantages.

* An immutable object can be in exactly one state, the state in which it was created.

* Immutable objects are inherently thread-safe; they require no synchronization.

* Since no thread can ever observe any effect of another thread on an immutable object, immutable objects can be 
  shared freely.

* Opting for static factories in place of public constructors when designing a new class gives you the flexibility 
  to add caching later, without modifying clients.

* A consequence of the fact that immutable objects can be shared freely is that we never have to make defensive 
  copies of them.

* We need not and should not provide a clone method or copy constructor on an immutable class. This was not well 
  understood in the early days of the Java platform, so the String class does have a copy constructor, but it should 
  rarely, if ever, be used.

* Not only can you share immutable objects, but they can share their internals.

* Immutable objects make great building blocks for other objects, whether mutable or immutable.

* Immutable objects provide failure atomicity for free. Their state never changes, so there is no 
  possibility of a temporary inconsistency.

* The major disadvantage of immutable classes is that they require a separate object for each distinct value.

* A Design alternative is instead of making an immutable class final, we can make all of its constructors private or 
  package-private and add public static factories in place of the public constructors. It is the most flexible because 
  it allows the use of multiple package-private implementation classes. To its clients that reside outside its package, 
  the immutable class is effectively final because it is impossible to extend a class that comes from another package 
  and that lacks a public or protected constructor. Besides allowing the flexibility of multiple implementation classes, 
  this approach makes it possible to tune the performance of the class in subsequent releases by improving the 
  object-caching capabilities of the static factories.

* The list of rules for immutable classes at the beginning of this item says that no methods may modify the object and 
  that all its fields must be final. In fact these rules are a bit stronger than necessary and can be relaxed to improve 
  performance.
  In truth, no method may produce an externally visible change in the object’s state. However, some immutable classes 
  have one or more non-final fields in which they cache the results of expensive computations the first time they are 
  needed. If the same value is requested again, the cached value is returned, saving the cost of recalculation. This 
  trick works precisely because the object is immutable, which guarantees that the computation would yield the same 
  result if it were repeated.

* If we choose to have our immutable class implement Serializable and it contains one or more fields that refer to 
  mutable objects, we must provide an explicit readObject or readResolve method, or use the 
  ObjectOutputStream.writeUnshared and ObjectInputStream.readUnshared methods, even if the default serialized form is 
  acceptable. Otherwise an attacker could create a mutable instance of your class.

* Resist the urge to write a setter for every getter. Classes should be immutable unless there’s a very good reason to 
  make them mutable.

* We should provide a public mutable companion class for your immutable class only once you’ve confirmed that it’s 
  necessary to achieve satisfactory performance.

* There are some classes for which immutability is impractical. If a class cannot be made immutable, limit its mutability 
  as much as possible.

* Declare every field private final unless there’s a good reason to do otherwise.

* Constructors should create fully initialized objects with all of their invariants established. Don’t provide a public 
  initialization method separate from the constructor or static factory unless there is a compelling reason to do so. 
  Similarly, don’t provide a “reinitialize” method that enables an object to be reused as if it had been constructed with 
  a different initial state. Such methods generally provide little if any performance benefit at the expense of increased complexity


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 4. Favor composition over inheritance

* It is safe to use inheritance within a package, where the subclass and the superclass implementations are under the 
  control of the same programmers. It is also safe to use inheritance when extending classes specifically designed and 
  documented for extension. Inheriting from ordinary concrete classes across package boundaries, however, is dangerous.

* Unlike method invocation, inheritance violates encapsulation.

* Instead of extending an existing class, give our new class a private field that references an instance of the existing 
  class. This design is called composition because the existing class becomes a component of the new one. Each instance 
  method in the new class invokes the corresponding method on the contained instance of the existing class and returns 
  the results. This is known as forwarding, and the methods in the new class are known as forwarding methods. The 
  resulting class will be rock solid, with no dependencies on the implementation details of the existing class.

* Inheritance is appropriate only in circumstances where the subclass really is a subtype of the superclass. In other 
  words, a class B should extend a class A only if an “is-a” relationship exists between the two classes. If we are 
  tempted to have a class B extend a class A, ask ourself the question: Is every B really an A? If we cannot truthfully 
  answer yes to this question, B should not extend A. If the answer is no, it is often the case that B should contain a 
  private instance of A and expose a different API: A is not an essential part of B, merely a detail of its implementation.

* If we use inheritance where composition is appropriate, we needlessly expose implementation details. The resulting API 
  ties us to the original implementation, forever limiting the performance of our class. More seriously, by exposing the 
  internals we let clients access them directly. At the very least, it can lead to confusing semantics.

* There is one last set of questions we should ask ourself before deciding to use inheritance in place of composition. 
  Does the class that we contemplate extending have any flaws in its API? If so, are we comfortable propagating those 
  flaws into our class’s API? Inheritance propagates any flaws in the superclass’s API, while composition lets us design 
  a new API that hides these flaws.

* Inheritance is powerful, but it is problematic because it violates encapsulation. It is appropriate only when a genuine 
  subtype relationship exists between the subclass and the superclass. Even then, inheritance may lead to fragility if the subclass is in a different package from the superclass and the superclass is not designed for inheritance. To avoid this fragility, use composition and forwarding instead of inheritance, especially if an appropriate interface to implement a 
  wrapper class exists. 
  Not only are wrapper classes more robust than subclasses, they are also more powerful.



**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 5. Design and document for inheritance or else prohibit it

* The class must document precisely the effects of overriding any method. In other words, the class must document its 
  self-use of overridable methods. For each public or protected method, the documentation must indicate which overridable 
  methods the method invokes, in what sequence, and how the results of each invocation affect subsequent processing.

* The @implSpec tag was added in Java 8 and used heavily in Java 9. This tag should be enabled by default, but as of Java 9, 
  the Javadoc utility still ignores it unless we pass the command line switch -tag "apiNote:a:API Note:".

* The only way to test a class designed for inheritance is to write subclasses.

* Constructors must not invoke overridable methods, directly or indirectly

* It is safe to invoke private methods, final methods, and static methods, none of which are overridable, from a constructor.

* The Cloneable and Serializable interfaces present special difficulties when designing for inheritance. It is generally not 
  a good idea for a class designed for inheritance to implement either of these interfaces because they place a substantial
  burden on programmers who extend the class.

* if we decide to implement Serializable in a class designed for inheritance and the class has a readResolve or writeReplace 
  method, we must make the readResolve or writeReplace method protected rather than private. If these methods are private, 
  they will be silently ignored by subclasses. This is one more case where an implementation detail becomes part of a 
  class’s API to permit inheritance.

* Designing a class for inheritance requires great effort and places substantial limitations on the class.

* Prohibit subclassing in classes that are not designed and documented to be safely subclassed.

* There are two ways to prohibit subclassing. The easier of the two is to declare the class final. The alternative is to 
  make all the constructors private or package-private and to add public static factories in place of the constructors.

* Unless we know there is a real need for subclasses, we are probably better off prohibiting inheritance by declaring
  our class final or ensuring that there are no accessible constructors.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 6. Prefer interfaces to abstract classes

* Existing classes can easily be retrofitted to implement a new interface.

* Many existing classes were retrofitted to implement the Comparable, Iterable, and Autocloseable interfaces when they 
  were added to the platform. Existing classes cannot, in general, be retrofitted to extend a new abstract class. If we 
  want to have two classes extend the same abstract class, we have to place it high up in the type hierarchy where it is 
  an ancestor of both classes. Unfortunately, this can cause great collateral damage to the type hierarchy, forcing all 
  descendants of the new abstract class to subclass it, whether or not it is appropriate.

* Interfaces are ideal for defining mixins. Loosely speaking, a mixin is a type that a class can implement in addition to 
  its “primary type,” to declare that it provides some optional behavior. For example, Comparable is a mixin interface 
  that allows a class to declare that its instances are ordered with respect to other mutually comparable objects. Such 
  an interface is called a mixin because it allows the optional functionality to be “mixed in” to the type’s primary 
  functionality.

* Interfaces allow for the construction of nonhierarchical type frameworks.

* Interfaces enable safe, powerful functionality enhancements via the wrapper class idiom.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 7. Design interfaces for posterity

* It is not always possible to write a default method that maintains all invariants of every conceivable implementation.

* In the presence of default methods, existing implementations of an interface may compile without error or warning but 
  fail at runtime.

* It is also worth noting that default methods were not designed to support removing methods from interfaces or changing 
  the signatures of existing methods. Neither of these interface changes is possible without breaking existing clients.

* Even though default methods are now a part of the Java platform, it is still of the utmost importance to design 
  interfaces with great care. While default methods make it possible to add methods to existing interfaces, there is great 
  risk in doing so. If an interface contains a minor flaw, it may irritate its users forever; if an interface is severely deficient, it may doom the API that contains it.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 8. Use interfaces only to define types

* The constant interface pattern is a poor use of interfaces

* Constant interface antipattern - do not use

* Tagged classes are verbose, error-prone, and inefficient.

* Luckily, object-oriented languages such as Java offer a far better alternative for defining a single data type capable 
  of representing objects of multiple flavors: subtyping. A tagged class is just a pallid imitation of a class hierarchy.

* Tagged classes are seldom appropriate. If we’re tempted to write a class with an explicit tag field, think about whether 
  the tag could be eliminated and the class replaced by a hierarchy. When we encounter an existing class with a tag field, 
  consider refactoring it into a hierarchy.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 9. Favor static member classes over nonstatic

* A nested class is a class defined within another class. A nested class should exist only to serve its enclosing class. If 
 a nested class would be useful in some other context, then it should be a top-level class.

* There are four kinds of nested classes:
  • Static member classes 
  • Non-static member classes  
  • Anonymous classes
  • Local classes. 
 All but the first kind are known as inner classes

* A static member class is the simplest kind of nested class. It is best thought of as an ordinary class that happens to 
  be declared inside another class and has access to all of the enclosing class’s members, even those declared private. A 
  static member class is a static member of its enclosing class and obeys the same accessibility rules as other static 
  members. If it is declared private, it is accessible only within the enclosing class, and so forth.

* One common use of a static member class is as a public helper class, useful only in conjunction with its outer class.

* Syntactically, the only difference between static and nonstatic member classes is that static member classes have the 
  modifier static in their declarations.

* Static nested class object can be made directly i.e for e.x:
  Outer.Inner inner =  new Outer.Inner()

* Non-static nested class object can only be made using object of outer class.
  i.e. e.g: Outer.Inner inner = new Outer().new Inner()

* We can’t perform instanceof tests or do anything else that requires us to name the class of anonymous classes.

* We can’t declare an anonymous class to implement multiple interfaces or to extend a class and implement an interface at 
  the same time.

* A local class can be declared practically anywhere a local variable can be declared and obeys the same scoping rules.

* If a nested class needs to be visible outside of a single method or is too long to fit comfortably inside a method, use 
  a member class.

* If each instance of a member class needs a reference to its enclosing instance, make it nonstatic; otherwise, make it 
  static. 

* Assuming the class belongs inside a method, if we need to create instances from only one location and there is a 
  preexisting type that characterizes the class, make it an anonymous class; otherwise, make it a local class.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 10. Limit source files to a single top-level class

* Never put multiple top-level classes or interfaces in a single source file