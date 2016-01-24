package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
/**
 * Created by Latitude on 1/19/2016.
 */
public class controller_test extends OpMode {
    DcMotor motor1;
    DcMotor motor2;
    DcMotor motor3;
    DcMotor motor4;
    DcMotor motor5;
    DcMotor motor6;
    DcMotorController mc1;
    DcMotorController mc2;
    DcMotorController mc3;

    @Override
    public void init()
    {
        motor1 = hardwareMap.dcMotor.get("motor1a");
        motor2 = hardwareMap.dcMotor.get("motor1b");
        motor3 = hardwareMap.dcMotor.get("motor2a");
        motor4 = hardwareMap.dcMotor.get("motor2b");
        motor5 = hardwareMap.dcMotor.get("motor3a");
        motor6 = hardwareMap.dcMotor.get("motor3b");
        mc1 = hardwareMap.dcMotorController.get("m1");
        mc2 = hardwareMap.dcMotorController.get("m2");
        mc3 = hardwareMap.dcMotorController.get("m3");

    }
    @Override
    public void loop()
    {
        float leftY = -gamepad1.left_stick_y *.1f;
        motor1.setPower(leftY);
        motor2.setPower(leftY);
        motor3.setPower(leftY);
        motor4.setPower(leftY);
        motor5.setPower(leftY);
        motor6.setPower(leftY);
    }

}
