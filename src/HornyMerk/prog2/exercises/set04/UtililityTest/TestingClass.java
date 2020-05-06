package HornyMerk.prog2.exercises.set04.UtililityTest;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestingClass
{
    private long _TimeStart = 0;
    private long _TimeEnd = 0;
    private long _TimeNeeded = 0;
    private ArrayList<Integer> _ArrayList;
    private LinkedList<Integer> _LinkedList;
    private final int _Const = 50000;

    public void StartUtilityTest()
    {
        _ArrayList = new ArrayList<>();
        _LinkedList = new LinkedList<>();
        AppendTest();
        _ArrayList = new ArrayList<>();
        _LinkedList = new LinkedList<>();
        InsertTest();
        IndexAccess();
        IterationAccess();
    }
    private void AppendTest()
    {
        StartMeasure();
        {
            for(int i = 0; i < _Const; i++)
            {
                _ArrayList.add(i);
            }
        }
        EndMeasure();
        System.out.println("Exercise 1 (ArrayList) wasted " + _TimeNeeded + " ms of our time!");

        StartMeasure();
        {
            for(int i = 0; i < _Const; i++)
            {
                _LinkedList.add(i);
            }
        }
        EndMeasure();
        System.out.println("Exercise 1 (LinkedList) wasted " + _TimeNeeded + " ms of our time!");
    }
    private void InsertTest()
    {
        StartMeasure();
        {
            for(int i = 0; i < _Const; i++)
            {
                _ArrayList.add(0, i);
            }
        }
        EndMeasure();
        System.out.println("Exercise 2 (ArrayList) wasted " + _TimeNeeded + " ms of our time!");

        StartMeasure();
        {
            for(int i = 0; i < _Const; i++)
            {
                _LinkedList.add(0, i);
            }
        }
        EndMeasure();
        System.out.println("Exercise 2 (LinkedList) wasted " + _TimeNeeded + " ms of our time!");
    }
    private void IndexAccess()
    {
        StartMeasure();
        {
            for(int i = 0; i < _Const; i++)
            {
                int j = _ArrayList.get(i);
            }
        }
        EndMeasure();
        System.out.println("Exercise 3 (ArrayList) wasted " + _TimeNeeded + " ms of our time!");

        StartMeasure();
        {
            for(int i = 0; i < _Const; i++)
            {
                int j = _LinkedList.get(i);
            }
        }
        EndMeasure();
        System.out.println("Exercise 3 (LinkedList) wasted " + _TimeNeeded + " ms of our time!");
    }
    private void IterationAccess()
    {
        StartMeasure();
        {
            for(int i : _ArrayList)
            {
                int j = i;
            }
        }
        EndMeasure();
        System.out.println("Exercise 4 (ArrayList) wasted " + _TimeNeeded + " ms of our time!");

        StartMeasure();
        {
            for(int i : _LinkedList)
            {
                int j = i;
            }
        }
        EndMeasure();
        System.out.println("Exercise 4 (LinkedList) wasted " + _TimeNeeded + " ms of our time!");
    }
    private void StartMeasure()
    {
        _TimeStart = System.currentTimeMillis();
    }
    private void EndMeasure()
    {
        _TimeEnd = System.currentTimeMillis();
        _TimeNeeded = _TimeEnd - _TimeStart;
    }
}
