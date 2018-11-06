package com.haiberg.automation.jdbc;

import java.io.IOException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class DBHelper {

	private final String url;
	private final String username;
	private final String password;
	private final String driverCls;
	
	private Connection connection;
	private static DBHelper instance = new DBHelper();
	private DBHelper(){
		Properties properties = new Properties();
		try {
			properties.load(DBHelper.class.getResourceAsStream("/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		url = properties.getProperty("jdbc.url");
		username = properties.getProperty("jdbc.username");
		password = properties.getProperty("jdbc.password");
		driverCls = properties.getProperty("jdbc.driver");
	}
	
	public static DBHelper getInstance(){
		return instance;
	}
	
	public void updateDB(String sql, Object... params){
		
		QueryRunner runner = new QueryRunner();
		Connection connection = null;
		try {
			connection = getConnection();
			runner.update(connection, sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void updateDB(String sql){
		updateDB(sql, null);
	}
	
	public Connection getConnection() throws SQLException{
		if(connection != null && !connection.isClosed()){
			return connection;
		}
		Driver driver = null;
		try{
			Class<?> cls = Class.forName(driverCls);
			driver = (Driver) cls.newInstance();
			Properties info = new Properties();
			info.setProperty("user", username);
			info.setProperty("password", password);
			return driver.connect(url, info);
		}catch (Exception e) {
			throw new RuntimeException("Create connectin failure", e);
		}
	}
	
	public List<Map<String, Object>> executeQuery(String sql, Object... params){
		QueryRunner runner = new QueryRunner();
		Connection connection = null;
		try {
			connection = getConnection();
			return runner.query(connection, sql, new MapListHandler(), params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	
	
	public List<Map<String, Object>> executeQuery(String sql){
		return executeQuery(sql, null);
	}
	
	public static void main(String[] args){
		DBHelper dbHelper = DBHelper.getInstance();
		List<Map<String, Object>> result = dbHelper.executeQuery("select * from cad_object where id = ? and scope = ?", 20, 1);
		showResult(result);
	}
	
	private static void showResult(List<Map<String, Object>> result){
		if(result == null || result.isEmpty()){
			System.out.println("empty");
		}else{
			for(Map<String, Object> row : result){
				for(Entry<String, Object> item : row.entrySet()){
					System.out.print(item.getKey()+":"+item.getValue());
					System.out.print(", ");
				}
				System.out.println();
			}
		}
	}
}
