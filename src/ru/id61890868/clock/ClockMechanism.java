package ru.id61890868.clock;

import ru.id61890868.utils.DoIt;

import java.sql.Time;
import java.util.Date;
import javax.swing.*;

public class ClockMechanism {

        private boolean active = false;
        private final Timer timer;
        private Time time;
        private final DoIt<String> setTime;
        private java.util.Date tikStart;

        public ClockMechanism(final DoIt<String> setTime) {

            this.setTime = setTime;
            time = new Time(0, 0, 0);
            this.timer = new Timer(1000, e -> {
                Date tikNow = new Date();
                time.setTime(time.getTime() + ((tikNow.getTime())- tikStart.getTime()));
                tikStart = tikNow;
                setTime.doIt(time.toString());
            });
        }

        public void startTimer() {
            active = true;
            tikStart = new Date();
            timer.start();
        }

        public void pauseTimer() {
            active = false;
            timer.stop();
        }

        public void stopTimer() {
            active = false;
            timer.stop();
            time = new Time(0,0,0);
            setTime.doIt(time.toString());

        }

        public boolean isActive() {
            return active;
        }

    public String getTime() {
        return time.toString();
    }
}