package Implementation.utilities;

import Implementation.dto.Aircraft;
import Implementation.dto.Airline;
import Implementation.dto.Airport;
import Implementation.Route;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl {

    public FileReaderImpl() {

    }

    public List<Aircraft> getAircrafts(String path) {

        List<Aircraft> aircrafts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                aircrafts.add(new Aircraft(values[0], values[1], values[2]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return aircrafts;
    }

    public List<Airline> getAirlines(String path) {
        List<Airline> aircrafts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length < 3) {
                    aircrafts.add(new Airline(values[0], values[1], "global"));
                } else {
                    aircrafts.add(new Airline(values[0], values[1], values[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aircrafts;
    }

    public List<Airport> getAirports(String path) {
        List<Airport> airports = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            //System.out.println(line);
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] values = line.split(";");
                airports.add(new Airport(values[0], values[1], values[2], values[3], values[4], values[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return airports;
    }

    public List<Route> getRoutes(String path) {
        List<Route> routes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                routes.add(new Route(values[0], values[1], values[2], Double.valueOf(values[3]), Float.valueOf(values[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routes;
    }
}
