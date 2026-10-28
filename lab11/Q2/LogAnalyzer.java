import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {

        Path dir = Paths.get("logs");
        Files.createDirectories(dir);

        Files.write(dir.resolve("app1.txt"), Arrays.asList(
            "INFO Application started",
            "ERROR Could not connect",
            "INFO Retrying"
        ));

        Files.write(dir.resolve("app2.txt"), Arrays.asList(
            "INFO User logged in",
            "ERROR Invalid request"
        ));

        Files.write(dir.resolve("app3.txt"), Arrays.asList(
            "INFO Task completed",
            "ERROR Disk warning",
            "INFO Shutdown"
        ));

        String keyword = "ERROR";

        long totalLines = 0;
        long matchingLines = 0;

        try (DirectoryStream<Path> files =
                Files.newDirectoryStream(dir, "*.txt")) {

            for (Path file : files) {

                BasicFileAttributes attrs =
                    Files.readAttributes(
                        file,
                        BasicFileAttributes.class
                    );

                System.out.println(
                    "File: " + file
                    + " | Size: " + attrs.size() + " bytes"
                );

                List<String> lines = Files.readAllLines(file);

                totalLines += lines.size();

                for (String line : lines) {
                    if (line.contains(keyword)) {
                        matchingLines++;
                    }
                }
            }
        }

        System.out.println("Total lines: " + totalLines);

        System.out.println(
            "Lines containing '" + keyword + "': " + matchingLines
        );
    }
}