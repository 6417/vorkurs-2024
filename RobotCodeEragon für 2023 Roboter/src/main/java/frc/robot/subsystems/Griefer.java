// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Griefer extends SubsystemBase {
    private Compressor compressor;
    private Joystick _joystick = new Joystick(Constants.joystickPort);
    private DoubleSolenoid greiferSolenoid = new DoubleSolenoid(61, PneumaticsModuleType.CTREPCM, 2, 3);
    
    /** Creates a new ExampleSubsystem. */
    public Griefer() {
        compressor = new Compressor(61, PneumaticsModuleType.CTREPCM);
        greiferSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    @Override
    public void periodic() {
        if (_joystick.getRawButtonPressed(12)){
            greiferSolenoid.toggle();
        }
        // greiferSolenoid.toggle();
      // This method will be called once per scheduler run
    }
}
