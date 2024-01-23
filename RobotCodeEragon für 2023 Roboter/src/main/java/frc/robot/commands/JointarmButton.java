// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.JointArm;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** An example command that uses an example subsystem. */
public class JointarmButton extends Command {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final JointArm m_subsystem;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public JointarmButton(JointArm subsystem) {
        m_subsystem = subsystem;
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    double joint_movement = 0.00;
    @Override
    public void execute() {
        if (Robot._joystick.getRawButtonPressed(7)) {
            joint_movement = 0.05;
        } else if (Robot._joystick.getRawButtonPressed(8)) {
            joint_movement = -0.05;
        } else if (Robot._joystick.getRawButtonReleased(7)
                || Robot._joystick.getRawButtonReleased(8)) {
            joint_movement = 0.00;
        }

        m_subsystem.moveWithPercent(joint_movement);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
