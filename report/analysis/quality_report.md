# Analysis Quality Report

Generated: 2026-02-15T09:32:29.644699052Z

## Summary

| Metric | Value |
|--------|-------|
| **Quality Score** | 69 / 100 |
| Type Resolution Rate | 99.0% |
| Dynamic Feature Score | 52 |
| Preprocess | OFF (SKIPPED) |
| Classpath (JP/Spoon) | WITH / WITH |
| Resolved Entries | 166 |

### Penalties Applied

- dynamic_features: -30

## Top Dynamic Files

| File | Count |
|------|-------|
| src/main/java/com/example/legacy/DynamicTestPatterns.java | 22 |

## Top Dynamic Types

| Subtype | Count |
|---------|-------|
| GET_METHOD | 6 |
| CONSTRUCTOR_NEWINSTANCE | 6 |
| CLASS_FORNAME | 4 |
| METHOD_INVOKE | 2 |
| GET_DECLARED_METHOD | 2 |

## Focus Test Targets

- src/main/java/com/example/legacy/DynamicTestPatterns.java

## Recommendations

- High dynamic feature score (52). Consider reviewing reflection or proxy usage for potential static resolution.
- Focus testing on dynamic hotspots: src/main/java/com/example/legacy/DynamicTestPatterns.java.

## Type Resolution Details

| Metric | Value |
|--------|-------|
| Total | 167 |
| Resolved | 166 |
| Unresolved | 0 |
| Ambiguous | 1 |

## Top Ambiguous Examples

- java.util.List#isEmpty()

