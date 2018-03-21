package frc.team2144.commands.auto;

import edu.wpi.first.wpilibj.PIDController;
import frc.team2144.CommandBase;
import frc.team2144.Constants;
import frc.team2144.pidhelpers.AbstractPIDOutput;
import frc.team2144.pidhelpers.DrivetrainDistancePIDSource;


public class AutoPIDDrive extends CommandBase {

    private double speed, distance;
    private boolean calibration = false;
    private PIDController speedController;

    private DrivetrainDistancePIDSource source;
    private AbstractPIDOutput output;

    /**
     * @param speed    The speed to drive at (positive forward).
     * @param distance The distance to drive (in inches).
     */
    public AutoPIDDrive(double speed, double distance) {
        requires(drivetrain);
        requires(gyro);
        source = new DrivetrainDistancePIDSource(drivetrain);
        output = new AbstractPIDOutput();
        this.speed = speed;
        this.distance = distance;
        speedController = new PIDController(Constants.K_DRIVE_P, Constants.K_DRIVE_I, Constants.K_DRIVE_D, source, output);
        speedController.setOutputRange(-1, 1);
    }

    public AutoPIDDrive(double speed, double distance, boolean calibration) {
        this(speed, distance);
        this.calibration = calibration;
    }


    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    @Override
    protected void initialize() {
        drivetrain.reset_encoders();
        gyro.resetOrientation();
        speedController.setSetpoint((int) (distance * Constants.K_DRIVE_PPIN));
        speedController.enable();
    }


    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    @Override
    protected void execute() {
        double error = gyro.getOrientation() * Constants.K_AUTO_DRIVE_P;
        if (error > 1) {
            error = 1;
        } else if (error < -1) {
            error = -1;
        }
        double spd = output.getValue();
        if (spd > speed) {
            spd = 1;
        } else if (spd < -speed) {
            spd = -1;
        }
        drivetrain.arcade(-spd, -error, false);
        if (calibration) {
            speedController.setSetpoint((int) (distance * Constants.K_DRIVE_PPIN * -24 * oi.get_right_y()));
        }
    }


    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        int distancePulses = (int) (distance * Constants.K_DRIVE_PPIN);
        return drivetrain.have_encoders_reached(distancePulses) && !calibration;
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
