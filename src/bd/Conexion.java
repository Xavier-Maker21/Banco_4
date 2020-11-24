package bd;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection; // Clase para poder conectar
import java.sql.Statement; // Clase para enviar consultas SQL
import java.sql.ResultSet; // Clase para obtener los datos o resultados de
// un select
import java.sql.SQLException; // Para manejar excepciones de SQL

public class Conexion {

    private Connection oConnection;
    public Statement oStatement;
    public ResultSet oResultSet;

    public Conexion(String server, String bd, String user, String pass) throws SQLException {
        MysqlDataSource mysql = new MysqlDataSource();
        mysql.setServerName(server);
        mysql.setDatabaseName(bd);
        mysql.setUser(user);
        mysql.setPassword(pass);
        oConnection = mysql.getConnection();
    }

    /**
     * @param sql - Puede ser un Delete, Update o Insert
     * @throws java.sql.SQLException
     */
    public void ejecutar(String sql) throws SQLException {
        oStatement = oConnection.createStatement();
        oStatement.executeUpdate(sql);
        oStatement.close();
    }

    /**
     * @param select consulta select
     * @return un objeto del Tipo ResultSet
     * @throws SQLException
     *
     */
    public ResultSet ejecutarSelect(String select) throws SQLException {
        oStatement = oConnection.createStatement();
        oResultSet = oStatement.executeQuery(select);
        return oResultSet;
    }
}
