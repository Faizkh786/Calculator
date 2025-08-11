import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class SoundCalculator {
    public static void main(String[] args) {
        SoundCalculatorApp calculator = new SoundCalculatorApp();
        calculator.run();
    }
}

class SoundCalculatorApp {
    private Scanner scanner;
    private AudioPlayer audioPlayer;
    
    public SoundCalculatorApp() {
        scanner = new Scanner(System.in);
        audioPlayer = new AudioPlayer();
    }
    
    public void run() {
        System.out.println("=== Voice Sound Calculator ===");
        System.out.println("Each button press will speak its name!");
        System.out.println("Available operations: +, -, *, /, %");
        System.out.println("Enter 'quit' to exit");
        
        while (true) {
            try {
                System.out.print("\nEnter first number: ");
                String input = scanner.nextLine();
                
                if (input.equalsIgnoreCase("quit")) {
                    playVoiceSound("goodbye");
                    System.out.println("Goodbye!");
                    break;
                }
                
                playVoiceSound("number_" + input);
                double num1 = Double.parseDouble(input);
                
                System.out.print("Enter operation (+, -, *, /, %): ");
                String operation = scanner.nextLine();
                playVoiceSound("operator_" + operation);
                
                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(scanner.nextLine());
                playVoiceSound("number_" + String.valueOf((int)num2));
                
                double result = calculate(num1, num2, operation);
                playVoiceSound("equals");
                System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, operation, num2, result);
                
            } catch (NumberFormatException e) {
                playVoiceSound("error");
                System.out.println("Invalid number format. Please try again.");
            } catch (ArithmeticException e) {
                playVoiceSound("error");
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                playVoiceSound("error");
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
    
    private void playVoiceSound(String soundType) {
        try {
            switch (soundType) {
                case "number_0":
                    audioPlayer.playVoicePattern(new int[]{262, 330, 392}, new int[]{100, 100, 150}); // "Zero"
                    break;
                case "number_1":
                    audioPlayer.playVoicePattern(new int[]{330, 392, 440}, new int[]{100, 100, 150}); // "One"
                    break;
                case "number_2":
                    audioPlayer.playVoicePattern(new int[]{392, 440, 494}, new int[]{100, 100, 150}); // "Two"
                    break;
                case "number_3":
                    audioPlayer.playVoicePattern(new int[]{440, 494, 523}, new int[]{100, 100, 150}); // "Three"
                    break;
                case "number_4":
                    audioPlayer.playVoicePattern(new int[]{494, 523, 587}, new int[]{100, 100, 150}); // "Four"
                    break;
                case "number_5":
                    audioPlayer.playVoicePattern(new int[]{523, 587, 659}, new int[]{100, 100, 150}); // "Five"
                    break;
                case "number_6":
                    audioPlayer.playVoicePattern(new int[]{587, 659, 698}, new int[]{100, 100, 150}); // "Six"
                    break;
                case "number_7":
                    audioPlayer.playVoicePattern(new int[]{659, 698, 784}, new int[]{100, 100, 150}); // "Seven"
                    break;
                case "number_8":
                    audioPlayer.playVoicePattern(new int[]{698, 784, 880}, new int[]{100, 100, 150}); // "Eight"
                    break;
                case "number_9":
                    audioPlayer.playVoicePattern(new int[]{784, 880, 988}, new int[]{100, 100, 150}); // "Nine"
                    break;
                case "operator_+":
                    audioPlayer.playVoicePattern(new int[]{440, 523, 659}, new int[]{120, 120, 200}); // "Plus"
                    break;
                case "operator_-":
                    audioPlayer.playVoicePattern(new int[]{523, 659, 784}, new int[]{120, 120, 200}); // "Minus"
                    break;
                case "operator_*":
                    audioPlayer.playVoicePattern(new int[]{659, 784, 880}, new int[]{120, 120, 200}); // "Multiply"
                    break;
                case "operator_/":
                    audioPlayer.playVoicePattern(new int[]{784, 880, 988}, new int[]{120, 120, 200}); // "Divide"
                    break;
                case "operator_%":
                    audioPlayer.playVoicePattern(new int[]{880, 988, 1047}, new int[]{120, 120, 200}); // "Percent"
                    break;
                case "equals":
                    audioPlayer.playVoicePattern(new int[]{523, 659, 784, 1047}, new int[]{100, 100, 100, 300}); // "Equals"
                    break;
                case "error":
                    audioPlayer.playVoicePattern(new int[]{200, 150, 100}, new int[]{200, 200, 300}); // "Error"
                    break;
                case "goodbye":
                    audioPlayer.playVoicePattern(new int[]{880, 1047, 1319, 1760}, new int[]{200, 200, 200, 500}); // "Goodbye"
                    break;
                default:
                    audioPlayer.playBeep(440, 100);
                    break;
            }
        } catch (Exception e) {
            // Silently ignore audio errors
        }
    }
    
    public double calculate(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "/":
                return divide(num1, num2);
            case "%":
                return modulo(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    
    public double modulo(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot calculate modulo with zero");
        }
        return a % b;
    }
}

class AudioPlayer {
    public void playBeep(int frequency, int duration) {
        try {
            byte[] audioData = generateBeep(frequency, duration);
            AudioFormat format = new AudioFormat(44100, 8, 1, true, false);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            
            if (AudioSystem.isLineSupported(info)) {
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                line.open(format);
                line.start();
                line.write(audioData, 0, audioData.length);
                line.drain();
                line.close();
            }
        } catch (Exception e) {
            // Silently ignore audio errors
        }
    }
    
    public void playVoicePattern(int[] frequencies, int[] durations) {
        try {
            AudioFormat format = new AudioFormat(44100, 8, 1, true, false);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            
            if (AudioSystem.isLineSupported(info)) {
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                line.open(format);
                line.start();
                
                // Play each frequency in sequence to simulate voice
                for (int i = 0; i < frequencies.length; i++) {
                    byte[] audioData = generateBeep(frequencies[i], durations[i]);
                    line.write(audioData, 0, audioData.length);
                    
                    // Small pause between sounds
                    if (i < frequencies.length - 1) {
                        byte[] silence = new byte[2205]; // 50ms silence
                        line.write(silence, 0, silence.length);
                    }
                }
                
                line.drain();
                line.close();
            }
        } catch (Exception e) {
            // Silently ignore audio errors
        }
    }
    
    private byte[] generateBeep(int frequency, int duration) {
        int sampleRate = 44100;
        int numSamples = (sampleRate * duration) / 1000;
        byte[] audioData = new byte[numSamples];
        
        for (int i = 0; i < numSamples; i++) {
            double angle = (2.0 * Math.PI * frequency * i) / sampleRate;
            audioData[i] = (byte) (Math.sin(angle) * 127.0);
        }
        
        return audioData;
    }
}
