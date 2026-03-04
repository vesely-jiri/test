# DataFilter

Java utility for filtering lists of elements based on conditions.

## How It Works

1. Data is loaded from `src/main/resources/data.txt` — one value per line.
2. Filtering rules are defined as `Predicate<T>` lambdas in `Main.java`.
3. All conditions are combined using logical AND — an element must pass every rule to be included in the result.

## Adding Rules

Open `Main.java` and add predicates to the `conditions` list:

Following example returns any number from data.txt, that is bigger than 100, and smaller than 500
```java
conditions.add(t -> Integer.parseInt(t) > 100);
conditions.add(t -> Integer.parseInt(t) < 500);
```

## Running the Project

### Prerequisites
- Java 17+
- Maven

### Run

```bash
mvn compile exec:java -Dexec.mainClass="cz.jpcz.Main"
```

Or run `Main.java` directly from your IDE.

## Example

Given `data.txt`:
```
42
1000
88
```

With condition `t -> Integer.parseInt(t) == 1000`, output:
```
Filtered data:
1000
```

## TODO

- Allow user to choose logic operators for filtering. (AND -> AND/OR)