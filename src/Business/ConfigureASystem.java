package Business;

import Business.Employee.Employee;
import Business.Role.ApplicationRegistrar;
import Business.Role.NoticeWorker;
import Business.Role.EligibilityWorker;

import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        
        UserAccount ua1 = system.getUserAccountDirectory().createUserAccount("aradmin", "aradmin", employee, new ApplicationRegistrar());
        UserAccount ua2 = system.getUserAccountDirectory().createUserAccount("nwadmin", "nwadmin", employee, new NoticeWorker());
        UserAccount ua3 = system.getUserAccountDirectory().createUserAccount("ewadmin", "ewadmin", employee, new EligibilityWorker());

        return system;
    }
    
}
