package frc.team2144.commands.auto;

import frc.team2144.CommandBase;
import frc.team2144.Constants;


public class AutoDrive extends CommandBase {
    private double speed, distance;

    /**
     * @param speed    The speed to drive at (positive forward).
     * @param distance The distance to drive (in inches).
     */
    public AutoDrive(double speed, double distance) {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
        requires(gyro);
        this.speed = speed;
        this.distance = distance;
    }


    // Called just before this Command runs the first time
    protected void initialize() {
        drivetrain.reset_encoders();
        gyro.resetOrientation();
        drivetrain.arcade(speed, 0, false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double error = gyro.getOrientation() * Constants.K_AUTO_DRIVE_P;
        if (error > 1) {
            error = 1;
        } else if (error < -1) {
            error = -1;
        }
        drivetrain.arcade(speed, error, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        int distancePulses = (int) (distance * Constants.K_DRIVE_PPIN);
        return drivetrain.have_encoders_reached(distancePulses);
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.stop();
        drivetrain.reset_encoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
