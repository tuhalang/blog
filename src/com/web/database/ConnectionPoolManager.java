/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author hungpv
 */
public class ConnectionPoolManager {
    
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolManager.class);

    private static final Map<String, DataSource> DATASOURCE_MAP = new ConcurrentHashMap<>();
    private static final Map<String, Properties> PROPERTIES_MAP = new ConcurrentHashMap<>();

    public synchronized static void loadConfig(String path) {
        try {
            InputStream is = new FileInputStream(path);
            Properties pro = new Properties();
            pro.load(is);
            
            String dbName = pro.getProperty("name");
            
            ConnectionPoolObject obj = new ConnectionPoolObject(pro);
            
            DATASOURCE_MAP.put(dbName, obj.createConnectionPool());
            PROPERTIES_MAP.put(dbName, pro);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
    
    public synchronized static DataSource getDatasource(String dbName){
        DataSource dataSource = null;
        if (DATASOURCE_MAP.containsKey(dbName)) {
            dataSource = DATASOURCE_MAP.get(dbName);
        } else {
            LOGGER.error("Not found datasource with id: " + dbName);
        }
        return dataSource;
    }
    
    public synchronized static Connection getConnection(String dbName){
        Connection conn = null;
        try {
            if (DATASOURCE_MAP.containsKey(dbName)) {
                conn = (DATASOURCE_MAP.get(dbName)).getConnection();
            } else {
                LOGGER.error("Not found datasource with id: " + dbName);
            }
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return conn;
    }
}
