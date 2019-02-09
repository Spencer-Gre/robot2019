/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class SliderCommand extends Command {
  
  public double set; //must NOT be public static double
  public boolean finished;

  public SliderCommand(double input) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.sliderSubsystem);
    set = input;
    finished = false;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.sliderSubsystem.encoder.resetAccumulator();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.sliderSubsystem.ToggleSlider(set);
    SmartDashboard.putNumber("Bosch Motor Value", Robot.sliderSubsystem.getValue());

    if(Robot.sliderSubsystem.getValue() >= 600){
      end();
    }
    // Wont spin, unless negative number is passed in.
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.sliderSubsystem.TurnOffSlider();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
