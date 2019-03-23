/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PIDElevatorSubsystem extends Subsystem {
  
  public WPI_TalonSRX elevator = new WPI_TalonSRX(RobotMap.kelevatorPort);

  public static int TIMEOUT_MS = 20;
  public static double kP = 0.1;
  public static double kI = 0.0;
  public static double kD = 0.0;
  public static double ArbFF = 0.3;

  public PIDElevatorSubsystem(){
    elevator.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

    elevator.setSensorPhase(true);
    elevator.setInverted(true);
    elevator.configNominalOutputForward(0, 0);
    elevator.configNominalOutputReverse(0, 0);
    elevator.configPeakOutputForward(1, 0);
    elevator.configPeakOutputReverse(-1, 0);



    elevator.configAllowableClosedloopError(0, 0, 0);
    elevator.config_kF(0, 0, TIMEOUT_MS);
    elevator.config_kP(0, kP, TIMEOUT_MS);
    elevator.config_kI(0, kI, TIMEOUT_MS);
    elevator.config_kD(0, kD, TIMEOUT_MS);

  }

  public void position(double num){
    elevator.set(ControlMode.Position, num, DemandType.ArbitraryFeedForward, ArbFF);
  }

  public void manualLift(double speed){
    elevator.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, ArbFF);
  }

  public void resetEncoder(){
    elevator.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
