package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class teleop extends OpMode
{
    //define the motors
    DcMotor leftmotor;
    DcMotor rightmotor;
    DcMotor elbow;
    DcMotor ls1;
    DcMotor ls2;
    //define the motor controllers
    DcMotorController mc1;
    DcMotorController mc2;
    DcMotorController mc3;
    //define the variables


      @Override
    public void init()
    {
        leftmotor = hardwareMap.dcMotor.get("motor1a");
        rightmotor = hardwareMap.dcMotor.get("motor1b");
        ls1 = hardwareMap.dcMotor.get("motor2a");
        ls2 = hardwareMap.dcMotor.get("motor2b");
        elbow = hardwareMap.dcMotor.get("motor3a");
        mc1 = hardwareMap.dcMotorController.get("m1");
        mc2 = hardwareMap.dcMotorController.get("m2");
        mc3 = hardwareMap.dcMotorController.get("m3");

    }

    @Override
    public void loop()
    {
        float leftY = gamepad1.left_stick_y *.85f;
        float rightY = -gamepad1.right_stick_y *.85f;
        float ls1Y = -gamepad2.left_stick_y;
        float ls2Y = gamepad2.right_stick_y;
        rightmotor.setPower(rightY);
        leftmotor.setPower(leftY);
        ls1.setPower(ls1Y);
        ls2.setPower(ls2Y);

    }//end of loop
}//end of class
