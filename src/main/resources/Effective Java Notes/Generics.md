
## ------------------------------------  **Generics** ------------------------------


### 1. Don’t use raw types

* using raw types can lead to exceptions at runtime, so don’t use
them. They are provided only for compatibility and interoperability with legacy
code that predates the introduction of generics

Term Example
Parameterized type List<String> Item 26
Actual type parameter String Item 26
Generic type List<E> Items 26, 29
Formal type parameter E Item 26
Unbounded wildcard type List<?> Item 26
Raw type List Item 26
Bounded type parameter <E extends Number> Item 29
Recursive type bound <T extends Comparable<T>> Item 30
Bounded wildcard type List<? extends Number> Item 31
Generic method static <E> List<E> asList(E[] a) Item 30
Type token String.class Item 33



**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 2. Eliminate unchecked warnings

Eliminate every unchecked warning that you can. If you
eliminate all warnings, you are assured that your code is typesafe, which is a very
good thing. It means that you won’t get a ClassCastException at runtime, and it
increases your confidence that your program will behave as you intended

If you can’t eliminate a warning, but you can prove that the code that
provoked the warning is typesafe, then (and only then) suppress the warning
with an @SuppressWarnings("unchecked") annotation.

Always use the
SuppressWarnings annotation on the smallest scope possible. Typically this
will be a variable declaration or a very short method or constructor. Never use
SuppressWarnings on an entire class. Doing so could mask critical warnings.

It is illegal to put a SuppressWarnings annotation on the return statement,Instead, declare a local variable to hold the
return value and annotate its declaration,

unchecked warnings are important. Don’t ignore them. Every
unchecked warning represents the potential for a ClassCastException at runtime.



**XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX**


### 3. Prefer lists to arrays
















