// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Hopper extends SubsystemBase {
  /** Creates a new Hopper. */
  DoubleSolenoid hopperSolenoid = null;
  public Hopper() {}
  public void Hopperout(){
    hopperSolenoid.set(Value.kForward);
 }
 
 public void Hopperin(){
    hopperSolenoid.set(Value.kReverse);
 }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}