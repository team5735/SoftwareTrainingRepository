package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.MotorSubsystemConstants;

public class MotorSubsystem extends SubsystemBase {
    private final SparkMax sparkMax_pull = new SparkMax(Constants.mot, com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);
    private final SparkBaseConfig sparkConfig = new SparkMaxConfig().inverted(true);
    public MotorSubsystem() {
        
        sparkMax_pull.configure(sparkConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public void pull() {
        sparkMax_pull.setVoltage(MotorSubsystemConstants.PULL_VOLTS);
    }

    public void push() {
        sparkMax_pull.setVoltage(-MotorSubsystemConstants.PUSH_VOLTS);
    }

    public void stop() {
        sparkMax_pull.setVoltage(0);
    }

    public Command pullStopCommand() {
        return startEnd(() -> pull(), () -> stop());
    }

    public Command pushStopComman() {
        return runOnce(() -> push());
    }

    public Command stopCommand() {
        return runOnce(() -> stop());
    }
}