package frc.team2144.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2144.Constants;


public class SwitchCross extends CommandGroup {

    /**
     * @param position the position of the alliance switch. -1 for left, 1 for right.
     */
    public SwitchCross(int position) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the arm.
        addSequential(new AutoIntakeDrive(true, 0)); // arm up
        addSequential(new AutoMecanumDrive(position * 1, 0.5, 12 * 16));
        addSequential(new TurnDegrees(0.4, -position * 90));
        addSequential(new AutoDrive(0.7, 20)); // drive up to switch
        addSequential(new AutoIntakeDrive(true, Constants.intake_output_spd)); // output cube and
        addSequential(new AutoMecanumDrive(position * 1, -0.1, 105)); // mecanum towards other cubes
    }
}
