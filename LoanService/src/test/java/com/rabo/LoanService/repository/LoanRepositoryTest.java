package com.rabo.LoanService.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rabo.LoanService.model.Loan;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class LoanRepositoryTest {

	@Autowired
	private LoanRepository rep;

	private Loan loan;

	@BeforeEach
	public void setUp() throws Exception {

		
		loan = new Loan();
		loan.setLoanNo(111);
		loan.setLoanAmount(500000);
		loan.setLoanType("Personal Loan");
		loan.setLoanTerm("2 years");
		loan.setLoanHandlingFees(2500);
		loan.setOriginationAccount(100012345);
		loan.setOriginationDate();
		loan.setApplicantBusinessAddress("perundurai,Erode Dt");
		loan.setApplicantBusinesscontact(232561);
		loan.setApplicantBusinessEmail("teggig@gmail.com");
		loan.setApplicantBusinessName("Paper Products");
		loan.setApplicantBusinessOwnership(100);
		loan.setTAN("TAN909090");
		loan.setPAN("PAN7890");
		loan.setCibilScore(700);
		loan.setPropertyAddress("Perundurai, Erode");
		loan.setPropertySize("2 acer");
		loan.setPropertyName("company");
		loan.setStatus("Requested");
		loan.setUserId("JUMAN");

	}

	@AfterEach
	public void tearDown() throws Exception {
		rep.deleteAll();
	}

	 @Test
	    public void createLoanTest() {

	    	rep.save(loan);
	    	Loan floan = rep.findById(loan.getLoanNo()).get();
	        assertThat(111, is(floan.getLoanNo()));

	    }

	    @Test
	    public void deleteLoantest() {

	    	rep.save(loan);
	    	Loan aloan = rep.findById(loan.getLoanNo()).get();
	        assertThat(111, is(aloan.getLoanAmount()));
	        rep.delete(aloan);

	    }

	    @Test
	    public void updateNewssourceTest() {

	    	rep.save(loan);
	    	Loan floan = rep.findById(loan.getLoanNo()).get();
	        assertThat(111, is(floan.getLoanNo()));
	        floan.setCibilScore(500);
	        rep.save(floan);
	        floan = rep.findById(loan.getLoanNo()).get();
	        assertThat(500, is(floan.getCibilScore()));


	    }

	    @Test
	    public void getNewssourceByIdTest() {

	    	rep.save(loan);
	    	Loan floan = rep.findById(loan.getLoanNo()).get();
	        assertThat(111, is(floan.getLoanNo()));
	    }

	    @Test
	    public void getAllNewssourceByUserId() {

	    	rep.save(loan);
	    	loan.setLoanNo(112);
	    	loan.setLoanAmount(200000);
	    	loan.setLoanHandlingFees(1400);
	    	loan.setLoanTerm("1 year");
	    	loan.setLoanType("Personal Loan");
	    	rep.save(loan);
	    	List<Loan> loans = rep.findAll();
	        assertThat(loans.size(), is(2));


	    }
}