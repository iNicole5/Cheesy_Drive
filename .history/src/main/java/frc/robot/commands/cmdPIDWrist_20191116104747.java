/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class cmdPIDWrist extends Command {

  private PIDController pidController;
  private double wristDistance = 0;

  public cmdPIDWrist(double distance) 
  {
    requires(Robot.sub_wrist);
    this.wristDistance = distance;

    pidController = new PIDController(.00006, 0, 0, new PIDSource() //6
    {
    
      @Override
      public void setPIDSourceType(PIDSourceType pidSource) 
      {

      }
    
      @Override
      public double pidGet() 
      {
        return Robot.sub_wrist.getWristEncoder();
      }
    
      @Override
      public PIDSourceType getPIDSourceType() 
      {
        return PIDSourceType.kDisplacement;
      }
    }, new PIDOutput(){
    
      @Override
      public void pidWrite(double output) 
      {
        SmartDashboard.putNumber("wristPID", output);
        Robot.sub_wrist.wristDrive(-output);  
      }
    });
    pidController.disable();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    Robot.sub_wrist.PIDmodeWrist = true;
    pidController.setSetpoint(wristDistance);
    pidController.enable();
    System.out.println("Wrist PID started!");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    SmartDashboard.putNumber("PIDError Wrist", pidController.getError());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    //return (pidController.getError() < 0.1);
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    pidController.disable();
    Robot.sub_wrist.stop();
    System.out.println("Wrist PID ended!");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    end();
  }
}
