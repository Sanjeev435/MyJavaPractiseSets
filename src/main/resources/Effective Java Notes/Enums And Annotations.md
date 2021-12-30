## Enums And Annotations:

### 1. Use enums instead of int constants :
* Old way to decalre a static final int constant is known as <i>enum pattern</i>
* It provides nothing in the way of type safety and little in the way of expressive power. The compiler won’t complain if you pass an apple to a method that expects an orange, compare apples to oranges with the == operator.
* Programs that use int enums are brittle. Because int enums are constant variables, their int values are compiled into the clients that use them. If the value associated with an int enum is changed, its clients must be recompiled.
* There is no easy way to translate int enum constants into printable strings.
* Enum types are effectively final, by virtue of having no accessible constructors.
* Enums provide compile-time type safety. If you declare a parameter to be of type Apple, you are guaranteed that any non-null object reference passed to the parameter is one of the three valid Apple values.
* We can add or reorder constants in an enum type without recompiling its clients because the fields that export the constants provide a layer of insulation between an enum type and its clients: constant values are not compiled into the clients as they are in the int enum patterns.
* Enums provide high-quality implementations of all the Object methods, they implement Comparable and Serializable, and their serialized form is designed to withstand most changes to the enum type.
* Enums are by their nature immutable, so all fields should be final.
* If switch statements on enums are not a good choice for implementing constant-specific behavior on enums.
* Switches on enums are good for augmenting enum types with constant-specific behavior.
* A minor performance disadvantage of enums is that there is a space and time cost to load and initialize enum types, but it is unlikely to be noticeable in practice.
* There is a better way to associate a different behavior with each enum constant: declare an abstract apply method in the enum type, and override it with a concrete method for each constant in a constant-specific class body. Such methods are known as constant-specific method implementations
* The Strategy Enum Pattern
```java
enum PayrollDay {
     MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
     SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

     private final PayType payType;
     PayrollDay(PayType payType) { 
     	this.payType = payType; 
     }

     PayrollDay() { 
        this(PayType.WEEKDAY); // Default
     }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
     }

     // The strategy enum type
     private enum PayType {
        WEEKDAY {
           int overtimePay(int minsWorked, int payRate) {
               return minsWorked <= MINS_PER_SHIFT ? 0 :
                  (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
         },
        WEEKEND {
           int overtimePay(int minsWorked, int payRate) {
               return minsWorked * payRate / 2;
            }
         };

        abstract int overtimePay(int mins, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
           int basePay = minsWorked * payRate;
           return basePay + overtimePay(minsWorked, payRate);
         }
     }
 }
```
* Use enums any time you need a set of constants whose members are known at compile time.
* It is not necessary that the set of constants in an enum type stay fixed for all time.


- - - -
### 2. Use instance fields instead of ordinals :
* All enums have an ordinal method, which returns the numerical position of each enum constant in its type.
* Abuse of ordinal : If the constants are reordered, the <i>numberOfMusicians</i> method will break.
```java

// Abuse of ordinal to derive an associated value - DON'T DO THIS
  public enum Ensemble {
      SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;

      public int numberOfMusicians() { 
      	return ordinal() + 1; 
      }
  }
```
* Never derive a value associated with an enum from its ordinal, store it in an instance field instead.
```java

  public enum Ensemble {
      SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8), NONET(9), DECTET(10), TRIPLE_QUARTET(12);

      private final int numberOfMusicians;
      Ensemble(int size) { 
      	this.numberOfMusicians = size; 
      }
      public int numberOfMusicians() { 
      	return numberOfMusicians; 
      }
  }
```
* According to the Enum specification, <b>Ordinal</b> is designed for use by general-purpose enumbased data structures such as EnumSet and EnumMap. Unless you are writing code with this character, you are best off avoiding the ordinal method entirely.


- - - -
### 3. Use EnumMap instead of ordinal indexing :
* There is a very fast Map implementation designed for use with enum keys, known as <b>java.util.EnumMap</b>
* The reason that EnumMap is comparable in speed to an ordinal-indexed array is that <b>EnumMap</b> uses such an array internally, but it hides this implementation detail from the programmer, combining the richness and type safety of a Map with the speed of an array
* EnumMap constructor takes the Class object of the key type: this is a <b><i>bounded type token</i></b>, which provides runtime generic type information.
```java
   // Using an EnumMap to associate data with an enum
   Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

   for (Plant.LifeCycle lc : Plant.LifeCycle.values())
   	  plantsByLifeCycle.put(lc, new HashSet<>());

   for (Plant p : garden) 
   	  plantsByLifeCycle.get(p.lifeCycle).add(p);

   System.out.println(plantsByLifeCycle);
```
* This above program can be further shortened by using a stream. Also note that by default stream grouping use HashMap, so in order to use EnumMap, we need to use <b><i>three-parameter form of Collectors.groupingBy</i></b>, which allow the caller to specify the map implementation using the mapFactory parameter.
```java
// Using a stream and an EnumMap to associate data with an enum
    System.out.println(Arrays.stream(garden)
    	.collect(groupingBy(p -> p.lifeCycle,
    		() -> new EnumMap<>(LifeCycle.class), toSet())));
```

