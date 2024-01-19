// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Griefer extends SubsystemBase {
    private Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    private DoubleSolenoid greiferSolenoid = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, 0, 1);
    
    /** Creates a new ExampleSubsystem. */
    public Griefer() {
        greiferSolenoid.set(DoubleSolenoid.Value.kReverse);
        compressor.enableDigital();
    }
    @Override
    public void periodic() {
        greiferSolenoid.toggle();
      // This method will be called once per scheduler run
    }
}
