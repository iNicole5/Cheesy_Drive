/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Wrist extends Subsystem 
{
  public WPI_TalonSRX wristMotor = new WPI_TalonSRX(RobotMap.wristMotor);
  public boolean PIDModeWrist = false;
  private Encoder wristEncoder;

  private void initWristEncoder()
  {
    wristEncoder = new Encoder(2, 3, false, EncodingType.k4X);
    wristEncoder
  }

  public Wrist()
  {
    init
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}