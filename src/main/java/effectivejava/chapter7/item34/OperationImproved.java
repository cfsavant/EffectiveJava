package effectivejava.chapter7.item34;

/*
    Demonstrates
        1. better approach to Operation.java
            more flexible (won't forget the apply method when adding a constant) and compiler will remind you if you do.

        2. constant specific behavior
            Uses abstract method
            We can add abstract method in enums.
            each enum field/constant must implement the abstract method

        3. constant specific data
        4. overriding toString to print the arithmetic operator used in each operation.

 */

public enum OperationImproved {

    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    OperationImproved(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

}
