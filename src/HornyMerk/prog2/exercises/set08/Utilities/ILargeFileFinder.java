package HornyMerk.prog2.exercises.set08.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface ILargeFileFinder {
    void largeWalk(ArrayList<File> files) throws IOException;
}
