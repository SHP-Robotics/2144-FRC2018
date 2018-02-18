package frc.team2144.commands.auto;

import frc.team2144.CommandBase;
import frc.team2144.Constants;


public class AutoMecanumDrive extends CommandBase {
    private double x, y, distance;

    public AutoMecanumDrive(double x, double y, double distance) {
        requires(drivetrain);
        requires(gyro);
        this.x = x;
        this.y = y;
        this.distance = distance;
    }


    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        drivetrain.reset_encoders();
        gyro.resetOrientation();
    }


    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double error = gyro.getOrientation() * Constants.K_AUTO_DRIVE_P;
        if (error > 1) {
            error = 1;
        } else if (error < -1) {
            error = -1;
        }
        drivetrain.mecanumCartesian(x, -y, -error);
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
