package effectivejava.chapter6.item34.customvalues;
/* Demonstrates how custom values work
*   1. create constructor
*   2. pass in values
*
*   Good reference: https://www.tutorialspoint.com/can-we-create-an-enum-with-custom-values-in-java
* */
public enum Level {
    HIGH  (3),  //calls constructor with value 3
    MEDIUM(2),  //calls constructor with value 2
    LOW   (1)   //calls constructor with value 1
    ; // semicolon needed when fields / methods follow


    private final int levelCode;

    Level(int levelCode) {
        this.levelCode = levelCode;
    }

    public int getLevelCode() {
        return this.levelCode;
    }

}