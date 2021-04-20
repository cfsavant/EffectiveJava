package effectivejava.chapter6.item34.custombehavior;

/*
Demonstrates
    Using the OperationImproved Enum


       Enum types have an automatically generated
       valueOf(String) method that translates a constant’s name into the constant itself.
       If you override the toString method in an enum type, consider writing
       a fromString method to translate the custom string representation back to the corresponding enum.

INPUT:
 8 9

OUTPUT:
> Task :OperationImprovedImplementation.main()
8.000000 PLUS 9.000000 = 17.000000
8.000000 MINUS 9.000000 = -1.000000
8.000000 TIMES 9.000000 = 72.000000
8.000000 DIVIDE 9.000000 = 0.888889

 */
public class OperationImprovedImplementation {

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }

}
