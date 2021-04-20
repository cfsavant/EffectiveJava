package effectivejava.chapter6.item34.custombehavior;
/* switch statement is brittle
*  see OperationImproved.java for a better approach
* */
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    // Do the arithmetic operation represented by this constant
    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        throw new AssertionError("Unknown op: " + this);
    }
}
