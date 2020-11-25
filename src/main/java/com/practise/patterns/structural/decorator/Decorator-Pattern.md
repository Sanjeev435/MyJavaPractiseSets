### Purpose:
  • Allows for the dynamic wrapping of objects in order to modify their existing responsibilities and behaviors.
  • This design pattern uses abstract classes or interfaces with the composition to implement the wrapper.
  • Decorator design patterns are most often used for applying single responsibility principles since we divide the functionality 	into classes with unique areas of concern.
  • The decorator design pattern is structurally similar to the chain of responsibility pattern.

#### Use When 
  • Object responsibilities and behaviors should be dynamically modifiable.
  • Concrete implementations should be decoupled from responsibilities and behaviors.
  • Subclassing to achieve modification is impractical or impossible.
  • Specific functionality should not reside high in the object hierarchy.
  • A lot of little objects surrounding a concrete implementation is acceptable.

  
#### Advantages & Disadvantages
Overuse of the Open/Closed principle can lead to abstract and complex code. This principle should really only be used in places where code is least likely to change.

The Design Patterns book does point out a couple of disadvantages with this pattern. Decorators can lead to a system with a lot of smaller objects that will look similar to a developer and introduce a maintenance headache. Also, the Decorator and it's enclosed components are not identical, so tests for object type (instanceof) will fail.