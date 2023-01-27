package streamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P06sortLines {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\35989\\OneDrive\\Desktop\\SoftUni\\Java Advanced\\07.StreamsFilesAndDirectories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\Files-and-Streams";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\06_output.txt";

        Path path = Paths.get(inputPath);
        List<String> sortedLines = Files.readAllLines(path)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Path output = Paths.get(outputPath);
        Files.write(output, sortedLines);
    }
}
