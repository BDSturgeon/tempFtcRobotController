package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {

    Servo claw;

    public void init(HardwareMap hwMap) {
        claw = hwMap.get(Servo.class, "Claw");
    }

    public void closeClaw(){
        claw.setPosition(0);
    }

    public void openClaw(){
        claw.setPosition(.5);
    }
}
