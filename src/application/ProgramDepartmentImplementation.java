package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class ProgramDepartmentImplementation {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: Department findById ===");
        Department dp = departmentDao.findById(2);
        System.out.println(dp);

        System.out.println("\n=== TEST 2: Department findAll ===");
        List<Department> findAll = departmentDao.findAll();
        findAll.forEach(System.out::println);

        System.out.println("\n=== TEST 3: Department Inset ===");
        dp = new Department(null, "Novo DP");
//        departmentDao.insert(dp);
        System.out.println(dp);

        System.out.println("\n=== TEST 4: Department deleteById ===");
//        departmentDao.deleteById(12);

        System.out.println("\n=== TEST 5: Department update ===");
        dp = departmentDao.findById(6);
        dp.setName("DP - Test");
        departmentDao.update(dp);
        System.out.println("Changed name ok!");
        sc.close();
    }
}
