package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorSubsystem extends SubsystemBase {
    private final TalonFX motorRight = new TalonFX(Constants.MOTOR_ID_TALONFX);
    private final SparkMax motorLeft = new SparkMax(Constants.MOTOR_ID_SPARKMAX, MotorType.kBrushless);
    private boolean isLeftRunning = false;
    private DoubleSupplier triggerLambda;

    public MotorSubsystem(DoubleSupplier triggerLambda) {
        this.triggerLambda = triggerLambda;
    }

    public void switchToRightMotor() {
        isLeftRunning = false;
    }

    public void switchToLeftMotor() {
        isLeftRunning = true;
    }

    @Override
    public void periodic() {
        if (isLeftRunning) {
            motorLeft.setVoltage(triggerLambda.getAsDouble());
            motorRight.setVoltage(0);
        } else {
            motorRight.setVoltage(triggerLambda.getAsDouble());
            motorLeft.setVoltage(0);
        }
    }
}
