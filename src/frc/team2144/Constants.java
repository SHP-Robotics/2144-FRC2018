package frc.team2144;

public class Constants {
    public static final int K_TURN_TOLERANCE = 2; // degrees +/-
    public static final double K_AUTO_DRIVE_P = 0.1; // error proportional multiplier used to drive straight

    public static final int K_DRIVE_PPR = 1440; // might be 360 actually
    public static final double K_DRIVE_DIA = 6; // drive wheel diameter
    public static final double K_DRIVE_CIR = Math.PI * K_DRIVE_DIA; // drive wheel circumference
    public static final double K_DRIVE_PPIN = K_DRIVE_PPR / K_DRIVE_CIR; // pulses per inch
}
