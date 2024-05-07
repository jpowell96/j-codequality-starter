
1. Background story with nice tag line.

The best tool for the job isn't always the best tool you have available.

Engineering teams are often have the build vs. buy conversation. Do we want to "buy" an off-the-shelf
tool to solve our problem or do we want to build it in-house? The conversation is usually for complex engineering solutions, but this time we're talking about code quality tools.


## Code Quality

I think code quality is more about standardizing practices across a team than writing "clean code". Everyone
has their own conceptions of best practices, so using code quality tools like linters, and static analysis tools 
standardize practices across teams. Even better, they can be integrated to the pull request, and CI/CD process
to automate the practice of "code quality" - letting developers focus on reviewing the business logic of code changes.

You get a few benefits of integrating automated code quality tools in your projects:

1. Standardized (and automated) best practices
2. Easier onboarding of new team members coming from different tech stacks
3. Evangelize good practices across the codebase

## We Have Code Quality At Home

SonarQube is one of the most common off-the-shelf code quality solutions, but I'm going to highlight 3 open source java plugins for "good enough" code quality in your Java projects.


### Spotless

[Spotless](https://github.com/diffplug/spotless/blob/main/README.md) is an open-source, multi-language, customizable code formatter for projects.
It comes with a [Maven Plugin](https://github.com/diffplug/spotless/blob/main/plugin-maven/README.md#quickstart) that can be customized as needed.

Here's an example of what it would look like. Spotless comes with some built-in formats. In this example, we specify we want to use Palantir's Java formatting rules:
```xml
      <plugin>
        <!-- https://github.com/diffplug/spotless -->
        <groupId>com.diffplug.spotless</groupId>
        <artifactId>spotless-maven-plugin</artifactId>
        <version>${spotless.version}</version>
        <configuration>
          <java>
            <!-- Tell Spotless to Use Palantir's Custom Java Format-->
            <palantirJavaFormat>
              <version>2.39.0</version>
              <!-- optional -->
              <style>PALANTIR</style>
              <!-- or AOSP/GOOGLE (optional) -->
              <formatJavadoc>false</formatJavadoc>
              <!-- defaults to false (optional, requires at least Palantir 2.39.0) -->
            </palantirJavaFormat>
          </java>
        </configuration>
    </plugin>
```

Once the plugin is added to the pom, you can check for formatting issues with:

```sh
mvn spotless:check
```

Or format your code with:
```sh
mvn spotless:apply
```

### SpotBugs
[SpotBugs](https://spotbugs.github.io/) is an open source static anlysis tool. "SpotBugs uses static analysis to inspect Java bytecode for occurrences of bug patterns." This means that SpotBugs runs against the compiled source source code, rather than raw Java files. Because it analyses bytecode, it can catch some types of bugs that source code analysis would not catch.

SpotBugs provides a [maven plugin](https://spotbugs.github.io/spotbugs-maven-plugin/#:~:text=SpotBugs%20uses%20static%20analysis%20to,do%20not%20indicate%20real%20errors.) for easy usage. Here's what it would look like in a pom.xml:

```xml
      <plugin>
        <groupId>com.github.spotbugs</groupId>
        <artifactId>spotbugs-maven-plugin</artifactId>
        <version>4.8.4.0</version>
        <configuration>
          <plugins>
            <plugin>
              <groupId>com.h3xstream.findsecbugs</groupId>
              <artifactId>findsecbugs-plugin</artifactId>
              <version>1.12.0</version>
            </plugin>
          </plugins>
        </configuration>
      </plugin>
```

Once added, you can run SpotBugs from the command line. I've include `mvn clean compile` because you want to ensure you've compiled the latest version of your code.
It also comes with a nice GUI if you want an easy way to know which classes have issues.

```sh
# Generate a report for SpotBugs errors
mvn clean compile spotbugs:spotbugs
```

```sh
# Check for SpotBugs errors
mvn clean compile spotbugs:check
```

```sh
mvn clean compile spotbugs:gui
```

If you want to suppress a SpotBugs Warning, you can use the @SuppressFBWarnings annotation with the SpotBugs errors as a parameter(s)

```java
@SuppressFBWarnings(value={"NM_METHOD_NAMING_CONVENTION", "NP_TOSTRING_COULD_RETURN_NULL"},justification = "This is why we ignore these FindBugs warnings.")
public class MyClassWithSpotBugsWarnings {
  // ...
}
```

SpotBugs will not automatically fix any errors it finds. It's up to the developer to decide if it's findings warrant code changes.

### PMD
[PMD](https://pmd.github.io/) is a source code static analysis tool. It inspects your Java files for any issues, and has a configurable set of rules
to look at.

PMD provides a [maven plugin](https://maven.apache.org/plugins/maven-pmd-plugin/index.html) to easily setup rules you care about. Here's what it 
would look like in a pom.xml

```xml
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-pmd-plugin</artifactId>
        <version>3.22.0</version>
        <!-- Link to a custom ruleset file for rules we care about -->
        <configuration>
          <rulesets>
            <ruleset>src/main/resources/pmd/custom-ruleset.xml</ruleset>
          </rulesets>
          <excludes>
            <exclude>**/test/**</exclude>
          </excludes>
        </configuration>
      </plugin>
```
You can find a list of availble rules on the [docs site](https://pmd.github.io/pmd/pmd_rules_java.html) and include/exclude them as needed.

Once added to the pom.xml, you can run PMD:

```sh
# Generate a report of PMD violations
mvn pmd:pmd
```

```sh
# Check the code for any PMD violations
mvn pmd:check
```

If you want to suppress a PMD violation you can do it like so:
```java
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
public class MyClassWithPMDViolations {
    // Your code here
}
```

Like SpotBugs, PMD will not automatically fix issues. It's up to the developer to decide if violations warrant changes, or ignore them.
### Putting it together

Together these tools give you linting and static analysis that you can customize to your needs.
If you want to see a sample of them in action, you can find a sample maven project I made, complete with fully configured pom.xml file here:

https://github.com/jpowell96/j-codequality-starter


### Links
- [Spotless Github](https://github.com/diffplug/spotless)
- [SpotBugs Main Page](https://spotbugs.readthedocs.io/en/latest/introduction.html)
- [SpotBugs Maven Plugin Docs](https://spotbugs.github.io/spotbugs-maven-plugin/)
- [PMD Main Page](https://pmd.github.io/)
- [PMD Java Rules](https://pmd.github.io/pmd/pmd_rules_java.html)
- [PMD Maven Plugin Docs](https://maven.apache.org/plugins/maven-pmd-plugin/index.html)