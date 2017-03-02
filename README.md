# testcontainers-template

[![Build Status](https://travis-ci.org/peter-evans/testcontainers-template.svg?branch=master)](https://travis-ci.org/peter-evans/testcontainers-template)

This is a bare-bones project demonstrating how the [TestContainers](https://github.com/testcontainers/testcontainers-java) library can be used to perform integration tests against a containerised system under test (SUT).
If the SUT and its dependencies can be built from docker images, [TestContainers](https://github.com/testcontainers/testcontainers-java) can create and tear-down containers during the testing phase of the build.
This allows integration tests to be preformed against a real instance of the SUT rather than relying on mocks.

Key points:
- Separation of unit test and integration test phases during the build
- Separation of unit test and integration test source files within the module
- Use of [TestContainers](https://github.com/testcontainers/testcontainers-java) to create and tear-down a container running a simple API as our SUT

## Separating unit test and integration test build phases

While the [Maven Surefire](http://maven.apache.org/surefire/maven-surefire-plugin/) plugin is designed to run unit tests, the [Maven Failsafe](https://maven.apache.org/surefire/maven-failsafe-plugin/) plugin is designed to run integration tests.
By default both plugins will include test classes based on the wildcard patterns described [here](http://maven.apache.org/surefire/maven-surefire-plugin/examples/inclusion-exclusion.html) and [here](https://maven.apache.org/surefire/maven-failsafe-plugin/examples/inclusion-exclusion.html).

However, by using JUnit [Categories](http://junit.org/junit4/javadoc/4.12/org/junit/experimental/categories/Categories.html) we can clearly separate our test classes regardless of their naming conventions.
This project demonstrates use of the `@Category` annotation to specify unit tests that will be executed by [Maven Surefire](http://maven.apache.org/surefire/maven-surefire-plugin/) and integration tests that will be executed by [Maven Failsafe](https://maven.apache.org/surefire/maven-failsafe-plugin/).

With both plugins enabled and test categories defined, executing maven's build phases gives the following results:

- `mvn test` - Executes tests annotated with the unit test category. The build terminates on test failure.
- `mvn integration-test` - Executes tests annotated with the integration test category. The build does not terminate on test failure.
- `mvn verify` - Terminates the build if there were any integration test failures.

## Separating integration test source files

It's good practice to separate integration test sources from unit test sources. This is often achieved by moving them into a different module. This project demonstrates how it can be achieved within the same module.

Integration test source files are moved under `src\integration\java` and integration test resources are moved under `src\integration\resources`.
By default maven will not include these directories during the build. Using the [Build Helper Maven Plugin](http://www.mojohaus.org/build-helper-maven-plugin/index.html) we can add additional test source directories and resource directories.
See the documentation [here](http://www.mojohaus.org/build-helper-maven-plugin/usage.html) for usage and examples.

## License

MIT License - see the [LICENSE](LICENSE) file for details