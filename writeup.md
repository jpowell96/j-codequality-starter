
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

### SpotBugs

### PMD


### Putting it together

Together these tools give you linting and static analysis that you can customize to your needs.
If you want to see a sample of them in action, you can find a sample maven project I made, complete with fully configured pom.xml file here:

https://github.com/jpowell96/j-codequality-starter