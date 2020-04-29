package HornyMerk.prog2.exercises.set03.General;

import java.util.ArrayList;
import java.util.List;

public class Journey
{
    private List<Location> _Locations;
    private Distance[][] _Distances;
    public List<Location> TravelledWay;
    public double Way;

    public Journey(List<Location> locations)
    {
        Way = 0;
        _Locations = new ArrayList<>(locations);
        _Distances = new Distance[_Locations.size()][_Locations.size()];
        TravelledWay = new ArrayList<>();
    }
    public void CreateJourney()
    {
        InitDistances();
        Travel(_Locations.get(0), false);
    }
    private void InitDistances()
    {
        int columnCounter = 0;
        for(Location locationColumn : _Locations)
        {
            int rowCounter = 0;
            for(Location locationRow : _Locations)
            {
                _Distances[columnCounter][rowCounter] = new Distance(locationColumn, locationRow);
                rowCounter++;
            }
            columnCounter++;
        }
    }
    private void Travel(Location actualCoord, boolean isLastElement)
    {
        TravelledWay.add(actualCoord); //start at A
        if(!isLastElement)
            GetNextCoordinate(TravelledWay.get(TravelledWay.size() - 1), isLastElement);
    }
    private void GetNextCoordinate(Location actualCoord, boolean isLastElement)
    {
        Location nextCoordinate = null;
        for(int i = 0; i < _Locations.size(); i++)
        {
            if(actualCoord.equals(_Distances[i][0].A))
            {
                Distance shortest = null;
                for(int j = 0; j < _Locations.size(); j++)
                {
                    boolean isInList = false;
                    for(Location alreadyVisited : TravelledWay)
                    {
                        if(_Distances[i][j].B.equals(alreadyVisited))
                        {
                            isInList = true;
                            break;
                        }
                    }
                    if(isInList)continue;

                    if(shortest == null)
                        shortest = _Distances[i][j];
                    else if (shortest.Length > _Distances[i][j].Length || shortest.Length <= 0)
                        shortest = _Distances[i][j];
                    else continue;
                }
                if(shortest != null)
                {
                    nextCoordinate = shortest.B;
                    Way += shortest.Length;
                    break;
                }
                else
                {
                    isLastElement = true;
                    nextCoordinate = _Distances[i][0].B;
                    Way += _Distances[i][0].Length;
                    break;
                }
            }
        }
        Travel(nextCoordinate, isLastElement);
    }
    private void LookupCoordinate()
    {

    }
}
