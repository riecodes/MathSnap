# MathSnap: Flashcard Drills

## Project Progress Checklist

- [x] Set up Maven JavaFX project in NetBeans 25
- [x] Created and styled Welcome screen (Welcome.fxml) with custom font and portrait orientation
- [x] Made Start button clickable and connected to Operation Selection screen
- [x] Created OperationSelection.fxml (initial version)
- [ ] Revise OperationSelection.fxml to match Welcome screen design (portrait, centered, child-friendly)
- [ ] Create and connect controllers for Operation Selection
- [ ] Create Difficulty Selection screen (DifficultySelection.fxml)
- [ ] Create Flashcard Drill screen (Flashcard.fxml)
- [ ] Create Feedback screen (Feedback.fxml)
- [ ] Implement models and problem generator
- [ ] Develop controllers for navigation and logic
- [ ] Apply CSS for color palette and child-friendly design to all screens
- [ ] Add animations and feedback logic
- [ ] Test with sample problems and user flows

---

## Overview
MathSnap: Flashcard Drills is a JavaFX application designed to help toddlers (ages 2-5) develop basic math skills through interactive flashcard drills. The app is built with Maven and JavaFX in Apache NetBeans 25, featuring a child-friendly, colorful interface and immediate feedback for continuous learning.

---

## Application Flow
- **Welcome Screen:**
  - Large title, single "Start" button (centered, bright yellow).
- **Operation Selection:**
  - Four buttons: Addition, Subtraction, Multiplication, Division.
- **Difficulty Selection:**
  - For each operation, three buttons: Easy (1-digit), Moderate (1- & 2-digit), Hard (2-digit).
- **Flashcard Drill:**
  - Flashcard displays a math problem.
  - Input box for answer.
  - "Enter" to submit.
  - Immediate feedback: green outline for correct, red for incorrect.
  - Flip effect to show correct answer and feedback ("Nice/Awesome" or "Try again").
  - "Home" and "Next" buttons for navigation.
- **Continuous Loop:**
  - User can keep practicing or return home at any time.
- **Back Button:**
  - Present on every interface except the main welcome.

---

## Color Palette
- **Easy:** Mint Green `#CFF5E7`
- **Medium:** Coral Orange `#FF9B42`
- **Hard:** Electric Purple `#BF5AF2`
- **Background:** Light Sky Blue `#B3E5FC`
- **Primary Buttons:** Bright Yellow `#FFEB3B`
- **Wrong Feedback:** Soft Red `#EF5350`
- **Correct Feedback:** Lime Green `#8BC34A`
- **Text:** Deep Blue `#1A237E`
- **Flashcard BG:** White `#FFFFFF`

---

## UI/UX Design
- **FXML for each screen:**
  - Welcome, Operation Selection, Difficulty Selection, Flashcard Drill, Feedback.
- **CSS:**
  - Uses the color palette for backgrounds, buttons, feedback, and flashcard borders.
  - Large, readable fonts (custom ComicNeueSansID font loaded programmatically).
  - Child-friendly, rounded buttons and input fields.
- **Images/Icons:**
  - Simple icons for operations and navigation (home, back, next).

---

## Core Logic
- **Enums:**
  - `Operation` (ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION)
  - `DifficultyLevel` (EASY, MODERATE, HARD)
- **MathProblem Model:**
  - Fields: operand1, operand2, operation, correctAnswer, difficulty
  - Method: `generateRandomProblem(Operation, DifficultyLevel)`
- **ProblemGenerator Utility:**
  - Handles random number generation based on difficulty.
- **Controllers:**
  - Manage navigation, user input, feedback, and state transitions.

---

## Flashcard Drill Implementation
- **Flashcard View:**
  - Displays problem, input box, and operation label.
  - Border color changes based on difficulty.
  - On answer submit:
    - Input box border flashes green/red.
    - Flip animation reveals correct answer and feedback.
    - "Next" and "Home" buttons appear.
- **Feedback:**
  - "Nice/Awesome" for correct, "Try again" for incorrect.
  - Immediate, visually distinct feedback.

---

## Navigation & State
- **Back Button:** Present on all screens except the main welcome.
- **Home Button:** Returns to the welcome screen.
- **Next Button:** Loads a new problem with the same settings.

---

## Accessibility & Child-Friendliness
- Large, high-contrast buttons and text.
- Minimal text, more icons and color cues.
- Simple, non-distracting animations.

---

## Project Structure (Current)
```
src/
  main/
    java/
      com.mycompany.mathsnap/
        App.java
        WelcomeController.java
        (other controllers/models planned)
    resources/
      com/mycompany/mathsnap/
        Welcome.fxml
        OperationSelection.fxml
        style.css
        font/
          comicsans.ttf
        (other FXMLs and resources planned)
pom.xml
```

---

## Next Steps
1. Revise OperationSelection.fxml to match Welcome screen design (portrait, centered, child-friendly)
2. Create and connect controllers for Operation Selection
3. Create Difficulty Selection screen (DifficultySelection.fxml)
4. Create Flashcard Drill screen (Flashcard.fxml)
5. Create Feedback screen (Feedback.fxml)
6. Implement models and problem generator
7. Develop controllers for navigation and logic
8. Apply CSS for color palette and child-friendly design to all screens
9. Add animations and feedback logic
10. Test with sample problems and user flows

---

## Notes
- Font family used: ComicNeueSansID (loaded programmatically, referenced in CSS).
- All navigation uses `App.setRoot()` for scene switching.
- FXML and controller naming follows the screen flow for clarity. 