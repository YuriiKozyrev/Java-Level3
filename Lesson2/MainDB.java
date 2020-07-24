package Java_Level3.Lesson2;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class MainDB {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;


    public static void main(String[] args) throws SQLException {
        try {
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dropTable();
        createTable();
        addElementsInTable();
        getDataDB();
        try {
            updateElementsInTableFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        close();
    }

    public static void getDataDB() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM citizens");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + rs.getString("name"));
        }
    }

    public static void dropTable() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS citizens");
    }

    public static void createTable() throws SQLException {
        stmt.executeUpdate("CREATE TABLE citizens (" +
                "id INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "score INT)");
    }

    public static void addElementsInTable() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i < 11; i++) {
            pstmt = connection.prepareStatement("INSERT INTO citizens (name, score) VALUES (?, ?)");
            pstmt.setString(1, "Bob" + i);
            pstmt.setInt(2, 1);
            pstmt.execute();
        }
        connection.setAutoCommit(true);
    }

    public static void updateElementsInTableFromFile() throws FileNotFoundException, SQLException {
        int id, score;
        String [] splitted;
        Scanner sc = new Scanner(new File("c:\\test.txt"));

        while(sc.hasNext()){

            splitted = sc.nextLine().split(" ");
            id = Integer.parseInt(splitted[0]);
            score = Integer.parseInt(splitted[2]);

            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement("UPDATE citizens SET score = ? WHERE id = ?");
            pstmt.setInt(1, score);
            pstmt.setInt(2, id);
            pstmt.execute();
            connection.setAutoCommit(true);
        }
    }

    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:maintest.db");
        stmt = connection.createStatement();
    }

    private static void close() throws SQLException {
        connection.close();
    }
}
