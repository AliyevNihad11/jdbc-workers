package org.example.dao;

import org.example.model.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class WorkerDao {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "nihad29";

    private Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public void save(Worker worker) {

        String sql = "INSERT INTO workers (id, ad,soyad,vəzifə,maaş,yaş,şöbə) VALUES(?,?,?,?,?,?,?)";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(sql);
            statement.setInt(1, worker.getId());
            statement.setString(2, worker.getAd());
            statement.setString(3, worker.getSoyad());
            statement.setString(4, worker.getVəzifə());
            statement.setInt(5, worker.getMaaş());
            statement.setInt(6, worker.getYaş());
            statement.setString(7, worker.getŞöbə());
            statement.execute();
            System.out.println("Successfully inserted worker");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Worker> getAll() {
        String sql = "SELECT * FROM workers";
        List<Worker> workers = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Worker worker = new Worker();
                worker.setId(resultSet.getInt("id"));
                worker.setAd(resultSet.getString("ad"));
                worker.setSoyad(resultSet.getString("soyad"));
                worker.setVəzifə(resultSet.getString("vəzifə"));
                worker.setMaaş(resultSet.getInt("maaş"));
                worker.setYaş(resultSet.getInt("yaş"));
                worker.setŞöbə(resultSet.getString("şöbə"));
                workers.add(worker);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }

    public Worker getById(int id) {
        String sql = "SELECT * FROM workers " +
                "WHERE id = ?";
        Worker worker = new Worker();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                worker = new Worker();
                worker.setId(resultSet.getInt("id"));
                worker.setAd(resultSet.getString("ad"));
                worker.setSoyad(resultSet.getString("soyad"));
                worker.setVəzifə(resultSet.getString("vəzifə"));
                worker.setMaaş(resultSet.getInt("maaş"));
                worker.setYaş(resultSet.getInt("yaş"));
                worker.setŞöbə(resultSet.getString("şöbə"));
            }
            return worker.getId() == null ? null : worker;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return worker;
    }

    public void createWorker() {

        try (Connection connection = getConnection();) {
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE workers " +
                    "(id INTEGER, " +
                    "ad VARCHAR(255), " +
                    " soyad VARCHAR(255)," +
                    "vəzifə VARCHAR(255), " +
                    " maaş INTEGER, " +
                    " yaş INTEGER," +
                    "şöbə VARCHAR(255) )";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateWorker(Worker worker, int id) {
        String sql = "UPDATE workers set ad = ?, soyad = ?, vəzifə = ?, maaş = ?,yaş = ?,şöbə = ? WHERE id = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(sql);
            statement.setString(1, worker.getAd());
            statement.setString(2, worker.getSoyad());
            statement.setString(3, worker.getVəzifə());
            statement.setInt(4, worker.getMaaş());
            statement.setInt(5, worker.getYaş());
            statement.setString(6, worker.getŞöbə());
            statement.executeUpdate();
            System.out.println("Successfully updated worker");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWorker(int id) {
        String sql = "DELETE FROM workers WHERE id = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Successfully deleted worker");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }










        }