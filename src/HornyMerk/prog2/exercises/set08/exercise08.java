package HornyMerk.prog2.exercises.set08;

import HornyMerk.prog2.exercises.set08.Utilities.FileTreeWalker;
import HornyMerk.prog2.exercises.set08.Utilities.FlexibleFileTreeWalker;

import java.io.IOException;

public class exercise08
{
    public static void main(String[] args) throws IOException {
        FlexibleFileTreeWalker walker = new FlexibleFileTreeWalker();
        walker.walk("C:\\Users\\Public");
        walker.largeWalk("C:\\Users\\Public");
        //walker.findDuplicates();
    }
}
