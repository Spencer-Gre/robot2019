/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SolenoidSubsystem extends Subsystem {
  //Ports 0 - 5 on solenoid portion of PCM
  DoubleSolenoid leftFront = new DoubleSolenoid(1, 0);
  DoubleSolenoid rightFront = new DoubleSolenoid(3, 2);
  DoubleSolenoid backCenter = new DoubleSolenoid(5, 4);
  Solenoid top = new Solenoid(6);

  //Move all three pistons out
  public void TurnOnLift(){
    leftFront.set(Value.kForward);
    rightFront.set(Value.kForward);
    backCenter.set(Value.kForward);
  }
  //Pull all three pistons in
  public void ReverseLift(){
    leftFront.set(Value.kReverse);
    rightFront.set(Value.kReverse);
    backCenter.set(Value.kReverse);
  }
  //Pull front two pistons in
  public void ReverseFront(){
    leftFront.set(Value.kReverse);
    rightFront.set(Value.kReverse);
  }
  //Pull back piston in
  public void ReverseBack(){
    backCenter.set(Value.kReverse);
  }
  //freezes relay to current state
  public void OffLift(){
    leftFront.set(Value.kOff);
    rightFront.set(Value.kOff);
    backCenter.set(Value.kOff);
  }

  public void PushTop(){
    top.set(true);
  }
  
  public void RetractTop(){
    top.set(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
