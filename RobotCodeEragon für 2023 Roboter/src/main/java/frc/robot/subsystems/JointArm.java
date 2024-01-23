// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.Function;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.StaticBrake;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.JointarmButton;
import frc.robot.commands.JointarmPos;

public class JointArm extends SubsystemBase {
    private TalonFX armMotorLinks = new TalonFX(Constants.JointArm.JointLinkerMotor);
    private TalonFX armMotorRechts = new TalonFX(Constants.JointArm.JointRechterMotor);

    Joystick _joystick = new Joystick(Constants.joystickPort);

    /** Creates a new ExampleSubsystem. */
    public void brakemode(boolean onOf) {
        if (onOf) {
            armMotorLinks.setNeutralMode(NeutralModeValue.Brake);
            armMotorRechts.setNeutralMode(NeutralModeValue.Brake);
        } else {
            armMotorLinks.setNeutralMode(NeutralModeValue.Coast);
            armMotorRechts.setNeutralMode(NeutralModeValue.Coast);
        }
    }

    public JointArm() {
        brakemode(true);
        // armMotorLinks.setControl(new Follower(Constants.JointArm.JointRechterMotor,
        // true));
        setDefaultCommand(new JointarmButton(this));
    }

    private double joint_movement = 0.0;

    @Override
    public void periodic() {
        if (Robot._joystick.getRawButton(5) == true){
            CommandScheduler.getInstance().schedule(new JointarmPos(this));
        }
        // SmartDashboard.putData(this);

    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("armrechtposition", () -> armMotorRechts.getPosition().getValueAsDouble(), null);
        super.initSendable(builder);
    }

    public void moveWithPercent(double joint_movement) {
        armMotorLinks.set(joint_movement);
        armMotorRechts.set(-joint_movement);
    }

    public double getMotorPos() {
        return armMotorLinks.getPosition().getValueAsDouble();
    }
}
