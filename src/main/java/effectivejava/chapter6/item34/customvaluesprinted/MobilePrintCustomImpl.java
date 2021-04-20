package effectivejava.chapter6.item34.customvaluesprinted;
/*
    Demonstrates printing the values via for loop
    and valueOf

    The name must match exactly an identifier used to declare an enum constant

    https://www.tutorialspoint.com/java/lang/enum_valueof.htm
 */
// enum showing Mobile prices

enum Mobile {
    Samsung(400), Nokia(250), Motorola(325);

    int price;

    Mobile(int p) {
        price = p;
    }

    int showPrice() {
        return price;
    }
}

public class MobilePrintCustomImpl {

    public static void main(String args[]) {

        System.out.println("CellPhone List:");

        for (Mobile m : Mobile.values()) {
            System.out.println(m + " costs " + m.showPrice() + " dollars");
        }

        Mobile ret;
        ret = Mobile.valueOf("Samsung");
        System.out.println("Selected : " + ret);

    }
}
