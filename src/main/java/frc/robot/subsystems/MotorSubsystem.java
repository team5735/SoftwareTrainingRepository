package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.constants.Constants;
import frc.robot.constants.MotorSubsystemConstants;

public class MotorSubsystem extends SubsystemBase {
    private final SparkMax sparkMax_pull = new SparkMax(Constants.mot,
            com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);
    private final SparkBaseConfig sparkConfig = new SparkMaxConfig().inverted(true);

    private final TalonFX talonFX_pull = new TalonFX(Constants.mot2);
    private boolean TalonFXOn;
    private Supplier<Double> supplier;

    public MotorSubsystem(Supplier<Double> supplier) {
        sparkMax_pull.configure(sparkConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        talonFX_pull.setVoltage(MotorSubsystemConstants.PULL_VOLTS);
        this.supplier = supplier;
    }

    public void runSpark() {
        sparkMax_pull.setVoltage(MotorSubsystemConstants.PULL_VOLTS);
        talonFX_pull.setVoltage(MotorSubsystemConstants.STOP_VOLTS);
        TalonFXOn = false;
    }

    // public void push() {
    // sparkMax_pull.setVoltage(-MotorSubsystemConstants.PUSH_VOLTS);
    // sparkMax_pull2.setVoltage(-MotorSubsystemConstants.PUSH_VOLTS);

    // }

    public void runTalon() {
        sparkMax_pull.setVoltage(MotorSubsystemConstants.STOP_VOLTS);
        talonFX_pull.setVoltage(MotorSubsystemConstants.PULL_VOLTS);
    TalonFXOn = true;
    }
    public void setSpeed(double triggerValue){
            if (TalonFXOn){
            talonFX_pull.setVoltage(1+ triggerValue);
           }  
           else{
            sparkMax_pull.setVoltage(1+ triggerValue);
           }
     }
     @Override
     public void periodic() {
         setSpeed(supplier.get());
     }
}