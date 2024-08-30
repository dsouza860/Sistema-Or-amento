
package br.com.sistema.mgs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mgs?characterEncoding=utf8", "root", "chkdsk");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
