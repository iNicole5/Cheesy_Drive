/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
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

    rightElevatorMaster.setInverted(false);
    leftElevatorSlave.setInverted(InvertType.FollowMaster);

    rightElevatorMaster.setNeutralMode(NeutralMode.Brake);
    leftElevatorSlave.setNeutralMode(NeutralMode.Brake);
  }

  private void initEncoder()
  {
    elevatorEncoder = new Encoder(0, 1, false, EncodingType.k4X);
    elevatorEncoder.setSamplesToAverage(5);
    elevatorEncoder.reset();
  }

  public double getElevatorEncoder()
  {
    return -elevatorEncoder.getDistance();
  }

  public void resetEncoder()
  {
    elevatorEncoder.reset();
  }

  public void periodic()
  {
    SmartDashboard.putNumber("Elevator Encoder", getElevatorEncoder());

    if ((Math.abs(Robot.oi.Operator.getRawAxis(1)) > 0.1 ) && (PIDMode))
    {
      PIDMode = false;
      Command joy = new cmdJoystickElevator();
      joy.start();
    }
  }

  public void elevatorBrakeOn()
  {
    elevatorBrake.set(Value.kForward);
  }

  public void elevatorBrakeOff()
  {
    elevatorBrake.set(Value.kReverse);
  }

  public void elevatorBrake(Joystick joystick)
  {
    if (joystick.getRawAxis(1) < 0.35 && joystick.getRawAxis(1) > -0.35)
    {
      ele
    }
  } 

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
