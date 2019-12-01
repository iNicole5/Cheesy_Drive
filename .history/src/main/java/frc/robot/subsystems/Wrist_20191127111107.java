/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.cmdWristJoystick;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



public class Wrist extends Subsystem {

  public WPI_TalonSRX wristMotor = new WPI_TalonSRX(RobotMap.wristMotor);
  public boolean PIDmodeWrist = false;
  private Encoder Wristencoder;

  public Wrist()
  {
    initWristEncoder();
    wristMotor.setNeutralMode(NeutralMode.Brake);
  }

  private void initWristEncoder()
  {
    Wristencoder = new Encoder(2, 3, false, EncodingType.k4X);
    Wristencoder.setSamplesToAverage(5);
    Wristencoder.reset();
  }

  public void wristDrive(double motor)
  {
    wristMotor.set(-motor * .75);  //55
  }

  public void stop()
  {
    wristMotor.stopMotor();
  }

  public double getWristEncoder() 
  {
    return Wristencoder.getDistance();
  }

  public void periodic() 
  {}
    SmartDashboard.putNumber("Wrist Encoder Value", getWristEncoder());
    SmartDashboard.putNumber("Wrist motor Value", wristMotor.getMotorOutputVoltage());

    if ((Math.abs(Robot.oi.Operator.getRawAxis(5)) > 0.1) && (PIDmodeWrist))
    {
      PIDmodeWrist = false;
      Command wristJoy = new cmdWristJoystick();
      wristJoy.start();
    }
  }

  public void JoystickWristBreak(Joystick joystick, double motor)
  {
    if(getWristEncoder() >= 50000)
    {
      wristMotor.set(-motor);
    } else {
      wristMotor.set(-motor * .35);
    }
  }

  public double getWristVoltage()
  {
    return wristMotor.getMotorOutputVoltage();
  }

  public void joystickWrist(Joystick joystick)
  { 
    wristMotor.set(joystick.getRawAxis(5));
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
