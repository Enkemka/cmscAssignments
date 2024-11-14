import java.io.BufferedReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class TwoDimRaggedArrayUtility {

	public static double[][] readFile(File selectedFile) throws IOException {
        // Initialize the BufferedReader to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
            String line;
          // First, count the number of rows in the file
            int rowc = 0;
           while ((line = br.readLine()) != null) {
                rowc++;
            }

            // Reset the BufferedReader to read the file again
            br.close();  // Close the original BufferedReader
            try (BufferedReader br2 = new BufferedReader(new FileReader(selectedFile))) {
                double[][] arr = new double[rowc][];  // Create the 2D jagged array
                int row = 0;
                // Read the file again line by line
                
                
                
               while ((line = br2.readLine()) != null) {
                    // Split the line by spaces to get the words
                    String[] words = line.split(" ");
                    // Initialize the row with the number of words in the current line
                   arr[row] = new double[words.length];

                   
                   
                   
                   
                   // Loop over each word, convert to double and store in the jagged array
                   for (int col = 0; col < words.length; col++) {
                        try {
                         arr[row][col] = Double.parseDouble(words[col]);
                        } catch (NumberFormatException e) {
                          System.out.println("Error parsing value: " + words[col]);
                            arr[row][col] = 0.0;  // Default value if parsing fails
                      }
         
                   }
                   
                   
                   
                   row++;
                }

                // Return the populated 2D jagged array
                return arr;
            }
        }
    }

	public static double getTotal(double[][] sales) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static double getRowTotal(double[][] sales, int row) {
		double num=0;
		for(int i=0; i < sales[row].length; i++) {
				
				num += sales[row][i];
		}
		
		return num;
		
        }

	        // Initialize the BufferedReader to read the file
	   
		
	

	public static double getColumnTotal(double[][] sales, int col) {
		
		double num=0;
		for(int i=0; i <sales.length; i++) {
				
			 if (col < sales[i].length) {
		            num += sales[i][col];  // Add the element in the specified column
		        }
		}
		
		return num;
	
		
		
		// TODO Auto-generated method stub
	
	}

	public static double getHighestInColumn(double[][] sales, int col) {
	
		double num=sales[0][col];
		for(int i=0; i <sales.length; i++) {
				
			 if (num < sales[i][col]) {
		            num = sales[i][col];  // Add the element in the specified column
		        }
		}
		return num;
		
	}

	public static double getLowestInColumn(double[][] sales, int col) {
		double num=sales[0][col];
		for(int i=0; i <sales.length; i++) {
				
			 if (num > sales[i][col]) {
		            num = sales[i][col];  // Add the element in the specified column
		        }
		}
		return num;
	}

	public static void writeToFile(double[][] sales, File selectedFile) {
		// TODO Auto-generated method stub
		
	}

}
