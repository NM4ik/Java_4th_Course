package Cases;

import SqlRequests.AddProductSqlRequest;
import SqlRequests.DeleteProductSqlRequest;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteProduct {
    public static void deleteProduct() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Which of products you want delete?
                """);

        System.out.println("Enter id: ");
        int id = scanner.nextInt();

        if(DeleteProductSqlRequest.deleteProduct(id)){
            System.out.println("Product was deleted");
        }else System.out.println("Product wasn't deleted");

    }
}
