/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import frc.robot.RobotMap;

public class Climber extends Subsystem 
{
  public DoubleSolenoid climberArms = new DoubleSolenoid(1, 4, 5);
  public DoubleSolenoid p_BAP          = new DoubleSolenoid(0, 4, 5);
  WPI_VictorSPX climberWheel  = new WPI_VictorSPX(RobotMap.climberWheel);

  public Climber()
  {
    climberWheel.setInverted(false);
  }

  public void BigGasPiston(boolean direction)
  {
    if (direction)
    {
      p_BAP.set(Value.kForward);
    } else {
      p_BAP.set(Value.kReverse);
    }
  }

  public void ClawRelease(boolean direction)
  {
    if(direction)
    {
      climberArms.set(Value.kForward); // Release
    }else{
      climberArms.set(Value.kReverse); 
    }
  }

  public void ClimbingWheel(Boolean direction)
  {
    if(direction)
    {
      climberWheel.set(1);
    }else{
      climberWheel.set(-1); 
    }
  }

  public void climberStop() 
  {
    climberWheel.stopMotor();
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
