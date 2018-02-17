package frc.team2144;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2144.subsystems.*;

public abstract class CommandBase extends Command {
    public static OI oi = Robot.oi;
    // Create a single static instance of all of your subsystems
    public static final Drivetrain drivetrain = Robot.drivetrain;
    public static final Gyro gyro = Robot.gyro;
    public static final Intake intake = Robot.intake;
    public static final Climber climber = Robot.climber;
    public static final Electronics electronics = Robot.electronics;

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
