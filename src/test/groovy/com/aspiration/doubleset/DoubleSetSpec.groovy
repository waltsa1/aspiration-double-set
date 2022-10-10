package com.aspiration.doubleset

import spock.lang.Specification

class DoubleSetSpec extends Specification {

    def ds = new DoubleSet();

    def "put() puts an element into the DoubleSet" (){

        when: ds.put(1)

        then:
        ds.size() == 1
        ds.get(1) == 1

    }

    def "put() ignores the third same element" (){

        when:
        ds.put(1)
        ds.put(1)
        ds.put(1)

        then:
        ds.size() == 1
        ds.get(1) == 2

    }

    def "get() gets the correct value"(){

        given:
        ds.put(1)
        ds.put(1)

        when:
        Integer value = ds.get(1)

        then:
        value == 2
    }

    def "putAll() puts all"(){

        when:
        ds.putAll(new ArrayList<>(Arrays.asList(1,1)))

        then:
        ds.size() == 1
        ds.get(1) == 2

    }


    def "add() properly sums two DoubleSets" (){

        given:
        DoubleSet thisDs = new DoubleSet();
        DoubleSet thatDs = new DoubleSet();

        thisDs.putAll(new ArrayList<>(Arrays.asList(1,1,2)));
        thatDs.putAll(new ArrayList<>(Arrays.asList(1,-3,2)));

        when:
        DoubleSet added = thisDs.add(thatDs);

        then:
        added.size() == 3
        added.get(1) == 2
        added.get(2) == 2
        added.get(-3) == 1

    }

    def "subtract() properly subtracts two DoubleSets" (){

        given:
        DoubleSet thisDs = new DoubleSet();
        DoubleSet thatDs = new DoubleSet();

        thisDs.putAll(new ArrayList<>(Arrays.asList(1,1,2,4)));
        thatDs.putAll(new ArrayList<>(Arrays.asList(1,2,2,-3)));

        when:
        DoubleSet subtracted = thisDs.subtract(thatDs);

        then:
        subtracted.size() == 2
        subtracted.get(1) == 1
        subtracted.get(4) == 1

    }

    def "subtract() is NOT commutative" (){

        given:
        DoubleSet thisDs = new DoubleSet();
        DoubleSet thatDs = new DoubleSet();

        thisDs.putAll(new ArrayList<>(Arrays.asList(1,1,2,4)));
        thatDs.putAll(new ArrayList<>(Arrays.asList(1,2,2,-3)));

        when:
        DoubleSet subtracted = thatDs.subtract(thisDs);

        then:
        subtracted.size() == 2
        subtracted.get(2) == 1
        subtracted.get(-3) == 1

    }

    def "remove() decrements the count by one"(){

        given:
        ds.putAll(Arrays.asList(1,1))

        when:
        ds.remove(1)

        then:
        ds.get(1) == 1

    }

    def "remove() removes the element when the count is less than one"(){

        given:
        ds.put(1)

        when:
        ds.remove(1)

        then:
        ds.size() == 0

    }

}
