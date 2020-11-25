### The Prototype pattern is generally used when we have an instance of the class (prototype) and we'd like to create new objects by just copying the prototype.

Let's use an analogy to better understand this pattern.

In some games, we want trees or buildings in the background. We may realize that we don't have to create new trees or buildings and render them on the screen every time the character moves.

So, we create an instance of the tree first. Then we can create as many trees as we want from this instance (prototype) and update their positions. We may also choose to change the color of the trees for a new level in the game.

The Prototype pattern is quite similar. Instead of creating new objects, we just have to clone the prototypical instance.


#### Implementation

The pattern is quite simple: the Prototype interface declares a method for cloning itself, while the ConcretePrototype implements the operation for cloning itself.

One of the ways we can implement this pattern in Java is by using the clone() method. To do this, we'd implement the Cloneable interface.
When we're trying to clone, we should decide between making a shallow or a deep copy. Eventually, it boils down to the requirements.

For example, if the class contains only primitive and immutable fields, we may use a shallow copy.
If it contains references to mutable fields, we should go for a deep copy. We might do that with copy constructors or serialization and deserialization.

#### Usage examples: 
The Prototype pattern is available in Java out of the box with a Cloneable interface.
Any class can implement this interface to become cloneable.

	```
    java.lang.Object#clone() (class should implement the java.lang.Cloneable interface)
	```

#### Identification: 
The prototype can be easily recognized by a clone or copy methods, etc.

#### When to use:

The Prototype pattern should be considered when

    Composition, creation and representation of objects should be decoupled from the system.
    Classes to be created are specified at runtime.
    You need to hide the complexity of creating new instance from the client.
    Creating an object is an expensive operation and it would be more efficient to copy an object.
    Objects are required that are similar to existing objects. 

#### Advantages & Disadvantages
This pattern is handy when our new object is only slightly different from our existing one. In some cases, instances may have only a few combinations of state in a class. So instead of creating new instances, we may create the instances with the appropriate state beforehand and then clone them whenever we want.

Sometimes, we might encounter subclasses that differ only in their state. We can eliminate those subclasses by creating prototypes with the initial state and then cloning them.

Prototype pattern, just like every other design pattern, should be used only when it's appropriate. Since we are cloning the objects, the process could get complex when there are many classes, thereby resulting in a mess. Additionally, it's difficult to clone classes that have circular references.