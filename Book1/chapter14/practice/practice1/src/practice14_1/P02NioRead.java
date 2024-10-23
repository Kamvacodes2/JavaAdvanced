package practice14_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author oracle
 */
public class P02NioRead {

    public static void main(String[] args) {

        try(Stream<String> lines = Files.lines(Paths.get("C:\\BootCamp\\Java Advanced\\Book\\chapter14\\practice\\practice1\\hamlet.txt"))){

            System.out.println("\n=== Entire File ===");
            lines.forEach(line -> System.out.println(line));

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
