# Patterns Information
24 Gang of Four design patterns, as listed in the book Design Patterns: Elements of Reusable Object-Oriented Software. Each pattern includes class diagrams, explanation, usage information, and a real world example.

#### Creational Patterns: 
1. Used to construct objects such that they can be decoupled from their implementing system.
2. Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
3. Allows for object level access control by acting as a pass through entity or a placeholder object.
4. Define an interface for creating an object, but let the subclasses decide which class to instantiate. the factory method lets a class defer instantiation to subclasses 

#### Structural Patterns: 
1. Used to form large object structures between many disparate objects.
2. Convert the interface of a class into another interface clients expect. adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
3. Decouple an abstraction from its implementation so that the two can vary independently
4. Allows you to compose objects into tree structures to represent part-whole hierarchies. composite lets clients treat individual objects and compositions of objects uniformly.
5. Allows for the dynamic wrapping of objects in order to modify their existing responsibilities and behaviours
6. Provide a unified interface to a set of interfaces in a subsystem. façade defines a higher-level interface that makes the subsystem easier to use.
7. Facilitates the reuse of many fine grained objects, making the utilization of large numbers of objects more efficient.
8. Allows for object level access control by acting as a pass through entity or a placeholder object.


#### Behavioral Patterns: 
1. Used to manage algorithms, relationships, and responsibilities between objects.
2. Gives more than one object an opportunity to handle a request by linking receiving objects together.
3. Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations
4. Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
5. Provides a way to access the elements of an aggregate object without exposing its underlying representation.
6. Allows loose coupling by encapsulating the way disparate sets of objects interact and communicate with each other.  allows for the actions of each object set to vary independently of one another.
7. Captures and externalizes an object's internal state so that it can be restored later, all without violating encapsulation.
8. Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
9. Allows an object to alter its behavior when its internal state changes. the object will appear to change its class.
10. Defines a set of encapsulated algorithms that can be swapped to carry out a specific behavior
11. Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. template method lets subclasses redefine certain steps of an algorithm without changing the algorithms structure.
12. Allows for one or more operation to be applied to a set of objects at runtime, decoupling the operations from the object structure. 

#### Object Scope: 
Deals with object relationships that can be changed at runtime.

#### Class Scope: 
Deals with class relationships that can be changed at compile time.

#### Patterns with classification: 
|    Creational    | Structural |         Behavioral       |
|:----------------:|:----------:|:------------------------:|
| Abstract Factory |  Decorator |         Observer         |
|  Factory Method  |   Adapter  |  Chain Of Responsibility |
|     Prototype    |   Facade   |       Interpreter        |
|      Builder     |    Proxy   |          State           |
|     Singleton    |   Bridge   |         Command          |
|        -         |  Flyweight |         Mediator         |
|        -         |  Composite |     Template Method      |
|        -         |      -     |         Memento          |
|        -         |      -     |         Visitor          |
|        -         |      -     |        Iteretor          |
|        -         |      -     |        Strategy          |
