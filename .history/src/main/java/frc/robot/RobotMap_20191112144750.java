/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
    //Drive Motors 
    public static int leftMaster = 1;
    public static int leftSlave = 5;
    public static int rightMaster = 2;
    public static int rightSlave = 4;

    //Elevator
    public static int rightElevatorMaster = 8;
    public static int leftElevatorSlave = 7;

    //Wrist
    public static int wristMotor = 10;

    public static int climberWheel = 6;
}
