package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanisms.Claw;

@TeleOp
public class TestOpMode extends OpMode{

    MecanumDrive drive = new MecanumDrive();
    Claw claw = new Claw();

    @Override
    public void init() {
        drive.init(hardwareMap);
        claw.init(hardwareMap);
    }

    @Override
    public void loop() {

        //drive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        if (gamepad1.a) {
            claw.openClaw();
        }

        if (gamepad1.b) {
            claw.closeClaw();
        }

        if (gamepad1.left_stick_y > 0) {
            claw.moveWristUp();
        } else if (gamepad1.left_stick_y < 0) {
            claw.moveWristDown();
        }

        String wristPositionStr = String.format("%.2f",claw.returnWristPosition());
        telemetry.addLine("Turret Position: " + wristPositionStr);
    }

}