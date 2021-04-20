package effectivejava.chapter6.item34.streams;

enum DaysOfWeekEnum {

    SUNDAY("off"),
    MONDAY("working"),
    TUESDAY("working"),
    WEDNESDAY("working"),
    THURSDAY("working"),
    FRIDAY("working"),
    SATURDAY("off");

    private String typeOfDay;

    DaysOfWeekEnum(String typeOfDay) {
        this.typeOfDay = typeOfDay;
    }

    // standard getters and setters

//    public static Stream<DaysOfWeekEnum> stream() {
//        //return Stream.Of(DaysOfWeekEnum.values());
//    }

    public String getTypeOfDay() {
        return typeOfDay;
    }
}


public class FilterOnValues {

    public static void main() {
//        DaysOfWeekEnum.stream()
//                .filter(d -> d.getTypeOfDay().equals("off"))
//                .forEach(System.out::println);
    }

}
