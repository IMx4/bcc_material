package com.bcc.mm;

import com.bcc.mm.dto.EmployeeDTO;

public class AppState {


    public static EmployeeDTO user = null;

    public static boolean isAdmin(){

        if(user.getJobPosition().equals("admin")){
            return true;
        } else {

            return false;
        }

    }

}
