/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.cmdPIDElevator;

public class GroundPickUpball extends CommandGroup {
  /**
   * Add your docs here.
   */
  public GroundPickUpball(double ballLevelSetpoint, double wristSetpoint) {

    addParallel(new cmdPIDElevator(ballLevelSetpoint));
    addSequential(new cmdPIDWrist(wristSetpoint));

  }
}
