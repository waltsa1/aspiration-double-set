import com.aspiration.doubleset.DoubleSet;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DoubleSet ds = new DoubleSet();
        System.out.println("Put 1.");
        ds.put(1);
        System.out.println(ds);
        System.out.println("Put 1.");
        ds.put(1);
        System.out.println(ds);
        System.out.println("Put 1.");
        ds.put(1);
        System.out.println(ds);

        System.out.println();

        System.out.println("Remove 1.");
        ds.remove(1);
        System.out.println(ds);
        System.out.println("Remove 1.");
        ds.remove(1);
        System.out.println(ds);
        System.out.println("Remove 1.");
        ds.remove(1);
        System.out.println(ds);


        System.out.println();
        System.out.println("Addition");
        DoubleSet thisDs = new DoubleSet();
        DoubleSet thatDs = new DoubleSet();

        thisDs.putAll(new ArrayList<>(Arrays.asList(1,1,2)));
        System.out.println(thisDs);

        thatDs.putAll(new ArrayList<>(Arrays.asList(1,-3,2)));
        System.out.println(thatDs);

        DoubleSet added = thisDs.add(thatDs);
        System.out.println(added);

        thisDs.clear();
        thatDs.clear();
        System.out.println();
        System.out.println();
        System.out.println("Subtraction");

        thisDs.putAll(new ArrayList<>(Arrays.asList(1,1,2,4)));
        System.out.println(thisDs);

        thatDs.putAll(new ArrayList<>(Arrays.asList(1,2,2,-3)));
        System.out.println(thatDs);

        DoubleSet subtracted = thisDs.subtract(thatDs);
        System.out.println(subtracted);

        System.out.println("Subtraction is NOT commutative!");
        subtracted = thatDs.subtract(thisDs);
        System.out.println(subtracted);

        System.out.println(subtracted.toString().equals("{{2: 1},{-3: 1}}"));
    }

}
