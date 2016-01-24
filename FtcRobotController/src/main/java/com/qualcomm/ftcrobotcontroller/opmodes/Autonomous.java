package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Latitude on 1/3/2016.
 */
public class Autonomous extends OpMode {
    DcMotor leftmotor;
    DcMotor rightmotor;
    DcMotorController mc1;
    int ctr =0;
    boolean rmstate;
    boolean lmstate;
    DcMotorController.DeviceMode devmode;
    DcMotorController.DeviceMode devmodeRO;
    DcMotorController.DeviceMode devmodeWO;
    DcMotorController.DeviceMode devmodeSRO;
    DcMotorController.DeviceMode devmodeSWO;

public void motorW(){
    mc1.setMotorControllerDeviceMode(DcMotorController.DeviceMode.WRITE_ONLY);
    while (mc1.getMotorControllerDeviceMode()!= devmodeWO){}
return;
}

    public void motorR(){
        mc1.setMotorControllerDeviceMode(DcMotorController.DeviceMode.READ_ONLY);
        while (mc1.getMotorControllerDeviceMode()!= devmodeRO){}
        return;
    }

    public void resetEncode(){
        motorW();
        leftmotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightmotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motorR();
        while (leftmotor.getCurrentPosition() != 0){}
        return;

    }




    @Override
    public void init() {
        leftmotor = hardwareMap.dcMotor.get("motor1a");
        rightmotor = hardwareMap.dcMotor.get("motor1b");
        mc1 = hardwareMap.dcMotorController.get("m1");
        devmodeRO = DcMotorController.DeviceMode.READ_ONLY;
        devmodeWO = DcMotorController.DeviceMode.WRITE_ONLY;
        leftmotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightmotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        leftmotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightmotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motorR();
        //mc1.setMotorControllerDeviceMode(DcMotorController.DeviceMode.READ_ONLY);
        //while (mc1.getMotorControllerDeviceMode()!= devmodeRO){}
        while (leftmotor.getCurrentPosition() != 0){telemetry.addData("waiting",leftmotor.getCurrentPosition());}

        mc1.setMotorControllerDeviceMode(DcMotorController.DeviceMode.WRITE_ONLY);
        while (mc1.getMotorControllerDeviceMode()!= devmodeWO){}

        leftmotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightmotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);


        leftmotor.setTargetPosition(12000);
        rightmotor.setTargetPosition(12000);
        leftmotor.setPower(.1);
        rightmotor.setPower(.1);

        mc1.setMotorControllerDeviceMode(DcMotorController.DeviceMode.READ_ONLY);
        while (mc1.getMotorControllerDeviceMode()!= devmodeRO){}
        while (leftmotor.getCurrentPosition() < 12000){}
        mc1.setMotorControllerDeviceMode(DcMotorController.DeviceMode.WRITE_ONLY);
        while (mc1.getMotorControllerDeviceMode()!= devmodeWO){}
        leftmotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightmotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        while (leftmotor.getCurrentPosition() != 0){}

    }

    @Overide
    public void loop() {



    }
}