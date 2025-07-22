import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class UsersTable {
    public static void main(String[] args) throws IOException {
        String sql = "insert into users_shyam values (?,?,?)";
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\ATPLD14\\IdeaProjects\\SqlDemo\\src\\db.properties");
            props.load(fis);
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement prepare_st = con.prepareStatement(sql);
            prepare_st.setInt(1,104);
            prepare_st.setString(2,"gill");
            prepare_st.setString(3,"gill@sachin.com");
            int rows_inserted=prepare_st.executeUpdate();
            if(rows_inserted>0){
                System.out.println("New user is inserted");
            }
            System.out.println("inserted successfully");
        } catch (SQLException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
