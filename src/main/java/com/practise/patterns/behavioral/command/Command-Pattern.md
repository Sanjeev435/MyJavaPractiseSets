### This Pattern encapsulates a request allowing it to be treated as an object. This allows the request to be handled in traditionally object based relationships such as queuing and callbacks.It is useful to abstract business logic into discrete actions which we call commands. This command object helps in loose coupling between two classes where one class (invoker) shall call a method on other class (receiver) to perform a business operation.


#### Implementation
1. Handler : This can be an interface which will primarily recieve the request and dispatches the request to chain of handlers. It has reference of only first handler in the chain and does not know anything about rest of the handlers.
2. Concrete handlers : These are actual handlers of the request chained in some sequential order.
3. Client : Originator of request and this will access the handler to handle it.


#### Usage examples: 
 * Job queues are widely used to facilitate the asynchronous processing of algorithms. By utilizing the command pattern the functionality to be executed can be given to a job queue for processing without any need for the queue to have knowledge of the actual implementation it is invoking. The command object that is enqueued implements its particular algorithm within the confines of the interface the queue is expecting.
 * One example could be a bank, where an application that you send in to the bank branch may be handled by one particular department. Another example is a vending machine, where you can put in any coin, but the coin is passed on to the appropriate receptacle to determine the amount that the coin is worth. 


#### When to use:
 * You need callback functionality.
 * Requests need to be handled at variant times or in variant orders.
 * A history of requests is needed.
 * The invoker should be decoupled from the object handling the invocation.
 * Handling actions for Java menu items and buttons.
 * Providing support for macros (recording and playback of macros).
 * Providing "undo" support.
 * Progress bars implementations.
 * Creating multi-step wizards.

#### Advantages & Disadvantages
 * Command is the core of command design pattern that defines the contract for implementation.
 * Receiver implementation is separate from command implementation.
 * Command implementation classes chose the method to invoke on receiver object, for every method in receiver there will be a command implementation. It works as a bridge between receiver and action methods.
 * Increase loose-coupling between the invoker and the receiver using the command object.
 * Client is responsible to instantiate appropriate command and receiver implementation and then associate them together.
 * Client is also responsible for instantiating invoker object and associating command object with it and execute the action method.
 * Command design pattern is easily extendible, we can add new action methods in receivers and create new Command implementations without changing the client code.
 * The drawback with Command design pattern is that the code gets huge and confusing with high number of action methods and because of so many associations. This pattern ends up forcing a lot of Command classes that will make your design look cluttered - more operations being made possible leads to more command classes. Intelligence required of which Command to use and when leads to possible maintainence issues for the central controller