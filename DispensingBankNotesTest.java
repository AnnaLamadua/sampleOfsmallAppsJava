import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DispensingBankNotesTest {
	
	@Before
	public void setUp() throws Exception {
		DispensingBankNotes.initBank();
	}
	
	@Test
	public void getBankNoteList() {
		Result r = DispensingBankNotes.getBankNoteList( 39805 );
		List<BankNote> banks = r.getLstBankNote();
		
		assertEquals( 1000, banks.get(0).getBank());
		assertEquals( 39, banks.get(0).getAmt());
		
		assertEquals( 500, banks.get(1).getBank());
		assertEquals( 1, banks.get(1).getAmt());
		
		assertEquals( 100, banks.get(2).getBank());
		assertEquals( 3, banks.get(2).getAmt());
		
		assertEquals( 5, (int) r.getAmount());

		Result r2 = DispensingBankNotes.getBankNoteList( 1280 );
		List<BankNote> banks2 = r2.getLstBankNote();
		
		assertEquals( 1000, banks2.get(0).getBank());
		assertEquals( 1, banks2.get(0).getAmt());
		
		assertEquals( 100, banks2.get(1).getBank());
		assertEquals( 2, banks2.get(1).getAmt());
		
		assertEquals( 50, banks2.get(2).getBank());
		assertEquals( 1, banks2.get(2).getAmt());
		
		assertEquals( 20, banks2.get(3).getBank());
		assertEquals( 1, banks2.get(3).getAmt());
		
		assertEquals( 10, (int)r2.getAmount());
	}

}
