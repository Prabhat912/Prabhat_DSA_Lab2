package paymoney.determinator.com;

import java.util.Scanner;

public class PayMoneyTargetDeterminator {
	
	//transaction list
	
	//scanner for input
	
	//constructor - initialize the scanner

	Integer[] transactionsList;
	
	Integer dailyTarget;
	
	Scanner input;
	
	public PayMoneyTargetDeterminator() {
		
		input = new Scanner(System.in);
	}
	
	/* Adding a scanner class for asking for the 
	 * size of transaction and each transaction value
	 *
	 */

	private void collectTransactionList() {
		
		System.out.println("Transactions list : ");
		
		System.out.println("Enter the size of the transactions list: ");
		Integer transactionListSize = input.nextInt();
		
		transactionsList = new Integer[transactionListSize];
		
		for (int index = 0; index < transactionListSize; index++) {
			// 1 / 5
			System.out.printf("Enter the transaction value : %d / %d ",
					(index + 1), transactionListSize);
			System.out.println();
			
			transactionsList[index] = input.nextInt();
	
		}
		
	}
	
	//method for collecting daily target - input
	
	private void collectDailyTarget() {
		
		System.out.println("Enter the value for daily target : ");
		dailyTarget = input.nextInt();
	}
	
	
	
	void determineTarget() {
		
		int currentSumOfTransactionValues = 0;
		
		boolean dailyTargetAchievedFlag = false;
		

		int counter = 0;
		

		
		for (int index = 0; index < transactionsList.length; index++) {

			counter++; 

			int transactionValue = transactionsList[index];
			

			currentSumOfTransactionValues = currentSumOfTransactionValues + transactionValue;
			
			
			if(currentSumOfTransactionValues >= dailyTarget) {
				
				dailyTargetAchievedFlag = true;
				break;
			}
			
		}
		
/*
 * Checking if target achieved or not 
 */
		
		if(dailyTargetAchievedFlag) {
			
			System.out.printf("Daily target of %d achieved after %d transactions",
					dailyTarget, counter);
			System.out.println();
			
		} else {
			
			System.out.printf("Daily target of %d not achieved", dailyTarget);
			System.out.println();
		}
		
	}
	
	public void determine() {
			
			collectTransactionList();
			
			collectDailyTarget();
			
			determineTarget();
			
		}

}
