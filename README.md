# UniFind

UniFind is an Android application built with **Java + XML** as part of the Android Application Development course (Assignment 2). It demonstrates the common screens found in most mobile apps, with simulated (local) authentication and no backend.

## Implemented screens

| Screen | Description |
|---|---|
| Splash | Shows the app logo and name for about 2.5 seconds, then opens Login |
| Login | Email and password with validation, links to Register and Forgot Password |
| Register | Name, email, password and confirm password with validation |
| Forgot Password | Accepts the registered email and simulates sending a reset link |
| Reset Password | New password and confirm password with validation |
| Landing (Dashboard) | Main modules shown as icon + label cards in a 2-column grid |
| Profile | Shows the user's name and email, with a Logout button |

## Navigation flow

```
Splash -> Login -> Landing -> Profile -> (Logout) -> Login
            |
            +--> Register -> (back to Login)
            |
            +--> Forgot Password -> Reset Password -> (back to Login)
```

All navigation uses explicit Intents.

## Technical requirements covered

- **Resources:** default `strings.xml` / `colors.xml`, night-mode colors (`values-night`) and Urdu strings (`values-ur`)
- **Layouts:** ConstraintLayout (Splash, Login), LinearLayout (Reset Password, Profile, Landing), RelativeLayout (Forgot Password), GridLayout (Landing)
- **Input controls:** TextInputLayout / TextInputEditText for text, email and password (with show/hide toggle)
- **Event handling:** button and card click listeners, input validation with error messages
- **Activity navigation:** explicit Intents, including `finish()` and clearing the back stack on logout

## Simulated authentication

Accounts are stored locally with SharedPreferences (`UserStore.java`). One account is kept at a time. A demo account is available on first launch:

- Email: `demo@unifind.com`
- Password: `123456`

Registering a new account replaces the stored one. Resetting the password updates it.

## Tech stack

- Language: Java
- UI: XML layouts, Material Components
- IDE: Android Studio

## How to run

1. Clone the repository and open it in Android Studio.
2. Let Gradle sync finish.
3. Select an emulator or a connected phone and press **Run**.

## Author

Syeda Fatima Hassan