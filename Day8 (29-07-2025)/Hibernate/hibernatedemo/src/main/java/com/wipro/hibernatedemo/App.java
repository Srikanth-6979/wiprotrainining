package com.wipro.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import com.wipro.hibernatedemo.entity.Pan1;
import com.wipro.hibernatedemo.repo.HibernateRepo;

public class App {
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Create New Pan Holder");
            System.out.println("2. Find by Pan ID");
            System.out.println("3. Update Pan");
            System.out.println("4. Delete by ID");
            System.out.println("5. Find All Holders");
            System.out.println("6. Find All Pan Holder Names");
            System.out.println("7. Find By Pan Number");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();


            switch (choice) {
            case 1:

                HibernateRepo.createPanHolder();
                break;


                case 2:
                    System.out.print("Enter Pan ID: ");
                    int id = sc.nextInt();
                    Pan1 pan = HibernateRepo.findById(id);
                    if (pan != null) {
                        System.out.println(pan);
                    } else {
                        System.out.println("No Pan record found with ID: " + id);
                    }
                    break;

                case 3:
                    HibernateRepo.updatePan();
                    break;

                case 4:
                    System.out.print("Enter Pan ID to delete: ");
                    int id1 = sc.nextInt();
                    Pan1 deleted = HibernateRepo.deleteById(id1);
                    if (deleted != null) {
                        System.out.println("Deleted: " + deleted);
                    } else {
                        System.out.println("Pan ID not found.");
                    }
                    break;

                case 5:
                    List<Pan1> list = HibernateRepo.findAll();
                    for (Pan1 holder : list) {
                        System.out.println(holder);
                    }
                    break;

                case 6:
                    List<String> names = HibernateRepo.findAllPanHolderNames();
                    for (String name : names) {
                        System.out.println(name);
                    }
                    break;

                case 7:
                    System.out.print("Enter PAN number: ");
                    String pnumber = sc.next();
                    List<Pan1> matched = HibernateRepo.findByPanNumbers(pnumber);
                    for (Pan1 match : matched) {
                        System.out.println(match);
                    }
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }

        } while (choice != 9);

    }
}
