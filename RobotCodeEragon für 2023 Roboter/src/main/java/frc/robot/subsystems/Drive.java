// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {

  private TalonFX m_rightMasterMotor = new TalonFX(Constants.Drive.rechtsVorne);
  private TalonFX m_leftMasterMotor = new TalonFX(Constants.Drive.linksVorne);
  private TalonFX m_rightSklavenMotor = new TalonFX(Constants.Drive.rechtsHinten);
  private TalonFX m_leftSklavenMotor = new TalonFX(Constants.Drive.linksHinten);
  //normalerweise auf rightMasterMotor
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMasterMotor, m_rightMasterMotor);

  Joystick _joystick = new Joystick(Constants.joystickPort);

  public Drive() {

    m_rightMasterMotor.setControl(new Follower(Constants.Drive.rechtsHinten, false));
    m_leftMasterMotor.setControl(new Follower(Constants.Drive.linksHinten, false));
  }

  public void periodic() {
    // normalerweise auf rightMasterMotor
    // m_rightMasterMotor.set(TalonFXControlMode.PercentOutput, 0.1);
    // m_leftMasterMotor.set(TalonFXControlMode.PercentOutput, -0.1);
  }

  public double deadzone(double wert, double threshold) {
    if (Math.abs(wert) < threshold) {
      return 0;
    }
    return (wert - Math.signum(wert) * threshold);
  }

  public void fahren() {
    double forw = -_joystick.getRawAxis(1);
    double turn = _joystick.getRawAxis(0);

    forw = deadzone(forw, Constants.deadzoneY);
    turn = deadzone(turn, Constants.deadzoneX);

    m_robotDrive.tankDrive((forw+turn)/2, (forw-turn)/2);
  }

  public void doNothing() {
    m_robotDrive.feed();
  }
}
