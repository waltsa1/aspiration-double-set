# Implement DoubleSet

## Problem Statement

Implement the DoubleSet data structure described below.

A DoubleSet is a collection whose members are integers, and who can have one or two of each member. We express them below in
maplike notation, ie the DoubleSet that has two 1s, one -3, and one 0 is represented as

{{1: 2}, {-3: 1}, {0: 1}}

If a DoubleSet has two of member 1, adding a third would result in an identical DoubleSet. If a
DoubleSet has zero of member 3, subtracting a 3 would likewise result in an identical DoubleSet.

We add two DoubleSets by adding each of their members, each of whose count can be no greater than two:

doubleSetOne has members

{{1: 2}, {2: 1}}

and doubleSetTwo has members

{{1: 1}, {2: 1}, {-3: 1}}

their sum is

{{1: 2}, {2: 2}, {-3: 1}}

We subtract two DoubleSets by subtracting each of their counts, where elements whose counts fall below one 
are omitted from the difference entirely:

doubleSetOne has members

{{1: 2}, {2: 1}, {4: 1}}

and doubleSetTwo has members

{{1: 1}, {2: 2}, {-3: 1}}

their difference is

{{1: 1}, {4: 1}}

## Language choice
I chose to use Java for this problem as it is my best language. This made it very easy to 
wrap several methods from the `Map<K, V>` interface in order to create helper methods for `DoubleSet`.

I chose Spock for the testing framework as it is really easy to use. 

## Files for submission
In `main/java`, you'll find a class called `Main.java` and a package, `com.aspiration.doubleset`. 
* `Main.java` - Unsurprisingly, this is where the `main` method is.
* `com.aspiration.doubleset.DoubleSet.java` - This is where all the methods for implementing `DoubleSet` live. 
I know, you're shocked!

In `test/groovy`, you'll see the package `com.aspiration.doubleset` which contains the test file.
* `DoubleSetSpec.groovy` - This is a Spock test class with relevant unit tests.

## Building and running
Run `main` through IntelliJ or `> gradle clean build run`