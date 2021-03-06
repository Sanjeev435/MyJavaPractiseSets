Problem :
------------------------------------------------------------------------

In today's modern world, everyone is using software to facilitate their jobs. Recently, a product company has shifted the way they used 
to take orders from their clients. The company is now looking to use an application to take orders from them. They receive orders, errors 
in orders, feedback for the previous order, and responses to the order in an XML format. The company has asked you to develop an application 
to parse the XML and display the result to them.

The main challenge for you is to parse an XML and display its content to the user. There are different XML formats depending on the different 
types of messages the company receives from its clients. Like, for example, an order type XML has different sets of xml tags as compared to 
the response or error XML. But the core job is the same; that is, to display to the user the message being carried in these XMLs.

Although the core job is the same, the object that would be used varies according to the kind of XML the application gets from the user. So, 
an application object may only know that it needs to access a class from within the class hierarchy (hierarchy of different parsers), but 
does not know exactly which class from among the set of subclasses of the parent class is to be selected.

In this case, it is better to provide a factory, i.e. a factory to create parsers, and at runtime a parser gets instantiated to do the job, 
according to the kind of XML the application receives from the user.

The Factory Method Pattern, suited for this situation, defines an interface for creating an object, but let subclasses decide which class to 
instantiate. Factory Method lets a class defer instantiation to subclasses.
________________________________________________________________________________________________________________________________________________

What is the Factory Pattern : 
---------------------------------------------------------------------------
It is a creational pattern i.e it creates object. The Factory Method Pattern gives us a way to encapsulate the instantiations of concrete types. 
The Factory Method pattern encapsulates the functionality required to select and instantiate an appropriate class, inside a designated method 
referred to as a factory method. The Factory Method selects an appropriate class from a class hierarchy based on the application context and 
other influencing factors. It then instantiates the selected class and returns it as an instance of the parent class type.

________________________________________________________________________________________________________________________________

Implementation of Factory Pattern :
---------------------------------------------------------------------------
The advantage of this approach is that the application objects can make use of the factory method to get access to the appropriate class 
instance. This eliminates the need for an application object to deal with the varying class selection criteria.

<b>Please refer to picture Factoryclass_diagram_1.jpg </b>

Product : Defines the interface of objects the factory method creates.
```
XmlParser.java
```

#### ConcreteProduct : Implements the Product interface.

```
ErrorXMLParser.java
FeedbackXML.java
OrderXMLParser.java
ResponseXMLParser.java
```

##### Creator :
Declares the factory method, which returns an object of type Product. 
Creator may also define a default implementation of the 
1. factory method that returns a default ConcreteProduct object.
2. May call the factory method to create a Product object.  
To display the parsed messages from the parsers, an abstract service class is created which will be extends by service specific, i.e. parser specific, display classes.
```
DisplayService.java
```
		  
ConcreteCreator : Overrides the factory method to return an instance of a ConcreteProduct.
Below are the subclasses of the DisplayService which implement the getParser method.
```
ErrorXMLDisplayService.java
FeedbackXMLDisplayService.java
OrderXMLDisplayService.java
ResponseXMLDisplayService.java
```

Factory methods eliminate the need to bind application-specific classes into your code. The code only deals with the Product interface; therefore
it can work with any user-defined ConcreteProduct classes.

________________________________________________________________________________________________________________________________

When to use Factory Method Pattern:
---------------------------------------------------------------------------
A class can't anticipate the class of objects it must create.
A class wants its subclasses to specify the objects it creates.
Classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.

________________________________________________________________________________________________________________________________

Factory Method Pattern in JDK
---------------------------------------------------------------------------
The following are the usage(s) of the Factory Method Pattern in JDK.
1. java.util.Calendar#getInstance()
2. java.util.ResourceBundle#getBundle()
3. java.text.NumberFormat#getInstance()
4. java.nio.charset.Charset#forName()
5. java.net.URLStreamHandlerFactory#createURLStreamHandler(String) (Returns singleton object per protocol)