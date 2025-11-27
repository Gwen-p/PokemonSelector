# Pokémon Battle AI: Decision Making Under Uncertainty

## 🧠 AI Concepts Implemented

### 1. **Decision-Making Under Uncertainty**

In the core function:

```java
expectedU = effectiveness * attack * rival_type_probability
```

This implements **decision-making under uncertainty** as taught in the course. The system doesn't know the opponent's actual type, only a probability distribution:

\[
P(\text{rival} = \text{type}_i)
\]

And calculates the **expected value** of damage. This directly relates to:
- "Decision-making under uncertainty: building blocks"
- "Updating an agent's beliefs" (for future improvements)
- "Conditional probabilities"

### 2. **Utility & Maximization of Expected Utility**

The method:
```java
getExpectedUtility(...)
```

Exactly implements the course concept:

\[
\mathbb{E}[U] = \sum_i U(\text{action}, \text{state}_i) \cdot P(\text{state}_i)
\]

This corresponds to:
- "Utilities and the principle of maximization of expected utility"
- "How an optimal classification agent works"
- "Beyond present-day ML: the Optimal Predictor Machine (OPM)"

Your system implements **a simplified OPM prototype**:
- **Action** → choose Pokémon
- **States** → possible rival types
- **Utility** → expected damage

### 3. **Knowledge Representation & Logic**

Your model structure:
- `PType`: effectiveness rules
- `Breed`: statistics
- `Pokemon`: entity with HP and type

This represents:
- "Knowledge implementation in AI"
- "Sentences: central components of knowledge representation"
- "The Four Fundamental Rules of inference" (implicit through deterministic rules)

You've created **a structured knowledge base** with logical rules (fixed multipliers).

### 4. **Probability Distributions**

Your `Map<Breed, Double> probabilities` represents:

\[
P(\text{rival type})
\]

Which relates to:
- "Distribution of belief: probability distributions"
- "Conditional probability distributions"
- "Marginal distributions"

As explained: "My system assumes a belief distribution about the enemy Pokémon type and uses these probabilities to evaluate each possible action."

### 5. **Statistics & Populations** (Future Enhancement)

The planned feature of battling random opponents connects to:
- "Populations and subpopulations"
- "Summary statistics"
- "Evaluation metrics"
- "Sampling"

**Measurable metrics:**
- Win rate
- Average damage
- Result distributions
- Whether EU predicts actual performance well

**Comparative analysis:**
- Current method (greedy EU maximization)
- Baseline (random selection)

## 🎯 Academic Summary

This project directly relates to:

### 🔹 Decision Making Under Uncertainty
### 🔹 Maximization of Expected Utility  
### 🔹 Knowledge Representation and Logical Rules
### 🔹 Probability and Belief Distributions
### 🔹 Population Statistics (with simulated battles)
### 🔹 Connection to Optimal Predictor Machine (simplified version)

The system demonstrates how AI agents can make optimal decisions under uncertainty using probability theory and utility maximization principles.
