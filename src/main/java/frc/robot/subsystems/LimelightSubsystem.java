/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class LimelightSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = limelight.getEntry("tx");
  NetworkTableEntry ty = limelight.getEntry("ty");
  NetworkTableEntry tv = limelight.getEntry("tv");
  NetworkTableEntry ta = limelight.getEntry("ta");


  
  double x = tx.getDouble(0.0);
  double y = ty.getDouble(0.0);
  double area = ta.getDouble(0.0);
  double target = tv.getDouble(0);

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

  public double getArea(){
    return area;
  }

  public double getTarget(){
    return target;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
