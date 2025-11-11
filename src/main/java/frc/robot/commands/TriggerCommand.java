package frc.robot.commands;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

public class TriggerCommand extends Command{
    
   
    private DoubleSupplier triggerVal;

    public TriggerCommand(DoubleSupplier triggerVal) {
        this.triggerVal = triggerVal;

    }

    @Override
    public void execute() {
     triggerVal.getAsDouble();
     
       
    }

    @Override
    public void initialize() {
        
    }
}
