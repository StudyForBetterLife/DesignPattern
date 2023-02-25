package com.design.mvc.dj.model;

import com.design.mvc.dj.BPMObserver;
import com.design.mvc.dj.BeatModelInterface;
import com.design.mvc.dj.BeatObserver;
import lombok.extern.slf4j.Slf4j;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BeatModel implements BeatModelInterface, Runnable {

    private List<BeatObserver> beatObservers = new ArrayList<>();
    private List<BPMObserver> bpmObservers = new ArrayList<>();
    private int bpm = 90;
    private Thread thread;
    private boolean stop = false;
    private Clip clip;


    @Override
    public void initialize() {
        try {
            File resource = new File("test.wav");
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.open(AudioSystem.getAudioInputStream(resource));
        } catch (Exception ex) {
            log.error("Error: Can't load clip", ex);
        }
    }

    @Override
    public void on() {
        bpm = 90;
        //notifyBPMObservers();
        thread = new Thread(this);
        stop = false;
        thread.start();
    }

    @Override
    public void off() {
        stopBeat();
        stop = true;
    }

    @Override
    public void setBPM(final int bpm) {
        this.bpm = bpm;
        notifyBPMObservers();
    }

    public void notifyBPMObservers() {
        for (BPMObserver bpmObserver : bpmObservers) {
            bpmObserver.updateBPM();
        }
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void registerObserver(final BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
    public void removeObserver(final BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    @Override
    public void registerObserver(final BPMObserver o) {
        bpmObservers.add(o);
    }

    @Override
    public void removeObserver(final BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    @Override
    public void run() {
        while (!stop) {
            playBeat();
            notifyBeatObservers();
            try {
                Thread.sleep(60000 / getBPM());
            } catch (InterruptedException e) {
                log.error("interuppted exception", e);
            }
        }
    }

    public void playBeat() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void stopBeat() {
        clip.setFramePosition(0);
        clip.stop();
    }

    public void notifyBeatObservers() {
        for (BeatObserver beatObserver : beatObservers) {
            beatObserver.updateBeat();
        }
    }

}
