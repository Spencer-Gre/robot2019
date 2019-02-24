/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class SliderSubsystem extends Subsystem {
  public Talon tal = new Talon(RobotMap.sliderPort);
  public AnalogInput encoder = new AnalogInput(0);
  public DigitalInput bosch = new DigitalInput(8);

  public long getValue(){
    return encoder.getAccumulatorCount();
  }

  public void ToggleSlider(double input){
    tal.set(input);
  }

  public void TurnOffSlider(){
    tal.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
