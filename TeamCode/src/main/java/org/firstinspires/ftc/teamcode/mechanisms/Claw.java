package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {

    Servo claw;
    Servo wrist;
    Servo arm;

    public static double convertDegToServo(double degrees){
        return (degrees - 30) / 300.0;
    }

    private double clawOpen = .2; //measured in servo units
    private double clawClosed = 0; //measured in servo units
    private double currentWristPosition = 180;  //measured in degrees
    private double currentArmPosition = 180; //Measured in degrees

    public void init(HardwareMap hwMap) {
        claw = hwMap.get(Servo.class, "claw");
        wrist = hwMap.get(Servo.class, "wrist");
        arm = hwMap.get(Servo.class, "arm");

        claw.setPosition(clawClosed);
        wrist.setPosition(convertDegToServo(currentWristPosition));
        arm.setPosition(convertDegToServo(currentArmPosition));
    }

    public void closeClaw() {
        claw.setPosition(clawClosed);
    }

    public void openClaw() {
        claw.setPosition(clawOpen);
    }

    public void moveWristUp() {
        currentWristPosition = currentWristPosition + 1;
        wrist.setPosition(convertDegToServo(currentWristPosition));
    }

    public void moveWristDown() {
        currentWristPosition = currentWristPosition - 1;
        wrist.setPosition(convertDegToServo(currentWristPosition));
    }

    public void adjustWristForArm(double armPosition) {
        currentWristPosition = 180 + (armPosition - 180);
        wrist.setPosition(convertDegToServo(currentWristPosition));
    }

    public void moveArmUp() {
        currentArmPosition = currentArmPosition + 1;
        arm.setPosition(convertDegToServo(currentArmPosition));
    }

    public void moveArmDown() {
        currentArmPosition = currentArmPosition - 1;
        arm.setPosition(convertDegToServo(currentArmPosition));
    }

    public double returnWristPosition() {
       return currentWristPosition;
    }
    public double returnArmPosition() {
        return currentArmPosition;
    }
}
