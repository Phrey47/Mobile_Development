# Hello Campus - Mobile Development

## Part 1: Hello Campus

### Description
An Android app that displays the Academic Department name
and shows the Department Chairwoman's name when a button is clicked.

### Screenshots
<img width="363" height="723" alt="Part1_ID" src="https://github.com/user-attachments/assets/7486bb93-ca9c-4db1-a13c-184225b42c41" />
<img width="355" height="783" alt="Part_1_Chairwoman" src="https://github.com/user-attachments/assets/900cacae-af8d-4139-be8d-2c5e7ace9843" />

---

## Part 2: The Interrupted Counter

### Description
A counter app that survives screen rotation using
Android's Activity Lifecycle methods.

### The Sabotage Crash
The following code caused a NullPointerException:

    TextView counterDisplay = null;
    counterDisplay.setText("0");

counterDisplay was declared as null and never assigned
to an actual View using findViewById(). Calling .setText()
on a null object reference causes an immediate crash.

### The Rotation Problem
When the screen rotates, Android completely destroys and
recreates the Activity. This resets all variables including
mCounter back to zero, causing the counter to lose its value.

### The Fix
Two lifecycle methods were used to save and restore the counter:

- onSaveInstanceState(): saves mCounter to a Bundle just
  before the Activity is destroyed during rotation.

- onRestoreInstanceState(): reads mCounter back from the
  Bundle after the Activity is recreated, then updates
  the TextView.

### Screenshots
<img width="1689" height="967" alt="Part_2_logcat_error" src="https://github.com/user-attachments/assets/1bd92f13-fe20-4a3d-9afd-9e7506d1e1c0" />
<img width="1681" height="970" alt="Part_2_before_counter_rotation_fix" src="https://github.com/user-attachments/assets/2df42618-73a0-4634-bcf8-e41c84c86160" />
<img width="377" height="182" alt="Part_2_before_counter_rotation_fix2" src="https://github.com/user-attachments/assets/5128003c-4aee-4188-83e8-35bd95ca673e" />
<img width="359" height="800" alt="Part_2_with_fix" src="https://github.com/user-attachments/assets/3ab0311f-5bb1-4330-b06b-6dfc1c972a74" />
<img width="398" height="245" alt="Part_2_with_rotaion_fix" src="https://github.com/user-attachments/assets/022e9e8b-3f95-40ce-97b3-4abbf03002dd" />


