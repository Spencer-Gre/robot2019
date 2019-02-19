/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.GrabberCommand;
import frc.robot.commands.SliderCommand;
import frc.robot.commands.LiftCommand;
import frc.robot.commands.RearWheelCommand;
import frc.robot.commands.TrackBallCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public boolean m_LimelightHasValidTarget = false;
  public double m_LimelightDriveCommand = 0.0;
  public double m_LimelightSteerCommand = 0.0;
  
  //Instantiate Joystick with port
  public Joystick stick = new Joystick(RobotMap.kjoystickPort);  

  JoystickButton grabberForward = new JoystickButton(stick, 6);
  JoystickButton grabberReverse = new JoystickButton(stick, 9);

  JoystickButton sliderForward = new JoystickButton(stick, 7);
  JoystickButton sliderReverse = new JoystickButton(stick, 8);

  JoystickButton dropForward = new JoystickButton(stick, 13);
  JoystickButton dropReverse = new JoystickButton(stick, 14);

  JoystickButton trackBall = new JoystickButton(stick, 16);

  //JoystickButton elevatorHatchOne = new JoystickButton(stick, 5);
  //JoystickButton resetElevator = new JoystickButton(stick, 4);
  //JoystickButton elevatorZero = new JoystickButton(stick, 10);

  JoystickButton elevatorButton = new JoystickButton(stick, 5);

  JoystickButton liftButton = new JoystickButton(stick, 2);
  JoystickButton reverseLift = new JoystickButton(stick, 1);

  public OI () {
    grabberForward.whileHeld(new GrabberCommand());
    grabberReverse.whileHeld(new GrabberCommand());

    sliderForward.whenPressed(new SliderCommand(1.0));
    sliderReverse.whenPressed(new SliderCommand(-1.0));

    dropForward.whenPressed(new RearWheelCommand(0.25));
    dropReverse.whileHeld(new RearWheelCommand(-0.25));

    trackBall.whileHeld(new TrackBallCommand());

    liftButton.whileHeld(new LiftCommand(1.0));
    reverseLift.whileHeld(new LiftCommand(2.0));


    //resetElevator.whenPressed(new ElevatorForceZero());
    //elevatorHatchOne.whenPressed(new HatchOneCommand());
    //elevatorZero.whenPressed(new ElevatorZeroCommand());

  }

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:


  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
