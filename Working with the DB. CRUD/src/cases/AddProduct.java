package cases;

import Entity.Product;
import SqlRequests.AddProductSqlRequest;

import java.sql.SQLException;
import java.util.Scanner;

public class AddProduct {
    public static void addProduct() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                You want to add a new Product : 
                Enter data: title, cost, count.
                """);

        System.out.println("Enter title: ");
        String title =  scanner.nextLine();

        System.out.println("Enter cost: ");
        int cost = scanner.nextInt();

        System.out.println("Enter count: ");
        int countInStock = scanner.nextInt();

        Product newProduct = new Product(1, title, cost, countInStock);



        if(AddProductSqlRequest.addProduct(newProduct)){
            System.out.println("Well done");
        }else System.out.println("Product wasn't added");
    }
}
