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
import frc.robot.subsystems.Elevator;

public class cmdPIDElevator extends Command {

  private PIDController pidController;
  public double elevatorDistance = 0;
  
  public cmdPIDElevator(double distance) 
  {
    requires(Robot.sub_elevator);
    this.elevatorDistance = distance;

    pidController = new PIDController(0.00005, 0, 0, new PIDSource()
    {
    
      @Override
      public void setPIDSourceType(PIDSourceType pidSource) {
        
      }
    
      @Override
      public double pidGet() {
        return Robot.sub_elevator.getElevatorEncoder();
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
        Robot.sub_elevator.elevatorDrive(output, output);
      }
    });
    pidController.disable();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    Robot.sub_elevator.PIDMode = true;
    pidController.setSetpoint(elevatorDistance);
    pidController.enable();
    System.out.println("PID started!");
    Robot.sub_elevator.elevatorBrakeOff();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    SmartDashboard.putNumber("PIDError Elevator", pidController.getError());
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
    pidController.disable();
    Robot.sub_elevator.stop();
    System.out.println("PID ended!");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    end();
  }
    
  }
