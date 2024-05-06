## Java Code Quality Starter

A basic Spring Boot project with common code quality tools set up in the repository
along with git hooks that can run the checks on commit.

Spotless Plugin is used for linting. It's configured with Palantir's Java Format.
SpotBugs and PMD are used together for static analysis. Examples are including of using custom filter files
for SpotBugs to include/exclude certain files from analysis. Likewise, PMD has a custom ruleset file
to include specific rules we care about.

### TODOS
1. Add commit hooks that run spotless, pmd, and spotbugs
2. Add github actions that run against pull requests
3. Add a bit more logic to Notes. Use in-memory hashmap as the "database" for now


### Code Quality Tools

#### Spotless

Spotless is a code formatting tool for the project.

To format code run:
```sh
mvn spotless:apply
```


#### PMD

PMD is a source code static analysis tool. 

To check if there are any violations, run:
```sh
mvn pmd:check
```

To generate a PMD report of violations:

```sh
mvn pmd:pmd
```

To view the report from the maven site:

```sh
#  Runs on port 8080 by default
mvn site:run 
```

Once the site is running, navigate to the Reports Page to find the PMD report.

#### Spotbugs

SpotBugs is a byte code analsis tool. Be sure to periodically run `mvn clean compile` to ensure SpotBugs
will run against the latest compiled version of your code.

To check if there are any violations, run:
```
mvn spotbugs:check
```

To generate a report of violations:

```sh
mvn spotbugs:spotbugs
```

For an interactive SpotBugs GUI, run:

```sh
mvn spotbugs:gui
```

Finally, to view the SpotBugs report from the maven site:

```sh
# Do a clean compile goals to ensure we've compiled the latest code for analysis
mvn clean compile site:run 
```

Once the site is running, navigate to the Reports Page to find the SpotBugs report.
