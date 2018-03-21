package frc.team2144.commands.auto;

import edu.wpi.first.wpilibj.PIDController;
import frc.team2144.CommandBase;
import frc.team2144.Constants;
import frc.team2144.pidhelpers.AbstractPIDOutput;
import frc.team2144.pidhelpers.GyroAnglePIDSource;


public class AutoPIDTurn extends CommandBase {

    private double speed, angle;
    private boolean calibration = false;
    private PIDController angleController;

    private GyroAnglePIDSource source;
    private AbstractPIDOutput output;

    /**
     * Turn to a given angle using navX gyro.
     *
     * @param speed The speed to turn at (positive for right, neg for left)
     * @param angle How far to turn (in degrees)
     */
    public AutoPIDTurn(double speed, double angle) {
        // Use requires() here to declare subsystem dependencies
        requires(gyro);
        requires(drivetrain);
        source = new GyroAnglePIDSource(gyro);
        output = new AbstractPIDOutput();
        this.speed = -speed;
        this.angle = normalizeAngle(angle);
        angleController = new PIDController(Constants.K_TURN_P, Constants.K_TURN_I, Constants.K_TURN_D, source, output);
        angleController.setOutputRange(-1, 1);
        angleController.setInputRange(-180, 180);
        angleController.setContinuous();
    }

    public AutoPIDTurn(double speed, double angle, boolean calibrationMode) {
        this(speed, angle);
        calibration = calibrationMode;
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
        angleController.setSetpoint(angle);
        angleController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.arcade(0, output.getValue());
        if (calibration) {
            angleController.setSetpoint(oi.get_right_z() * 180);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !calibration && gyro.getOrientation() > angle - Constants.K_TURN_TOLERANCE && gyro.getOrientation() < angle + Constants.K_TURN_TOLERANCE;
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
