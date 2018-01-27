package frc.team2144.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;


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

        addSequential(new AutoDrive(0.5, 24)); // drive away from alliance wall
        addSequential(new TurnDegrees(0.5, position * 90)); // turn to right side
        addSequential(new AutoDrive(0.5, 48)); // drive to switch plate
        addSequential(new TurnDegrees(0.5, -position * 90)); // turn to face switch
        addSequential(new AutoDrive(0.5, 24)); // drive up to switch
        // TODO: output cube
        // TODO: cross line
        // TODO: maybe use mechanum instead?
    }
}
