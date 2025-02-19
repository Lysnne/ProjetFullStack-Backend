package ikasaidi.backend.service;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

public class ServiceGeneral {
    private static Logger logger = Logger.getLogger(ServiceGeneral.class.getName());

    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("./data/application.properties"));
        return DriverManager.getConnection(
                props.getProperty("datasource.url"),
                props.getProperty("datasource.username"),
                props.getProperty("datasource.password")
        );
    }

}
