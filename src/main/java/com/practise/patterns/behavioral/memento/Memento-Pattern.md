### The Memento pattern allows for capturing and externalizing an object's internal state so that it can be restored later, all without violating encapsulation. It let us save and restore the previous state of an object without revealing the details of its implementation.


#### Implementation
 * Originator – is the object that knows how to create and save it’s state for future. It provides methods createMemento() and restore(memento).
 * Caretaker – performs an operation on the Originator while having the possibility to rollback. It keeps track of multiple mementos. Caretaker class refers to the Originator class for saving (createMemento()) and restoring (restore(memento)) originator’s internal state.
 * Memento – the lock box that is written and read by the Originator, and shepherded by the Caretaker. In principle, a memento must be in immutable object so that no one can change it’s state once created.


#### Usage examples: 
 * Undo functionality can nicely be implemented using the memento pattern. By serializing and deserializing the state of an object before the change occurs we can preserve a snapshot of it that can later be restored should the user choose to undo the operation.
 * In a GUI editor (e.g. MS Paint), we can keep making changing to drawing and we can rollback the changes with simple commands like CTRL + Z.
 * In code editors, we can revert or apply any code change with simple commands to undo and redo.
 * In calculator applications, we can revisit all the calculations in memory with simple button press.
 * In programming, memento can be used to create checkpoints during database transactions. If any operation fails, we just rollback everything to last known stable database state.


#### Mediator Pattern Example in JDK
 * javax.swing.text.JTextComponent class provides an undo support mechanism.
 * javax.swing.undo.UndoManager can act as a caretaker, an implementation of javax.swing.undo.UndoableEdit can act like a memento, and an implementation of javax.swing.text.Document can act like an originator.


#### When to use:
 * The internal state of an object must be saved and restored at a later time.
 * Internal state cannot be exposed by interfaces without exposing implementation.
 * Encapsulation boundaries must be preserved.
 * Use the Memento pattern when you want to produce snapshots of the object’s state to be able to restore a previous state of the object.
	 * The Memento pattern lets you make full copies of an object’s state, including private fields, and store them separately from the object. While most people remember this pattern thanks to the “undo” use case, it’s also indispensable when dealing with transactions (i.e., if you need to roll back an operation on error).
  * Use the pattern when direct access to the object’s fields/getters/setters violates its encapsulation
	 * The Memento makes the object itself responsible for creating a snapshot of its state. No other object can read the snapshot, making the original object’s state data safe and secure.


#### Advantages & Disadvantages
 ✔ The biggest advantage is that you can always discard the unwanted changes and restore it to an intended or stable state. <br/>
 ✔ You do not compromise the encapsulation associated with the key objects that are participating in this model. <br/>
 ✔ Maintains high cohesion. <br/>
 ✔ Provides an easy recovery technique. <br/>
 ✔ You can produce snapshots of the object’s state without violating its encapsulation. <br/>
 ✔ You can simplify the originator’s code by letting the caretaker maintain the history of the originator’s state. <br/>
 ❌ The app might consume lots of RAM if clients create mementos too often. <br/>
 ❌ Caretakers should track the originator’s lifecycle to be able to destroy obsolete mementos. <br/>
 ❌ Most dynamic programming languages, such as PHP, Python and JavaScript, can’t guarantee that the state within the memento stays untouched. <br/>
 ❌ Some problems with this pattern is that the saving or restoring of state can be a time consuming process. Used incorrectly, it can expose the internal structure of your object, thus allowing any other object to change the state of your object. <br/>
 
 
#### Relations with Other Patterns
 * You can use Command and Memento together when implementing “undo”. In this case, commands are responsible for performing various operations over a target object, while mementos save the state of that object just before a command gets executed.
 * You can use Memento along with Iterator to capture the current iteration state and roll it back if necessary.
 * Sometimes Prototype can be a simpler alternative to Memento. This works if the object, the state of which you want to store in the history, is fairly straightforward and doesn’t have links to external resources, or the links are easy to re-establish.

