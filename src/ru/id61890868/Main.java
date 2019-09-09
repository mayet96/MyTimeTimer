package ru.id61890868;


import ru.id61890868.clock.ClockMechanism;
import ru.id61890868.logger.TimeLogger;
import ru.id61890868.view.MyTimer;


class Main {


    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(System.getProperty("user.home"));
        main.init();
    }

    private void init() {
        final MyTimer timer = new MyTimer();
        final TimeLogger logger = new TimeLogger();
        final ClockMechanism mechanism = new ClockMechanism(timer::setTime);
        timer.setControls(
                e -> {
                    mechanism.startTimer();
                    logger.log("Start -> " + timer.getLogText());
                },
                e -> mechanism.pauseTimer(),
                e -> {
                    logger.log("End(total: " + mechanism.getTime() + ") -> " + timer.getLogText());
                    mechanism.stopTimer();
                    timer.setLogText("");
                }
        );
        timer.setVisible(true);
    }







}
