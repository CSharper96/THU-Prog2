package HornyMerk.prog2.exercises.set08.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FlexibleFileTreeWalker
{
    public ILargeFileFinder iLargeFileFinder;
    private ArrayList<File> _Files;
    public FlexibleFileTreeWalker()
    {
        iLargeFileFinder = new LargeFileFinder();
    }
    public void walk(String pathname) throws IOException
    {
        File[] files = new File(pathname).listFiles();
        if (files != null)
        {
            for (File file : files)
                if (file.isDirectory())
                    walk(file.getCanonicalPath());
                else FileProcessor.process(file);
        }
    }
    private void getFiles(String pathname) throws IOException
    {
        File[] files = new File(pathname).listFiles();
        if (files != null)
        {
            for (File file : files)
                if (file.isDirectory())
                    getFiles(file.getCanonicalPath());
                else _Files.add(file);
        }
    }
    public void largeWalk(String pathname) throws IOException
    {
        _Files = new ArrayList<>();
        getFiles(pathname);
        iLargeFileFinder.largeWalk(_Files);
    }

    public interface FileProcessor
    {
        static void process(File file) throws IOException
        {
            System.out.printf("%-100s%6d%n", file.getCanonicalPath(), file.length());
        }
    }
}
