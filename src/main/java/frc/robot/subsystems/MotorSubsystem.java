package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.MotorConstants;

public class MotorSubsystem extends SubsystemBase {

    private final SparkMax sparkMax_pull = new SparkMax(Constants.num, MotorType.kBrushless);
    private final TalonFX talon_pull = new TalonFX(Constants.num2);
    private final SparkBaseConfig sparkConfig = new SparkMaxConfig().inverted(true);
    private Supplier<Double> supplierR, supplierL;
    private boolean sparkMaxOn;


    public MotorSubsystem(Supplier<Double> supplierR, Supplier<Double> supplierL) {
        sparkMax_pull.configure(sparkConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        talon_pull.setVoltage(MotorConstants.runVolts);
        this.supplierR = supplierR;
        this.supplierL = supplierL;
    }

    public void runSparkMax(){
        talon_pull.setVoltage(0);
        sparkMaxOn = true;
    }

    public void runTalon(){
        sparkMax_pull.setVoltage(0);
        sparkMaxOn = false;
    }

    public void setSpeed(double speedR, double speedL){
        if (sparkMaxOn) {
            if (supplierR.get() > supplierL.get()){
                sparkMax_pull.setVoltage(speedR+1);
            }else{
                sparkMax_pull.setVoltage(-speedL-1);
            }
        }else{
            if (supplierR.get() > supplierL.get()){
                talon_pull.setVoltage(speedR+1);
            }else{
                talon_pull.setVoltage(-speedL-1);
            }
        }
    }

    @Override
    public void periodic(){
        setSpeed(supplierR.get(), supplierL.get());
    }
}