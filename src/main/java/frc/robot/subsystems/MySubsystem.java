package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.MySubsystemConstants;

public class MySubsystem extends SubsystemBase {


    private final SparkMax motor = new SparkMax(Constants.FISH, MotorType.kBrushless);
    private final TalonFX motor2 = new TalonFX(Constants.TALONID);
    private boolean sparkMax;
    public boolean isPressed = false;
    private Supplier<Double> supplierRight;
    private Supplier<Double> supplierLeft;

    private final SparkMaxConfig con = new SparkMaxConfig();



    public MySubsystem(Supplier<Double> supplierRight, Supplier<Double> supplierLeft) {
        con.inverted(true);
        motor.configure(con, null, null);
        this.supplierRight = supplierRight;
        this.supplierLeft = supplierLeft;
    }

    public void clockSpin(){
        motor.setVoltage(MySubsystemConstants.VOLTS);
        if(isPressed){
            motor2.setVoltage(MySubsystemConstants.VOLTS);
            motor.setVoltage(0);

        }
    }
    
    public void counterSpin(){
        motor.setVoltage(-MySubsystemConstants.VOLTS);
        if(isPressed){
            motor2.setVoltage(-MySubsystemConstants.VOLTS);
            motor.setVoltage(0);

        }
    }

    public void stop(){
        motor.setVoltage(0);
        motor.setVoltage(0);
    }

    public void setSpeed(double x, double y){
        double voltClock = MySubsystemConstants.VOLTS + x;
        double voltCounter = -MySubsystemConstants.VOLTS - y;
        if(x == 0){
            voltClock = 0;
        }
        if(y == 0){
            voltCounter = 0;
        }
        

        if(sparkMax){
            //double voltTemp = MySubsystemConstants.VOLTS + x;
            motor.setVoltage(voltClock + voltCounter);
            
        } else {
            //double voltTemp = MySubsystemConstants.VOLTS + x;
            motor2.setVoltage(voltClock + voltCounter);
        }
    }

    @Override
    public void periodic(){
        setSpeed(supplierRight.get(), supplierLeft.get());
    }

    
    
    

}
