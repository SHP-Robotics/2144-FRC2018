package frc.team2144.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.team2144.commands.GatorDrive;


public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Spark fl, fr, bl, br;
    private MecanumDrive drive;

    /**
     * @param fl_port The PWM port the front left Spark is plugged into.
     * @param fr_port The PWM port the front right Spark is plugged into.
     * @param bl_port The PWM port the back left Spark is plugged into.
     * @param br_port The PWM port the back right Spark is plugged into.
     */
    public Drivetrain(int fl_port, int fr_port, int bl_port, int br_port) {
        fl = new Spark(fl_port);
        fr = new Spark(fr_port);
        bl = new Spark(bl_port);
        br = new Spark(br_port);
        drive = new MecanumDrive(fl, bl, fr, br);
    }

    /**
     * @param x   How fast to move sideways. Positive for right.
     * @param y   How fast to move forward. Positive forward.
     * @param rot How fast to turn. Positive right.
     */
    public void mecanumCartesian(double x, double y, double rot) {
        drive.driveCartesian(y, x, rot);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new GatorDrive());
    }
}

