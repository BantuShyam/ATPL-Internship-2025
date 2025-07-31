import java.sql.*;
import java.util.Arrays;

public class BatchProcessing {
    public static void main(String[] a) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String username = "intern2025";
        String password = "intern2025";
        String sql = "insert into users_shyam values(?,?,?)";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            PreparedStatement pt_st = con.prepareStatement(sql);
            pt_st.setInt(1,105);
            pt_st.setString(2,"raina");
            pt_st.setString(3,"ss@gmail.com");
            pt_st.addBatch();
            pt_st.setInt(1,106);
            pt_st.setString(2,"klrahul");
            pt_st.setString(3,"kkl@gmail.com");
            pt_st.addBatch();
            pt_st.setInt(1,107);
            pt_st.setString(2,"karun nair");
            pt_st.setString(3,"dc@gmail.com");
            pt_st.addBatch();
            int[] count=pt_st.executeBatch();
            con.commit();
            System.out.println(Arrays.toString(count));
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
