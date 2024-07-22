import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List<Integer> l = new ArrayList(intList);

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) < 1 || (l.get(i) % 2) == 1) {
                l.remove(i);
                i--;
            }
        }
        l.sort(Comparator.naturalOrder());
        for (int string : l) {
            System.out.println(string);
        }
//        List<Integer> l = new ArrayList(intList);
//
//        l.removeIf(X -> X < 1);
//        l.removeIf(x -> x % 2 == 1);
//        l.sort(Comparator.naturalOrder());
//
//        for (int v : l) {
//            System.out.println(v);
//        }


    }
}