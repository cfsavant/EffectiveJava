package effectivejava.chapter6.item34.comparing;

/* Java program to illustrate enum members comparison
== operator
    returns false when null, never throws NullPointerException whereas .equals() method can throw NullPointerException. will
    does compile time checks for type compatability

.equals
    will error if null
    does not do compile time checks (just returns false at runtime)


Below, the  == does not error but the .equals does.

 */
public class EnumComparisonDemo {
    public enum Day { MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        SUN }

    public static void main(String[] args)
    {
        Day mySelectedDay = null;
        mySelectedDay = Day.WED;
        // Comparing an enum member with null
        // using == operator
       System.out.println(mySelectedDay == Day.MON);

//         Comparing an enum member with null
//         using .equals() method
//        System.out.println(mySelectedDay.equals(Day.MON));
    }
}
