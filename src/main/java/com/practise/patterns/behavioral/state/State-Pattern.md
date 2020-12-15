### The State pattern ties object circumstances to its behavior, allowing the object to behave in different ways based upon its internal state. In other words, it lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.


#### Implementation
 * Define separate (state) objects that encapsulate state-specific behavior for each state. That is, define an interface (state) for performing state-specific behavior, and define classes that implement the interface for each state.
 * The State pattern does not specify where the state transitions will be defined. The choices are two: the “context” object, or each individual State derived class.
 	* State – The interface define operations which each state must handle.
 	* Concrete States – The classes which contain the state specific behavior.
 	* Context – Defines an interface to client to interact. It maintains references to concrete state object which may be used to define current state of object. It delegates state-specific behavior to different State objects.


#### Usage examples: 
 * To make things simple, let’s visualize a TV box operated with remote controller. We can change the state of TV by pressing buttons on remote. But the state of TV will change or not, it depends on the current state of the TV. If TV is ON, we can switch it OFF, mute or change aspects and source. But if TV is OFF, nothing will happen when we press remote buttons.
 * For a switched OFF TV. only possible next state can be switch ON.
 * State patterns are used to implement state machine implementations in complex applications.
 * Another example can be of Java thread states. A thread can be one of its five states during it’s life cycle. It’s next state can be determined only after getting it’s current state. e.g. we can not start a stopped thread or we cannot a make a thread wait, until it has started running.


#### When to use:
 * The behavior of an object should be influenced by its state.
 * Complex conditions tie object behavior to its state.
 * Transitions between states need to be explicit.
 * If we do not use the state pattern in such case, we will end up having lots of if-else statements which make the code base ugly, unnecessarily complex and hard to maintain. 
 * State pattern allows the objects to behave differently based on the current state, and we can define state-specific behaviors within different classes.


#### Advantages & Disadvantages
<pre> ✔ Single Responsibility Principle. Organize the code related to particular states into separate classes.</pre>
<pre> ✔ Open/Closed Principle. Introduce new states without changing existing state classes or the context.</pre>
 ✔ Simplify the code of the context by eliminating bulky state machine conditionals.
 ✔ Helps in reducing complexity by reducing the use of if-else statements or switch/case conditional logic.
 ✔ The benefits of using State pattern to implement polymorphic behavior is clearly visible.
 ✔ The chances of error are less and it’s very easy to add more states for additional behavior. Thus making our code more robust, easily maintainable and flexible
 ❌ Applying the pattern can be overkill if a state machine has only a few states or rarely changes.
 ❌ The state pattern is also known as objects for states. So, we can assume that more states need more codes, and the obvious side effect is difficult maintenance for us

