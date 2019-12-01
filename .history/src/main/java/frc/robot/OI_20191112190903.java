/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.cmdBallIntake;
import frc.robot.commands.cmdGrabberOC;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
  public Joystick Driver = new Joystick(0);
  public Joystick Driver2 = new Joystick(1);
  public Joystick Operator = new Joystick(2);
  public Joystick ButtonPannel = new Joystick(3);

  //Driver
  public Button grabberButton = new JoystickButton(Driver, 1);  
  public Button ballIntake =  new JoystickButton(Driver, 2);
  public Button ballIntakeReverse = new JoystickButton(Driver, buttonNumber)

  public Button shifter = new JoystickButton(Driver2, 1);

  
  public OI()
  {
    grabberButton.whenPressed(new cmdGrabberOC());

    ballIntake.whileHeld(new cmdBallIntake(true));

  }
}
