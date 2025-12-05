# 🏁 Flags Quiz Game

An interactive Android quiz application that tests your knowledge of world flags! Built with Kotlin as part of the Mobile Software Development (CS325) course at MedTech during my Master's degree.

## 📱 About

Flags Quiz Game is an educational and entertaining mobile application where users can test their knowledge of flags from around the world. The app presents flag images and challenges users to identify the correct country from multiple choice options.

## ✨ Features

- **Interactive Quiz Interface**: Clean and intuitive UI with visual feedback
- **Multiple Choice Questions**: Four options per question for engaging gameplay
- **Progress Tracking**: Visual progress bar and question counter
- **Score Calculation**: Track correct answers and view final results
- **Visual Feedback**: Color-coded answer validation (correct/incorrect)
- **User Login**: Personalized welcome screen before starting the quiz
- **Result Screen**: Displays final score with option to finish

## 🎮 How to Play

1. Launch the app and enter your name on the login screen
2. Click "Start" to begin the quiz
3. View the flag image and read the question
4. Select one of the four country options
5. Click "Submit" to confirm your answer
6. Progress through all questions
7. View your final score on the result screen

## 🛠️ Tech Stack

- **Language**: Kotlin
- **Platform**: Android
- **Build System**: Gradle (Kotlin DSL)
- **UI**: XML Layouts with View Binding
- **Architecture**: Activity-based with MVC pattern
- **Min SDK**: Android SDK (check `build.gradle.kts` for specific version)

## 📂 Project Structure

```
app/src/main/java/com/example/firstapplication/
├── Constants.kt         # Quiz questions and app constants
├── LoginActivity.kt     # Entry point with user login
├── MainActivity.kt      # Main quiz logic and UI handling
├── Question.kt          # Data class for quiz questions
└── ResultActivity.kt    # Final score display
```

## 🚀 Getting Started

### Prerequisites

- Android Studio (Arctic Fox or later recommended)
- JDK 11 or higher
- Android SDK
- Gradle 7.0+

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/emansarahafi/Flags-Quiz-Game.git
   ```

2. Open the project in Android Studio

3. Sync Gradle files

4. Run the app on an emulator or physical device

### Building the Project

```bash
./gradlew build
```

### Running Tests

```bash
./gradlew test
```

## 🎯 Features Breakdown

### Question Management

- Centralized question bank in `Constants.kt`
- Easy to add/modify questions
- Support for flag images as drawable resources

### UI Components

- Custom option borders (default, selected, correct, wrong)
- Progress indicators
- Responsive layouts
- Custom fonts (Poppins Bold & SemiBold)

### Themes

- Light and dark mode support
- Material Design components
- Consistent color scheme

## 🔧 Configuration

Key configuration files:

- `build.gradle.kts`: Dependencies and build configuration
- `AndroidManifest.xml`: App permissions and activities
- `res/values/strings.xml`: String resources
- `res/values/colors.xml`: Color palette

## 📝 License

This project is licensed under the terms specified in the [LICENSE](LICENSE) file.

## 🙏 Acknowledgments

- Developed as part of CS325 - Mobile Software Development course at MedTech
- Flag images and educational content
