package Launcher;

import GUI.EmployeeRecords;
import GUI.Home;

public class Launcher {

    public static void main(String[] args) {
        // Create an instance of EmployeeRecords
        EmployeeRecords recordsWindow = new EmployeeRecords();
        // Pass the instance of EmployeeRecords to the Home constructor
        var home = new Home(recordsWindow);
    }

}

