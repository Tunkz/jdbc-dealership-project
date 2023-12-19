package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        String query = "INSERT INTO vehicles VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, vehicle.getVin());
            statement.setString(2, vehicle.getMake());
            statement.setString(3, vehicle.getModel());
            statement.setInt(4, vehicle.getYear());
            statement.setBoolean(5, vehicle.isSold());
            statement.setString(6, vehicle.getColor());
            statement.setString(7, vehicle.getVehicleType());
            statement.setInt(8, vehicle.getOdometer());
            statement.setDouble(9, vehicle.getPrice());

            int rows = statement.executeUpdate();
            System.out.println("\nVehicle added.");
            System.out.println("Rows updated: " + rows);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeVehicle(String VIN) {
        String query = "DELETE FROM vehicles WHERE VIN = ?;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, VIN);

            int rows = statement.executeUpdate();
            System.out.println("\nVehicle removed.");
            System.out.println("Rows updated: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        //Vehicle vehicle = null;
        String query = "SELECT * FROM vehicles  WHERE vehicles.price BETWEEN ? AND ?;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);

            try(ResultSet resultSet = statement.executeQuery()){
                Vehicle vehicle = new Vehicle();
                do {
                    vehicle.setVin(resultSet.getString("VIN"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setYear(resultSet.getInt("year"));
                    vehicle.setSold(resultSet.getBoolean("SOLD"));
                    resultSet.getString("color");
                    resultSet.getString("vehicleType");
                    resultSet.getInt("odometer");
                    resultSet.getDouble("price");

                    vehicles.add(new Vehicle());

                } while(resultSet.next());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE vehicles.make LIKE ? AND vehicles.model LIKE ?;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, make);
            statement.setString(2, model);

            try(ResultSet resultSet = statement.executeQuery()){
                Vehicle vehicle = new Vehicle();
                do {
                    vehicle.setVin(resultSet.getString("VIN"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setYear(resultSet.getInt("year"));
                    vehicle.setSold(resultSet.getBoolean("SOLD"));
                    resultSet.getString("color");
                    resultSet.getString("vehicleType");
                    resultSet.getInt("odometer");
                    resultSet.getDouble("price");

                    vehicles.add(new Vehicle());

                } while(resultSet.next());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE vehicles.year BETWEEN ? AND ?;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, minYear);
            statement.setInt(2, maxYear);

            try(ResultSet resultSet = statement.executeQuery()){
                Vehicle vehicle = new Vehicle();
                do {
                    vehicle.setVin(resultSet.getString("VIN"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setYear(resultSet.getInt("year"));
                    vehicle.setSold(resultSet.getBoolean("SOLD"));
                    resultSet.getString("color");
                    resultSet.getString("vehicleType");
                    resultSet.getInt("odometer");
                    resultSet.getDouble("price");

                    vehicles.add(new Vehicle());

                } while(resultSet.next());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE vehicles.color LIKE ?;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, color);

            try(ResultSet resultSet = statement.executeQuery()){
                Vehicle vehicle = new Vehicle();
                do {
                    vehicle.setVin(resultSet.getString("VIN"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setYear(resultSet.getInt("year"));
                    vehicle.setSold(resultSet.getBoolean("SOLD"));
                    resultSet.getString("color");
                    resultSet.getString("vehicleType");
                    resultSet.getInt("odometer");
                    resultSet.getDouble("price");

                    vehicles.add(new Vehicle());

                } while(resultSet.next());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE vehicles.mileage BETWEEN ? AND ?;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setDouble(1, minMileage);
            statement.setDouble(2, maxMileage);

            try(ResultSet resultSet = statement.executeQuery()){
                Vehicle vehicle = new Vehicle();
                do {
                    vehicle.setVin(resultSet.getString("VIN"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setYear(resultSet.getInt("year"));
                    vehicle.setSold(resultSet.getBoolean("SOLD"));
                    resultSet.getString("color");
                    resultSet.getString("vehicleType");
                    resultSet.getInt("odometer");
                    resultSet.getDouble("price");

                    vehicles.add(new Vehicle());

                } while(resultSet.next());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> searchByType(String type) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE vehicles.type LIKE ?;";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, type);

            try(ResultSet resultSet = statement.executeQuery()){
                Vehicle vehicle = new Vehicle();
                do {
                    vehicle.setVin(resultSet.getString("VIN"));
                    vehicle.setMake(resultSet.getString("make"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setYear(resultSet.getInt("year"));
                    vehicle.setSold(resultSet.getBoolean("SOLD"));
                    resultSet.getString("color");
                    resultSet.getString("vehicleType");
                    resultSet.getInt("odometer");
                    resultSet.getDouble("price");

                    vehicles.add(new Vehicle());

                } while(resultSet.next());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return vehicles;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
