
## ------------------------------------  **Methods Common to All Objects** ------------------------------

Although Object is a concrete class, it is designed primarily for extension. All of its nonfinal methods (equals, 
hashCode, toString, clone, and finalize) have explicit general contracts because they are designed to be overridden. 
It is the responsibility of any class overriding these methods to obey their general contracts; failure to do so 
will prevent other classes that depend on the contracts (such as HashMap and HashSet) from functioning properly in 
conjunction with the class.

### 1. Obey the general contract when overriding equals.

* The easiest way to avoid problems arises with overriding equals is not to override the equals method, in which case 
  each instance of the class is equal only to itself. It applies only in the below scenario :
  • Each instance of the class is inherently unique
  • There is no need for the class to provide a “logical equality” test.
  • A superclass has already overridden equals, and the superclass behavior is appropriate for its sub class. 
    For e.g: AbstractList, AbstractMap, AbstractSet
  • The class is private or package-private, and you are certain that its equals method will never be invoked.

* When we override the equals method, we must adhere to its general contract. Specifications are as below :
  The equals method implements an equivalence relation. It has these properties:
  • Reflexive: For any non-null reference value x, x.equals(x) must return true.
    If you were to violate it and then add an instance of your class to a collection, the contains method might well 
    say that the collection didn’t contain the instance that you just added.
  • Symmetric: For any non-null reference values x and y, x.equals(y) must return true if and only if y.equals(x) 
    returns true.
  • Transitive: For any non-null reference values x, y, z, if x.equals(y) returns true and y.equals(z) returns true, 
    then x.equals(z) must return true.
  • Consistent: For any non-null reference values x and y, multiple invocations of x.equals(y) must consistently 
    return true or consistently return false, provided no information used in equals comparisons is modified.
    Whether or not a class is immutable, do not write an equals method that depends on unreliable resources.
    For e.g: IP may not be same over a period of time for same url.
  • For any non-null reference value x, x.equals(null) must return false.

* Below are techniques which can be used to create a high-quality equals method.
  • Use the == operator to check if the argument is a reference to this object.
  • Use the instanceof operator to check if the argument has the correct type.
  • Cast the argument to the correct type.
  • For each “significant” field in the class, check if that field of the argument matches the corresponding field 
    of this object
  • For primitive fields whose type is not float or double, use the == operator for comparisons;
    for float fields, use the static Float.compare(float, float) method; 
    for double fields, use Double.compare(double, double).
  • The special treatment of float and double fields is made necessary by the existence of Float.NaN, -0.0f and the 
    analogous double values.
  • Always override hashCode when you override equals
  • Don’t substitute another type for Object in the equals declaration. It should always override 
    public boolean equals(Object obj) method and the parameter should always be of Object class.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 2. Always override hashCode when you override equals.

* Failing to do so will badly impact collections such as HashMap and HashSet from functioning properly.

* Equal objects must have equal hash codes.

* Always remember, if two objects are equal then they will have same hash code but if two objects have same hash code 
  then it may or may not be equal.

* HashMap always first check the bucket position with HashCode, once it finds the bucket then it implies equals method 
  to find the correct object.

* A good hash function tends to produce unequal hash codes for unequal instances.

* Steps for making good HashCode :
  • Take all the variables into account which were used in equals method.
  • Take an int variable with odd number and decalre as result. 
  • Always choose odd prime number for first initialization.If we choose even and the multiplication overflowed, information 
    would be lost, because multiplication by 2 is equivalent to shifting.
  • If the field is of a primitive type, compute Type.hashCode(f), where Type is the boxed primitive class corresponding to 
    f’s type. For e.g: Short.hashCode(var)
  • If the value feild is null, use 0.
  • f the field is an object reference and this class’s equals method compares the field by recursively invoking equals, 
    recursively invoke hashCode on the field.
  • If the field is an array, treat it as if each significant element were a separate field. That is, compute a hash code 
    for each significant element by applying these rules recursively, and combine the values.If all elements are significant, 
    use Arrays.hashCode
  • Do not be tempted to exclude significant fields from the hash code computation to improve performance..
  • Typical example for hashCode method
     @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
     }

* If we have a need for very good hashCode, we can also check api provided by Guava’s com.google.common.hash.Hashing [Guava].

* Dont use Objects.hash(object) function as it have performance issue. Only use if performance can be neglected.

* If a class is immutable and the cost of computing the hash code is significant, we might consider caching the hash code 
  in the object rather than recalculating it each time it is requested. 

* If we believe that most objects of this type will be used as hash keys, then we should calculate the hash code when the 
  instance is created.

* We also can choose to lazily initialize the hash code the first time hashCode is invoked. But beware to do so only for 
  thread-safe classes.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 3. Always override toString.

* The toString contract goes on to say, “It is recommended that all subclasses override this method.”
* Providing a good toString implementation makes our class much more pleasant to use and makes systems using the class 
  easier to debug.
* When practical, the toString method should return all of the interesting information contained in the object.
* Whether or not we decide to specify the format returned in toString, we should clearly document our intentions.
* We should write a toString method in any abstract class whose subclasses share a common string representation.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 4. Override clone judiciously

* The purpose of Cloneable interface, given that it contains no methods is very intersting. It determines the behavior 
  of Object’s protected clone implementation: if a class implements Cloneable, Object’s clone method returns a 
  field-by-field copy of the object; otherwise it throws CloneNotSupportedException.

* In practice, a class implementing Cloneable is expected to provide a properly functioning public clone method.

* Immutable classes should never provide a clone method because it would merely encourage wasteful copying.

* In effect, the clone method functions as a constructor; you must ensure that it does no harm to the original object 
  and that it properly establishes invariants on the clone.

* A better approach to object copying is to provide a copy constructor or copy factory.


**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 4. Consider implementing Comparable

* It is the sole method in the Comparable interface. It is similar in character to Object’s equals method, except that 
  it permits order comparisons in addition to simple equality comparisons, and it is generic.

* Compares this object with the specified object for order. Returns a negative integer, zero, or a positive integer as 
  this object is less than, equal to, or greater than the specified object. Throws ClassCastException if the specified 
  object’s type prevents it from being compared to this object

* The notation sgn(expression) designates the mathematical signum function, which is defined to return -1, 0, or 1, 
  according to whether the value of expression is negative, zero, or positive.
  • The implementor must ensure that sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y. (This implies that 
    x.compareTo(y) must throw an exception if and only if y.compareTo(x) throws an exception.)
  • The implementor must also ensure that the relation is transitive: (x.compareTo(y) > 0 && y.compareTo(z) > 0) implies 
    x.compareTo(z) > 0.
  • Finally, the implementor must ensure that x.compareTo(y) == 0 implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)), 
    for all z.
  • It is strongly recommended, but not required, that (x.compareTo(y) == 0) == (x.equals(y)).
    For. e.g: BigDecimal class, whose compareTo method is inconsistent with equals.

* To compare object reference fields, invoke the compareTo method recursively. If a field does not implement Comparable 
  or you need a nonstandard ordering, use a Comparator instead.

* Use of the relational operators < and > in compareTo methods is verbose and error-prone and no longer recommended.

* Comparator interface was outfitted with a set of comparator construction methods, which enable fluent construction of 
  comparators. These comparators can then be used to implement a compareTo method, as required by the Comparable interface.

* In Java 7, static compare methods were added to all of Java’s boxed primitive classes.