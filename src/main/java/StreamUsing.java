import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUsing {

    @Test
    public  void stream1(){
        //Stream Creation
        String[] arr = new String[]{"a", "b", "c","a"};
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");
        System.out.println(stream.distinct().count());
    }

    @Test
    public  void stream2(){
        //Multi-threading
        List<String> list =new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("abc");
        list.add("ccc");
        list.add("ddd");
        list.parallelStream().forEach(element -> System.out.println(element));

    }

    @Test
    public  void stream3(){
        //Matching
        List<String> list =new ArrayList();
        list.add("aaas");
        list.add("bbbe");
        list.add("abgh");
        list.add("cccuu");
        list.add("dddii");
        List<String> resultList
                = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
        resultList.forEach(x-> System.out.println(x));
//        System.out.println(list.stream().anyMatch(element -> element.equals("wssx")));
//        System.out.println(list.stream().allMatch(element -> element.contains("a")));
//        System.out.println(list.stream().noneMatch(element -> element.contains("z")));
//        list.stream().filter(x -> x.endsWith("u")).forEach(x -> System.out.println(x));
//        list.stream().map(x -> x.substring(0,2)).forEach(x -> System.out.println(x));

    }


    @Test
    public  void stream4(){
        //Reduction
        List<Integer> integers = Arrays.asList(4, 1, 1);
        Integer reduced = integers.stream().reduce(100, (a, b) -> a + b);
        System.out.println(reduced);

    }

    @Test
    public  void stream5(){

            List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//            ints.stream()
//                    .forEach(i -> {
//                        if (i.intValue() % 2 == 0) {
//                            System.out.println("i is even");
//                        } else {
//                            System.out.println("i is old");
//                        }
//                    });

            ints.stream().filter(i -> i % 2 ==0).forEach(i -> System.out.println("偶数:"+i));
            ints.stream().filter(i -> i % 2 ==1).forEach(i -> System.out.println("奇数:"+i));

    }

    @Test
    public  void stream6(){
        Map<String, String> someMap = new HashMap<>();
        someMap.put("jack","20");
        someMap.put("bill","35");
//        Map.Entry
        Optional<String> first = someMap.entrySet().stream()
                .filter(e -> "20".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println(first.isPresent());

    }

    @Test
    public  void stream7(){

        List<String> list = Arrays.asList("jack", "bob", "alice", "mark");
        List<String> duplicateList = Arrays.asList("jack", "jack", "alice", "mark");

//        String collect1 = list.stream().collect(Collectors.joining(" ", "prefix", "suffix"));
//        System.out.println(collect1);
//        List<String> collect = list.stream().filter(x -> x.contains("a")).collect(Collectors.toList());
        Set<String> stringSet = duplicateList.stream().collect(Collectors.toSet());
//        collect.forEach(x-> System.out.println(x));
        stringSet.forEach(System.out::println);
    }
}
