package com.medfusion.interview.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.medfusion.interview.data.DocumentReference;
import com.medfusion.interview.service.ProviderService;

public class ClientServiceTest {

	private ClientService cs;
	private DocumentReference dr;
	private ProviderService ps;
	private List<DocumentReference> drList;
	private List<DocumentReference> nonCcdDrList;
		
	public ClientServiceTest() {
		drList = new ArrayList<DocumentReference>();
		dr = new DocumentReference("1234", "CCD", "Mar 01, 2021");
		drList.add(dr);
		
		dr = new DocumentReference("1233", "CCD", "Mar 02, 2021");
		drList.add(dr);
		
		dr = new DocumentReference("1235", "CCDS", "Mar 03, 2021");
		drList.add(dr);
		
		nonCcdDrList = new ArrayList<DocumentReference>();
		dr = new DocumentReference("1234", "CCDS", "Mar 01, 2021");
		nonCcdDrList.add(dr);
		
		dr = new DocumentReference("1233", "CCDS", "Mar 02, 2021");
		nonCcdDrList.add(dr);
		
		dr = new DocumentReference("1235", "CCDS", "Mar 03, 2021");
		nonCcdDrList.add(dr);
	}
	
	@Test
	public void testGetCurrentCcdDocumentId() throws Exception {
		
		ps = new ProviderService() {
			@Override
			public List<DocumentReference> search(Map<String, String> searchParams) {
				return drList;
			}
		};
		cs = new ClientService();
		cs.setProviderService(ps);
		String currentCcdDocumentId = cs.getCurrentCcdDocumentId();
		assertNotNull(currentCcdDocumentId);
		assertEquals(currentCcdDocumentId, "1233");
		// Empty Array List
		ps = new ProviderService() {
			@Override
			public List<DocumentReference> search(Map<String, String> searchParams) {
				return new ArrayList<>();
			}
		};
		cs = new ClientService();
		cs.setProviderService(ps);
		currentCcdDocumentId = cs.getCurrentCcdDocumentId();
		assertNull(currentCcdDocumentId);
	}
	
	// Non CCD List
	@Test
	public void testNullGetCurrentCcdDocumentId() throws Exception {
				
		ps = new ProviderService() {
			@Override
			public List<DocumentReference> search(Map<String, String> searchParams) {
				return nonCcdDrList;
			}
		};
		cs = new ClientService();
		cs.setProviderService(ps);
		String currentCcdDocumentId = cs.getCurrentCcdDocumentId();
		assertNull(currentCcdDocumentId);
	}
	
	@Test
	public void testGetCcdDocumentCount() {
		
		ps = new ProviderService() {
			@Override
			public List<DocumentReference> search(Map<String, String> searchParams) {
				return drList;
			}
		};
		
		cs = new ClientService();
		cs.setProviderService(ps);
		long count = cs.getCcdDocumentCount();
		
		assertEquals(count, 2);
		// Empty Array List
		ps = new ProviderService() {
			@Override
			public List<DocumentReference> search(Map<String, String> searchParams) {
				return new ArrayList<>();
			}
		};
		cs = new ClientService();
		cs.setProviderService(ps);
		count = cs.getCcdDocumentCount();
		
		assertEquals(count, 0);

		
	}
	
	// Non CCD List
	@Test
	public void testEmptyGetCcdDocumentCount() {
		
		ps = new ProviderService() {
			@Override
			public List<DocumentReference> search(Map<String, String> searchParams) {
				return nonCcdDrList;
			}
		};
		
		cs = new ClientService();
		cs.setProviderService(ps);
		long count = cs.getCcdDocumentCount();
		
		assertEquals(count, 0);
		
	}
}
