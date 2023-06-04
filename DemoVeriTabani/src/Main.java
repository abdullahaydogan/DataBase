import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        DbHelper dbHelper=new DbHelper();
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection=dbHelper.getConnection();
            System.out.println("Connection Successful***");//Veri tabanıyla bağlantı kurulup kurulmadığını görmek istedim
            statement= connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM personel");
            ArrayList<Personnel>personels=new ArrayList<Personnel>();
            while (resultSet.next()){
               personels.add(new Personnel(
                       resultSet.getInt(1),// veri tabanındaki personelin id
                       resultSet.getString(2),//veri tabanındaki personelin adı
                       resultSet.getString(3),//veri tabanındaki personelin soyadı
                       resultSet.getString(4)//veri tabanındaki personelin email
               ));
            }
            System.out.println(personels.size());// veri tabanından gelen bilgilerin Personnels klasıma eklenip eklenmediğini kontrol ettim
                                                 // veri tabanına 4 personel eklemiştim
        } catch (SQLException sqlException) {
            dbHelper.showErrorMessage(sqlException);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error shutting down: "+e);
            }
        }


    }
}