import java.util.List;

public class Result {
	
	private List<BankNote> lstBankNote;
	private String errComment;
	private double amount;
	
	public List<BankNote> getLstBankNote() {
		return lstBankNote;
	}
	public void setLstBankNote(List<BankNote> lstBankNote) {
		this.lstBankNote = lstBankNote;
	}
	public String getErrComment() {
		return errComment;
	}
	public void setErrComment(String errComment) {
		this.errComment = errComment;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
