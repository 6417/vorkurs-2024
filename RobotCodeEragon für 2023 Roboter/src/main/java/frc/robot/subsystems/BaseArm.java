// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BaseArm extends SubsystemBase {
    private TalonFX baseMotorLinks = new TalonFX(Constants.BaseArm.BaseLinkerMotor);
    private TalonFX baseMotorRechts = new TalonFX(Constants.BaseArm.BaseRechterMotor);
    
    Joystick _joystick = new Joystick(Constants.joystickPort);
    /** Creates a new ExampleSubsystem. */
    public BaseArm() {
        baseMotorLinks.setControl(new Follower(Constants.BaseArm.BaseRechterMotor, false));
    }

    private double base_movement = 0.0;

    @Override
    public void periodic() {
        if (_joystick.getRawButtonPressed(9)){
            base_movement = 0.05;
        } else if (_joystick.getRawButtonPressed(10)){
            base_movement = -0.05;
        } else if (_joystick.getRawButtonReleased(9)
            || _joystick.getRawButtonReleased(10)) {
            base_movement = 0.0;
        }
        baseMotorLinks.set(base_movement);
        baseMotorRechts.set(-base_movement);
    }
}
