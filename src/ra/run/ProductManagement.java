package ra.run;

import ra.businessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    private static List<Product> productList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số sản phẩm và nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputProduct(scanner);
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    sortProductsByInterest();
                    break;
                case 4:
                    deleteProductById(scanner);
                    break;
                case 5:
                    searchProductByName(scanner);
                    break;
                case 6:
                    changeProductStatus(scanner);
                    break;
                case 7:
                    isRunning = false;
                    System.out.println("Đã thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Nhập thông tin sản phẩm
    private static void inputProduct(Scanner scanner) {
        System.out.print("Nhập số sản phẩm cần nhập thông tin: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho sản phẩm thứ " +(i+1));
            Product product = new Product();
            product.inputData(scanner);
            productList.add(product);
        }
    }

    // Hiển thị thông tin các sản phẩm
    private static void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Không có sản phẩm nào để hiển thị.");
            return;
        }
        for (Product product : productList) {
            product.displayData();
        }
    }

    // Sắp xếp sản phẩm theo lợi nhuận tăng dần
    private static void sortProductsByInterest() {
        if (productList.isEmpty()) {
            System.out.println("Không có sản phẩm nào để sắp xếp.");
            return;
        }
        Collections.sort(productList);
        System.out.println("Đã sắp xếp sản phẩm theo lợi nhuận tăng dần.");
    }

    // Xóa sản phẩm theo mã sản phẩm
    private static void deleteProductById(Scanner scanner) {
        if (productList.isEmpty()) {
            System.out.println("Không có sản phẩm nào để xóa.");
            return;
        }
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int deleteID = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getProductId() == deleteID) {
                productList.remove(i);
                found = true;
                System.out.println("Đã xóa sản phẩm có mã sản phẩm: " + deleteID);
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm có mã sản phẩm: " + deleteID);
        }
    }

    // Tìm kiếm sản phẩm theo tên sản phẩm
    private static void searchProductByName(Scanner scanner) {
        if (productList.isEmpty()) {
            System.out.println("Không có sản phẩm nào để tìm kiếm.");
            return;
        }
        System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
        String inputName = scanner.nextLine();
        boolean isFound = false;
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(inputName)) {
                product.displayData();
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Không tìm thấy sản phẩm có tên " + inputName);
        }
    }

    // Thay đổi trạng thái của sản phẩm theo mã sản phẩm
    private static void changeProductStatus(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        int inputID = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getProductId() == inputID) {
                product.setProductStatus(!product.isProductStatus());
                System.out.println("Đã thay đổi trạng thái của sản phẩm có mã sản phẩm " + inputID);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã sản phẩm " + inputID);
    }
}
