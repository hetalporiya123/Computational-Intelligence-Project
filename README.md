# Computational Intelligence Project

### Team Members

- **Hetal Poriya**
- **Lalji Nasit**

## Project Overview

This project demonstrates the implementation of three major Computational Intelligence techniques:

1. **Neural Network**

    * Customer Churn Prediction System

2. **Swarm Intelligence**

    * Drone-based Search and Rescue Simulation

3. **Evolutionary Computing**

    * Evolutionary Job Scheduling System

---

## Software Requirements

* Java Development Kit (JDK) 17 or higher
* IntelliJ IDEA or Eclipse IDE

---

# Project 1: Neural Network

## Customer Churn Prediction System

### Steps to Run

#### Step 1

Open the project in IntelliJ IDEA or Eclipse.

#### Step 2

Ensure that the dataset file:

```text
customer_churn.csv
```

is located inside:

```text
src/main/resources/
```

#### Step 3

Run the following class:

```java
neuralnetwork.Main
```

### Output

The application will:

* Load the customer dataset
* Train the neural network
* Display training progress in the console
* Calculate model accuracy
* Open the Customer Churn Prediction GUI
* Open the Neural Network visualization window

### Concepts Implemented

* Dataset Loading
* Weight Initialization
* Sigmoid Activation Function
* Gradient Descent Learning
* Forward Propagation
* Epoch-based Training
* Binary Classification
* Model Evaluation

---

# Project 2: Swarm Intelligence

## Drone-based Search and Rescue Simulation

### Steps to Run

#### Step 1

Open the project in IntelliJ IDEA or Eclipse.

#### Step 2

Run the following class:

```java
swarm.Main
```

### Output

The application will:

* Initialize the search environment
* Deploy 20 autonomous drones
* Generate a random target location
* Start the search and rescue mission
* Display drone movement and search behavior
* Detect and locate the lost person
* Display mission statistics in the console

### Concepts Implemented

* Autonomous Agents
* Search Space Partitioning
* Exploration
* Target Detection
* Collective Behavior
* Exploitation
* Convergence

---

# Project 3: Evolutionary Computing

## Evolutionary Job Scheduling System

### Steps to Run

#### Step 1

Open the Evolutionary Job Scheduling System project in Eclipse.

#### Step 2

Ensure all source files are present inside the `src` directory.

#### Step 3

Run the following class:

```java
src/app/Main.java
```

#### Step 4

Enter the required parameters:

* Population Size
* Number of Generations
* Mutation Rate
* Number of Machines
* Job Processing Times

#### Step 5

Click **Start Algorithm**.

### Output

The application will display:

* Execution Log
* Current Generation Statistics
* Best Fitness Value
* Best Makespan
* Final Optimized Job Schedule

### Sample Input

#### Jobs

```text
J1 = 12
J2 = 18
J3 = 7
J4 = 25
J5 = 14
```

#### Parameters

```text
Machines = 3
Population Size = 100
Generations = 100
Mutation Rate = 0.05
```

### Concepts Implemented

* Population Initialization
* Fitness Evaluation
* Tournament Selection
* Single-Point Crossover
* Mutation
---

## Additional Notes

* The Neural Network module uses the **Sigmoid Activation Function** and **Gradient Descent-based learning**.
* The Swarm Intelligence module demonstrates **collective behavior**, **exploration**, and **convergence**.
* The Evolutionary Computing module demonstrates **optimization using Genetic Algorithms**.
* The target location in the swarm simulation is randomly generated during each execution.

---

## Authors

Developed as part of the **Computational Intelligence Course Project**, demonstrating the practical implementation of:

* Neural Networks
* Swarm Intelligence
* Evolutionary Computing
