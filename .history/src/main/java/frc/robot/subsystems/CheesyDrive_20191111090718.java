/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class CheesyDrive extends Subsystem 
{

  WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMaster);
  WPI_VictorSPX leftSlave = new WPI_VictorSPX(RobotMap.leftSlave);
  WPI_VictorSPX rightMaster = new WPI_VictorSPX(RobotMap.rightMaster);
  WPI_TalonSRX rightslave = new WPI_TalonSRX(RobotMap.rightSlave);

  DifferentialDrive cheesyDrive = new DifferentialDrive(leftMaster, rightMaster);

  public CheesyDrive()
  {
    leftSlave.follow(leftMaster);
    rightslave.follow(rightMaster);
  }

  public void manualDrive(double move, double turn, )
  {
    cheesyDrive.curvatureDrive(move, turn, superTurn);
  }
  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }


public static void curvatureDrive(double rawAxis, double rawAxis2, boolean b) {
}
}
