package Book_8.Chapter_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest
{
    public static void main(String[] args) {
        Path p = Paths.get("C:\\Users\\Mark\\Desktop\\Java\\TestArgs.java");
        if (Files.exists(p)) {
            System.out.println("The input file does exist!");
        } else {
            System.out.println("The input file does not exist!");
        }

        Path p2 = Paths.get("C:\\Users\\Mark\\Desktop\\Java\\HelloWorld.java");
        try {
            Files.createFile(p2);
            System.out.println("File created!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
