package com.design.mvc.dj;

public interface BeatModelInterface {

    /**
     * 사용자의 입력을 controller가 model에게 전달할 때 사용하는 메소드들
     */
    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    /**
     * view, controller가 상태를 알아내거나 observer로 등록할 때 사용하는 메소드들.
     */

    int getBPM();

    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);
}
