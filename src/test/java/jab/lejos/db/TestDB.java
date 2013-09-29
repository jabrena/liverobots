
package jab.lejos.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class TestDB {

    private Connection conn;

    public TestDB(String db_file_name_prefix) throws Exception {
        Class.forName("org.hsqldb.jdbcDriver");
        conn = DriverManager.getConnection("jdbc:hsqldb:"
                                           + db_file_name_prefix,    // filenames
                                           "sa",                     // username
                                           "");                      // password
    }

    public void shutdown() throws SQLException {

        Statement st = conn.createStatement();
        st.execute("SHUTDOWN");
        conn.close();
    }

    //use for SQL command SELECT
    public synchronized void query(String expression) throws SQLException {

        Statement st = null;
        ResultSet rs = null;

        st = conn.createStatement();
        rs = st.executeQuery(expression);
        dump(rs);
        st.close();
    }

    //use for SQL commands CREATE, DROP, INSERT and UPDATE
    public synchronized void update(String expression) throws SQLException {

        Statement st = null;
        st = conn.createStatement();
        int i = st.executeUpdate(expression);
        if (i == -1) {
            System.out.println("db error : " + expression);
        }

        st.close();
    }

    public static void dump(ResultSet rs) throws SQLException {

        ResultSetMetaData meta   = rs.getMetaData();
        int               colmax = meta.getColumnCount();
        int               i;
        Object            o = null;

        for (; rs.next(); ) {
            for (i = 0; i < colmax; ++i) {
                o = rs.getObject(i + 1);
                System.out.print(o.toString() + " ");
            }

            System.out.println(" ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        TestDB db = null;

        System.out.println(System.getProperty("user.dir"));
        Properties props = new Properties();
        props.load(new FileInputStream("/home/root/lejos/examples/Brity/lib/log4j.properties"));
        PropertyConfigurator.configure(props);
    
        try {
            db = new TestDB("db_file");
        } catch (Exception ex1) {
            ex1.printStackTrace();    // could not start db

            return;                   // bye bye
        }

        try {
            db.update(
                "CREATE TABLE sample_table ( id INTEGER IDENTITY, str_col VARCHAR(256), num_col INTEGER)");
        } catch (SQLException ex2) {

        }

        try {
            db.update("INSERT INTO sample_table(str_col,num_col) VALUES('Ford', 100)");
            db.update("INSERT INTO sample_table(str_col,num_col) VALUES('Toyota', 200)");
            db.update("INSERT INTO sample_table(str_col,num_col) VALUES('Honda', 300)");
            db.update("INSERT INTO sample_table(str_col,num_col) VALUES('GM', 400)");

            // do a query
            db.query("SELECT * FROM sample_table WHERE num_col < 250");
            db.shutdown();

        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
    }
}