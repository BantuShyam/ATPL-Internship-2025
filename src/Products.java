import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Products {
    public static void main(String[] a) throws IOException {
        String sql = "select * from products_shyam";
        Properties props=new Properties();
//        String url = "jdbc:mysql://192.168.71.15:3306/intern";
//        String username = "intern2025";
//        String password = "intern2025";
//          Class.forName("com.mysql.jdbc.Driver");
        try {
            FileInputStream fis=new FileInputStream("C:\\Users\\ATPLD14\\IdeaProjects\\SqlDemo\\src\\db.properties");
            props.load(fis);
            String url=props.getProperty("db.url");
            String username=props.getProperty("db.username");
            String password=props.getProperty("db.password");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd=rs.getMetaData();
            //int count=rsmd.getColumnCount();
            System.out.println(rsmd.getColumnName(1)+" "+rsmd.getColumnName(2)+" "+rsmd.getColumnName(3));
            while (rs.next()) {
                System.out.println(rs.getString("id") + " " + rs.getString("product_name"));
            }
            con.close();
            st.close();
            rs.close();
        } catch (SQLException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
