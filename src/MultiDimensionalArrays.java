/*
 * Created by: Phoebe Vermithrax
 * Created on: 26-Feb-2018
 * Created for: ICS4U
 * Daily Assignment – Day #12
 * This program generates random numbers to populate a multi-dimensional array to calculate the total average.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

//import the random class.
import java.util.Random;
import org.eclipse.swt.widgets.Label;

public class MultiDimensionalArrays {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MultiDimensionalArrays window = new MultiDimensionalArrays();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//Create a function to calculate the average of the class, which takes a multi-dimensional array.
	public int CalculateAverage(int[] []tmpArrayOfIntegers)
	{
		//Set the variables for the counter for both rows, the random number, the sum, and the total.
		int countOne;
		int countTwo;
		int sum = 0;
		int total = 0;
		int randomNumber;
		final int MAX_RANDOM_NUMBER = 99;
		final int MIN_NUMBER = 1;
		
		//Generate a random number, and state the min and the max. [start + (end - start) * .nextDouble()] This is for
		//doubles.
		//Random randomNumberGenerator = new Random();
		//randomNumber = MIN_NUMBER + (MAX_RANDOM_NUMBER - MIN_NUMBER) * randomNumberGenerator.nextDouble();
		randomNumber = ((int) (Math.random() * MAX_RANDOM_NUMBER)) + MIN_NUMBER;
		
		//Use a nested for loop to populate the array.
		for (countOne = 0; countOne < tmpArrayOfIntegers.length; countOne++)
		{
			
			for (countTwo = 0; countTwo < tmpArrayOfIntegers[countOne].length; countTwo++)
			{
				//Assign the random number to the counter in the array.
				tmpArrayOfIntegers[countOne][countTwo] = randomNumber;
			}
		}
		
		//Use a nested for loop to get the sum.
		for (countOne = 0; countOne < tmpArrayOfIntegers.length; countOne++)
		{
			for (countTwo = 0; countTwo < tmpArrayOfIntegers.length; countTwo++)
			{
				sum += tmpArrayOfIntegers[countOne][countTwo];
			}
		}
		
		//Calculate the average.
		total = sum / tmpArrayOfIntegers.length;
		
		//Return the value.
		return total;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Multi-Dimensional Arrays");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(167, 152, 55, 15);
		lblNewLabel.setText("New Label");
		//Make invisible.
		lblNewLabel.setVisible(false);
		
		Button btnCalculate = new Button(shell, SWT.NONE);
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Set variable that'll store the average.
				int average;
				
				//Create a multi-dimensional array of 4x6.
				int[] []studentGrades = new int[4][6];
				
				//Call the function, CalculateAverage.
				average = CalculateAverage(studentGrades);
				
				//Display it into the label.
				lblNewLabel.setVisible(true);
				lblNewLabel.setText("" + average);
				
			}
		});
		btnCalculate.setBounds(116, 61, 182, 25);
		btnCalculate.setText("Calculate");
		
		Label lblClickTheButton = new Label(shell, SWT.NONE);
		lblClickTheButton.setBounds(49, 39, 323, 15);
		lblClickTheButton.setText("Click the button to populate an array and get the average.");
		
		Label lblTheAverageIs = new Label(shell, SWT.NONE);
		lblTheAverageIs.setBounds(49, 152, 88, 15);
		lblTheAverageIs.setText("The average is:");
		


	}
}
