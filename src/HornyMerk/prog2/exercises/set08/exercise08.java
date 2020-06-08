package HornyMerk.prog2.exercises.set08;

import HornyMerk.prog2.exercises.set08.Utilities.FlexibleFileTreeWalker;
import HornyMerk.prog2.exercises.set08.Utilities.LargeFileFinder;

import java.io.IOException;

public class exercise08
{
    public static void main(String[] args) throws IOException {
        FlexibleFileTreeWalker walker = new FlexibleFileTreeWalker(new LargeFileFinder());
        walker.walk("C:\\Users\\Public");
        walker.largeWalk("C:\\Users\\Public");
        //walker.findDuplicates();
    }
}
