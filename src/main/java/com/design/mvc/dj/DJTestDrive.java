package com.design.mvc.dj;

import com.design.mvc.dj.controller.BeatController;
import com.design.mvc.dj.controller.ControllerInterface;
import com.design.mvc.dj.model.BeatModel;

public class DJTestDrive {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
