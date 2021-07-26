package tk.felixfab.sql;

import tk.felixfab.sql.sql.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SQLApi {

    private String host;
    private String database;
    private String user;
    private String psw;

    public SQLApi(String host,String database,String user,String psw){
        Objects.requireNonNull(host,"");
        Objects.requireNonNull(database,"");
        Objects.requireNonNull(user,"");

        this.host = host;
        this.database = database;
        this.user = user;
        this.psw = psw;
    }

    /**
     * Try to connect with the database
     */
    public void connect(){
        MySQL.connect(host,database,user,psw);
    }

    /**
     * Check if you already connected with the database
     *
     * @return Boolean
     */
    public Boolean isConnected(){
        return MySQL.isConnected();
    }

    /**
     * Try to disconnect from the database
     */
    public void disconnect(){
        MySQL.disconnect();
    }

    /**
     * Send update command to the database
     *
     * @param cmd command
     * @throws SQLException
     */
    public void update(String cmd) throws SQLException {
        MySQL.onUpdate(cmd);
    }

    /**
     * Get Data from the database with a command
     *
     * @param cmd command
     * @return ResultSet Data from the database
     * @throws SQLException
     */
    public ResultSet query(String cmd) throws SQLException {
        return MySQL.onQuery(cmd);
    }

    /**
     * Change Host
     *
     * @param host String
     */
    public void setHost(String host){
        this.host = host;
    }

    /**
     * Change Database
     *
     * @param database String
     */
    public void setDatabase(String database){
        this.database = database;
    }

    /**
     * Change User
     *
     * @param user String
     */
    public void setUser(String user){
        this.user = user;
    }

    /**
     * Change Password
     *
     * @param psw String
     */
    public void setPsw(String psw){
        this.psw = psw;
    }
}
