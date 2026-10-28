
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;

public class FolderReport {

    public static void main(String[] args) throws IOException {

        Path root = args.length > 0
                ? Paths.get(args[0])
                : Paths.get(".");

        Path report = args.length > 1
                ? Paths.get(args[1])
                : Paths.get("file-report.txt");

        Path base = root.toAbsolutePath().normalize();
        Path reportPath = report.toAbsolutePath().normalize();

        try (BufferedWriter writer =
                Files.newBufferedWriter(reportPath)) {

            writer.write("FILE REPORT");
            writer.newLine();

            writer.write("Name | Size (bytes) | Modified time");
            writer.newLine();

            Files.walkFileTree(
                base,
                new SimpleFileVisitor<Path>() {

                    @Override
                    public FileVisitResult visitFile(
                            Path file,
                            BasicFileAttributes attrs)
                            throws IOException {

                        if (attrs.isRegularFile()
                                && !file.toAbsolutePath()
                                        .normalize()
                                        .equals(reportPath)) {

                            writer.write(
                                base.relativize(file)
                                + " | " + attrs.size()
                                + " | "
                                + Instant.ofEpochMilli(
                                    attrs.lastModifiedTime()
                                         .toMillis()
                                )
                            );

                            writer.newLine();
                        }

                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(
                            Path file,
                            IOException exc) throws IOException {

                        writer.write(
                            "SKIPPED | " + file
                            + " | " + exc.getMessage()
                        );

                        writer.newLine();

                        return FileVisitResult.CONTINUE;
                    }
                }
            );
        }

        System.out.println(
            "Report written to: " + reportPath
        );

        System.out.println("Included: regular files only");

        System.out.println(
            "Fields: name | size (bytes) | modified time"
        );

        System.out.println(
            "Directories are skipped; symbolic links are not followed."
        );
    }
}