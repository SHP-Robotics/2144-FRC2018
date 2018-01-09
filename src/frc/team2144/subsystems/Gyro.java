package frc.team2144.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyro extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private AHRS navx = new AHRS(SPI.Port.kMXP);

    public void resetOrientation() {
        navx.reset();
    }

    public double getOrientation() {
        return navx.getAngle();
    }

    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}

