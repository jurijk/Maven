import java.sql.*;

public class Connect {
    static final String USER = "root";//логин доступа к базе
    static final String PASSWORD = "Magnum1783";//пароль доступа к базе
    static final String URL = "jdbc:mysql://localhost:3306/mysql?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver;
        try {
            driver = new com.mysql.cj.jdbc.Driver();//создание драйвера подключения к базе
            DriverManager.registerDriver(driver);//регистрация драйвера
        }catch (SQLException ex){
            System.out.println("Драйвер не зарегистрировался");
            ex.printStackTrace();
            return;
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);//создаем подключение
            System.out.println("Получен connection");
            Statement statement = connection.createStatement();//создаем контейнер для выполнения запросов к базе данных
            System.out.println("Получен statement");
            ResultSet resSet;

             String sql = "select * from student.students";
            resSet = statement.executeQuery(sql);
            while (resSet.next())
                System.out.println(resSet.getInt("id_student") + " : " + resSet.getString("first_second_name")
                        + " : " + resSet.getInt("id_class") + " : " + resSet.getInt("year_receipt"));

            System.out.println("--------------------------------------------- ");

            String sql1 = String.format("select * from student.students where year_receipt = %d",2017);
            resSet = statement.executeQuery(sql1);
            //select * from student.students where year_receipt = 2017

            while (resSet.next())
                System.out.println(resSet.getInt("id_student") + " : " + resSet.getString("first_second_name")
                        + " : " + resSet.getInt("id_class") + " : " + resSet.getInt("year_receipt"));

            System.out.println("--------------------------------------------- ");

            String sql2 = String.format("select student.students.first_second_name, student.classes.index_class from student.students \n" +
                    "inner join student.classes on students.id_class = classes.id_class where classes.index_class = %s", "'Java 1'");

            resSet = statement.executeQuery(sql2);

            while (resSet.next())
                System.out.println(resSet.getString("first_second_name") + " : " + resSet.getString("index_class"));

            System.out.println("--------------------------------------------- ");

            String sql3 = String.format("select student.students.first_second_name, student.points.point_st, student.lessons.name_of_lesson, student.teachers.first_cecond_name from student.students\n" +
                    "inner join student.points on student.students.id_student = points.id_student\n" +
                    "inner join student.lessons on student.points.id_lesson = lessons.id_lesson\n" +
                    "inner join student.teachers on student.lessons.id_teacher = teachers.id_teacher\n" +
                    "where students.id_student = %d", 3);

           resSet = statement.executeQuery(sql3);
            while (resSet.next())
                System.out.println(resSet.getString("first_second_name") + " : " + resSet.getInt("point_st")
                        + " : " + resSet.getString("name_of_lesson") + " : " + resSet.getString("first_cecond_name"));

            System.out.println("--------------------------------------------- ");

            String sql4 = String.format("select first_second_name as Avg_count from student.students where id_student = %d\n " +
                    " union select avg(point_st)  from student.points where id_student = %d",5, 5);

            resSet = statement.executeQuery(sql4);
            while (resSet.next())
                System.out.println(resSet.getString("Avg_count") );

        }catch (SQLException ex){
            System.out.println("Соединение не установлено");
            ex.printStackTrace();
            return;
        }
        finally {
            if (connection != null)
                connection.close();//закрытие соединения после использования

            System.out.println("Соединение закрыто");
        }
    }
}




