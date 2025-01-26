package frc.robot.subsystems;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class BackgroundChanger extends SubsystemBase {
    public Command takeAScreenShot() {
        return runOnce(() -> { 
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File("C:\\Users\\aidan\\Downloads\\e\\screenshot.png"));
            ImageIO.write(image, "png", new File("C:\\Users\\aidan\\Downloads\\e\\screenshot2.png"));
        } catch (Exception e) {
            System.err.println("Failed to save screenshot L");
        }
        });
    }
}
