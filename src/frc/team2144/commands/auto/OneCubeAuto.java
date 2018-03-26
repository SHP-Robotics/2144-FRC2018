package frc.team2144.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2144.Constants;


public class OneCubeAuto extends CommandGroup {

    /**
     * Plops one cube in the switch.
     *  |-----------|
     * >|X----|-----|
     *  |-----------|
     * @param position the position of the alliance switch. -1 for left, 1 for right.
     */
    public OneCubeAuto(int position) {
        addSequential(new AutoIntakeDrive(false, 0)); // arm down
        addSequential(new AutoDrive(0.5, 6)); // drive forward and
        addSequential(new TurnDegrees(0.5, position * 48)); // turn to drive to switch
        addSequential(new AutoIntakeDrive(true, 0)); // arm up
        addSequential(new AutoDrive(0.7, 120)); // drive up to switch and
        addSequential(new TurnDegrees(0.5, -position * (90 + 48))); // turn to plop cube
        addSequential(new AutoDrive(0.5, 20)); // drive up to switch
        addSequential(new AutoIntakeDrive(true, Constants.intake_output_spd)); // output cube and
        addSequential(new AutoDrive(0, 100), 3); // wait
    }
}
