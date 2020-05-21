package HornyMerk.prog2.exercises.set06.Utilities;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class WordFrequencyCounter extends Collector
{
    public void analyzeText(File textFile)
    {
        try
        {
            BufferedReader in =
                    new BufferedReader(new FileReader(textFile));// Iterate through each line of the file
            while(true)
            {
                String currLine = in.readLine();
                if(currLine == null)break;
                analyzeLine(currLine);
            }
        }
        catch(IOException ex)
        {
            System.out.println("Error occurred while reading from "+ textFile.getAbsolutePath() + ":");
            System.out.println(ex);
        }
    }
    private void analyzeLine(String line)
    {
        System.out.println(line);
        LineCount++;
        String[] words = line.split("\\s+");
        for (String s: words)
        {
            add(s.toLowerCase());
            WordCount++;
        }
    }
    public void printResults()
    {
        System.out.println("\n\n");
        System.out.println("Line Count: " + LineCount);
        System.out.println("Word Count: " + WordCount);
        sort();
        int i = 0;
        for (HashMap.Entry<String, Integer> entry: CollectedWords.entrySet())
        {
            if(entry.getKey().equals(""))continue;
            if(i != 4)
            {
                System.out.printf("%10s : %3d\t", entry.getKey(), entry.getValue());
                i++;
            }
            else
            {
                System.out.printf("%10s : %3d\n", entry.getKey(), entry.getValue());
                i = 0;
            }
        }
    }
}
