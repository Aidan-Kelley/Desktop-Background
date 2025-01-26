// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.time.LocalTime;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.BackgroundChanger;
import frc.robot.subsystems.Mouse;

public class RobotContainer {

  private Mouse m_mouse = new Mouse();
  private BackgroundChanger m_backgroundChanger = new BackgroundChanger();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    Trigger trigger = new Trigger(this::timesUp);

    trigger.onTrue(Commands.sequence(
      m_backgroundChanger.takeAScreenShot(),
      m_mouse.minimize()
    ));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  private boolean timesUp() {
    return LocalTime.now().getMinute() % 15 == 0 && LocalTime.now().getSecond() == 59;
  }
}
