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
import frc.robot.commands.ExtraPusherCommand;
import frc.robot.commands.TrackBallCommand;
import frc.robot.commands.ElevatorReset;
import frc.robot.commands.HatchOneCommand;
import frc.robot.commands.ElevatorZeroCommand;
import frc.robot.commands.ElevatorManualCommand;

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
  public Joystick stick2 = new Joystick(RobotMap.kjoystick2Port);  

  JoystickButton grabberForward = new JoystickButton(stick, 5);
  JoystickButton grabberReverse = new JoystickButton(stick, 10);

  JoystickButton sliderForward = new JoystickButton(stick, 6);
  JoystickButton sliderReverse = new JoystickButton(stick, 9);

  JoystickButton dropForward = new JoystickButton(stick, 13);
  JoystickButton dropReverse = new JoystickButton(stick, 14);

  JoystickButton toggleTop = new JoystickButton(stick, 7);

  JoystickButton trackBall = new JoystickButton(stick, 16);

  JoystickButton manualUp = new JoystickButton(stick2, 13);
  JoystickButton manualDown = new JoystickButton(stick2, 10);

  JoystickButton elevatorHatchOne = new JoystickButton(stick2, 7);
  JoystickButton elevatorHatchTwo = new JoystickButton(stick2, 6);
  JoystickButton elevatorHatchThree = new JoystickButton(stick2, 5);
  JoystickButton elevatorBallOne = new JoystickButton(stick2, 8);
  JoystickButton elevatorBallTwo = new JoystickButton(stick2, 9);
  JoystickButton elevatorBallThree = new JoystickButton(stick2, 10);


  JoystickButton resetElevator = new JoystickButton(stick2, 4);
  JoystickButton elevatorZero = new JoystickButton(stick2, 14);

  JoystickButton liftButton = new JoystickButton(stick, 2);
  JoystickButton reverseLift = new JoystickButton(stick, 1);
  JoystickButton reverseFront = new JoystickButton(stick, 12);
  JoystickButton reverseRear  = new JoystickButton(stick, 15);

  public OI () {
    grabberForward.whileHeld(new GrabberCommand());
    grabberReverse.whileHeld(new GrabberCommand());

    sliderForward.whenPressed(new SliderCommand(1.0));
    sliderReverse.whenPressed(new SliderCommand(-1.0));

    dropForward.whenPressed(new RearWheelCommand(0.8));
    dropReverse.whileHeld(new RearWheelCommand(-0.8));

    trackBall.whileHeld(new TrackBallCommand());

    liftButton.whileHeld(new LiftCommand(1.0));
    reverseLift.whileHeld(new LiftCommand(2.0));
    reverseFront.whileHeld(new LiftCommand(3.0));
    reverseRear.whileHeld(new LiftCommand(4.0));

    manualUp.whileHeld(new ElevatorManualCommand(0.25));
    manualDown.whileHeld(new ElevatorManualCommand(-0.1));
    

    resetElevator.whenPressed(new ElevatorReset());
    elevatorHatchOne.whenPressed(new HatchOneCommand(RobotMap.kHatchOne));
    elevatorHatchTwo.whenPressed(new HatchOneCommand(RobotMap.kHatchTwo));
    elevatorHatchThree.whenPressed(new HatchOneCommand(RobotMap.kHatchThree));
    elevatorBallOne.whenPressed(new HatchOneCommand(RobotMap.kBallOne));
    elevatorBallTwo.whenPressed(new HatchOneCommand(RobotMap.kBallTwo));
    elevatorBallThree.whenPressed(new HatchOneCommand(RobotMap.kBallThree));
    elevatorZero.whenPressed(new ElevatorZeroCommand());

    toggleTop.whenPressed(new ExtraPusherCommand());

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
