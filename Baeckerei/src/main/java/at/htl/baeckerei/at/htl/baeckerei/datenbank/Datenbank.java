package at.htl.baeckerei.at.htl.baeckerei.datenbank;

import at.htl.baeckerei.model.Kunde;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Datenbank {
    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db;create=true";
    static final String USER = "app";
    static final String PASSWORD = "app";
    private static Connection conn;

    //InitJdbc
    public static void initJdbc(){
        //Verbindung zur DB herstellen
        try{
            Class.forName(DRIVER_STRING);
            conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("Verbindung zur Datenbank nich möglich: \n"
                + e.getMessage() + "\n");
            System.exit(1);
        }
    }

    //TearDown
    public static void teardownJdbc(){
        try{
            if(conn != null || !conn.isClosed()){
                conn.close();
                System.out.println("Goodbye!");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Select Kunde
    public Kunde getKunde(int id) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement (
                "select id, name from KUNDE where id=?");
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        Kunde kunde = new Kunde();
        if(rs.next()) {
            kunde.setId(rs.getInt(1));
            kunde.setName(rs.getString(2));
        }
        rs.close();
        preparedStatement.close();
        return kunde;
    }

    //Select alle Kunden
    public List<Kunde> getAllKunden() throws SQLException {
        LinkedList<Kunde> kundenList = new LinkedList<>();
        PreparedStatement preparedStatement = conn.prepareStatement (
                "select * from KUNDE");
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
            Kunde kunde = new Kunde();
            kunde.setId(rs.getInt(1));
            kunde.setName(rs.getString(2));
            kundenList.add(kunde);
        }
        rs.close();
        preparedStatement.close();
        return kundenList;
    }

    //Update Kunde
    public void updateKunde(Kunde kunde) throws SQLException{
        PreparedStatement updateKundePreparedStatement = conn.prepareStatement(
                "update KUNDE set NAME = ? where ID = ?");
        updateKundePreparedStatement.setString(1, kunde.getName());
        updateKundePreparedStatement.setInt(2, kunde.getId());
        updateKundePreparedStatement.close();
    }

    //Delete Kunde
    public void deleteKunde(Kunde kunde) throws SQLException{
        PreparedStatement deleteKundePreparedStatement =
                conn.prepareStatement("delete from KUNDE where ID = ?");
        deleteKundePreparedStatement.setInt(1, kunde.getId());
        deleteKundePreparedStatement.executeUpdate();
    }

    //Insert Kunde
    public Kunde insertKunde(Kunde kunde) throws SQLException{
        PreparedStatement insertKundePreparedStatement =
                conn.prepareStatement("insert into KUNDE(ID, NAME) values (?, ?)");
        insertKundePreparedStatement.setInt(1, kunde.getId());
        insertKundePreparedStatement.setString(2, kunde.getName());
        insertKundePreparedStatement.executeUpdate();
        insertKundePreparedStatement.close();
        return kunde;
    }
}
