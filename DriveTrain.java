/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Class variables for storing data and objects that this subsystem needs to
   * operate.
   *
   * These variables are declared private to this class, because no other object
   * should need direct access to these objects. Any changes or commands to the 
   * drivetrain should come through public methods like the tankDrive() function.
   */

  private CANSparkMax left1NEO;
  private CANSparkMax right1NEO;
  private CANSparkMax left2NEO;
  private CANSparkMax right2NEO;
  private MotorController leftSide;
  private MotorController rightSide;
  private DifferentialDrive drive;

  public DriveSubsystem() {
    left1NEO = new CANSparkMax(Constants.DriveConstants.LEFT1_NEO_CANID, MotorType.kBrushless);
    right1NEO = new CANSparkMax(Constants.DriveConstants.RIGHT1_NEO_CANID, MotorType.kBrushless);
    right2NEO = new CANSparkMax(Constants.DriveConstants.RIGHT2_NEO_CANID, MotorType.kBrushless);
    left1NEO = new CANSparkMax(Constants.DriveConstants.LEFT2_NEO_CANID, MotorType.kBrushless);
    // set all NEOs to factory defaults
    leftNEO.restoreFactoryDefaults();
    rightNEO.restoreFactoryDefaults();

    // assign each motor to a MotorControllerGroup
    leftSide = new MotorControllerGroup(left1NEO, left2NEO);
    rightSide = new MotorControllerGroup(right1NEO, right2NEO);

    // create our DifferentialDrive class
    drive = new DifferentialDrive(leftSide, rightSide);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
}