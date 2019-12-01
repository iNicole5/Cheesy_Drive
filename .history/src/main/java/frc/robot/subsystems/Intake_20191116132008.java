/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public WPI_TalonSRX intakeMotor = new WPI_TalonSRX(RobotMap.intakeMotor);

public class Intake extends Subsystem {

  public void Intake(boolean direction)
  {
    if(direction)
    {
      intakeMotor.set(1);
    }else{
      intakeMotor.set(-1); 
    }
  }

public void IntakeStop() 
{
  intakeMotor.stopMotor();
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
