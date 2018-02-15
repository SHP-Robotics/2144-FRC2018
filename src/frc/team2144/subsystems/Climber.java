package frc.team2144.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2144.RobotMap;
import frc.team2144.commands.ClimberDrive;

public class Climber extends Subsystem {

    private Spark guideMotor, climbMotor;

    public Climber() {
        guideMotor = new Spark(RobotMap.guide_motor_port);
        climbMotor = new Spark(RobotMap.climb_motor_port);
    }

    public void setGuidePower(double pwr) {
        guideMotor.set(pwr);
    }

    public void setClimbPower(double pwr) {
        climbMotor.set(pwr);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ClimberDrive());
    }
}

