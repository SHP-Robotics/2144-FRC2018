package frc.team2144.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2144.Constants;


public class ThreeCubeAuto extends CommandGroup {

    /**
     * @param position the position of the alliance switch. -1 for left, 1 for right.
     */
    public ThreeCubeAuto(int position) {
        addSequential(new AutoIntakeDrive(true, 0)); // arm up
        addSequential(new AutoMecanumDrive(position * 1, 0.5, 12 * 16));
        addSequential(new TurnDegrees(0.4, -position * 90));
        addSequential(new AutoDrive(0.7, 20)); // drive up to switch
        addSequential(new AutoIntakeDrive(true, Constants.intake_output_spd)); // output cube and
        addSequential(new AutoMecanumDrive(position * 1, -0.1, 105)); // mecanum towards other cubes
        addSequential(new AutoIntakeDrive(false, Constants.intake_intake_spd)); // arms down, intake, and
        addSequential(new AutoDrive(0.5, 14)); // move to grab cube
        addSequential(new TurnDegrees(0.7, -position * 85)); // turn towards cube
        addSequential(new AutoDrive(0.4, 20), 2); // drive up to, intake cube (2)
        addSequential(new AutoDrive(-0.2, 5), 0.5);
        addSequential(new AutoIntakeDrive(true, 0));// arms up, stop intake and
        addSequential(new AutoDrive(0, 100), 1.5); // wait 1.5 sec
        addSequential(new AutoDrive(0.4, 12));// drive to output
        addSequential(new AutoIntakeDrive(true, Constants.intake_output_spd));// output and
        addSequential(new AutoDrive(-0.5, 15)); // reverse to not hit block
        addSequential(new AutoIntakeDrive(false, Constants.intake_intake_spd)); // stop output, arm down and
        // mecanum to next block
        // intake and
        // drive up to, intake cube (3)
        // arms up, stop intake and
        // drive to output
        // output
    }
}
