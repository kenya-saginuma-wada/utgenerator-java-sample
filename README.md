# Sample Legacy Project

This is a **sample project** included in the UTGenerator repository for demonstration and testing purposes.

## Purpose
- **Demonstration**: You can run UTGenerator against this project to see how it analyzes code and generates tests.
- **Testing**: It serves as a fixture for the tool's own integration tests.

## Structure
It mimics a legacy Java application structure:
- `src/main/java`: Contains sample "legacy" business logic (e.g., `CustomerService`).
- `src/test/java`: Contains existing tests (or generated tests).

## Usage
You can try running the UTGenerator CLI against this directory from the project root.

**Example 1: Analyze the project**
```bash
./gradlew :app:run --args="analyze -p sample-legacy-project -c config.example.yaml"
```
*(Note: Use `config.example.yaml` or your own `config.yaml`)*

**Example 2: Generate tests**
(Requires an LLM API key set in your environment if you go beyond analysis)

rm -rf  ./sample-legacy-project/.utgen/cache