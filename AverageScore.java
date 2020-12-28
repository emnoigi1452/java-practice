import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static double parseAverage(List<Double> h1, List<Double> h2, List<Double> h3) {
		double total = 0; int base = h1.size() + (h2.size() * 2) + (h3.size() * 3);
		for(Double i: h1) total += i;
		for(Double j: h2) total += j*2;
		for(Double k: h3) total += k*3;
		return total / base;
	}
	public static double parsePoints(String param) {
		boolean parse = true;
		try {
			Double.parseDouble(param);
		} catch(NumberFormatException e) {
			parse = false;
		}
		double value = -1;
		if(parse) {
			value = Double.parseDouble(param);
		} else return -1;
		if(value > 10) value = -1;
		return value;
	}
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in); String in = ""; String out = "";
		System.out.print("Tên file nhập điểm (hoặc path): "); in = read.nextLine();
		System.out.print("Tên file in điểm (hoặc path): "); out = read.nextLine(); System.out.println("");
		File input = new File(in); File output = new File(out); int generateActions = 0;
		if(!(input.exists())) {
			try {
				System.out.println("File nhập điểm không tồn tại! Đang tạo file mới...");
				input.createNewFile(); generateActions++;
				System.out.println("Đã tạo tập tin thành công!");
			} catch(IOException e) {
				System.out.println("Đã xảy ra lỗi!");
				e.printStackTrace();
			}
		}
		if(!(output.exists())) {
			try {
				System.out.println("File in điểm không tồn tại! Đang tạo file mới...");
				output.createNewFile(); generateActions++;
				System.out.println("Đã tạo tập tin thành công!");
			} catch(IOException e) {
				System.out.println("Đã xảy ra lỗi!");
				e.printStackTrace();
			}
		}
		if(generateActions > 0) {
			System.out.println("Hệ thống sẽ khởi động lại để kết nối với các file...");
			System.exit(-1);
		} else {
			System.out.println("Đã kết nối tất cả file, bắt đầu tính điểm...");
		}
		int invalidChecks = 0;
		try {
			Scanner sc = new Scanner(input);
			PrintWriter wr = new PrintWriter(output);
			List<Double> base1 = new ArrayList<Double>();
			List<Double> base2 = new ArrayList<Double>();
			List<Double> base3 = new ArrayList<Double>();
			while(sc.hasNextLine()) {
				String str = sc.nextLine();
				if(str.indexOf("<miệng>") != -1) {
					String[] param = str.replace("<miệng>", "").trim().split(";");
					for(String s: param) {
						double p = parsePoints(s);
						if(p == -1) invalidChecks++;
						else base1.add(p);
					}
				} else if(str.indexOf("<15p>") != -1) {
					String[] param = str.replace("<15p>", "").trim().split(";");
					for(String s2: param) {
						double p2 = parsePoints(s2);
						if(p2 == -1) invalidChecks++;
						else base1.add(p2);
					}
				} else if(str.indexOf("<45p>") != -1) {
					String[] param = str.replace("<45p>", "").trim().split(";");
					for(String s3: param) {
						double p3 = parsePoints(s3);
						if(p3 == -1) invalidChecks++;
						else base2.add(p3);
					}
				} else if(str.indexOf("<giữa kì>") != -1) {
					String[] param = str.replace("<giữa kì>", "").trim().split(";");
					for(String s4: param) {
						double p4 = parsePoints(s4);
						if(p4 == -1) invalidChecks++;
						else base2.add(p4);
					}
				} else if(str.indexOf("cuối kì") != -1) {
					String[] param = str.replace("<cuối kì>", "").trim().split(";");
					for(String s5: param) {
						double p5 = parsePoints(s5);
						if(p5 == -1) invalidChecks++;
						else base3.add(p5);
					}
				} else {
					wr.println("Flag không hợp lệ!");
				}
			}
			double diemtb = parseAverage(base1, base2, base3);
			wr.print("Điểm trung bình: "); wr.format("%.1f%n", diemtb); wr.println("");
			wr.flush(); wr.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Đã hoàn thành tính toán! Xem kết quả trong tập tin " + output.getName());
		if(invalidChecks > 0) System.out.println("Đã phát hiện " + invalidChecks + " điểm không hợp lệ!"); 
		System.out.print("Code bởi Đức Hải Cẽo :') Chào nhé :3");
	}
}
