package ru.id61890868.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyTimer {

    static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    static GraphicsDevice[] screens = ge.getScreenDevices();
    private JFrame frame;
    private JButton start;
    private JButton pause;
    private JButton stop;
    private JButton exit;
    private JTextField timerScreen;
    private JTextField logField;

    public MyTimer() {
        frame = new JFrame("Time Timer", screens[0].getDefaultConfiguration());
        frame.setUndecorated(true);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen(), e.getYOnScreen());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setAlwaysOnTop(true);

        frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", true);

        frame.getContentPane().setLayout(new BorderLayout());
        start = new JButton("|>");
        pause = new JButton("||");
        stop = new JButton("|=|");
        exit = new JButton("exit");
        exit.addActionListener(e -> System.exit(0));

        JPanel controls = new JPanel();
        controls.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        controls.add(start);
        controls.add(pause);
        controls.add(stop);
        controls.add(exit);

        logField = new JTextField("");

        frame.getContentPane().add(logField,BorderLayout.CENTER);

        frame.getContentPane().add(controls, BorderLayout.NORTH);

        timerScreen = new JTextField(" ");
        timerScreen.setEnabled(false);
        frame.getContentPane().add(timerScreen, BorderLayout.SOUTH);

        frame.pack();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public void setControls(ActionListener start, ActionListener pause, ActionListener stop){
        this.start.addActionListener(start);
        this.pause.addActionListener(pause);
        this.stop.addActionListener(stop);
    }

    public String getLogText(){
        return logField.getText();
    }

    public void setLogText(String text){
        logField.setText(text);
    }

    public void setTime(String time) {
        timerScreen.setText(time);
    }
}