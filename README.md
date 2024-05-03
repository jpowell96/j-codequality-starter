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
4. Include instructions for how to run spotless, how to run pmd, how to run spotbugs
5. Set up maven site abd explain how to use it for reports