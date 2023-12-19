// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  // private WPI_TalonFX m_rightMasterMotor = new WPI_TalonFX(Constants.Drive.Motors.rechtsVorne);
  private WPI_TalonFX m_leftMasterMotor = new WPI_TalonFX(Constants.Drive.Motors.rechtsHinten);
  private WPI_TalonFX m_rightSklavenMotor = new WPI_TalonFX(Constants.Drive.Motors.linksVorne);
  private WPI_TalonFX m_leftSklavenMotor = new WPI_TalonFX(Constants.Drive.Motors.linksHinten);
  //normalerweise auf rightMasterMotor
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMasterMotor, m_rightSklavenMotor);

  Joystick _joystick = new Joystick(Constants.Drive.joystickPort);

  public Drive() {
    // m_rightMasterMotor.configFactoryDefault();
    m_leftMasterMotor.configFactoryDefault();
    m_rightSklavenMotor.configFactoryDefault();
    m_leftSklavenMotor.configFactoryDefault();

    // m_rightSklavenMotor.follow(m_rightMasterMotor);
    m_leftSklavenMotor.follow(m_leftMasterMotor);
  }

  public void periodic() {
    //normalerweise auf rightMasterMotor
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

    double forw = _joystick.getRawAxis(1);
    double turn = _joystick.getRawAxis(0);

    forw = deadzone(forw, Constants.Drive.deadzoneY);
    turn = deadzone(turn, Constants.Drive.deadzoneX);
    System.out.print(forw);
    System.out.print(turn);

    m_robotDrive.arcadeDrive(turn, forw);
  }

  public void doNothing() {
    m_robotDrive.feed();
  }
}
