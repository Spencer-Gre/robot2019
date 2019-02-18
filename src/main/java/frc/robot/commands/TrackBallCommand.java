/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class TrackBallCommand extends Command {
  public TrackBallCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveSubsystem);
    requires(Robot.limelightSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipline").setNumber(1);

    
    Update_Limelight_Tracking();

    if (Robot.m_oi.m_LimelightHasValidTarget)
    {
      Robot.driveSubsystem.telopDrive(Robot.m_oi.m_LimelightDriveCommand, Robot.m_oi.m_LimelightSteerCommand);
    }
    else
    {
      Robot.driveSubsystem.telopDrive(0.0,0.0);
    }


  }

  public void Update_Limelight_Tracking()
  {
        // These numbers must be tuned for your Robot!  Be careful!
        final double STEER_K = 0.03;                    // how hard to turn toward the target
        final double DRIVE_K = 0.26;                    // how hard to drive fwd toward the target
        final double DESIRED_TARGET_AREA = 50;        // Area of the target when the robot reaches the wall
        final double MAX_DRIVE = 0.3;                   // Simple speed limit so we don't drive too fast

        double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
        double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

        if (tv < 1.0)
        {
          Robot.m_oi.m_LimelightHasValidTarget = false;
          Robot.m_oi.m_LimelightDriveCommand = 0.0;
          Robot.m_oi.m_LimelightSteerCommand = 0.0;
          return;
        }


        Robot.m_oi.m_LimelightHasValidTarget = true;

        // Start with proportional steering
        double steer_cmd = tx * STEER_K;
        Robot.m_oi.m_LimelightSteerCommand = steer_cmd;

        // try to drive forward until the target area reaches our desired area
        double drive_cmd = -1 * (DESIRED_TARGET_AREA - ta) * DRIVE_K;

        // don't let the robot drive too fast into the goal
        if (drive_cmd > MAX_DRIVE)
        {
          drive_cmd = MAX_DRIVE;
        }
        Robot.m_oi.m_LimelightDriveCommand = drive_cmd;
        SmartDashboard.putNumber("LimelightX2", tx);
        SmartDashboard.putNumber("LimelightArea2", ta);
        SmartDashboard.putNumber("drive_cmd", drive_cmd);
        SmartDashboard.putNumber("steer_cmd", steer_cmd);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
