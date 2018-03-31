import java.text.DecimalFormat;
import java.util.*;

public class DispensingBankNotes {
	private static Scanner input = new Scanner(System.in);
	
	private static List<BankNote> lstBankNote;
	private static double currentBal;
	private static DecimalFormat numberFormat;
	
	public static void initBank() {
		lstBankNote = new ArrayList<BankNote>();
		BankNote bank = new BankNote(1000, 200); // Value order by descending
		lstBankNote.add(bank);
		bank = new BankNote(500, 200);
		lstBankNote.add(bank);
		bank = new BankNote(100, 500);
		lstBankNote.add(bank);
		bank = new BankNote(50, 200);
		lstBankNote.add(bank);
		bank = new BankNote(20, 1000);
		lstBankNote.add(bank);
		
		currentBal = getAllBalance();
	}
	
	public static Result getBankNoteList( double amt ) {
		List<BankNote> lstBanks = new ArrayList<BankNote>();
		BankNote obj;
		for (int i=0; i < lstBankNote.size(); i++)
		{
			int quantity = (int) (amt / lstBankNote.get(i).getBank()); // quantity to pay
			if ( quantity == 0 || quantity > lstBankNote.get(i).getAmt() ) // if this bank need this money more than in our ATM. 
			{
				continue; // go to next bank
			}
			else  // enough to pay
			{    
				obj = new BankNote();
				obj.setAmt( quantity );
				obj.setBank( lstBankNote.get(i).getBank() );
				lstBanks.add( obj );          // save to result
				
				lstBankNote.get(i).setAmt( lstBankNote.get(i).getAmt() - quantity );  // how many we pay, erase it.
				amt = amt % lstBankNote.get(i).getBank();
			}
		}
		Result r = new Result();
		r.setLstBankNote( lstBanks );
		if ( amt > 0) 
		{
			r.setErrComment("Can't pay this amount "+amt);
			r.setAmount( amt );
		}
		return r;
	}
	
	public static void main(String[] args) {
        int menu = 0;
        double withdrawAmt = 0;
        numberFormat = new DecimalFormat("#,###.00");
        initBank();

        while (menu != 3)
        { 
            menu = menu();
            switch (menu)
            {
            case 1:
                displayAllBalance();
                break;
            case 2:
                System.out.print("\nEnter Amount to Withdrawl: ");
                withdrawAmt = input.nextDouble();

                while( withdrawAmt <= 0 || withdrawAmt > currentBal )
                {
                    System.out.print("Error Amount!! " + "Please enter a different amount : ");
                    withdrawAmt = input.nextDouble();
                }
                
                Result r = getBankNoteList( withdrawAmt );
                displayResult( r );
                currentBal = withdraw( currentBal, withdrawAmt - r.getAmount() );
                break;
            case 3:
                System.out.print("\nLog Out, Thank you.");
                System.exit(0);
                break;
            }
        }

	}
	
	public static int menu()
    {
        int menuChoice;
        do
        { 
            System.out.print("\nPlease select menu:"
                    + "\n 1. Display All BankNote Balance "
                    + "\n 2. Withdraw"
                    + "\n 3. Log Out\n\n");

            menuChoice = input.nextInt();

            if (menuChoice < 1 || menuChoice > 3){
                System.out.println("error");
            }

        }while (menuChoice < 1 || menuChoice > 3);

        return menuChoice;
    }
	
	public static void displayBalance(List<BankNote> result)
    {
		for (BankNote b: result)
		{
			if ( b.getAmt() > 0 )
			{
				System.out.println(b.getBank()+" has " + b.getAmt());
			}
		}
    }
	
	public static void displayResult(Result result)
	{
		displayBalance( result.getLstBankNote() );
		if ( result.getAmount() > 0 )
		{
			System.out.println( result.getErrComment() );
		}
	}
	
	public static void displayAllBalance()
    {
		displayBalance( lstBankNote );
		System.out.println("All Balance is "+numberFormat.format( getAllBalance() )+" Baht");
    }
	
	public static double getAllBalance()
	{
		double amt = 0.0;
		for (BankNote b: lstBankNote)
		{
			amt += (b.getBank() * b.getAmt());
		}
		return amt;
	}

    public static double withdraw(double currentBal, double withdrawAmt)
    {
        double newBalance = currentBal - withdrawAmt;
        System.out.println("Your New Balance is "+numberFormat.format( newBalance ) +" Baht");

        return newBalance;  
    }

}
