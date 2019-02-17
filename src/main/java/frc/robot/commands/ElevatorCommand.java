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

  public double target; //must NOT be public static double

  public ElevatorCommand(double input) {
    requires(Robot.elevatorSubsystem);
    
    //Moves elevator to position relative to when command is called
    target = input + Robot.elevatorSubsystem.elevator.getSensorCollection().getQuadraturePosition();
    
    //Moves elevator to absolute position? untested.
    //target = input + Robot.elevatorSubsystem.elevatorStartPosition;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.elevatorSubsystem.usePIDOutput(set);

    double slope = 2000.0; //how quickly motor speed decreases
    double intercept = 0.1; //minimum motor speed while active
    double minError = 10; //target error to kill motor

    //Hacky P algorithm
    //As motor gets closer to target position, slow down by calculating "speed" from error
    //If motor overshoots in the positive direction, 'error' will be negative, as will speed
    //Vice versa if motor overshotts in the negative direction (untested though)
    double speed;
    double error = target - Robot.elevatorSubsystem.elevator.getSensorCollection().getQuadraturePosition();
    if(error > 0){
      speed = Math.min(1.0,error/slope+intercept);
    }else{
      speed = Math.max(-1.0,error/slope-intercept);
    }

    //Print useful information about targetting
    SmartDashboard.putNumber("Starting position", 
      Robot.elevatorSubsystem.elevatorStartPosition);
    SmartDashboard.putNumber("Target position", this.target);
    SmartDashboard.putNumber("EncoderValue", 
      Robot.elevatorSubsystem.elevator.getSensorCollection().getQuadraturePosition());
    SmartDashboard.putNumber("Error", error);
    
    if(Math.abs(error) > minError){
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
