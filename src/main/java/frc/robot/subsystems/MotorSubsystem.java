package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.MotorConstants;

public class MotorSubsystem extends SubsystemBase{
    
    private final SparkMax motor = new SparkMax(Constants.MOTOR_ID, MotorType.kBrushless);
    private final TalonFX betterMotor = new TalonFX(Constants.MOTOR_ID);
    private final boolean isLeftRunning = false;

    public MotorSubsystem() {}

    public void spinClockwise() {
        motor.setVoltage(MotorConstants.VOLTAGE);
    }

    public void spinCounterwise() {
        motor.setVoltage(-MotorConstants.VOLTAGE);

    }

    public void stopMotor() {
        motor.setVoltage(0);
    }




}