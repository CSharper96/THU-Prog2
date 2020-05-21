package HornyMerk.prog2.exercises.set06;

import HornyMerk.prog2.exercises.set06.Utilities.WordFrequencyCounter;

import java.io.File;

public class exercise06
{
    public static void main(String[] args)
    {
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.analyzeText(new File("data/Song"));
        counter.printResults();
    }
}
