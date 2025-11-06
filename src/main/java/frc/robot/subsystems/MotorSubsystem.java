package frc.robot.subsystems;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
    private final SparkMax sparkMax_pull2 = new SparkMax(Constants.mot2, com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);
    public MotorSubsystem() {
        
        sparkMax_pull.configure(sparkConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        sparkMax_pull2.configure(sparkConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);

    }

    public void pull() {
        sparkMax_pull.setVoltage(MotorSubsystemConstants.PULL_VOLTS);
        sparkMax_pull2.setVoltage(MotorSubsystemConstants.STOP_VOLTS);

    }

    // public void push() {
    //     sparkMax_pull.setVoltage(-MotorSubsystemConstants.PUSH_VOLTS);
    //     sparkMax_pull2.setVoltage(-MotorSubsystemConstants.PUSH_VOLTS);

    // }

    public void stop() {
        sparkMax_pull.setVoltage(MotorSubsystemConstants.STOP_VOLTS);
        sparkMax_pull2.setVoltage(MotorSubsystemConstants.PULL_VOLTS);

    }
}