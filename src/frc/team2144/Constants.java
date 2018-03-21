package frc.team2144;

public class Constants {
    public static final int K_TURN_TOLERANCE = 2; // degrees +/-
    public static final int K_TURN_SLOW_TOLERANCE = 15; // degrees +/-
    public static final double K_TURN_SLOW_SPD = 0.3; // when turning within tolerance degrees, use this spd
    public static final double K_AUTO_DRIVE_P = 0.03; // error proportional multiplier used to drive straight

    public static final int K_DRIVE_PPR = 360; // might be 360 actually
    public static final double K_DRIVE_DIA = 6; // drive wheel diameter
    public static final double K_DRIVE_CIR = Math.PI * K_DRIVE_DIA; // drive wheel circumference
    public static final double K_DRIVE_PPIN = K_DRIVE_PPR / K_DRIVE_CIR; // pulses per inch

    public static final double intake_intake_spd = -1;
    public static final double intake_output_spd = 1;

    public static final double K_DRIVE_P = 1;
    public static final double K_DRIVE_I = 1;
    public static final double K_DRIVE_D = 1;

    public static final double K_TURN_P = 1;
    public static final double K_TURN_I = 1;
    public static final double K_TURN_D = 1;

}
