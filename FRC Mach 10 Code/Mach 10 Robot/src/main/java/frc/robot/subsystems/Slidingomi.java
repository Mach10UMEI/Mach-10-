// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Slidingomi extends SubsystemBase {
  /** Creates a new Claw. */
  DoubleSolenoid omiSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, id1, id2);
  public Slidingomi() {}
  
  public void Oniout(){
    omiSolenoid.set(Value.kForward);
 }
 
 public void Omiin(){
    omiSolenoid.set(Value.kReverse);
 }
  @Override
  public void periodic() {
    
  }
}
