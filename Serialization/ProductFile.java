package com.mph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class ProductRecord implements Serializable {
    private int productCode;
    private String composition;
    private String productName;
    private String company;
    private int stockQuantity;
    private int reorderLevel;
    private float unitPrice;

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ProductRecord(int productCode, String composition,
                         String productName, String company, int stockQuantity,
                         int reorderLevel, float unitPrice) {
        this.productCode = productCode;
        this.composition = composition;
        this.productName = productName;
        this.company = company;
        this.stockQuantity = stockQuantity;
        this.reorderLevel = reorderLevel;
        this.unitPrice = unitPrice;
    }
}

class ProductFileStream {

    public void writeToFile(List<ProductRecord> list, String file) {
        ObjectOutputStream outStream = null;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(file));
            for (ProductRecord p : list) {
                outStream.writeObject(p);
            }

        }
        catch (IOException ioException) {
            System.err.println("Error opening file.");
        }
        catch (NoSuchElementException noSuchElementException) {
            System.err.println("Invalid input.");
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outStream != null)
                    outStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
    }

    public List<ProductRecord> readFromFile(String file) {
        List<ProductRecord> list = new ArrayList<>();
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                ProductRecord p = (ProductRecord) inputStream.readObject();
                list.add(p);
            }
        } catch (EOFException eofException) {
            return list;
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Object creation failed.");
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
        return list;
    }

}

public class ProductFile{
    public static void main(String[] args) {
        String filePath = "d://java//product.dat";
        List<ProductRecord> list = new ArrayList<>();
        list.add(new ProductRecord(111, "Amitryptyline", "Amiline", "Torrent",
                10, 5, 13.35f));
        // ...dummy data

        list.add(new ProductRecord(191, "Amlodipine", "Amdepin",
                "ZydusCadila", 18, 6, 20.90f));
        ProductFileStream pf=new ProductFileStream();
        pf.writeToFile(list, filePath);
        List<ProductRecord> products=pf.readFromFile(filePath);
        printlist(products);

    }

    public static void printlist(List<ProductRecord> list) {
        System.out.printf("%-7s%-20s%-20s%-20s%-10s%-10s%-10s\n", "Code",
                "Generic", "Name", "Company", "Stock", "Reorder", "Unit Price");
        for (ProductRecord p : list) {
            System.out.printf("%-7d%-20s%-20s%-20s%-10d%-10d%.2f\n",
                    p.getProductCode(), p.getComposition(), p.getProductName(),
                    p.getCompany(), p.getStockQuantity(), p.getReorderLevel(),
                    p.getUnitPrice());
        }
    }
}
