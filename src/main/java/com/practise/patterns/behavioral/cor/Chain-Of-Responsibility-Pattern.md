### Chain Of Responsibility pattern gives more than one object an opportunity to handle a request by linking receiving objects together. In other words, it avoids coupling the sender of the request to the receiver, giving more than one object the opportunity to handle the request.  This process of delegation appears quite frequently in the real world where there is one interface for the customer to go through.


#### Implementation
1. Handler : This can be an interface which will primarily recieve the request and dispatches the request to chain of handlers. It has reference of only first handler in the chain and does not know anything about rest of the handlers.
2. Concrete handlers : These are actual handlers of the request chained in some sequential order.
3. Client : Originator of request and this will access the handler to handle it.


#### Usage examples: 
 * Exception handling in some languages implements this pattern. When an exception is thrown in a method the runtime checks to see if the method has a mechanism to handle the exception or if it should be passed up the call stack. When passed up the call stack the process repeats until code to handle the exception is encountered or until there are no more parent objects to hand the request to.
 * One example could be a bank, where an application that you send in to the bank branch may be handled by one particular department. Another example is a vending machine, where you can put in any coin, but the coin is passed on to the appropriate receptacle to determine the amount that the coin is worth. 


#### When to use:
 * Multiple objects may handle a request and the handler doesn't have to be a specific object.
 * A set of objects should be able to handle a request with the handler determined at runtime.
 * A request not being handled is an acceptable potential outcome.


#### Advantages & Disadvantages
This pattern can make it difficult to follow through the logic of a particular path in the code at runtime. It's also important to note that there is the potential that the request could reach the end of the chain and not be handled at all.