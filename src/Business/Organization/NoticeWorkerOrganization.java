/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.NoticeWorker;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class NoticeWorkerOrganization extends Organization{

    public NoticeWorkerOrganization() {
        super(Organization.Type.NoticeWorker.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NoticeWorker());
        return roles;
    }
     
   
    
    
}
