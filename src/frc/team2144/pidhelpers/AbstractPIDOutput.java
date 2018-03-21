package frc.team2144.pidhelpers;

import edu.wpi.first.wpilibj.PIDOutput;

public class AbstractPIDOutput implements PIDOutput {
    private double output = 0.0;

    public AbstractPIDOutput() {

    }

    @Override
    public void pidWrite(double output) {
        this.output = output;
    }

    public double getValue() {
        return output;
    }
}
