package at.htl.baeckerei;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaeckereiTest {
    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db;create=true";
    static final String USER = "app";
    static final String PASSWORD = "app";
    private static Connection conn;

    @BeforeClass
    public static void initJdbc(){
        try{
            Class.forName(DRIVER_STRING);
            conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Verbindung zur Datenbank nicht möglich: \n"
                + e.getMessage());
            System.exit(1);
        }
    }

    @AfterClass
    public static void teardownJdbc(){
        //Table Kunde löschen
        try{
            conn.createStatement().execute("DROP TABLE kunde");
            System.out.println("Tabelle KUNDE gelöscht");
        } catch (SQLException e) {
            System.out.println("Tabelle KUNDE konnte nicht gelöscht werden:\n" +
                    e.getMessage());
        }

        //Connection schließen
        try{
            if(conn != null || !conn.isClosed()){
                conn.close();
                System.out.println("Goodbye!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ddl(){
        try{
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE kunde("+
                    "   id int constraint kunde_pk PRIMARY KEY,"+
                    "   name varchar(20) not null)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void dml(){
        //Daten einfügen
        int countInserts = 0;
        try{
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO kunde (id, name) values (1, 'Lisa')";
            countInserts += stmt.executeUpdate(sql);
            sql = "INSERT INTO kunde (id, name) values(2, 'Stefan')";
            countInserts += stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(countInserts, is(2));

        //Daten abfragen
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, name from kunde");
            ResultSet rs = pstmt.executeQuery();

            rs.next();
            assertThat(rs.getString("NAME"), is("Lisa"));
            rs.next();
            assertThat(rs.getString("NAME"), is("Stefan"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
