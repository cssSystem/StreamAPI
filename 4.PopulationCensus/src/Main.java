import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long minors = persons.stream()
                .filter(x -> x.getAge() < 18).count();
        System.out.println("Несовершеннолетних - " + minors);

        List conscripts =
                persons.stream()
                        .filter(x -> x.getAge() > 17 && x.getAge() < 28)
                        .map(x -> x.getFamily())
                        .collect(Collectors.toList());
        System.out.println("Призывники - " + conscripts.size());

        List l = persons.stream()
                .filter(x ->
                        Education.HIGHER.equals(x.getEducation())
                                && x.getAge() > 17 &&
                                (
                                        (
                                                Sex.WOMAN.equals(x.getSex())
                                                        && x.getAge() < 61
                                        )
                                                || (
                                                Sex.MAN.equals(x.getSex())
                                                        && x.getAge() < 66
                                        )
                                )
                )
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        int coll = 10;
        System.out.println("Колличество потенциально работоспособных людей с высшим образованием - " + l.size()
                + "\nПервые " + coll + ":");


        for (int i = 0; i < coll; i++) {
            System.out.println(l.get(i));
        }

    }
}