package ra.businessImp;

import ra.business.IProduct;

import java.util.Scanner;

public class Product implements IProduct,Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Mã sản phẩm: ");
        productId = Integer.parseInt(scanner.nextLine());
        System.out.print("Tên sản phẩm: ");
        productName = scanner.nextLine();
        System.out.print("Tiêu đề sản phẩm: ");
        title = scanner.nextLine();
        System.out.print("Mô tả sản phẩm: ");
        descriptions = scanner.nextLine();
        System.out.print("Giá nhập: ");
        importPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Giá xuất: ");
        exportPrice = Float.parseFloat(scanner.nextLine());
        interest = exportPrice - importPrice;
        productStatus = true;
        System.out.println("Thông tin sản phẩm đã được nhập.");
    }

    @Override
    public void displayData() {
            System.out.println("Thông tin sản phẩm:");
            System.out.printf("Mã sản phẩm: %d | Tên sản phẩm: %s | Tiêu đề sản phẩm: %s | Mô tả sản phẩm: %s \n",productId,productName,title,descriptions);
            System.out.printf("Giá nhập: %.2f | Giá xuất: %.2f | Lợi nhuận: %.2f | Trạng thái : %b\n",importPrice,exportPrice,interest,productStatus);
            System.out.println("---------------------------------------------------------------------------------------------------");
    }

    @Override
    public int compareTo(Product o) {
        return Float.compare(this.interest, o.interest);
    }
}
