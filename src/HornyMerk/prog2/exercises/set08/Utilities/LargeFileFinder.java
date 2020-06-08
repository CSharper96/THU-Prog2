package HornyMerk.prog2.exercises.set08.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LargeFileFinder
{

    public void execute(ArrayList<File> files) throws IOException
    {
        files = FileProcessor.sortFiles(files);
        for(File file : files)
            FileProcessor.process(file);
    }
    public static class FileProcessor
    {
        static public void process(File file) throws IOException
        {
            System.out.printf("%-100s%6d%n", file.getCanonicalPath(), file.length());
        }
        static public ArrayList<File> sortFiles(ArrayList<File> files)
        {
            return null;
        }
    }
}
