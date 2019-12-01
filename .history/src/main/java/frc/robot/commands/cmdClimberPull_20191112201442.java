/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class cmdClimberPull extends Command 
{
  boolean diretion;
  public cmdClimberPull(boolean diretion) 
  {
    requires(Robot.sub_climber);
    this.diretion = diretion;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize()
  {
    Robot.sub_climber.climberStop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute()
  {
    Robot.sub_climber.ClimbingWheel(diretion);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    Robot.sub_climber.climberStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    Robot.sub_climber.climberStop();
  }
}
*/


/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class cmdClimberPull extends Command {
  private boolean direction;

  public cmdClimberPull(boolean direction) 
  {
    requires(Robot.sub_climber);
    this.direction = direction;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.sub_grabberOC.IntakeStop();
    Robot.sub_climber.climberStop();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    Robot.sub_grabberOC.Intake(direction);
    //Robot.sub_grabberOC.IntakeStop();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    Robot.sub_grabberOC.IntakeStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //Robot.sub_grabberOC.IntakeStop();
  }
}

