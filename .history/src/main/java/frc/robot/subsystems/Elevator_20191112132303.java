/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Elevator extends Subsystem 
{
  WPI_TalonSRX rightElevatorMaster = new WPI_TalonSRX(RobotMap.rightElevatorMaster);
  WPI_VictorSPX leftElevatorSlave = new WPI_VictorSPX(RobotMap.leftElevatorSlave);

  public DoubleSolenoid elevatorBrake = new DoubleSolenoid(1, 6, 7);

  public boolean PIDMode = false;

  private Encoder elevatorEncoder;

  public Elevator()
  {
    leftElevatorSlave.follow(rightElevatorMaster);
  }

  public void elevatorBrakeOn()
  {
    elevatorBrake.set(Value.kForward);
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
