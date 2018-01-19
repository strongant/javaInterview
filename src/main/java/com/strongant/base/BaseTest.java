package com.strongant.base;

import com.sun.tools.javac.util.ArrayUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class BaseTest {

    public static void main(String[] args) throws IOException {

        //foobar();

        //joining();

        //collector();

        //patternCount();


        //toUnsignedString();

        //integerOverflow();

        //toIntExact();

        //filesList();

        //fileCount();

        //filesWalk();

        //filesWrite();

        //streamWriteToFile();

        //bufferedReaderRead();

        //writeToFile();

        //linesCount();


        //tryWithResources();

        //reflectiveOperationException();

        LocalDateTime localDate = LocalDateTime.now();
        System.out.println(localDate);

    }

    private static void reflectiveOperationException() {
        try {

            Class<?> clazz = Class.forName("com.biezhi.apple.User");

        } catch (ReflectiveOperationException e){

            e.printStackTrace();

        }
    }

    private static void tryWithResources() {
        try {

            Thread.sleep(1000);

            FileInputStream fis = new FileInputStream("a/b.txt");

            fis.read();

        } catch (InterruptedException | IOException e) {

            e.printStackTrace();

        }
    }

    private static void linesCount() throws IOException {
        Path path = Paths.get("res/nashorn1.js");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            long countPrints = reader
                    .lines()
                    .filter(line -> line.contains("print"))
                    .count();
            System.out.println(countPrints);
        }
    }

    private static void writeToFile() throws IOException {
        Path path = Paths.get("res/output.js");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("print('Hello World');");
        }
    }

    private static void bufferedReaderRead() throws IOException {
        Path path = Paths.get("res/nashorn1.js");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println(reader.readLine());
        }
    }

    private static void streamWriteToFile() {
        try (Stream<String> stream = Files.lines(Paths.get("res/nashorn1.js"))) {
            stream
                    .filter(line -> line.contains("print"))
                    .map(String::trim)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filesWrite() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("res/nashorn1.js"));
        lines.add("print('foobar');");
        Files.write(Paths.get("res/nashorn1-modified.js"), lines);
    }

    private static void filesWalk() {
        Path start = Paths.get("");
        int maxDepth = 10;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> path.endsWith(".js"))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("walk(): " + joined);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileCount() {
        Path start = Paths.get("");
        int maxDepth = 10;
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                String.valueOf(path).endsWith(".js"))) {
            String joined = stream
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining("; "));
            System.out.println("Found: " + joined);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filesList() {
        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("List: " + joined);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void toIntExact() {
        try {
            Math.toIntExact(Long.MAX_VALUE);
        }
        catch (ArithmeticException e) {
            System.err.println(e.getMessage());
            // => integer overflow
        }
    }

    private static void integerOverflow() {
        try {
            Math.addExact(Integer.MAX_VALUE, 1);
        }
        catch (ArithmeticException e) {
            System.err.println(e.getMessage());
            // => integer overflow
        }
    }

    private static void toUnsignedString() {
        long maxUnsignedInt = (1l << 32) - 1;

        System.out.println(maxUnsignedInt);

        String string = String.valueOf(maxUnsignedInt);

        System.out.println(string);

        int unsignedInt = Integer.parseUnsignedInt(string, 10);
        String string2 = Integer.toUnsignedString(unsignedInt, 2);

        System.out.println(string2);
    }

    private static void patternCount() {
        Pattern pattern = Pattern.compile(".*@gmail\\.com");
        long count = Stream.of("bob@gmail.com", "alice@hotmail.com")
                .filter(pattern.asPredicate())
                .count();

        System.out.println(count);
    }

    private static void collector() {
        String result = Pattern.compile(":")
                .splitAsStream("foobar:foo:bar")
                .filter(s -> s.contains("bar"))
                .sorted()
                .collect(Collectors.joining(":"));

        System.out.println(result);
    }

    private static void joining() {
        String foobarStr = "foo:foo:bar:foobar";

        String result = foobarStr.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .sorted()
                .collect(Collectors.joining());

        System.out.println(result);
    }

    private static void foobar() {
        String strs = String.join(":", "foobar", "foo", "bar");

        System.out.println(strs);
    }
}
