import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }
        System.out.println("There are " + squares.size() + " and " + cubes.size() + " cubes.");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("The union has " + union.size() + " elements");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("The intersection has " + intersection.size() + " elements");

        addSeparation();
        printSet(intersection);

        addSeparation();
        Set<String> words = getStringSet("one day in the year of the fox");
        printSet(words);

        addSeparation();
        Set<String> nature = getStringSet("all nature is but art unknown to thee");
        Set<String> divine = getStringSet("to err is human to forgive is divine");

        System.out.println("nature - divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
//        Solamente mantendrá "to" y "do", las únicas presentes en ambos sets

        addSeparation();
        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);
//        Nos dará todas las palabras menos "to do"

        addSeparation();
        if (nature.containsAll(divine))
            System.out.println("Divine is a subset of nature");
        if (nature.containsAll(intersectionTest))
            System.out.println("intersectionTest is a subset of nature");
        if (divine.containsAll(intersectionTest))
            System.out.println("intersectionTest is a subset of divine");


    }

    public static <T> void printSet(Set<T> set) {
        System.out.print("\t");
        for (T s : set) System.out.print(s + " ");
        System.out.println();
    }


    public static HashSet<String> getStringSet(String sentence) {
        return new HashSet<>(Arrays.asList(sentence.split(" ")));
    }

    public static void addSeparation() {
        System.out.println("_____________________________");
    }
}
