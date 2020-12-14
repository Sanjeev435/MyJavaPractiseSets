### Interpreter pattern defines a representation for a grammar as well as a mechanism to understand and act upon the grammar. It's used to manage algorithms, relationships and responsibilities between objects. Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.


#### Implementation
 * Create Interpreter context engine that will do the interpretation work.
 * Create different Expression implementations that will consume the functionalities provided by the interpreter context.
 * Create the client that will take the input from user and decide which Expression to use and then generate output for the user.


#### Usage examples: 
 * Text based adventures, wildly popular in the 1980's, provide a good example of this. Many had simple commands, such as "step down" that allowed traversal of the game. These commands could be nested such that it altered their meaning. For example, "go in" would result in a different outcome than "go up". By creating a hierarchy of commands based upon the command and the qualifier (non-terminal and terminal expressions) the application could easily map many command variations to a relating tree of actions.
 * SQL Parsing uses interpreter design pattern.
 * java.util.Pattern and subclasses of java.text.Format are some of the examples of interpreter pattern used in JDK.


#### When to use:
 * There is grammar to interpret that can be represented as large syntax trees.
 * The grammar is simple.
 * Efficiency is not important.
 * Decoupling grammar from underlying expressions is desired.


#### Advantages & Disadvantages
 * It is easier to change and extend the grammar.
 * Implementing the grammar is straightforward
 * Interpreter design pattern requires a lot of error checking and a lot of expressions and code to evaluate them. It gets complicated when the grammar becomes more complicated and hence hard to maintain and provide efficiency.
 * Efficiency is a big concern for any implementation of this pattern. Introducing your own grammar requires extensive error checking, which will be time consuming for the programmer to implement, and needs careful design in order to run efficiently at runtime. Also, as the grammar becomes more complicated, the maintainence effort is increased.
