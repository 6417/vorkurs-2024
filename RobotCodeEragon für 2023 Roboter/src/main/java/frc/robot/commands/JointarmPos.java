// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.JointArm;

import com.ctre.phoenix6.configs.Slot0Configs;

import com.ctre.phoenix6.configs.Slot0Configs;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** An example command that uses an example subsystem. */
public class JointarmPos extends Command {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final JointArm m_subsystem;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public JointarmPos(JointArm subsystem) {
        m_subsystem = subsystem;
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    private double ziel = 5;
    private double toleranz = 0.5;
    private double motorPos = 0;

    @Override
    public void execute() {
        var slot0Configs = new Slot0Configs();
        slot0Configs.kP = 24; // An error of 0.5 rotations results in 12 V output
        slot0Configs.kI = 0; // no output for integrated error
        slot0Configs.kD = 0.1; // A velocity of 1 rps results in 0.1 V output

        JointArm.jointArmMotorLinks.getConfigurator().apply(slot0Configs);
        motorPos = m_subsystem.getMotorPos();
        // double speed;
        // if (motorPos < ziel) {
        //     speed = 0.05;
        // } else {
        //     speed = -0.05;
        // }
        // m_subsystem.moveWithPercent(speed);
        // m_subsystem.moveWithPercent(0);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        var pos = m_subsystem.getMotorPos();
        return pos >= ziel - toleranz && pos <= ziel + toleranz;
    }
}
