package com.niit.course2.project;

public class OakBridgeSchool {

	public static void main(String[] args) {
		
		int [] math = {88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
		int [] science = {80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
		int [] english = {90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
		
		String[] studentNames = {"Michelle", "Kate", "Ann", "Tina", "Tom", "Sam", "Ria", "Pam", "Leena", "Leo"};
		
		int [] rollNos = {102, 109, 101, 103, 104, 108, 110, 105, 106, 107};
		int noOfSubjects = 3;
		
		OakBridgeSchool oakBridgeSchool = new OakBridgeSchool();
		
		if (noOfSubjects > 0 && math.length > 0 && science.length > 0 && english.length > 0) {
			int [] totalMarks = oakBridgeSchool.calculateTotalMarks(math, science, english);
			
			if (totalMarks.length > 0) {
				int [] averageMarks = oakBridgeSchool.calculateTotalAverageMarksForEachStudent(totalMarks, noOfSubjects);
				

				System.out.println("----------------------------------------");
				System.out.println("Student Name :: " + studentNames[0] + " || " + "Roll Number :: " + rollNos[0]);
				System.out.println("----------------------------------------");
				System.out.println("The Total Marks - " + totalMarks[0] + "/300");
				System.out.println("The Average Marks - " + averageMarks[0]);
				System.out.println("");
				
				System.out.println("Average Science marks scored by the class is : " + oakBridgeSchool.calculateAverageScienceMarks(science, science.length));
				System.out.println("Average Math marks scored by the class is    : " + oakBridgeSchool.calculateAverageMathMarks(math, math.length));
				System.out.println("Average English marks scored by the class is : " + oakBridgeSchool.calculateAverageEnglishMarks(english, english.length));
				System.out.println("");
				
				char mathGrade = oakBridgeSchool.findGradeInMath(math[0]);
				char scienceGrade = oakBridgeSchool.findGradeInScience(science[0]);
				char englishGrade = oakBridgeSchool.findGradeInEnglish(english[0]);
				
				oakBridgeSchool.displayDetails(totalMarks[0], averageMarks[0], mathGrade, scienceGrade, englishGrade, studentNames[0], rollNos[0]);
				System.out.println("");
				
		        boolean checkIfNamesAreRepeated = oakBridgeSchool.checkIfNamesAreRepeated(studentNames);
		        if (checkIfNamesAreRepeated == false) {
		            System.out.println("Names are not repeated.");
		            
		            StringBuilder[] resultMessages = oakBridgeSchool.generateResultMesssage(studentNames, totalMarks);
		            for (StringBuilder message : resultMessages) {
		                System.out.println(message.toString());
		            }
		        }
		        
		        int [] totalMarksSorted = oakBridgeSchool.sortByTotalMarks(totalMarks);
		        System.out.println("++++++++++++++++++++++++++++++++++++++++");
		        System.out.println("Report");
		        System.out.println("++++++++++++++++++++++++++++++++++++++++");
		        for (int i = 0; i < studentNames.length; i++) {
		        	System.out.println(totalMarksSorted[i]);
		        }
		        
		        System.out.println("The top score is " + oakBridgeSchool.findTopScore(totalMarksSorted, totalMarksSorted.length));
			} else {
				System.out.println("Invalid input data: arrays are of different lengths.");
			}
		} else {
			System.out.println("No. of subjects are zero or input arrays are empty");
		}
	}

	public int[] calculateTotalMarks(int[] math, int[] science, int[] english) {
		
		if ((math.length != science.length) || (science.length != english.length) || (english.length != math.length)) {
			return new int[0];
		} else {
		    int[] total = new int[math.length];
		    for (int i = 0; i < math.length; i++) {
                if (math[i] < 0 || science[i] < 0 || english[i] < 0) {
                    return new int[0];
                }
		        total[i] = math[i] + science[i] + english[i];
		    }
		    return total;
		}
	}
    
	public int[] calculateTotalAverageMarksForEachStudent(int[] totalMarks, int noOfSubjects) {
		
	    if (noOfSubjects == 0 || totalMarks.length == 0) {
	        return new int[0];
	    }
		
	    int[] averageTotalMarks = new int[totalMarks.length];
	    for (int i = 0; i < totalMarks.length; i++) {
	        averageTotalMarks[i] = totalMarks[i] / noOfSubjects;
	    }
	    return averageTotalMarks;
	}
    
    public double calculateAverageScienceMarks(int[] science, int len) {
    	
    	if (len <= 0) {
    		return 0;
    	}
    	
        double sum = 0;
        for (int mark : science) {
            sum += mark;
        }
        return sum / len;
    }
    
    public double calculateAverageEnglishMarks(int[] english, int len) {
    	
    	if (len <= 0) {
    		return 0;
    	}
    	
        double sum = 0;
        for (int mark : english) {
            sum += mark;
        }
        return sum / len;
    }
    
    public double calculateAverageMathMarks(int[] math, int len) {
    	
    	if (len <= 0) {
    		return 0;
    	}
    	
        double sum = 0;
        for (int mark : math) {
            sum += mark;
        }
        return sum / len;
    }
    
    // Write the logic inside the method to calculate the grade based on the math mark of the student
    public char findGradeInMath(int math) { 
    	
    	if (math >= 90) {
    		return 'A';
    	} else if (math >= 80 && math <= 89) {
    		return 'B';
    	} else if (math >= 70 && math <= 79) {
    		return 'C';
    	} else if (math >= 60 && math <= 69) {
    		return 'D';
    	} else {
    		return 'F';
    	}
    }
    
    // Write the logic inside the method to calculate the grade based on the science mark of the student
    public char findGradeInScience(int science){

    	if (science >= 90) {
    		return 'A';
    	} else if (science >= 80 && science <= 89) {
    		return 'B';
    	} else if (science >= 70 && science <= 79) {
    		return 'C';
    	} else if (science >= 60 && science <= 69) {
    		return 'D';
    	} else {
    		return 'F';
    	}
    }
    
    // Write the logic inside the method to calculate the grade based on the english mark of the student
    public char findGradeInEnglish(int english){
        
    	if (english >= 90) {
    		return 'A';
    	} else if (english >= 80 && english <= 89) {
    		return 'B';
    	} else if (english >= 70 && english <= 79) {
    		return 'C';
    	} else if (english >= 60 && english <= 69) {
    		return 'D';
    	} else {
    		return 'F';
    	}
    }
    
    // Write the logic to sort the total marks of the students of the class in ascending order, use insertion-sort
    public int[] sortByTotalMarks(int[] totalMarks) {   
    	
    	for (int i = 1; i < totalMarks.length; i++) {
    		int key = totalMarks[i];
    		int j = i - 1;
    		while (j >= 0 && totalMarks[j] > key) {
    			totalMarks[j + 1] = totalMarks[j];
    			j = j - 1;
    		}
    		totalMarks[j + 1] = key;
    	}
    	
    	return totalMarks;
    }
    
    // Check if any of the studentNames in the array is repeated, if yes return true else false
    public boolean checkIfNamesAreRepeated(String[] studentNames) {
    	
        boolean repeat = false;
        
        for (int i = 0; i < studentNames.length; i++) {
            for (int j = 1 ; j < studentNames.length; j++) {
                if (i == j) {
                    break;
                } else {
                    if (studentNames[i].equals(studentNames[j])) {
                        repeat = true;
                    }
                }
            }
        }
        
        return repeat;
    	
    }
    
    //write the logic to find the top score using recursion
    public int findTopScore(int [] totalMarks,int len) {
        
    	if (len == 1) {
    		return totalMarks[0];
    	}
    	
    	int maxOfRest = findTopScore(totalMarks, len - 1);
    	
    	if (totalMarks[len - 1] > maxOfRest) {
    		return totalMarks[len - 1];
    	} else {
    		return maxOfRest;
    	}
    }
    
    //Display the details of the student
    public void displayDetails(int totalMark, int averageMark, char mathGrade, char scienceGrade, char englishGrade,String studentName, int rollNo ){ 
    	
    	System.out.println("++++++++++++++++++++++++++++++++++++++++");
    	System.out.println("Grading And Evaluation");
    	System.out.println("++++++++++++++++++++++++++++++++++++++++");
    	System.out.println("----------------------------------------");
    	System.out.println("Student Name              Roll Number");
    	System.out.println("----------------------------------------");
    	System.out.println(studentName + "                      " + rollNo);
    	System.out.println("The total marks scored   : " + totalMark);
    	System.out.println("The average marks scored : " + averageMark);
    	System.out.println("----------------------------------------");
    	System.out.println(" ");
    	System.out.println("Grade in Math    : " + mathGrade);
    	System.out.println("Grade in Science : " + scienceGrade);
    	System.out.println("Grade in English : " + englishGrade);
    	System.out.println("----------------------------------------");
    	
    }

    //write the logic to generate the result message using name and score
    public StringBuilder[] generateResultMesssage(String[] studentNames, int[] totalScores) {
        StringBuilder[] resultMessages = new StringBuilder[studentNames.length];
        for (int i = 0; i < studentNames.length; i++) {
            resultMessages[i] = new StringBuilder("Hi " + studentNames[i] + " you have secured " + totalScores[i]);
        }
        return resultMessages;
    }
}
