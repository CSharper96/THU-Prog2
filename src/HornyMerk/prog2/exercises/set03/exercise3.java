package HornyMerk.prog2.exercises.set03;

import HornyMerk.prog2.exercises.set03.General.Journey;
import HornyMerk.prog2.exercises.set03.General.Location;
import HornyMerk.prog2.exercises.set03.General.TSP;

import java.util.Scanner;

public class exercise3
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner((System.in));
        System.out.println("Please choose Leiterplatte (1-3): ");
        int num = scan.nextInt();
        if(num < 1 || num > 3) return;
        TSP travellingSalesmanProblem = new TSP(num);
        Journey journey = travellingSalesmanProblem.Init();
        System.out.println("The travelled way is:\n");
        for(int i = 0; i < journey.TravelledWay.size(); i++)
        {
            System.out.print(journey.TravelledWay.get(i).Name);
            if(i != journey.TravelledWay.size() - 1) System.out.print(" -> ");
        }
        System.out.print("\nThe distance travelled is: " + (Math.round(100.0 * journey.Way) / 100.0));
    }
}
