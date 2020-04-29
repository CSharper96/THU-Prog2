package HornyMerk.prog2.exercises.set03.General;

import java.util.ArrayList;
import java.util.List;

public class TSP
{
    public List<Location> Locations = new ArrayList<>();
    private int _ChoosenOne;

    public TSP(int num)
    {
        _ChoosenOne = num;
    }
    public Journey Init()
    {
        Journey journey = null;
        switch (_ChoosenOne)
        {
            case 1:
            {
                journey = InitTSP1();
                break;
            }
            case 2:
            {
                journey = InitTSP2();
                break;
            }
            case 3:
            {
                journey = InitTSP3();
                break;
            }
            default:
            {
                break;
            }
        }
        return journey;
    }
    private Journey InitTSP1()
    {
        CreateCoordinates1();
        Journey journey = new Journey(Locations);
        journey.CreateJourney();
        return journey;
    }
    private void CreateCoordinates1()
    {
        Locations.add(new Location(1, 1, "A"));
        Locations.add(new Location(1, 2, "B"));
        Locations.add(new Location(2, 1, "C"));
        Locations.add(new Location(2, 2, "D"));
        Locations.add(new Location(3, 1, "E"));
        Locations.add(new Location(3, 2, "F"));
    }
    private Journey InitTSP2()
    {
        CreateCoordinates2();
        Journey journey = new Journey(Locations);
        journey.CreateJourney();
        return journey;
    }
    private void CreateCoordinates2()
    {
        Locations.add(new Location(1, 1, "A"));
        Locations.add(new Location(1, 2, "B"));
        Locations.add(new Location(1, 3, "C"));
        Locations.add(new Location(1, 4, "D"));
        Locations.add(new Location(2, 2, "E"));
        Locations.add(new Location(2, 3, "F"));
        Locations.add(new Location(4, 1, "G"));
        Locations.add(new Location(4, 4, "H"));
        Locations.add(new Location(4, 5, "I"));
        Locations.add(new Location(4, 6, "J"));
        Locations.add(new Location(4, 7, "K"));
    }
    private Journey InitTSP3()
    {
        CreateCoordinates3();
        Journey journey = new Journey(Locations);
        journey.CreateJourney();
        return journey;
    }
    private void CreateCoordinates3()
    {
        Locations.add(new Location(1, 1, "A"));
        Locations.add(new Location(1, 2, "B"));
        Locations.add(new Location(1, 3, "C"));
        Locations.add(new Location(1, 4, "D"));
        Locations.add(new Location(2, 2, "E"));
        Locations.add(new Location(2, 3, "F"));
        Locations.add(new Location(4, 1, "G"));
        Locations.add(new Location(4, 4, "H"));
        Locations.add(new Location(4, 5, "I"));
        Locations.add(new Location(4, 6, "J"));
        Locations.add(new Location(4, 7, "K"));
        Locations.add(new Location(5, 1, "L"));
        Locations.add(new Location(5, 4, "M"));
        Locations.add(new Location(5, 5, "N"));
        Locations.add(new Location(5, 6, "O"));
    }
}
