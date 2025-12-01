# SimStation
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

📖 **About**
SimStation provides an educational and extensible framework for experimenting with distributed, emergent, and agent-based behaviors. Each simulation consists of a population of agents—independent objects that move, interact, and update over time.

Core Architecture
The system is built on three fundamental principles:

Multithreading — Each agent runs in its own thread, enabling true concurrent behavior
MVC Structure — Clear separation of model, view, and simulation logic for maintainable code
Reusable Base Classes — Simplified extension points for creating new simulations


✨ **Features**
Prebuilt Simulations
Explore complex behaviors through ready-to-run examples:

Random Walk — Stochastic movement patterns
Flocking — Emergent group behavior and alignment
Plague Spread — Epidemic modeling and transmission dynamics
Prisoner's Dilemma Tournament — Game theory and strategic interaction

Framework Capabilities

🧵 Threaded agent execution for realistic concurrency
🗺️ 2D environment with efficient neighbor lookup
🎨 Flexible UI/UX extension (GUI or console-based)
🔧 Reusable framework for custom agent behaviors
📚 Ideal for teaching or experimenting with emergent systems


📁 **Project Structure**
SimStation/
├── src/                # Java source files
├── .idea/              # IDE configuration (IntelliJ)
├── .gitignore
└── README.md
Key Components
ComponentPurposeSimulationOrchestrates agent activities and manages simulation lifecycleAgentBase class for defining custom agent behaviorsSimulationPanelVisual representation layer (when implemented)Concrete SimulationsSpecific implementations (e.g., Plague, Flocking)
