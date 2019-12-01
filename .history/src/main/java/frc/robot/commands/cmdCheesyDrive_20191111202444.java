/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class cmdCheesyDrive extends Command {
  public cmdCheesyDrive() 
  {
    requires(Robot.sub_CheesyDrive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    double move = Robot.oi.Driver.getRawAxis(1);
    double turn = -Robot.oi.Driver2.getRawAxis(0);

    boolean superTurn = Robot.oi.ButtonPannel.getRawButton(1);

    Robot.sub_CheesyDrive.manualDrive(move, turn, superTurn);

    if (-move == Robot.oi.Driver.getRawAxis(1))
    {
      turn = Robot.oi.Driver2.getRawAxis(0);
    } else if( move == Robot.oi.Driver.get)
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

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {

  }
}