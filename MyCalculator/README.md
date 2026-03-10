# MyCalculator
### CIS2203N - Mobile Development | MOCK Midterm

---

## Overview
A fully functional calculator Android application built entirely in Java.
Features standard arithmetic, state preservation, a custom ID-based operator,
and a bonus scrollable history log.

---

## Implementation Choices

### UI Layout — Why LinearLayout over GridLayout?
I initially used GridLayout but switched to nested LinearLayouts with
`layout_weight="1"` for each button. This guarantees perfectly equal button
widths across all screen sizes without excessive nesting or unpredictable
column sizing that GridLayout can produce.

### State Preservation — Why onSaveInstanceState over ViewModel?
I chose `onSaveInstanceState` because it directly handles saving and restoring
primitive values (operandA, operandB, operator, display text) during activity
recreation. For a calculator of this scale, it is simpler and more appropriate
than setting up a full ViewModel architecture. Additionally, `configChanges`
was added to the AndroidManifest to prevent activity recreation on rotation,
giving the display natural persistence.

### Division by Zero Handling
Instead of letting the app crash, the divide operation explicitly checks if
the second operand is zero and displays "Error" on screen, resets the
operator, and returns safely without computing.

### Custom Operator — ID Button
The ID button adds the first 3 digits of my Student ID to the current display
value. My Student ID starts with `230` so pressing ID on any number adds 230
to it. Example: `5 + ID = 235`.

### Color Theme
| Element | Color |
|---|---|
| Background | Soft White `#FFFDF9` |
| Number Buttons | Vibrant Blue `#4F9CF9` |
| Operator Buttons | Vivid Orange `#FF8C42` |
| Clear and Equals | Fresh Green `#43D997` |
| Display Text | Dark Navy `#1A1F71` |
| History Text | Pastel `#FFD6A5` |

---

## Milestone Commits

| Milestone | Commit Message |
|---|---|
| Milestone 1 | `feat: implement UI grid and styling` |
| Milestone 2 | `feat: implement core math logic and zero-division handling` |
| Milestone 3 | `feat: add state preservation and custom operator` |
| Bonus | `feat: add scrolling history log` |
| Docs | `docs: add README with implementation notes` |

All milestone commits are visible in the Git history of the `MOCK-MIDTERM` branch.

---

## Features
- Standard arithmetic: addition, subtraction, multiplication, division
- Division by zero displays `Error` without crashing
- Screen rotation preserves current operands and display
- Custom ID operator adds 230 to any input
- Light color theme with rounded pill-shaped buttons
- Scrollable history log of all past calculations
