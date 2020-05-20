package HornyMerk.prog2.exercises.set06.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordFrequencyCounter
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
    }
    public void printResults()
    {

    }
}
