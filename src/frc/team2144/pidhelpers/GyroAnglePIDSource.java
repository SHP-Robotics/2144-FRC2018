package frc.team2144.pidhelpers;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.team2144.subsystems.Gyro;

public class GyroAnglePIDSource implements PIDSource {
    private Gyro gyro;

    public GyroAnglePIDSource(Gyro gyro) {
        this.gyro = gyro;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
        // feh
    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement; // feh part 2
    }

    @Override
    public double pidGet() {
        return normalize(gyro.getOrientation());
    }

    private double normalize(double angle) {
        while (angle < -180) {
            angle += 360;
        }
        while (angle > 180) {
            angle -= 360;
        }
        return angle;
    }
}
