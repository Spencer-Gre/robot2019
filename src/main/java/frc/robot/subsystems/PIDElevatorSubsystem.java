/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PIDElevatorSubsystem extends Subsystem {
  
  public WPI_TalonSRX elevator = new WPI_TalonSRX(RobotMap.kelevatorPort);

  public PIDElevatorSubsystem(){
    elevator.configSelectedFeedbackSensor(FeedbackDevice.Tachometer, 0, 0);
    elevator.setSensorPhase(true);
    elevator.setInverted(false);
    elevator.selectProfileSlot(0, 0);
    elevator.config_kF(0, 0.474, 0);
    elevator.config_kP(0, 0.629, 0);
    elevator.config_kI(0, 0, 0);
    elevator.config_kD(0, 0, 0);
    elevator.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 0);
    elevator.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 0);

    elevator.configNominalOutputForward(0, 0);
    elevator.configNominalOutputReverse(0, 0);
    elevator.configPeakOutputForward(0, 0);
    elevator.configPeakOutputReverse(0, 0);

    elevator.configMotionAcceleration(4000, 0);
    elevator.configMotionCruiseVelocity(4000, 0);
  }

  public void motionMagic(double num){
    elevator.set(ControlMode.MotionMagic, num);
  }

  public void gotoZero(){
    elevator.set(ControlMode.MotionMagic, 0);
  }

  public void resetEncoder(){
    elevator.setSelectedSensorPosition(0, 0, 0);
  }

  public void gotoHatchOne(){
    elevator.set(ControlMode.MotionMagic, 1500);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
