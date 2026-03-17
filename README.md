# Exercise 03: Event Handling, Intents & Debugging

## Overview
A two-screen Android application called **Echo App** built as part of CIS 2203N - Mobile Development.

## Parts

### Part 1 - Echo App
A simple two-screen app that demonstrates:
- **Event Handling** - capturing user input via a button click
- **Explicit Intent** - navigating from InputActivity to EchoActivity
- **Intent Extras** - passing data between activities using `putExtra()` and `getStringExtra()`
- **Logcat Logging** - using `Log.d()` to track app events in both activities

### Part 2 - Echo App with Bonus
Everything in Part 1, plus:
- **Implicit Intent** - a second button that shares the typed message via SMS or email using `Intent.ACTION_SEND`

## Screens
- **InputActivity** - contains an EditText for typing a message and a Send button
- **EchoActivity** - displays the message received from InputActivity

## Screenshots 
### PART 1
<img width="376" height="794" alt="Screenshot 2026-03-17 213144" src="https://github.com/user-attachments/assets/0057ea61-6d65-4bcc-830b-dbc93657fad9" />
<img width="435" height="805" alt="Screenshot 2026-03-17 213948" src="https://github.com/user-attachments/assets/179340d1-b39f-4f38-96d5-6a333e57b3ee" />

### PART 2
<img width="414" height="820" alt="Screenshot 2026-03-17 213121" src="https://github.com/user-attachments/assets/e872f770-9202-4cd0-a9a5-91ae8bad7238" />
<img width="376" height="794" alt="Screenshot 2026-03-17 213144" src="https://github.com/user-attachments/assets/f33d93df-626d-47d1-bc78-1f63bac47e4a" />

### LOGCAT
<img width="1703" height="978" alt="Screenshot 2026-03-17 213315" src="https://github.com/user-attachments/assets/a664e51a-60ce-4470-80f3-a50fc1c581c0" />
<img width="1671" height="957" alt="Screenshot 2026-03-17 213240" src="https://github.com/user-attachments/assets/73955350-e612-4b48-acc5-fc5051faa784" />

