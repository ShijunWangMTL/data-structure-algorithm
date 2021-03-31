package predicatePractice;

import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(e -> {
            if (predicate.test(e)) {
                System.out.println(e);
            }
        });
    }
}
