package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
//        Department dp = new Department(1, "Books");
//        Seller seller = new Seller(1, "Willian", "algo@algo", new Date(), 3000.00, dp);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}
