/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
//import frc.robot.Robot;
//import frc.robot.RobotMap;
//import frc.robot.commands.cmdBallIntake;
import frc.robot.RobotMap;
import frc.robot.commands.cmdBallIntake;


public class GrabberOpenClose extends Subsystem {

//public Joystick Operator = new Joystick(1);

public boolean IntakeMode = false;

public WPI_TalonSRX intakeMotor = new WPI_TalonSRX(RobotMap.intakeMotor);

public DoubleSolenoid p_gripper = new DoubleSolenoid(1, 2, 3);

public GrabberOpenClose() {
  //gripperMotor.setInverted(false);
  //gripperMotor.setSafetyEnabled(true);
}

public void GrabberOC() {
  if (p_gripper.get() == Value.kForward)
  {
    p_gripper.set(Value.kReverse);
  } else {
    p_gripper.set(Value.kForward);
  }
}

public void Intake(Joystick joystick)
{
  if (joystick.getRawAxis(2) > .5)
  {
    System.out.println("Left Intake");
    System.out.println(joystick.getRawAxis(2));
    System.out.println(joystick.getRawAxis(3));
    intakeMotor.set(joystick.getRawAxis(2)); 
  }

  if(joystick.getRawAxis(3) > .5)
    {
      System.out.println("Right Intake");
      System.out.println(joystick.getRawAxis(2));
      System.out.println(joystick.getRawAxis(3));
      intakeMotor.set(-joystick.getRawAxis(3));  
    }
}

public void IntakeStop() 
{
  intakeMotor.stopMotor();
}

public void periodic()
{
  if ((Math.abs(Robot.oi.Driver.getRawAxis(2)) > 0.1 || (Math.abs(Robot.oi.Driver.getRawAxis(3)) > 0.1) && (IntakeMode)))
    {
      IntakeMode = false;
      Command joy = new cmdBallIntake();
      joy.start();
    }
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
