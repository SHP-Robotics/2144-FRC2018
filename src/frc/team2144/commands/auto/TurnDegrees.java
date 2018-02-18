package frc.team2144.commands.auto;

import frc.team2144.CommandBase;
import frc.team2144.Constants;


public class TurnDegrees extends CommandBase {

    private double speed, angle;

    /**
     * Turn to a given angle using navX gyro.
     *
     * @param speed The speed to turn at (positive for right, neg for left)
     * @param angle How far to turn (in degrees)
     */
    public TurnDegrees(double speed, double angle) {
        // Use requires() here to declare subsystem dependencies
        requires(gyro);
        requires(drivetrain);
        this.speed = -speed;
        this.angle = normalizeAngle(angle);
    }

    private double normalizeAngle(double angle) {
        while (angle < -180) {
            angle += 360;
        }
        while (angle > 180) {
            angle -= 360;
        }
        return angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        gyro.resetOrientation();
        if (gyro.getOrientation() < angle) {
            drivetrain.arcade(0, speed, false);
        } else {
            drivetrain.arcade(0, -speed, false);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double spd = speed;
        if (gyro.getOrientation() > angle - Constants.K_TURN_SLOW_TOLERANCE
                && gyro.getOrientation() < angle + Constants.K_TURN_SLOW_TOLERANCE) {
            spd = -Constants.K_TURN_SLOW_SPD;
        }
        if (gyro.getOrientation() < normalizeAngle(angle + 180) && gyro.getOrientation() > normalizeAngle(angle)) {
            drivetrain.arcade(0, spd, false);
        } else {
            drivetrain.arcade(0, -spd, false);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return gyro.getOrientation() > angle - Constants.K_TURN_TOLERANCE
                && gyro.getOrientation() < angle + Constants.K_TURN_TOLERANCE;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.stop();
        drivetrain.reset_encoders();
    }


    /**
     * <p>
     * Called when the command ends because somebody called {@link #cancel()} or
     * another command shared the same requirements as this one, and booted it out. For example,
     * it is called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     * </p><p>
     * This is where you may want to wrap up loose ends, like shutting off a motor that was being
     * used in the command.
     * </p><p>
     * Generally, it is useful to simply call the {@link #end()} method within this
     * method, as done here.
     * </p>
     */
    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
