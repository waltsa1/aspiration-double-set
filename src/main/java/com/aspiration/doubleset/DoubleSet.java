package com.aspiration.doubleset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoubleSet {

    private final HashMap<Integer, Integer> doubleSet = new HashMap<>();


    /**
     * The put method puts the Integer element into the DoubleSet if that element's count is less than two.
     *
     * From the gist:
     * "A DoubleSet is a collection whose members are integers, and who can have one or two of each member."
     *
     * @param element - The Integer to attempt to put in the DoubleSet
     * @return - The previous count of that Integer, else -1
     */
    public Integer put(Integer element){

        Integer previousValue = -1;

        // If the doubleSet is empty, put the new element and count of 1.
        if(doubleSet.isEmpty()){
            doubleSet.put(element, 1);
        }
        else if (doubleSet.containsKey(element)) {

            // If the element is already in the doubleSet
            // get the count
            previousValue = doubleSet.get(element);

            if (previousValue < 2){
                // If the count is less than 2, increment the count in the doubleSet
                doubleSet.put(element, previousValue + 1);
            }
            else {
                // Otherwise set previousValue to 2
                previousValue = 2;
            }

        }
        else {
            // If the doubleSet does not contain the element, put it in the doubleSet with count of 1.
            doubleSet.put(element, 1);
        }

        return previousValue;
    }


    /**
     * The putAll method creates a new DoubleSet from a list of Integers.
     *
     *
     * @param elements - A List of Integers to put in the DoubleSet
     * @return - The resulting DoubleSet
     */
    public DoubleSet putAll(List<Integer> elements){

        for (Integer element : elements) {
            this.put(element);
        }

        return this;
    }


    /**
     * The remove method checks if the element is in the DoubleSet
     * and if it exists in the DoubleSet, decrements the count of that element.
     *
     * If the count of the element falls to zero or below, the element is removed from the DoubleSet.
     *
     * @param element - The element to remove.
     * @return - The resulting DoubleSet.
     */
    public DoubleSet remove(Integer element){

        if(this.doubleSet.containsKey(element)){

            // If the element is in the keySet,
            // get the current count and decrement it.
            Integer count = this.doubleSet.get(element);
            count--;

            if(count > 0){
                // if the count remains above zero, update the count.
                this.doubleSet.put(element, count);
            }
            else {
                // If the count falls to 0 or below, remove the element.
                this.doubleSet.remove(element);
            }

        }

        return this;

    }


    /**
     * The add method adds two DoubleSets by summing the count of each element, up to a count of two.
     * If the summed count of an element exceeds two, nothing is added and the count of two is retained.
     *
     * From the gist:
     * "If a DoubleSet has two of member 1, adding a third would result in an identical DoubleSet. ...
     *
     * We add two DoubleSets by adding each of their members, each of whose count can be no greater than two."
     *
     * @param that - The DoubleSet to add to this.
     * @return - A new DoubleSet with the counts for each element in this and that added, up to a count of two.
     */
    public DoubleSet add (DoubleSet that){

        DoubleSet sum = new DoubleSet();

        // Union the keySets from the two DoubleSets
        Set<Integer> combinedKeySet = new HashSet<Integer>(this.doubleSet.keySet());
        combinedKeySet.addAll( that.doubleSet.keySet());

        for (Integer key : combinedKeySet) {

            if(this.doubleSet.containsKey(key) && that.doubleSet.containsKey(key)){

                // If the key is in both DoubleSets, check the count

                Integer thisCount = this.doubleSet.get(key);
                Integer thatCount = that.doubleSet.get(key);

                if(thisCount + thatCount >= 2){
                    sum.doubleSet.put(key, 2);
                }
                else {
                    sum.doubleSet.put(key, thisCount + thatCount);
                }

            }
            else if (this.doubleSet.containsKey(key) && !that.doubleSet.containsKey(key)) {
                // If the key is only in this DoubleSet, add the key and the count.
                sum.doubleSet.put(key, this.doubleSet.get(key));
            }
            else if (!this.doubleSet.containsKey(key) && that.doubleSet.containsKey(key)) {
                // If the key is only in that DoubleSet, add the key and the count.
                sum.doubleSet.put(key, that.doubleSet.get(key));
            }

        }

        return sum;
    }


    /**
     * The subtract method subtracts two DoubleSets by subtracting the count of each element, down to zero.
     * If the count of an element falls below one, the element is removed.
     *
     * From the gist:
     * "If a DoubleSet has zero of member 3, subtracting a 3 would likewise result in an identical DoubleSet.
     *
     * We subtract two DoubleSets by subtracting each of their counts, where elements whose counts fall
     * below one are omitted from the difference entirely."
     *
     * Based on the information given, I have inferred that subtraction is NOT commutative
     *
     * @param that - The DoubleSet to add to this.
     * @return - A new DoubleSet with the counts for each element in this and that subtracted. With elements whose
     * count falls below one removed.
     */
    public DoubleSet subtract (DoubleSet that){

        DoubleSet subtracted = new DoubleSet();

        // Union the keySets from the two DoubleSets
        Set<Integer> combinedKeySet = new HashSet<Integer>(this.doubleSet.keySet());
        combinedKeySet.addAll( that.doubleSet.keySet());

        for (Integer key : combinedKeySet) {

            if(this.doubleSet.containsKey(key) && that.doubleSet.containsKey(key)){

                // If the key is in both DoubleSets, check the count

                Integer thisCount = this.doubleSet.get(key);
                Integer thatCount = that.doubleSet.get(key);

                if(thisCount - thatCount >= 1){
                    subtracted.doubleSet.put(key, thisCount - thatCount);
                }

            }
            else if (this.doubleSet.containsKey(key) && !that.doubleSet.containsKey(key)) {
                // Since subtraction is NOT commutative,
                // if the key is only in this DoubleSet, add the key and the count.
                subtracted.doubleSet.put(key, this.doubleSet.get(key));
            }


        }

        return subtracted;
    }

    /**
     * The clear method removes all elements from a DoubleSet and returns an empty DoubleSet.
     */
    public void clear(){

        this.doubleSet.clear();

    }

    public int size(){

        return this.doubleSet.size();

    }

    public Integer get(Integer key){

        return this.doubleSet.get(key);
    }


    @Override
    public String toString(){

        String strDoubleSet = "{";

        for (Integer i : this.doubleSet.keySet()){

            strDoubleSet += "{" + i + ": " + this.doubleSet.get(i) + "},";
        }

        // Remove that last comma if it's there.
        if(strDoubleSet.substring(strDoubleSet.length() - 1).equals(",")) {
            strDoubleSet = strDoubleSet.substring(0, strDoubleSet.length() - 1);
        }
        // Close the curly brace
        strDoubleSet += "}";

        return strDoubleSet;
    }


    // I know I should override hashCode and equals, but I have to move on to other things in life.

}
