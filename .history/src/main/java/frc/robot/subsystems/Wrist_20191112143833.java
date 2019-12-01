/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Wrist extends Subsystem 
{
  public WPI_TalonSRX wristMotor = new WPI_TalonSRX(RobotMap.wristMotor);
  public boolean PIDModeWrist = false;
  private Encoder wristEncoder;

  private void initWristEncoder()
  {
    wristEncoder = new Encoder(2, 3, false, EncodingType.k4X);
    wristEncoder.setSamplesToAverage(5);
    wristEncoder.reset();
  }

  public double getWristEncoder()
  {
    return wristEncoder.getDistance();
  }

  public void periodic() 
  {
    SmartDashboard.putNumber("Wrist Encoder Value", getWristEncoder());
    SmartDashboard.putNumber("Wrist motor Value", wristMotor.getMotorOutputVoltage());

    if ((Math.abs(Robot.oi.Operator.getRawAxis(5)) > 0.1) && (PIDModeWrist))
    {
      PIDModeWrist = false;
      Command wristJoy = new cmdWristJoystick();
      wristJoy.start();
    }
  }

  public Wrist()
  {
    initWristEncoder();
    wristMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void wristDrive(double motor)
  {
    wristMotor.set(-motor * .55);
  }

  public void stop()
  {
    wristMotor.stopMotor();
  }

  public void joystickWristSlowDown(Joystick joystick, double motor)
  {
    if 
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
