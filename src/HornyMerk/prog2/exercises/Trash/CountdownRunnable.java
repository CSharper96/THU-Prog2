package HornyMerk.prog2.exercises.Trash;

public class CountdownRunnable implements Runnable
{
    private volatile boolean isCanceled = false;
    @Override
    public void run()
    {
        isCanceled = false;
        for(int i = 10; i >= 0 && !isCanceled; i--)
        {
            print(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    void print(int counter)
    {
        System.out.println(counter + " ... (Countdown Runnable)");
    }
    public void cancel()
    {
        isCanceled = true;
    }
}
