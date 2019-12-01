/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.cmdBallIntake;
import frc.robot.commands.cmdCheesyDrive;
import frc.robot.commands.cmdJoystickElevator;
import frc.robot.commands.cmdShift;
import frc.robot.commands.cmdWristJoystick;
import frc.robot.subsystems.CheesyDrive;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.GrabberOpenClose;
import frc.robot.subsystems.Wrist;;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static CheesyDrive sub_CheesyDrive = new CheesyDrive();
  public static Elevator sub_elevator = new Elevator();
  public static Wrist sub_wrist = new Wrist();
  public static Climber sub_climber = new Climber();
  public static GrabberOpenClose sub_grabberOC = new GrabberOpenClose();
  public static OI oi = new OI();

  Command cmdWristJotstick = new cmdWristJoystick();
  Command cmdShift = new cmdShift();
  Command cmdCheesyDrive = new cmdCheesyDrive();
  Command cmdJoystickElevator = new cmdJoystickElevator();

  Compressor compressor = new Compressor(0);


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    CameraServer.getInstance().startAutomaticCapture();

    compressor.setClosedLoopControl(true);
    compressor.start();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }


  @Override
  public void autonomousInit() {
    cmdCheesyDrive.start();
    cmdWristJotstick.start();
    cmdJoystickElevator.start();
    cmd
   
  }


  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
