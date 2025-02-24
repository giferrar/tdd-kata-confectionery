# Learn TDD with Katas

## Introduction

Test-Driven Development (**TDD**) is a workflow to develop software guided by tests.

We start by writing down a list of tests, or use cases, that cover all the variants of the behavior or functionality we want to implement.
Then, we pick one use case from the list (usually starting from the most simple to the most complex) and we perform the following steps:

1) _RED_: first we write down the unit test for the implementation that we have not done yet. The test of course fails (failing to compile is considered _RED_).
2) _GREEN_: we write the minimal implementation to let the test pass. This does not mean the full implementation, but just what is needed to have a green bar. 
3) _REFACTOR_: we refactor the code to complete the implementation or improve its design. This step is of course open to discussion and exchange of ideas about a proper solution.

Here is an example of the workflow, highlighting some common mistakes:
![Example of TDD Workflow, highlighting some common mistakes](https://substackcdn.com/image/fetch/f_auto,q_auto:good,fl_progressive:steep/https%3A%2F%2Fsubstack-post-media.s3.amazonaws.com%2Fpublic%2Fimages%2F7491e124-9e22-4e55-b03b-68d76316dcba_1602x1076.jpeg "TDD Workflow")

## Project Structure
In this exercise we will practice Test-Driven Development working on a sample project.
In the Project is present the Object [`Cake`](src/main/java/org/example/kata/confectionery/persistence/model/Cake.java), which represents a database Entity, and its Repository [`CakeRepository`](src/main/java/org/example/kata/confectionery/persistence/repository/CakeRepository.java).

The goal of this exercise is to implement the Service [`CakeService`](src/main/java/org/example/kata/confectionery/service/CakeService.java) using **TDD**.

In the Project you can find the Test class [`CakeServiceTest`](src/test/java/org/example/kata/confectionery/service/CakeServiceTest.java) to work on.

## Katas
We will complete a series of Exercises, called _Kata_. _Kata_ is the Japanese word for "form" and in Karate refers to detailed patterns of movements.
In a Kata we follow precisely the steps of the **TDD** workflow, with the purpose to learn the logic behind it and to implement it in certain real world situations.

Our list of Katas represents the list of scenarios we want to write to guide our implementation. This would be the step 1 of the workflow.

### Randori
Randori is a term used in Japanese martial arts to refer to sparring. In Randori we will perform a variation of Katas involving pair programming.

One developer plays the role of the "attacker" and is responsible for writing the failing test (_RED_ step), presenting the challenge to a second developer, the "defender", responsible for the implementation (_GREEN_ and _REFACTOR_ step).

After terminating the challenge going through the whole round of the **TDD** workflow, the two can pick another scenario from the list and swap their roles.

## Description of the Kata/Randori challenges

### CakeService

#### getCake
1) When we get the cake with ID `1`, then the right cake is returned
2) When we try to get a cake whose ID does not exist, a `CakeNotBakedException` is thrown

#### findCakeByIngredientsContaining
1) When find cake with ingredients including `savoiardi`, then a list containing `Tiramisu` is returned
2) When find cake with ingredients including `nails`, then an empty list is returned

#### bakeCake
1) When baking a cake with parameter `name` null or empty, an exception is thrown with message `Name is mandatory`
2) When baking a cake with parameter `ingredients` not representing a CSV (comma separated value) with more than 3 elements, an exception is thrown with message `Not enough ingredients`
3) When baking a cake with proper parameters, the cake is persisted and the saved entity is returned

#### deleteCakeByName
1) When deleting a cake with name `Strawberry Cake`, then a cake with ID `4` cannot be found

#### eatCakeIfHealthy
1) If the ID of a healthy Cake is given (`5`), return the number of calories (`224`)
2) If the ID of an unhealthy Cake is given (`2`), return `0`. A Cake is unhealthy if it is not vegan. A vegan Cake does not contain neither `eggs` nor `butter`.
3) If a non-existing ID is given, a `CakeNotBakedException` is thrown

## Refactoring tips
- In some cases you should extract some code from the Service into a method object belonging to the Entity. This is particularly useful regarding `if` conditions. 
  Finding a name for the method can help you understand the state of the Entity. For example, determine if the parameter `ingredients` is incomplete by writing the object method `isRecipeComplete` inside `Cake`.
- Remember to follow the naming convention for Unit Tests `when_a_with_b_then_c` to improve understandability of the scope of the test.

## Sources

- https://martinfowler.com/bliki/TestDrivenDevelopment.html,
- https://tidyfirst.substack.com/p/canon-tdd
