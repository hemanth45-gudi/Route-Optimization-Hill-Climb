# 🚀 Route Optimization using Hill Climbing Algorithm

## 📌 Project Description

This project implements a **Route Optimization System** using the **Hill Climbing algorithm** to determine the shortest delivery path between multiple locations. The system starts with an initial route and continuously improves it by making small modifications until the most efficient route (local optimum) is found.

The project simulates a delivery route planning system where travel cost is calculated using a distance matrix, and the optimized route is visualized using a graphical interface.

This approach is computationally efficient and suitable for small to medium-sized delivery networks.

---

## 🎯 Project Objective

* Minimize travel distance between locations.
* Optimize delivery routes using local search techniques.
* Improve route efficiency step-by-step.
* Visualize optimized routes using a graphical interface.

---

## ⚙️ Tech Stack

* Java Programming
* Hill Climbing Algorithm
* Java Swing (GUI Visualization)
* Distance Matrix
* ArrayList Data Structure
* Local Search Optimization

---

## ⭐ Features

### 📍 Route Cost Calculation

* Calculates total travel distance using a predefined distance matrix.

### 🔄 Hill Climbing Optimization

* Improves route by iteratively selecting better neighboring solutions.
* Stops when no further improvement is possible.

### 🔀 Neighbor Route Generation

* Generates alternative routes by swapping locations.
* Evaluates each route to find better solutions.

### ✔ Route Validation

* Ensures route starts and ends at the same location.
* Validates user input format.

### 🎲 Random Route Generation

* Automatically generates a random route if input is invalid.

### 🖥 Graphical Visualization

* Displays locations and routes visually.
* Shows both initial and optimized routes.

### 👤 Interactive User Input

* Users can provide custom routes for optimization.

---

## 🧠 Algorithm Used — Hill Climbing

Hill Climbing is a greedy local search algorithm that continuously improves a solution by making small changes. It selects the best neighboring solution and stops when no better solution exists.

### Working Steps:

1. Start with an initial route.
2. Generate neighboring routes.
3. Compare route costs.
4. Select the better route.
5. Repeat until no improvement is found.

---

## 📊 System Workflow

1. User enters route.
2. System calculates route cost.
3. Neighbor routes are generated.
4. Hill Climbing algorithm optimizes the route.
5. Optimized route is displayed graphically.

---

## 📸 Screenshot

![Route Optimization](images/project-image.png)

---

## ▶️ How to Run the Project

1. Install Java (JDK).
2. Check Java version:

   ```
   java -version
   ```
3. Compile the program:

   ```
   javac RouteOptimizer.java
   ```
4. Run the program:

   ```
   java RouteOptimizer
   ```

---

## 🌍 Real-World Applications

* Delivery route planning
* Logistics optimization
* Vehicle routing problems
* Supply chain management
* Navigation systems

---


---

## 👨‍💻 Author

**Hemanth Gudi**
