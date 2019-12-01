/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class cmdWristJoystick extends Command {

  //private OI oi = Robot.oi;  
  //private Joystick wristJoy = oi.Operator;

  public cmdWristJoystick() 
  {
    requires(Robot.sub_wrist);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    Robot.sub_wrist.PIDmodeWrist = false;
    System.out.println("Wrist Joystick Command start");
    Robot.sub_wrist.stop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
   double move = -Robot.oi.Operator.getRawAxis(1); 
   Robot.sub_wrist.JoystickWristBreak(Robot.oi.Operator, move);
   //Robot.sub_wrist.wristDrive(move); 
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
    Robot.sub_wrist.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    end(); 
  }
}
