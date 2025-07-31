import java.util.LinkedList;
import java.util.Queue;

public class JobScheduler {
		 Queue<String> jobDocument=new LinkedList<>();
		 void add(String c) {
			jobDocument.add(c);
			System.out.println("Document is added");
		}
	 void remove() {
			jobDocument.poll();
			System.out.println("Document is removed");
			
		}
	public static void main(String[] args) {
		JobScheduler documents=new JobScheduler();
		documents.add("shyam");
		documents.add("balaram");
		documents.add("akbar");
		documents.add("hemanth");
		documents.add("sai");
		documents.remove();
		documents.remove();
	
		System.out.println("The remaining documents are "+documents.jobDocument);
}
}
