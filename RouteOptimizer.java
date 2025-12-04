package casestudy;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RouteOptimizer extends JPanel {
    private static final int NUM_LOCATIONS = 6;
    private static final int[][] coordinates = {
            {50, 250}, {150, 100}, {250, 50},
            {350, 200}, {400, 300}, {200, 350}
    };
    private static final int[][] distanceMatrix = {
            {0, 2, 9, 10, 7, 3},
            {2, 0, 6, 4, 8, 5},
            {9, 6, 0, 3, 6, 4},
            {10, 4, 3, 0, 2, 7},
            {7, 8, 6, 2, 0, 9},
            {3, 5, 4, 7, 9, 0}
    };

    private List<Integer> route;

    public RouteOptimizer(List<Integer> route) {
        this.route = route;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        g2d.setColor(Color.RED);
        for (int i = 0; i < NUM_LOCATIONS; i++) {
            g2d.fillOval(coordinates[i][0] - 5, coordinates[i][1] - 5, 10, 10);
            g2d.drawString("L" + i, coordinates[i][0] - 15, coordinates[i][1] - 10);
        }

        g2d.setColor(Color.BLUE);
        for (int i = 0; i < route.size() - 1; i++) {
            int from = route.get(i);
            int to = route.get(i + 1);
            g2d.drawLine(coordinates[from][0], coordinates[from][1], coordinates[to][0], coordinates[to][1]);
        }
    }

    private static void showVisualization(List<Integer> route, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.add(new RouteOptimizer(route));
        frame.setVisible(true);
    }

    private static int calculateRouteCost(List<Integer> route) {
        int cost = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            cost += distanceMatrix[route.get(i)][route.get(i + 1)];
        }
        return cost;
    }

    private static List<Integer> parseUserRoute(String input) {
        List<Integer> route = new ArrayList<>();
        String[] parts = input.split(",");
        try {
            for (String part : parts) {
                int location = Integer.parseInt(part.trim());
                if (location >= 0 && location < NUM_LOCATIONS) {
                    route.add(location);
                } else {
                    return new ArrayList<>();
                }
            }
            if (route.get(0) != 0 || route.get(route.size() - 1) != 0) {
                return new ArrayList<>();
            }
        } catch (NumberFormatException e) {
            return new ArrayList<>();
        }
        return route;
    }

    private static List<Integer> generateRandomRoute() {
        List<Integer> route = new ArrayList<>();
        for (int i = 0; i < NUM_LOCATIONS; i++) {
            route.add(i);
        }
        Collections.shuffle(route);
        route.add(route.get(0));
        return route;
    }

    private static List<List<Integer>> generateNeighbors(List<Integer> route) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 1; i < route.size() - 2; i++) {
            for (int j = i + 1; j < route.size() - 1; j++) {
                List<Integer> newRoute = new ArrayList<>(route);
                Collections.swap(newRoute, i, j);
                neighbors.add(newRoute);
            }
        }
        return neighbors;
    }

    private static List<Integer> hillClimbingOptimize(List<Integer> currentRoute) {
        int currentCost = calculateRouteCost(currentRoute);

        while (true) {
            List<List<Integer>> neighbors = generateNeighbors(currentRoute);
            List<Integer> bestNeighbor = currentRoute;
            int bestNeighborCost = currentCost;

            for (List<Integer> neighbor : neighbors) {
                int neighborCost = calculateRouteCost(neighbor);
                if (neighborCost < bestNeighborCost) {
                    bestNeighbor = neighbor;
                    bestNeighborCost = neighborCost;
                }
            }

            if (bestNeighborCost < currentCost) {
                currentRoute = bestNeighbor;
                currentCost = bestNeighborCost;
            } else {
                break;
            }
        }

        return currentRoute;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a route (comma-separated locations from 0-5, e.g., 0,1,3,2,4,5,0): ");
        String input = scanner.nextLine();
        List<Integer> customRoute = parseUserRoute(input);

        if (customRoute.isEmpty()) {
            System.out.println("Invalid input! Using a random route.");
            customRoute = generateRandomRoute();
        }

        int userRouteCost = calculateRouteCost(customRoute);
        System.out.println("User Input Route: " + customRoute);
        System.out.println("User Input Route Cost: " + userRouteCost);

        showVisualization(customRoute, "User Input Route");

        List<Integer> optimizedRoute = hillClimbingOptimize(new ArrayList<>(customRoute));
        int optimizedRouteCost = calculateRouteCost(optimizedRoute);

        System.out.println("Optimized Route: " + optimizedRoute);
        System.out.println("Optimized Route Cost: " + optimizedRouteCost);

        showVisualization(optimizedRoute, "Optimized Route");
    }
}