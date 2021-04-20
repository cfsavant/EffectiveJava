package effectivejava.chapter6.item34.constants;
/*
    Example of constants w/o an Enum
    this approach was used before Java introduced Enums.
    It's an example of how it used to be
    These constants are rigid and do not have all the powerful capabilities of an Enum

    see Apple and Orange Enums for examples of basic Enums / Contants

 */
public class ConstantsExample {

    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_FUJI = 1;


    public static void main(String[] args) {

    }

    public int getFruit(int fruit) {
        return fruit;
    }

}
