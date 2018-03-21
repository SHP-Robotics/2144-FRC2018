package frc.team2144.pidhelpers;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.team2144.subsystems.Drivetrain;

public class DrivetrainDistancePIDSource implements PIDSource {
    private Drivetrain drivetrain;

    public DrivetrainDistancePIDSource(Drivetrain drive) {
        this.drivetrain = drive;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
        // feh. I'm too lazy to implement this
    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement; // so there's only one type
    }

    @Override
    public double pidGet() {
        return drivetrain.average_encoders();
    }
}
