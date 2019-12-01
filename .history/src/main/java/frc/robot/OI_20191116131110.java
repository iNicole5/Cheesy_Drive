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
import frc.robot.CommandGroups.PIDElevatorWrist;
import frc.robot.commands.cmdArmDrop;
import frc.robot.commands.cmdBAP;
import frc.robot.commands.cmdBallIntake;
import frc.robot.commands.cmdClimberPull;
import frc.robot.commands.cmdGrabberOC;
import frc.robot.commands.cmdShift;

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
  public Button ballIntakeReverse = new JoystickButton(Driver, 3);

  public Button shifter = new JoystickButton(Driver2, 1);

  //Operator

  //public Button
  public Button linearActuatorUp = new JoystickButton(Operator, 11);  
  public Button linearActuatorDown = new JoystickButton(Operator, 10);  

  public Button climbingWheel = new JoystickButton(Operator, 6);  
  public Button climbingWheelReverse  = new JoystickButton(Operator, 7); 

  public Button releaseClimbingClaw = new JoystickButton(Operator, 8); 
  public Button attachClimbingClaw = new JoystickButton(Operator, 9);  

  //ButtonPannel
  public Button hatchLevel1 = new JoystickButton(ButtonPannel, 3);
  public Button hatchLevel2 = new JoystickButton(ButtonPannel, 4);
  public Button hatchLevel3 = new JoystickButton(ButtonPannel, 5);

  public Button ballLevel1 = new JoystickButton(ButtonPannel, 6);
  public Button ballLevel2 = new JoystickButton(ButtonPannel, 7);
  public Button ballLevel3 = new JoystickButton(ButtonPannel, 8);

  public Button groundBall = new JoystickButton(ButtonPannel, 2);
  public Button groundBall2 = new JoystickButton(ButtonPannel, 12);
  public Button groundBall3 = new JoystickButton(ButtonPannel, 11);

  public Button cargoShipBall = new JoystickButton(ButtonPannel, 10); 
  public Button humanPlayerStationHatch = new JoystickButton(ButtonPannel, 1); 

  public Joystick getDriverJoystick()
  {
    return Driver;
  }

  public Joystick getDriver2Joystick()
  {
    return Driver2;
  }

  public Joystick getOperatorJoystick()
  {
    return Operator;
  }

  public Joystick getButtonPannelJoystick()
  {
    return ButtonPannel;
  }

  public OI()
  {
    hatchLevel1.whenPressed(new PIDElevatorWrist(0, 0));        
    hatchLevel2.whenPressed(new PIDElevatorWrist(203160, 0));       
    hatchLevel3.whenPressed(new PIDElevatorWrist(384299, 0)); 

    ballLevel1.whenPressed(new PIDElevatorWrist(0,31769));     
    ballLevel2.whenPressed(new PIDElevatorWrist(134639, 6560)); 
    ballLevel3.whenPressed(new PIDElevatorWrist(317128, 7487));   
    
    groundBall.whenPressed(new PIDElevatorWrist(0, 115000));
    groundBall2.whenPressed(new PIDElevatorWrist(0, 95000));
    groundBall3.whenPressed(new PIDElevatorWrist(0, 85000));

    cargoShipBall.whenPressed(new PIDElevatorWrist(34203, 16760));
    humanPlayerStationHatch.whenPressed(new PIDElevatorWrist(38522, 28996)); //35960   //79124

    grabberButton.whenPressed(new cmdGrabberOC());

    shifter.whenPressed(new cmdShift());

    ballIntake.whileHeld(new cmdBallIntake(true));
    ballIntakeReverse.whileHeld(new cmdBallIntake(false));

    releaseClimbingClaw.whenPressed(new cmdArmDrop(true));
    attachClimbingClaw.whenPressed(new cmdArmDrop(false));

    climbingWheel.whileHeld(new cmdClimberPull(true));
    climbingWheelReverse.whileHeld(new cmdClimberPull(false));

    linearActuatorDown.whenPressed(new cmdBAP(true));
    linearActuatorUp.whenPressed(new cmdBAP(false));

  }
}
