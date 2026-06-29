package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {

    Servo claw;
    Servo wrist;

    private double currentWristPosition = .5;

    public void init(HardwareMap hwMap) {
        claw = hwMap.get(Servo.class, "claw");
        wrist = hwMap.get(Servo.class, "wrist");
        claw.setPosition(0);
        wrist.setPosition(currentWristPosition);
    }

    public void closeClaw() {
        claw.setPosition(0);
    }

    public void openClaw() {
        claw.setPosition(.2);
    }

    public void moveWristUp() {
        currentWristPosition = currentWristPosition + 1.0/300;
        wrist.setPosition(currentWristPosition);
    }

    public void moveWristDown() {
        currentWristPosition = currentWristPosition - 1.0/300;
        wrist.setPosition(currentWristPosition);
    }

    public double returnWristPosition() {
       return currentWristPosition * 300;
    }
}
