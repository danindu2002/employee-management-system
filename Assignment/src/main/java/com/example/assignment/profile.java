package com.example.assignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class profile {

    public profile() throws SQLException {
    }

    public String[] ppLabels() throws SQLException {
        String[] labels = new String[4];

        HelloController profile = new HelloController();
        String uName = profile.Username;
        String uPassword = profile.Password;

        DatabaseConnection conPp = new DatabaseConnection();
        Connection dbPp = conPp.getdbconnection();

        String sqlQuerry = "SELECT`First_Name`,`Last_Name`,`Department`,`ID` FROM `ems`.`employee_details` WHERE Username = '" + uName + "'AND Password = '"+uPassword+"'";

        Statement ppStatement = dbPp.createStatement();
        ResultSet ppResultSet = ppStatement.executeQuery(sqlQuerry);


        if (ppResultSet.next()) {

            labels[0] = ppResultSet.getString(1);
            labels[1] = ppResultSet.getString(2);
            labels[2] = ppResultSet.getString(3);
            labels[3] = ppResultSet.getString(4);

        }

        return labels;
    }
}

