package Book_5.Chapter_1.Sync;

import Book_5.Chapter_1.CountDownV1.CountDownClock;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class DoTwoThings
{
    ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);
    CountDownClock clock = new CountDownClock();

    DoTwoThings()
    {
        pool.execute(clock);
        pool.execute(clock);
        pool.shutdown();
    }

}
