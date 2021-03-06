package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: Seller insert ===");
        Seller seller1 = new Seller(null, "WillNog", "jdbc@outlook.com", new Date(), 4000.00, department);
//        sellerDao.insert(seller1);
        System.out.println("Inserted! New id: " + seller1.getId());

        System.out.println("\n=== TEST 5: Seller insert ===");
        seller1 = sellerDao.findById(1);
        seller1.setName("TestName Changed");
        sellerDao.update(seller1);
        System.out.println("Done!");

        System.out.println("\n=== TEST 6: Seller insert ===");
        System.out.println("Type one code: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");
        sc.close();
    }
}
