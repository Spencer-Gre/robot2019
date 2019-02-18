/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  public static int kjoystickPort = 0;

  public static int kleftMasterPort = 0;
  public static int kleftSlavePort = 1;
  public static int krightMasterPort = 2;
  public static int krightSlavePort = 3;

  public static int kelevatorPort = 5;
  public static int sliderPort = 1;
  public static int grabberPort = 0;
  public static int dropMotorPort = 2;

  public int ElevatorPos = 0;

  public static int kHatch = 1000;
  public static int kBall = 500;

}
