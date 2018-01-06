package frc.team2144.subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.team2144.RobotMap;
import frc.team2144.commands.GatorDrive;


public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Spark fl, fr, bl, br;
    private Encoder flenc, frenc, blenc, brenc;
    private MecanumDrive drive;

    /**
     * Constructs a Drivetrain using port constants found in RobotMap.
     */
    public Drivetrain() {
        fl = new Spark(RobotMap.fl_drive_port);
        fr = new Spark(RobotMap.fr_drive_port);
        bl = new Spark(RobotMap.bl_drive_port);
        br = new Spark(RobotMap.br_drive_port);
        flenc = new Encoder(RobotMap.fl_drive_enc_port_a, RobotMap.fl_drive_enc_port_b);
        frenc = new Encoder(RobotMap.fr_drive_enc_port_a, RobotMap.fr_drive_enc_port_b);
        blenc = new Encoder(RobotMap.bl_drive_enc_port_a, RobotMap.bl_drive_enc_port_b);
        brenc = new Encoder(RobotMap.br_drive_enc_port_a, RobotMap.br_drive_enc_port_b);
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

