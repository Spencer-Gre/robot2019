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
import java.lang.Math;

public class ElevatorCommand extends Command {

  public double set; //must NOT be public static double

  public ElevatorCommand(double input) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevatorSubsystem);
    set = input + Robot.elevatorSubsystem.elevator.getSensorCollection().getQuadraturePosition();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.elevatorSubsystem.usePIDOutput(set);
    SmartDashboard.putNumber("EncoderValue", Robot.elevatorSubsystem.elevator.getSensorCollection().getQuadraturePosition());

    double error = set - Robot.elevatorSubsystem.elevator.getSensorCollection().getQuadraturePosition();
    double speed = Math.min(1.0,error/2000.0+0.1);

    SmartDashboard.putNumber("Error", error);

    if(error > 10){
      Robot.elevatorSubsystem.elevator.set(speed);
    }else{
      end();
    }
    if(Robot.elevatorSubsystem.elevator.getSensorCollection().isFwdLimitSwitchClosed()
    || Robot.elevatorSubsystem.elevator.getSensorCollection().isRevLimitSwitchClosed()){
      end();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevatorSubsystem.TurnOffElevator();
    this.cancel();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
