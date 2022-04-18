package Cases;

import Entity.Product;
import SqlRequests.DeleteProductSqlRequest;
import SqlRequests.EditProductSqlRequest;

import java.sql.SQLException;
import java.util.Scanner;

public class EditProduct {
        public static void editProduct() throws SQLException {
            Scanner scanner = new Scanner(System.in);

            System.out.println("""
                Which of products you want edit?
                """);

            System.out.println("Enter id: ");
            int id = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Enter title: ");
            String title = scanner.nextLine();

            System.out.println("Enter cost: ");
            int cost = scanner.nextInt();

            System.out.println("Enter count: ");
            int countInStock = scanner.nextInt();

            Product editProduct = new Product(1, title, cost, countInStock);


            if(EditProductSqlRequest.editProduct(id, editProduct)){
                System.out.println("Product was edited");
            }else System.out.println("Product wasn't edited");

        }
}
