package effectivejava.chapter6.item34.multipleattributes;
/* Demonstrates Power of ENUMs
    If you remove a member from the Planet ENUM, this still works.
*/
public class PlanetImplementation {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight /
                Planet.EARTH.surfaceGravity();
        // values provided by Enum by default; iterates in order declared.
        for (Planet p : Planet.values())
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
    }
}

