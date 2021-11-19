package com.cg.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.net.URL;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.cg.wallet.dao.WalletDao;
import com.cg.wallet.dto.Wallet;
import com.cg.wallet.dto.WalletTransfer;
import com.cg.wallet.exception.FundTransferException;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.WalletService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EWallet1ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	/*
	 * @Test void contextLoads() { }
	 */

	@Autowired
	private WalletService walletService;

	@Autowired
	private WalletDao walletDao;

	private Wallet wallet = new Wallet(5, "TestName", 5000.00D);
	private WalletTransfer wallettransfer = new WalletTransfer(1, 2, 15000.0);


	@Mock
	static WalletDao walletDaoMock;

	@InjectMocks
	static private WalletService WalletServiceMock;

	/*
	 * @Before(value = "") static public void setUp() { // loginController = new
	 * LoginController(); MockitoAnnotations.initMocks(WalletServiceMock); }
	 */

	@Test
	public void assertTwoMethodsHaveBeenCalled() {

		Mockito.when(WalletServiceMock.createWallet(wallet)).thenReturn(wallet);

		Wallet wallet = WalletServiceMock.createWallet(this.wallet);

		assertEquals(1, wallet.getId());
		Mockito.verify(WalletServiceMock).createWallet(wallet);

	}

	
	@BeforeAll
	static public void beforeAllTest() {

	}

	@AfterAll
	static public void afterAllTest() {

	}

	@BeforeEach
	public void beforeEachTest() {

	}

	@AfterEach
	public void afterEachTest() {

	}

	@Test
	void getHello() throws Exception {

		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/").toString(), String.class);
		assertEquals("Hello Controller", response.getBody());

	}

	@Test
	void createWalletTest() {
		// TODO Auto-generated method stub
		// System.out.println("Test");
		assertEquals(this.wallet.getId(), walletService.createWallet(this.wallet).getId());
	}

	@Test
	void transferFundTest() throws WalletException {
		// TODO Auto-generated method stub
		// assumeTrue(false);
		try {
			assertTrue(walletService.transferFund(wallettransfer));
		} catch (FundTransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void transferFundTest1() {
		// TODO Auto-generated method stub
		wallettransfer.setFund(-100.D);
		assertThrows(WalletException.class, () -> walletService.transferFund(wallettransfer));

	}

	@Test
	void transferFundTest2() {
		// TODO Auto-generated method stub
		// wallettransfer.setFund(-100.D);
		assertThrows(WalletException.class, () -> walletService.transferFund(wallettransfer));

	}

	@Test
	void getWalletTest() {
		// TODO Auto-generated method stub
	}

	@Test
	void updateBalanceTest() {
		// TODO Auto-generated method stub
		Object object = null;
		// assertNull(object);
	}

	@Test
	void deleteWalletTest() {
		// TODO Auto-generated method stub

	}

}
