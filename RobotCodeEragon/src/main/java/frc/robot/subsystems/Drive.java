// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenixpro.configs.MotorOutputConfigs;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    private TalonFX rightMasterMotor;
    private TalonFX leftMasterMotor;
    private TalonFX rightSklavenMotor;
    private TalonFX leftSklavenMotor;


    
    public Drive() {
        rightMasterMotor = new TalonFX(12);
        leftMasterMotor = new TalonFX(10);
        rightSklavenMotor = new TalonFX(13);
        leftSklavenMotor = new TalonFX(11);
        
        rightMasterMotor.configFactoryDefault();
        leftMasterMotor.configFactoryDefault();
        rightSklavenMotor.configFactoryDefault();
        leftSklavenMotor.configFactoryDefault();

        rightSklavenMotor.follow(rightMasterMotor);
        leftSklavenMotor.follow(leftMasterMotor);
  }

  public void periodic(){
    rightMasterMotor.set(TalonFXControlMode.PercentOutput, 0.1);
    leftMasterMotor.set(TalonFXControlMode.PercentOutput, -0.1);
  }

}
