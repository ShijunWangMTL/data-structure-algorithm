package predicatePractice;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {

    public static List<String> getNameContainingCharacter(String c, List<String> names, BiFunction<String, List<String>, List<String>> biFunc) {
        return biFunc.apply(c, names);
    }

    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull   //接口的函数引用实现，满足test方法签名的要求：接受一个参数，返回boolean值
                : object -> targetRef.equals(object); //接口的lambda表达式实现，object就是test(T t)方法的参数t
    }

    public static void main(String[] args) {

        // abstract method
        // boolean test(T t);
        Predicate<String> predicate = e -> "mattie".equals(e); //using lambda expression
        predicate.test("mattie"); //true
        predicate.test("hello"); //false
        System.out.println("--------------------------------");

        List<String> names = Arrays.asList("ted", "mattie", "hello", "world");
        //找出names中包含字母e的元素
        List<String> result = getNameContainingCharacter("e", names, (t, u) -> {
            return u.stream().filter(name -> name.contains(t)).collect(Collectors.toList());
        });
        System.out.println("--------------------------------");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateDemo instance = new PredicateDemo();
        instance.conditionFilter(list, e -> {
            return e > 5;
        });
        instance.conditionFilter(list, e -> e % 2 == 0);
        instance.conditionFilter(list, e -> true);//打印所有元素

        Predicate<Integer> p = e -> e > 5;
        //取反
        instance.conditionFilter(list, p.negate()); // 5 6 7 8 9 10
        //and
        instance.conditionFilter(list, p.and(e -> e < 9));//6 7 8
        //or
        instance.conditionFilter(list, p.or(e -> e < 4));//1 2 3 6 7 8 9 10
    }


}
