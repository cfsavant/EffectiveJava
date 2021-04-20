package effectivejava.chapter7.item34.comparison;


public class CompareToExample {

    enum Tutorials {
        topic1, topic2, topic3;
    }

    public static void main(String args[]) {

        Tutorials t1, t2, t3;

        t1 = Tutorials.topic1;
        t2 = Tutorials.topic2;
        t3 = Tutorials.topic3;

        if (t1.compareTo(t2) > 0) {
            System.out.println(t2 + " completed before " + t1);
        }

        if (t1.compareTo(t2) < 0) {
            System.out.println(t1 + " completed before " + t2);
        }

        if (t1.compareTo(t3) == 0) {
            System.out.println(t1 + " completed with " + t3);
        }
    }
}
