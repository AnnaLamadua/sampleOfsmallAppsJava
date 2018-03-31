
public class BankNote {
	
	private int bank;   //support ฿ 20, ฿ 50, ฿ 100, ฿ 500, ฿ 1000 notes.
	private int amt;

	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public BankNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankNote(int bank, int amt) {
		super();
		this.bank = bank;
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "BankNote [bank=" + bank + ", amt=" + amt + "]";
	}	
	
}
