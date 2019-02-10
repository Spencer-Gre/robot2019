/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends PIDSubsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX elevator = new WPI_TalonSRX(RobotMap.kelevatorPort);


  public ElevatorSubsystem(){
    super("Elevator", 1.0, 0.0, 0.0);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
    LiveWindow.addActuator("Elevator", "PIDSubsystem Controller", getPIDController());
    elevator.setSelectedSensorPosition(0);
  }

  public void ToggleElevator(double position){
    elevator.pidWrite(position);
  } 

  public void TurnOffElevator(){
    elevator.pidWrite(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public double returnPIDInput() {
    return elevator.getSensorCollection().getQuadraturePosition();
  }

  @Override
  public void usePIDOutput(double output) {
    elevator.pidWrite(output);
  }
}
