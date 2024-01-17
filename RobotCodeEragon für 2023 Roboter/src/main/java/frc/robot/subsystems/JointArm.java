// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;

public class JointArm extends SubsystemBase {
    private TalonFX armMotorLinks = new TalonFX(Constants.HauptArm.linkerMotor);
    private TalonFX armMotorRechts = new TalonFX(Constants.HauptArm.rechterMotor);
    
    Joystick _joystick = new Joystick(Constants.joystickPort);
    /** Creates a new ExampleSubsystem. */
    public JointArm() {
        armMotorLinks.setControl(new Follower(Constants.HauptArm.rechterMotor, false));
    }

    private double joint_movement = 0.0;

    @Override
    public void periodic() {
        if (_joystick.getRawButtonPressed(7)){
            joint_movement = 0.05;
        } else if (_joystick.getRawButtonPressed(8)){
            joint_movement = -0.05;
        } else if (_joystick.getRawButtonReleased(7)
            || _joystick.getRawButtonReleased(8)) {
            joint_movement = 0.0;
        }
        armMotorLinks.set(joint_movement);
        armMotorRechts.set(-joint_movement);
    }
}
