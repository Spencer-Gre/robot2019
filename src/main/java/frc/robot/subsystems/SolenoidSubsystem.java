/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SolenoidSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  DoubleSolenoid leftFront = new DoubleSolenoid(0, 1);
  DoubleSolenoid rightFront = new DoubleSolenoid(2, 3);
  DoubleSolenoid backCenter = new DoubleSolenoid(4, 5);

  public void TurnOnLift(){
    leftFront.set(Value.kForward);
    rightFront.set(Value.kForward);
    backCenter.set(Value.kForward);
  }
  public void ReverseLift(){
    leftFront.set(Value.kReverse);
    rightFront.set(Value.kReverse);
    backCenter.set(Value.kReverse);
  }
  public void ReverseFront(){
    leftFront.set(Value.kReverse);
    rightFront.set(Value.kReverse);
  }
  public void ReverseBack(){
    backCenter.set(Value.kReverse);
  }
  public void OffLift(){
    leftFront.set(Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
