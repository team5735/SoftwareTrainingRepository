package frc.robot.subsystems;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import org.ejml.dense.block.decomposition.qr.BlockHouseHolder_DDRB;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.TriggerCommand;

public class MotorSubsystem extends SubsystemBase {
    private final TalonFX motorRight = new TalonFX(Constants.MOTOR_ID_TALONFX);
    private final SparkMax motorLeft = new SparkMax(Constants.MOTOR_ID_SPARKMAX, MotorType.kBrushless);
    private boolean isLeftRunning = false;
    private DoubleSupplier triggerLambda;

    public MotorSubsystem(DoubleSupplier triggerLambda) {
        this.triggerLambda = triggerLambda;
    }

    public void startMotorRight() {
        motorRight.setVoltage(1);
        isLeftRunning = false;
    }

    public void stopMotorRight() {
        motorRight.setVoltage(0);
    }

    public void startMotorLeftt() {
        motorLeft.setVoltage(1);
        isLeftRunning = true;
    }

    public void stopMotorLeft() {
        motorLeft.setVoltage(0);
    }

    @Override
    public void periodic() {
        if (isLeftRunning) {
            motorLeft.setVoltage(triggerLambda.getAsDouble());
        }
        if (!isLeftRunning) {
            motorRight.setVoltage(triggerLambda.getAsDouble());
        }
    }
}
