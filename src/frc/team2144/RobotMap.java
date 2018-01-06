/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2144;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int fl_drive_port = 0;
    public static final int fr_drive_port = 1;
    public static final int bl_drive_port = 2;
    public static final int br_drive_port = 3;

    public static final int fl_drive_enc_port_a = 0;
    public static final int fl_drive_enc_port_b = 1;
    public static final int fr_drive_enc_port_a = 2;
    public static final int fr_drive_enc_port_b = 3;
    public static final int bl_drive_enc_port_a = 4;
    public static final int bl_drive_enc_port_b = 5;
    public static final int br_drive_enc_port_a = 6;
    public static final int br_drive_enc_port_b = 7;

}
