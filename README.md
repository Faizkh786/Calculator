# 🔊 Voice Sound Calculator Project

This project contains two different calculator implementations with **voice sound effects** that speak the button names!

## 🎵 Voice Sound Features

### Each Button Speaks Its Name:
- **Numbers (0-9)**: Each number has a unique voice pattern
  - "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
- **Operators**: Each operator has its own voice
  - "Plus", "Minus", "Multiply", "Divide", "Percent"
- **Special Buttons**:
  - "Equals" - Success voice pattern
  - "Clear" - Warning voice pattern
  - "Delete" - Deletion voice pattern
  - "Decimal" - Decimal point voice pattern
  - "Goodbye" - Farewell voice pattern

### Voice Pattern Technology:
- **Java Version**: Uses frequency sequences to simulate speech patterns
- **Web Version**: Uses Web Audio API with multiple oscillators for voice synthesis
- **Realistic Timing**: Pauses between syllables for natural speech flow

## 📁 Files in this Project

- `SoundCalculator.java` - Java console calculator with voice patterns
- `SoundCalculator.html` - Web calculator with Web Audio API voice synthesis
- `README.md` - This documentation file

---

## 🖥️ Java Voice Calculator (`SoundCalculator.java`)

A command-line calculator that speaks button names using synthesized voice patterns.

### Features:
- ✅ **Voice feedback** for every input - buttons speak their names!
- ✅ **Frequency sequences** to simulate speech patterns
- ✅ All basic arithmetic operations (+, -, *, /, %)
- ✅ Error handling with error voice patterns
- ✅ Interactive console interface
- ✅ Different voice patterns for different actions

### How to Run:

#### Prerequisites:
1. **Install Java JDK** (if not already installed):
   - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/)
   - Install and add to PATH

#### Steps:
1. **Compile the Java file:**
   ```bash
   javac SoundCalculator.java
   ```

2. **Run the calculator:**
   ```bash
   java SoundCalculator
   ```

3. **Follow the prompts** and hear the voice sounds!

### Example Usage:
```
=== Voice Sound Calculator ===
Each button press will speak its name!
Available operations: +, -, *, /, %

Enter first number: 5
[Plays "Five" voice pattern]
Enter operation (+, -, *, /, %): +
[Plays "Plus" voice pattern]
Enter second number: 3
[Plays "Three" voice pattern]
Result: 5.00 + 3.00 = 8.00
[Plays "Equals" voice pattern]
```

---

## 🌐 HTML/CSS Voice Calculator (`SoundCalculator.html`)

A beautiful web-based calculator with **real-time voice synthesis** using the Web Audio API.

### Features:
- ✅ **Real-time voice generation** using Web Audio API
- ✅ **Voice toggle** - Turn voice sounds on/off
- ✅ **Visual voice indicator** (green = ON, red = OFF)
- ✅ **Modern glassmorphism design**
- ✅ **Responsive layout** for all devices
- ✅ **Keyboard support** with voice feedback
- ✅ **Calculation history**
- ✅ **Smooth animations** and hover effects

### How to Run:

#### Method 1: Direct Browser Opening
1. **Double-click** `SoundCalculator.html` in your file explorer
2. **Or** drag and drop the file into any modern web browser

#### Method 2: Using Command Line
```bash
start SoundCalculator.html
```

#### Method 3: Using a Local Server (Recommended)
```bash
# Using Python (if installed)
python -m http.server 8000

# Then open: http://localhost:8000/SoundCalculator.html
```

### Controls:

#### Mouse/Touch:
- **Click any button** to hear its voice speak its name
- **Voice Toggle**: Click the "Toggle" button in the top-right corner

#### Keyboard Shortcuts:
- **Numbers**: `0-9` keys (each speaks its name)
- **Operations**: `+`, `-`, `*`, `/`, `%` (each speaks its name)
- **Calculate**: `Enter` or `=` (speaks "Equals")
- **Clear**: `Escape` (speaks "Clear")
- **Delete**: `Backspace` (speaks "Delete")
- **Decimal**: `.` (speaks "Decimal")
- **Toggle Voice**: `M` key

### Voice Types:
- **🔢 Numbers**: Each number has a unique voice pattern
  - 0: "Zero" (262-330-392 Hz)
  - 1: "One" (330-392-440 Hz)
  - 2: "Two" (392-440-494 Hz)
  - 3: "Three" (440-494-523 Hz)
  - 4: "Four" (494-523-587 Hz)
  - 5: "Five" (523-587-659 Hz)
  - 6: "Six" (587-659-698 Hz)
  - 7: "Seven" (659-698-784 Hz)
  - 8: "Eight" (698-784-880 Hz)
  - 9: "Nine" (784-880-988 Hz)
- **🔧 Operators**: Each operator speaks its name
  - Plus: "Plus" (440-523-659 Hz)
  - Minus: "Minus" (523-659-784 Hz)
  - Multiply: "Multiply" (659-784-880 Hz)
  - Divide: "Divide" (784-880-988 Hz)
  - Percent: "Percent" (880-988-1047 Hz)
- **✅ Equals**: "Equals" (523-659-784-1047 Hz)
- **🗑️ Clear**: "Clear" (200-150-100 Hz)
- **⌫ Delete**: "Delete" (300-250-200 Hz)
- **🔘 Decimal**: "Decimal" (550-659-784 Hz)

---

## 🎛️ Voice Controls

### Web Calculator:
- **Toggle Voice**: Click the toggle button or press `M`
- **Visual Indicator**: Green = Voice ON, Red = Voice OFF
- **Automatic**: Voice speaks immediately when buttons are pressed

### Java Calculator:
- **Automatic**: Voice speaks for every action
- **No toggle**: Voice is always enabled
- **Different patterns**: Each action has a unique voice pattern

---

## 🎨 Design Features

### Web Calculator:
- **Glassmorphism effect** with backdrop blur
- **Gradient background** (purple to blue)
- **Responsive design** for mobile devices
- **Smooth animations** and hover effects
- **Color-coded buttons** for different operations
- **Real-time voice indicator**

### Java Calculator:
- **Clean console interface**
- **Immediate voice feedback**
- **Error handling** with error voice patterns
- **User-friendly prompts**

---

## 🔧 Technical Details

### Web Audio API Voice Synthesis:
- **Real-time voice generation**
- **Multiple oscillator sequences**
- **Frequency modulation for speech patterns**
- **Gain control** for volume
- **Cross-browser compatibility**
- **Syllable timing** for natural speech flow

### Java Voice Synthesis:
- **Built-in audio system**
- **Frequency sequence patterns**
- **Voice pattern simulation**
- **Error handling** for unsupported systems
- **Synthesized speech patterns**

---

## 🚀 Quick Start

### For Immediate Use (Recommended):
1. **Open** `SoundCalculator.html` in your browser
2. **Click any button** to hear it speak its name
3. **Use keyboard** for faster input with voice feedback
4. **Toggle voice** with the button or `M` key

### For Java Version:
1. **Install Java** (if needed)
2. **Compile**: `javac SoundCalculator.java`
3. **Run**: `java SoundCalculator`
4. **Enjoy the voice sounds!**

---

## 🎵 Voice Experience

Both calculators provide a **unique interactive experience** where every button press is accompanied by a voice that speaks the button's name, making calculations more engaging and providing clear audio feedback for all actions!

**Try it now and enjoy the talking calculator experience! 🗣️✨**
