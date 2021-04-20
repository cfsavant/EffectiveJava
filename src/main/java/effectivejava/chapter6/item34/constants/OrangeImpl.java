package effectivejava.chapter6.item34.constants;



public class OrangeImpl {
    public static void main(String[] args) {
        OrangeImpl.getFruit(Orange.BLOOD);
    }

    static Orange getFruit(Orange orange) {
        return Orange.BLOOD;
    }
}
