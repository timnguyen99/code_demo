package com.medfusion.interview.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.medfusion.interview.data.DocumentReference;
import com.medfusion.interview.service.ProviderService;

public class ClientService {

	private static String DOCUMENT_TYPE;
	private static String DOCUMENT_PERIOD_BEFORE;
	private static String DOCUMENT_PERIOD_AFTER;

	public ProviderService providerService;

	private HashMap<String, String> searchParams;

	public ClientService() {
		DOCUMENT_TYPE = "type";
		DOCUMENT_PERIOD_BEFORE = "periodBefore";
		DOCUMENT_PERIOD_AFTER = "periodAfter";
	}


	/**
	 * <p>
	 * Gets the Id of the most recent CCD Document.
	 * </p>
	 * 
	 * @return The id of the most recent CCD Document or null.
	 * @throws Exception
	 *             When there is a problem.
	 */
	public String getCurrentCcdDocumentId(){

		searchParams = new HashMap<String, String>();
		searchParams.put(DOCUMENT_TYPE, "CCD");

		List<DocumentReference> results = providerService.search(searchParams);
		
		System.out.print("here...");
		Date current = null;
		DocumentReference dr = null;
		SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
		Date dd;
		
		for(DocumentReference d: results) {
			if(d.getType() == "CCD") {
				try {
					dd = df.parse(d.getCreated());
					if (current == null || dd.getTime() >= current.getTime()) {
						current = dd;
						dr = d;
					}
				} catch (ParseException e) {
					System.out.println(e.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		System.out.print("here...");
		String documentId = null;
		if(dr!= null) {
			LoggerFactory.getLogger(this.getClass().getName()).info("Document type is CCD.", dr.getType());
			documentId = dr.getId();
			LoggerFactory.getLogger(this.getClass().getName()).debug("Found the document {}", documentId);
		} else {
			LoggerFactory.getLogger(this.getClass().getName()).debug("The document was not found.");
		}
		
		return documentId;
	}

	/**
	 * <p>
	 * Gets the number of CCD Documents.
	 * </p>
	 * 
	 * @return
	 */
	public long getCcdDocumentCount() {

		searchParams = new HashMap<String, String>();
		searchParams.put(DOCUMENT_TYPE, "CCD");

		List<DocumentReference> results = providerService.search(searchParams);
		
		int count = 0;
		for(DocumentReference d: results) {
			if(d.getType() == "CCD") {
				count++;
			}
		}

		return count;

	}

	public ProviderService getProviderService() {
		return this.providerService;
	}

	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}

}
