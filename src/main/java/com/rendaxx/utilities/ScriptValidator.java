package com.rendaxx.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
/**
 * Class for validating script files.
 */
public class ScriptValidator {
    final HashSet<Path> paths = new HashSet<>();
    public boolean validate(Path path) {
        if (Files.notExists(path) || !Files.isReadable(path)) return false;
        paths.add(path);
        try (var stream = Files.lines(path)){
            var scripts = stream.filter(s -> s.startsWith("execute_script")).map(s -> s.split("\\s")).toList();
            if (scripts.isEmpty()) return true;
            if (!scripts.stream().allMatch(o -> o.length != 2)) return false;
            var scripts_paths = scripts.stream().map(o -> Path.of(o[1]).toAbsolutePath()).toList();
            if (scripts_paths.stream().anyMatch(paths::contains)) return false;
            //noinspection RedundantIfStatement
            if (!scripts_paths.stream().allMatch(this::validate)) return false;
            return true;
        } catch (IOException e) {
            System.err.println("Some shit happened while processing " + path);
            return false;
        }
    }
}
