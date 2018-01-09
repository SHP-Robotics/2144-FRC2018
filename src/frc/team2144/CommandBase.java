package frc.team2144;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2144.subsystems.Drivetrain;
import frc.team2144.subsystems.Gyro;

public abstract class CommandBase extends Command {
    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static final Drivetrain drivetrain = Robot.drivetrain;
    public static final Gyro gyro = Robot.gyro;

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
