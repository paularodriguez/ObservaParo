package utils;


public class UpdateDocuments {
	
	public static long lastUpdated;
	
	public static void checkDocumentAge() {
		//About 15 days
		long updatedTime = 1296000000;	
		
		if ( (System.currentTimeMillis() - lastUpdated) > updatedTime) {
			//Update documents
			lastUpdated = System.currentTimeMillis();
			URLLoader.downloader();
		}
	}
	
}
