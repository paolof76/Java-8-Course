package ch.diso.exercise.nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copy {

    public static void main(String[] args) {
        boolean overwrite = false;
        boolean prompt = false;

        if (args.length < 2) {
            error("Usage: java Copy <source directory> <target directory");
        } else if (args[0].equals(args[1])) {
            error("source and target cannot be the same directory");
        }

        // Existieren die notwendigen Verzeichnisse
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);

        if (Files.notExists(source)) {
            error("The source must exist: " + source);
        }

        // Absoluter Pfad sicherstellen
        if (!target.isAbsolute()) {
            Path base = source.subpath(0, source.getNameCount() - 1);
            target = Paths.get(source.getRoot().toString(), base.toString(), target.toString());
        }

        // Plausibilisierungen und notwengige Aktionen
        if (Files.exists(target)) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.print("Target directory exists. Overwrite existing files? (yes/no): ");
                String s = in.readLine().trim();
                if (!(s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes"))) {
                    error("Choose an empty target directory or file.");
                }
            } catch (IOException e) {
                error("Console I/O exception: " + e);
            }
        } else {
            // Erstellen der Verzeichnisstruktur
            try {
                target = Files.createDirectories(target);
            } catch (IOException e) {
                error("Exception creating target directory: " + e);
            }
        }

        CopyFileTree cft = new CopyFileTree(source, target);
        try {
            Files.walkFileTree(source, cft);
        } catch (IOException e) {
            error("WalkFileTree Exception: " + e);
        }
        System.out.println("Successfully copied " + source + " to " + target);

    }

    public static void error(String message) {
        System.err.println(message);
        System.exit(-1);
    }
}