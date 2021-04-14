import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Assumption 1: CSV column order is same as in the document
 * Assumption 2: Separating enrolls by insurance company is grouping the insurance company records
 * 
 */
public class EnrollSolution {
	
	static List<Enroll> enrollList = new ArrayList<>();
	
	public static void main(String args[]) {
		System.out.println("Enter the full path with filename: \n");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Path filePath = Paths.get(input);
		String line;
		EnrollSolution enrollSol = new EnrollSolution();
		try (BufferedReader br = Files.newBufferedReader(filePath)) {
			while((line=br.readLine()) != null) {
				String cols[] = line.split(",");
				if(cols.length > 0) 
					enrollSol.addOrUpdate(cols);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		enrollList = enrollList.stream()
				// Separating based on insurance 
			.sorted(Comparator.comparing(Enroll::getInsurance)
				// Sorting based on Last Name and First name
				.thenComparing(Enroll::getLastName)
				.thenComparing(Enroll::getFirstName))
			.collect(Collectors.toList());
		try (BufferedWriter bw = Files.newBufferedWriter(filePath,StandardOpenOption.CREATE)){
			
			for(Enroll e: enrollList) {
				bw.write(e.getUserId()+","+
						e.getFirstName()+","+
						e.getLastName()+","+
						e.getVersion()+","+
						e.getInsurance()+"\n");
			}
			
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Enroll createObj(String cols[]) {
		Enroll e = new Enroll(cols[0], cols[1], cols[2], Integer.parseInt(cols[3]), cols[4]);
		return e;
	}
	
	void addOrUpdate(String cols[]) {
		
		// Checks if user id present 
		// and checks if the existing userid belongs to same insurance company
		// and checks if the existing version is less than the new version
		enrollList.stream()
		.filter(
			o -> o.getUserId().equalsIgnoreCase(cols[0])
			&& o.getInsurance().equalsIgnoreCase(cols[4])
			&& o.getVersion() <= Integer.parseInt(cols[3]))
		.findAny()
		.ifPresentOrElse(
			e -> {
				e.setFirstName(cols[1]);
				e.setLastName(cols[2]);
				e.setVersion(Integer.parseInt(cols[3]));
			},
			() -> {
				Enroll enroll = createObj(cols);
				enrollList.add(enroll);
			});
	}
}