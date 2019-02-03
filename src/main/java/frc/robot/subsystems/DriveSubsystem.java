/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Drive Subsystem. Currently uses arcade drive.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.kleftMasterPort);
  public WPI_VictorSPX leftSlave = new WPI_VictorSPX(RobotMap.kleftSlavePort);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.krightMasterPort);
  public WPI_VictorSPX rightSlave = new WPI_VictorSPX(RobotMap.krightSlavePort);

  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  public DriveSubsystem(){
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  public void telopDrive(double y, double x) {  
    drive.arcadeDrive(y, x);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
}
