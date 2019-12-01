/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.cmdJoystickElevator;


public class Elevator extends Subsystem 
{
  WPI_TalonSRX rightElevatorMaster = new WPI_TalonSRX(RobotMap.rightElevatorMaster);
  WPI_VictorSPX leftElevatorSlave = new WPI_VictorSPX(RobotMap.leftElevatorSlave);

  public DoubleSolenoid elevatorBrake = new DoubleSolenoid(1, 6, 7);

  double feedforward = 0.07;

  public boolean PIDMode = false;

  private Encoder elevatorEncoder;

  public void elevatorBrakeOn()
  {
    elevatorBrake.set(Value.kForward);
  }

  public void elevatorBrakeOff()
  {
    elevatorBrake.set(Value.kReverse);
  }

  public Elevator()
  {
    rightElevatorMaster.setInverted(false);
    leftElevatorSlave.setInverted(false);

    rightElevatorMaster.set(ControlMode.MotionMagic, targetPos, DemandType.ArbitraryFeedForward, feedforward);
    leftElevatorSlave.set(ControlMode.MotionMagic, targetPos, DemandType.ArbitraryFeedForward, feed);)

    rightElevatorMaster.setNeutralMode(NeutralMode.Brake);
    leftElevatorSlave.setNeutralMode(NeutralMode.Brake);

    initEncoder();
  }

  private void initEncoder()
  {
    elevatorEncoder = new Encoder(0, 1, false, EncodingType.k4X);
    elevatorEncoder.setSamplesToAverage(5);
    elevatorEncoder.reset();
  }

  public void elevatorDrive(double left, double right)
  {
    rightElevatorMaster.set(-right);
    leftElevatorSlave.set(-left);
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

  public double getElevatorEncoder()
  {
    return -elevatorEncoder.getDistance();
  }

  public void elevatorBrake(Joystick joystick)
  {
    if (joystick.getRawAxis(1) < 0.35 && joystick.getRawAxis(1) > -0.35)
    {
      elevatorBrakeOn();
    } else {
      elevatorBrakeOff();
    }
  } 

  public void joystickElevator(Joystick joystick)
  {
    rightElevatorMaster.set(joystick.getRawAxis(1));
    leftElevatorSlave.set(joystick.getRawAxis(1));
  }

  public void stop()
  {
    elevatorDrive(0, 0);
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
