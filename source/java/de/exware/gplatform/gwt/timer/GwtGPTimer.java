package de.exware.gplatform.gwt.timer;

import com.google.gwt.user.client.Timer;

import de.exware.gplatform.timer.GPTimer;
import de.exware.gplatform.timer.GPTimerTask;

public class GwtGPTimer implements GPTimer
{
    @Override
    public void schedule(final GPTimerTask task, int delay)
    {
        Timer t = new Timer()
        {
            @Override
            public void run()
            {
                task.execute();
            }
        };
        t.schedule(delay);
    }

    @Override
    public void cancel()
    {
    }

    @Override
    public void scheduleRepeating(GPTimerTask task, int delay, int interval)
    {
        Timer t = new Timer()
        {
            @Override
            public void run()
            {
                task.execute();
                if(task.isCanceled() == false)
                {
                    schedule(interval);
                }
            }
        };
        t.schedule(delay);
    }
}
