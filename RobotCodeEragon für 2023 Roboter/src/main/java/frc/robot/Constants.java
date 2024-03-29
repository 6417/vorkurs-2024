// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  // Joystick
  public static double deadzoneX = 0.1;
  public static double deadzoneY = 0.1;
  public static final int joystickPort = 0;
  
  // Drive
  public static class Drive{
    public static boolean isEnabeld = true;
    // Motors
    public static final int rechtsVorne = 10;
    public static final int rechtsHinten = 12;
    public static final int linksVorne = 11;
    public static final int linksHinten = 13;
  }

  public static class JointArm{
    public static final int JointRechterMotor = 22;
    public static final int JointLinkerMotor = 23;
  }
  public static class BaseArm{
    public static final int BaseRechterMotor = 20;
    public static final int BaseLinkerMotor = 21;
  }
}
