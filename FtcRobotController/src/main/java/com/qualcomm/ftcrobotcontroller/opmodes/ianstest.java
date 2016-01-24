package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Latitude on 11/25/2015.
 */
public class ianstest extends OpMode
{
    DcMotor leftmotor;
    DcMotor rightmotor;
    DcMotorController mc1;
    int ctr =0;
    int rnctr =0;
    boolean runstate = false;
    boolean runagain =true;
    boolean run3rd = false;
    DcMotorController.DeviceMode devmode;
    DcMotorController.DeviceMode devmodeRO;
    DcMotorController.DeviceMode devmodeWO;
    DcMotorController.DeviceMode devmodeSRO;
    DcMotorController.DeviceMode devmodeSWO;
    int rightPos;
    int leftPos;
    int tpos;
    int curpos;
    int togo=0;
    int inchtorun =5;
    int loopctr;
    public void motorW()
    {
        mc1.setMotorControllerDeviceMode(DcMotorController.DeviceMode.WRITE_ONLY);
        while (mc1.getMotorControllerDeviceMode()!= devmodeWO){}
        return;
    }

    public void motorR()
    {
        mc1.setMotorControllerDeviceMode(DcMotorController.DeviceMode.READ_ONLY);
        while (mc1.getMotorControllerDeviceMode()!= devmodeRO){}
        return;
    }

    public void resetEncode()
    {
        motorW();
        leftmotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightmotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motorR();
        while (leftmotor.getCurrentPosition() != 0){}
        return;
    }

    @Override
    public void init()
    {
        leftmotor = hardwareMap.dcMotor.get("motor1a");
        rightmotor = hardwareMap.dcMotor.get("motor1b");
        mc1 = hardwareMap.dcMotorController.get("m1");
        devmodeRO = DcMotorController.DeviceMode.READ_ONLY;
        devmodeWO = DcMotorController.DeviceMode.WRITE_ONLY;
        leftmotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightmotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        resetEncode();
        motorW();
        leftmotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightmotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightPos=172;
        leftPos=-172;
        run1();
        /*leftmotor.setPower(0);
        //rightmotor.setPower(0);
        motorR();
        while (rightmotor.getPower() !=0 ){
           // telemetry.addData("rt togo", togo);
            telemetry.addData("lf pos", leftmotor.getCurrentPosition());
        }
        resetEncode();
        rightPos=800;
        leftPos=800;
        run1();*/
    }
    @Override
    public void loop()
    {

        loopctr++;
        motorR();
        //tpos=rightmotor.getTargetPosition();
        //curpos=rightmotor.getCurrentPosition();
        //togo=tpos-curpos;
        telemetry.addData("left mode", leftmotor.getMode());
        telemetry.addData("lf pos", leftmotor.getCurrentPosition());
        telemetry.addData("lf to", leftmotor.getTargetPosition());
        /*if (togo<=0)
        {
           if (runagain==true)
           {
            resetEncode();
            rightPos=800;
            leftPos=800;
            run1();
            runagain=false;
            run3rd=true;
           }
            if (run3rd==true)
            {
                resetEncode();
                rightPos=6625;
                leftPos=-6625;
                run1();
                run3rd=false;
            }
        }*/
    }//end of loop
    public void run1()
    {
        motorW();
        rnctr++;
        leftmotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightmotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        telemetry.addData("runct", rnctr);
        while (togo<inchtorun)
        {
            motorW();
            rightmotor.setTargetPosition(rightPos*togo);
            leftmotor.setTargetPosition(leftPos*togo);
            leftmotor.setPower(.5);
            rightmotor.setPower(.5);
            while (ctr < 50000000)
            {
                ctr++;
            }

            motorR();
            while (leftmotor.getCurrentPosition() != leftPos) {
            }
            togo++;
        }
        motorW();
        leftmotor.setPower(0);
        rightmotor.setPower(0);
        //return;
    }
}//end of class
