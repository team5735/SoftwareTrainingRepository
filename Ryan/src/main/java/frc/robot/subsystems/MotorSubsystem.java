package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorSubsystem extends SubsystemBase{
    public final TalonFX motor = new TalonFX(Constants.MOTOR_ID);
    public void startMotor() {
        motor.setVoltage(1);
    }
    
    public void stopMotor() {
        motor.setVoltage(0);
    }

}
