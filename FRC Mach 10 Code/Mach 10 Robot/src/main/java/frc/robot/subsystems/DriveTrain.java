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

public class DriveTrain extends SubsystemBase {
  /**
   * Class variables for storing data and objects that this subsystem needs to
   * operate.
   *
   * These variables are declared private to this class, because no other object
   * should need direct access to these objects. Any changes or commands to the 
   * drivetrain should come through public methods like the tankDrive() function.
   */

  private CANSparkMax driverfrontNEO;
  private CANSparkMax passagerfrontNEO;
  private CANSparkMax driverbackNEO;
  private CANSparkMax passagerbackNEO;
  private MotorController driverSide;
  private MotorController passagerSide;
  private DifferentialDrive drive;

  public DriveSubsystem() {
    driverfrontNEO = new CANSparkMax(Constants.DriveConstants.DRIVERFRONT_NEO_CANID, MotorType.kBrushless);
    passagerfrontNEO = new CANSparkMax(Constants.DriveConstants.PASSAGERFRONT_NEO_CANID, MotorType.kBrushless);
    passagerbackNEO = new CANSparkMax(Constants.DriveConstants.PASSAGERBACK_NEO_CANID, MotorType.kBrushless);
    driverbackNEO = new CANSparkMax(Constants.DriveConstants.DRIVERBACK_NEO_CANID, MotorType.kBrushless);
    // set all NEOs to factory defaults
    driverNEO.restoreFactoryDefaults();
    passagerNEO.restoreFactoryDefaults();

    // assign each motor to a MotorControllerGroup
    leftSide = new MotorControllerGroups(driverfrontNEO, driverbackNEO);
    rightSide = new MotorControllerGroups(passagerfrontNEO, passagerbackNEO);

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