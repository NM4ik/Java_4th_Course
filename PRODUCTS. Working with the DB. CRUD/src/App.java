import Cases.DeleteProduct;
import Cases.EditProduct;
import SqlRequests.allProductsSqlRequest;
import Cases.AddProduct;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        int i = 1;

        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("simple AIS of products : ");
            System.out.println("""
                    Choose variant: 
                    1. show all products.
                    2. add product.
                    3. delete product.
                    4. edit product.
                    5. exit.
                    """);
            System.out.print("Choose something:  ");
            int variant = scanner.nextInt();

            switch (variant){
                case 1:
                    System.out.println("All products: ");
                    System.out.println(allProductsSqlRequest.AllProducts());
                    System.out.println("---------------------------------");
                    break;
                case 2:
                    AddProduct.addProduct();
                    break;
                case 3:
                    DeleteProduct.deleteProduct();
                    break;
                case 4:
                    EditProduct.editProduct();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Non-existing item");
                    break;
            }
        }
    }

}
