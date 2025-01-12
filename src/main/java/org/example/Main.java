package org.example;

import org.example.dao.WorkerDao;
import org.example.model.Worker;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WorkerDao workerDao=new WorkerDao();
        while (true) {
            System.out.println("What dou want? !. 1. Create Worker table\n" +
                    "2. Save Worker\n" +
                    "3. Get All Workers\n" + "4.Get worker by id\n" + "5.Update worker by id\n" + "6.Delete worker by id");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:
                    workerDao.createWorker();
                    break;
                case 2:
                    Worker worker = new Worker();
                    System.out.println("Enter worker ID: ");
                    worker.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter worker name: ");
                    String ad = scanner.next();
                    worker.setAd(ad);
                    System.out.println("Enter worker surname: ");
                    String soyad = scanner.next();
                    worker.setSoyad(soyad);
                    scanner.nextLine();
                    System.out.println("Enter worker duty: ");
                    String vəzifə = scanner.next();
                    worker.setVəzifə(vəzifə);
                    System.out.println("Enter worker salary: ");
                    worker.setMaaş(scanner.nextInt());
                    System.out.println("Enter student age: ");
                    worker.setYaş(scanner.nextInt());
                    System.out.println("Enter worker department: ");
                    String şöbə = scanner.next();
                    worker.setŞöbə(şöbə);

                    workerDao.save(worker);
                    break;
                case 3:
                    System.out.println(workerDao.getAll());
                    break;
                case 4:
                    System.out.println("Enter worker id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(workerDao.getById(id));
                    break;
                case 5:
                    System.out.println("Enter worker id to update: ");
                    int idd = scanner.nextInt();
                    Worker st = workerDao.getById(idd);
                    if (st.getId() == null) {
                        throw new RuntimeException("Worker not found");
                    }
                    System.out.println(st);
                    scanner.nextLine();
                    System.out.println("Enter worker name: ");
                    ad = scanner.next();
                    st.setAd(ad);
                    System.out.println("Enter student surname: ");
                    soyad = scanner.next();
                    st.setSoyad(soyad);
                    System.out.println("Enter student duty: ");
                    vəzifə = scanner.next();
                    st.setVəzifə(vəzifə);
                    System.out.println("Enter student salary: ");
                    st.setMaaş(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter student age: ");
                    st.setYaş(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter student department: ");
                    şöbə = scanner.next();
                    st.setŞöbə(şöbə);


                    workerDao.updateWorker(st, idd);
                    break;
                case 6:
                    System.out.println("Enter worker id: ");
                    id = scanner.nextInt();
                    Worker worker1 = workerDao.getById(id);
                    if (worker1 == null) {
                        throw new RuntimeException("Worker not found");
                    }
                    if (worker1.getId() == null) {
                        throw new RuntimeException("Worker not found");
                    }
                    workerDao.deleteWorker(worker1.getId());
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }
}




