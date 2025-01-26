package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

public class Mouse extends SubsystemBase {
    
    private Robot m_robot;

    public Mouse() {
        try {
            m_robot = new Robot();
        } catch (Exception e) {
            System.err.println("It didn't work");
        }
    }

    public void click() {
        m_robot.mousePress(0);
        m_robot.mouseRelease(0);
    }

    public Command minimize() {
        return runOnce(() -> {
            m_robot.mouseMove(getMinimizeLocation(), 0);
            m_robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            m_robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        });
    }

    private int getMinimizeLocation() {
        return (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 1920.0 * 1770);  
    }
    
}
