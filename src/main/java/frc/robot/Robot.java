/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {
  // AnalogInput sensor = new AnalogInput(0);
  WPI_TalonSRX leftTalon = new WPI_TalonSRX(18);
  WPI_TalonSRX notUsed1 = new WPI_TalonSRX(4);
  Ultrasonic ultra = new Ultrasonic(0,1);
  WPI_TalonSRX rightTalon = new WPI_TalonSRX(3);
  WPI_TalonSRX notUsed2 = new WPI_TalonSRX(21);
  public void robotInit() {
   notUsed1.follow(leftTalon);
   notUsed2.follow(rightTalon);
   rightTalon.setInverted(true);
   notUsed2.setInverted(true);
   ultra.setAutomaticMode(true);
  }

  
  public void robotPeriodic() {
  }

  
  public void autonomousInit() {
    
  }
double distance;
  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    System.out.println(ultra.getRangeInches());
    distance = (ultra.getRangeInches() );
    if(distance < 10){
        rightTalon.set(0);
        leftTalon.set(0);
    }
    else if(distance < 24){
      rightTalon.set(.06);
      leftTalon.set(.06);
    }
    else{
      rightTalon.set(.2);
      leftTalon.set(.2);
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  
  double input;
  public void teleopPeriodic() {
    System.out.println(ultra.getRangeInches());
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
