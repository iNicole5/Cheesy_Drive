/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class cmdJoystickElevator extends Command {
  public cmdJoystickElevator() 
  {
    requires(Robot.sub_elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    Robot.sub_elevator.PIDMode = false;
    System.out.print("Joystick Command Start");
    Robot.sub_elevator.stop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    double power = Robot.oi.Operator.getRawAxis(1);
    Robot.sub_elevator.elevatorBrake(Robot.oi.Operator);
    Robot.sub_elevator.elevatorDrive(power, power);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    Robot.sub_elevator.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    end()
  }
}
