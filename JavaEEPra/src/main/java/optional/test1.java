package optional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {
    public static void main(String[] args) {
        String s = new String("123");
        PriorityQueue<int[]> ints = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
        String[] s5 = s.split(" ");
        Collections.reverse(Arrays.asList(s5));
        String strip = s.strip();
//        s.substring()
        ArrayList<String> stringArrayList = new ArrayList<String>();
        Optional<String> q = stringArrayList.stream().filter(d -> d.startsWith("Q")).findFirst();
        //String s = q.orElse("");
        String s1 = q.orElseGet(() -> System.getProperty("myqpp.default"));
        String s2 = q.orElseThrow(IllegalStateException::new);

        q.ifPresent(stringArrayList::add);
        q.ifPresent(v->stringArrayList.add(v));
        q.ifPresentOrElse(v-> System.out.println("Found"+v),
                () -> System.out.println("error"));
        Optional<String> s3 = q.map(String::toUpperCase);
        q.filter(d->d.length() >= 8).map(String::toUpperCase);
        String s4 = q.get();
        boolean present = q.isPresent();
        Optional<Integer> integer = Optional.of(1);
        Optional<Object> empty = Optional.empty();
        Stream<String> stream = q.stream();
        //Optional<Object> o = q.map(Optional::stream);

        stream.forEach(System.out::println);
        stream.forEachOrdered(System.out::println);
        String[] strings = stream.toArray(String[]::new);
        List<String> collect = stream.collect(Collectors.toList());
        TreeSet<String> collect1 = stream.collect(Collectors.toCollection(TreeSet::new));

        //stream.collect(Collectors.toMap(Person::getId(), Person()::getName()));
//        stream.collect(COllectors.toMap(Locale.getAvailableLocales(),
//                Person::getID(),
//                (ex, newd) -> {throw new IllegalStateException();},
//                TreeMap::new));
    }

    public static Stream<String> noVowels() throws IOException {
        var contents = new String(Files.readAllBytes(Paths.get("../eg.txt")), StandardCharsets.UTF_8);
        List<String> split = List.of(contents.split("\\PL+"));
        Stream<String> stream = split.stream();
        return stream.map(s->s.replaceAll("[sdf]", ""));
    }
}
