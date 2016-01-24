package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Latitude on 12/27/2015.
 */
public class TestEncoder extends OpMode {
    DcMotor leftmotor;
    DcMotorController driveMotors;
    HiTechnicMotorControllerClass drive;
    public void init()
    {
        leftmotor = hardwareMap.dcMotor.get("motor1a");
        drive = new HiTechnicMotorControllerClass(driveMotors);
        drive.resetMotor1Encoder();
    }
    public void loop(){}
}
