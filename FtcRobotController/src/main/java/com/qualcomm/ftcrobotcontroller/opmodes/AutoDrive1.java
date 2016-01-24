package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Latitude on 12/27/2015.
 */
public class AutoDrive1 extends OpMode {

    //DcMotor rightmotor;
    DcMotor leftmotor;
    DcMotorController driveMotors;
    DcMotorController.DeviceMode devmode;

   public void init()
   {
       leftmotor = hardwareMap.dcMotor.get("motor1a");
       //rightmotor = hardwareMap.dcMotor.get("motor1b");
       //rightmotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
       driveMotors=hardwareMap.dcMotorController.get("m1");
       devmode=DcMotorController.DeviceMode.READ_WRITE;
       leftmotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

   }


    public void loop()
    {

        if(leftmotor.getCurrentPosition()<1200) {
            leftmotor.setPower(.2);
            //rightmotor.setPower(-.2);
        }
        else {
            leftmotor.setPower(0);
            //rightmotor.setPower(0);
        }
    }
}