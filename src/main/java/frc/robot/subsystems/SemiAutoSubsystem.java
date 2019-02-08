/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class SemiAutoSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Added by Ken. Stolen from 
  //http://docs.limelightvision.io/en/latest/getting_started.html#basic-programming
  public NetworkTable readLimeLight(){
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);

    return(table);
  }

  /*Added by Ken
  Rough code for aiming. Activate from OI.java when button held?
  http://docs.limelightvision.io/en/latest/cs_aiming.html */
  public void limeLightAim(){
    double Kp = -0.1; //TODO: optimize
    double min_command = 0.05; //TODO: optimize
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    double tx = table.getEntry("tx").getDouble(0.0);

    double heading_error = -tx;
    /*double steering_adjust = 0.0;
    if (tx > 1.0){
        steering_adjust = Kp*heading_error - min_command;
    }else if (tx < 1.0){
        steering_adjust = Kp*heading_error + min_command;
    }*/
    //TODO: use steering_adjust to alter X and Y for motors
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }
}
