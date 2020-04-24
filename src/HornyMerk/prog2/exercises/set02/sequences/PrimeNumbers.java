package HornyMerk.prog2.exercises.set02.sequences;

import HornyMerk.prog2.exercises.set02.Filters.ZapMultiples;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers
{
    public List<Integer> Primes;
    public PrimeNumbers()
    {
        Naturals naturals = new Naturals();
        Primes = new ArrayList<>();
        InitArray(naturals);
    }
    private void InitArray(Naturals naturals)
    {
        naturals.Numbers.remove(0);
        ZapMultiples zapMultiples = new ZapMultiples(naturals, 2);
        naturals.Numbers = zapMultiples.PassList();
        zapMultiples = new ZapMultiples(naturals, 3);
        Primes.add(3);
        Primes.addAll(zapMultiples.PassList());
    }
}
