package frc.team2144.subsystems;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2144.commands.CompressorManagement;

public class Electronics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Compressor compressor = new Compressor();
    public PowerDistributionPanel pdp = new PowerDistributionPanel();


    public void initDefaultCommand() {
        setDefaultCommand(new CompressorManagement());
    }
}

