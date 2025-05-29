A Java program that transforms indices from one list to another using the 2n-1 formula.  
📖 Description: This program demonstrates how to:Map values from a numeric list (List1) to indices in a string list (List2)Apply the transformation formula index = 2n - 1Generate the corresponding output sequence

🧮 Transformation LogicFor each integer n in List1:Output = List2[2n - 1]  
Example:List1 ValueCalculationList2 IndexOutput62*6 - 1 = 1111"N1w"42*4 - 1 = 77"lNU"

🛠️ Technical Implementation//  
Key components:  
List<Integer> list1 = Arrays.asList(6, 4, 5,...);  
List<String> list2 = Arrays.asList("Q7Zm", "D7PP",...);  
// Transformation logic within a loop:  
// For each 'n' in list1:  
// String result = list2.get((2 * n) - 1);  

🚀 How to RunRequirements:Java JDK 8+Command Line:  
# Navigate to your project's root directory (where src/ is located)  
# Compile the Java source file:  
javac src/oop/mid2/t1/ListProcessor.java  
# Run the compiled program.  
# The '-cp src' flag adds the 'src' directory to the classpath,
# allowing Java to find your packaged class 'oop.mid2.t1.ListProcessor'.java -cp src oop.mid2.t1.ListProcessor  
Expected Output:--- List Transformation Program ---  
List1: 6 4 5 4 7 9 2 2 7 7 8 2 9  
List2: Q7Zm D7PP SY5t ZdI Ldt pqTIo dXQ lNU ZXKSj x6r8N rqr N1w 6LZ G2eM6 uaLm rjZ yMxxE qBEL  
Output (transformed sequence):  
N1w, lNU, x6r8N, lNU, G2eM6, qBEL, ZdI, ZdI, G2eM6, G2eM6, rjZ, ZdI, qBEL. 
-----------------------------------
📝 File Structureproject/  
├── src/  
│   └── oop/  
│       └── mid2/  
│           └── t1/  
│               └── ListProcessor.java  # Main program file  
└── README.md                     # This documentation file  
📜 LicenseMIT License - Free for educational and commercial use  
⁉️ FAQQ: Why use 2n-1 for indexing?  
A: This was the specified transformation rule in the original problem to map List1 values to List2 indices.  
Q: How to modify for different lists?  
A: Simply change the list1 and list2 initialization values within ListProcessor.java while maintaining the same index calculation logic.  

**Screenshot**: <img width="1440" alt="Screenshot 2025-05-28 at 22 44 39" src="https://github.com/user-attachments/assets/c0e5351c-9e8c-4050-ba1f-d8487120f113" />
