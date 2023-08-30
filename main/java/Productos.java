import java.sql.*;
import java.util.Scanner;

public class Productos {
    public static void main(String[] args) {
        int celular = 700;
        int computador = 1000;
        int televisor = 1200;

        Scanner scanner = new Scanner(System.in);
        System.out.println("***BIENVENIDOS***");

        System.out.print("¿Que dispositivo deseas adquirir?: ");
        String dispositivo = scanner.nextLine();


        if (dispositivo.equals("celular") || dispositivo.equals("televisor")){

            System.out.print("Ingrese marca del dispositivo: ");
            String marca = scanner.nextLine();

            System.out.print("Ingrese color del dispositivo: ");
            String color = scanner.nextLine();

            System.out.print("Ingrese sus especificaciones: ");
            String especificaciones = scanner.nextLine();

            System.out.println("¿Que cantidad deseas adquirir: ");
            int cantidad = scanner.nextInt();

            int Valor_total = 0;

            if (marca.equals("") ||  especificaciones.equals("")) {
                System.out.println("No se admiten datos vacios.");
            }

            if (dispositivo.equals("celular")) {
                Valor_total = cantidad * celular;
                System.out.println("Su valor a pagar es: " + Valor_total);
            } else if (dispositivo.equals("computador")) {
                Valor_total = cantidad * computador;
                System.out.println("Su valor a pagar es: " + Valor_total);
            } else if (dispositivo.equals("televisor")) {
                Valor_total = cantidad * televisor;
                System.out.println("Su valor a pagar es: " + Valor_total);
            }

            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/productos_tecnologicos";
            String username = "root";
            String password = "";

            try {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM `productos tecnológicos`");//TABLA


                Insert(dispositivo, marca, color, especificaciones, cantidad, Valor_total, connection);
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Insert(String dispositivo, String marca, String color, String especificaciones, int cantidad, int Valor_total, Connection connection){

        try {
            // Sentencia INSERT
            String sql = "INSERT INTO `productos tecnológicos` (dispositivo, marca, color, especificaciones, cantidad, Valor_total) VALUES (?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dispositivo);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, color);
            preparedStatement.setString(4, especificaciones);
            preparedStatement.setInt(5, cantidad);
            preparedStatement.setInt(6, Valor_total);

            // Ejecutar la sentencia
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Poducto " + dispositivo + " agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar el producto.");
            }

            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}