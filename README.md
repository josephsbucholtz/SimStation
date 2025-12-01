# SimStation (README is AI generated, but the code is completely our group's work and the template code provided by SJSU CS 152)
A lightweight Java framework for building agent-based simulations such as Random Walk, Flocking, Plague spread, and Prisoner’s Dilemma.  

![Java](https://img.shields.io/badge/Java-8%2B-orange)  
![Platform](https://img.shields.io/badge/Platform-Java%20SE-blue)  
![Status](https://img.shields.io/badge/Status-Active-brightgreen)

---

## 📦 Prerequisites

Before running or modifying the project, ensure you have:

- **Java JDK 8 or higher**  
  (Java 11 or 17 recommended)
- **A Java-capable IDE**, such as:  
  - Visual Studio Code + Extension Pack for Java  
  - IntelliJ IDEA  
  - Eclipse
- **Git** (to clone the repository)

---

## 🚀 Clone & Run the Project

1. **Clone the repository**  
   ```bash
   git clone https://github.com/josephsbucholtz/SimStation.git
   cd SimStation

📖 About

SimStation provides an educational and extensible framework for experimenting with distributed, emergent, and agent-based behaviors.
Each simulation consists of a population of agents—independent objects that move, interact, and update over time.

The system uses:

Multithreading: each agent runs in its own thread

MVC structure: encourages separation of model, view, and simulation logic

Reusable base classes: easy to extend and create new simulations


✨ Features

Prebuilt simulation examples:

Random Walk

Flocking

Plague Spread

Prisoner’s Dilemma Tournament

Reusable framework for creating new agent behaviors

Threaded agent execution

2D environment with neighbor lookup

Easy UI/UX extension (GUI or console)

Great for teaching or experimenting with emergent behavior systems

Project Structure
SimStation/
  ├── src/           # Java source files
  ├── .idea/         # IDE config (IntelliJ)
  ├── .gitignore
  └── README.md


Key code concepts include:

Simulation — orchestrates agent activities

Agent — base class for behaviors

SimulationPanel — (if implemented) visual representation

Concrete simulation folders/classes — e.g., Plague, Flocking, etc.
