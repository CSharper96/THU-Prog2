package HornyMerk.prog2.exercises.set04.General;

import java.util.ArrayList;
import java.util.List;

public class Train extends Locomotive
{
    public Locomotive Locomotive;

    public Train(Locomotive locomotive)
    {
        super(locomotive.Type, locomotive.Length);
        Locomotive = locomotive;
    }
    public void Relink(Locomotive locomotive)
    {
        while (locomotive.HasCars())
        {
            this.Add(this.GetIndex(), locomotive.RemoveFirst());
        }
    }
}
