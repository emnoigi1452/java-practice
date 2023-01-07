package me.stella.Excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Main {
	
	public static final int[] count = new int[] {-1, 44, 42, 43, 40, 44, 44, 44, 44, 44, 44, 43, 44, 44, 44, 43};
	
	public static void main(String[] args) throws Exception {
		NumberFormat formatter = buildFormatter(3);
		File sheet = new File("so_diem_tong_ket_khoi_khoi_11.xls");
		if(!(sheet.exists()))
			throw new IllegalArgumentException("No sheet found!");
		HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(sheet));
		System.out.println("Đang tiếp nhận thông tin từ file Excel... Chờ tí :3");
		File output = new File("output.txt");
		if(!(output.exists())) {
			output.createNewFile();
			importData(output, book, formatter);
		}
		List<String> lines = Files.readAllLines(output.toPath());
		List<EntryHandle> students = new ArrayList<EntryHandle>();
		Map<String, List<EntryHandle>> classTable = new HashMap<String, List<EntryHandle>>();
		Map<String, EntryHandle> ref = new HashMap<String, EntryHandle>();
		lines.stream().forEach(line -> {
			try {
				EntryHandle handle = EntryHandle.parseHandle(line, formatter);
				students.add(handle);
				ref.put(handle.getInfo(), handle);
				if(!(classTable.containsKey(handle.getClassroom())))
					classTable.put(handle.getClassroom(), new ArrayList<EntryHandle>());
				classTable.get(handle.getClassroom()).add(handle);
			} catch(Exception e) { e.printStackTrace(); }
		});
		Map<Integer, List<EntryHandle>> rank = sortHashMap(students);
		System.out.println("Hoàn tất xếp hạng cho " + students.size() + " học sinh!");
		System.out.println("------------------------");
		Scanner client = new Scanner(System.in);
		main: while(true) {
			System.out.print("Nhập tên người muốn xem hạng (Bấm quit để hủy): ");
			String o = client.nextLine();
			if(o.equalsIgnoreCase("quit"))
				break;
			System.out.print("Nhập tên lớp: ");
			String c = client.nextLine();
			EntryHandle reference = ref.getOrDefault(o + ";" + c, null);
			if(reference == null)
				System.out.println("Người này không có tên trong danh sách :/");
			else {
				String format = "#{rank} - {name} - {grade} - Cùng hạng với {share} người!";
				for(Integer i: rank.keySet()) {
					if(rank.get(i).contains(reference)) {
						System.out.println(format.replace("{rank}", String.valueOf(i))
								.replace("{name}", reference.getName())
								.replace("{grade}", formatter.format(reference.getGrade()))
								.replace("{share}", String.valueOf(rank.get(i).size()-1)));
						System.out.println("------------------------");
						continue main;
					}
				}
				System.out.println("Lạ ta, không thấy bạn đâu cả :<");
			}
			System.out.println("------------------------");
		}
		client.close();
		System.out.println("Thanks for using :3 - Coded by Đức Hải Cẽo.");
	}
	public static void importData(File file, HSSFWorkbook ss, NumberFormat numFormat) throws IOException {
		String sheetNameFormat = "11a{id}";
		String dataEncode = "{name};{class};{grade}";
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(int i = 1; i <= 15; i++) {
			String className = sheetNameFormat.replace("{id}", parseID(i));
			HSSFSheet classSheet = ss.getSheet(className);
			for(int x = 7; x < (7+count[i]); x++) {
				HSSFRow row = classSheet.getRow(x);
				String name = row.getCell(2).getStringCellValue();
				double grade = 0.0D;
				for(int o = 4; o < (4+12); o++)
					grade += row.getCell(o).getNumericCellValue();
				grade = grade / 12;
				writer.write(dataEncode.replace("{name}", name).replace("{class}", className).replace("{grade}", numFormat.format(grade)).concat("\n"));
			}
			System.out.println("Complete importing data for class " + className); writer.flush();	
		}
		writer.flush(); writer.close();
	}
	
	public static Map<Integer, List<EntryHandle>> sortHashMap(List<EntryHandle> handles) {
		Map<Integer, List<EntryHandle>> comp = new LinkedHashMap<Integer, List<EntryHandle>>();
		double pm = 10.0D; int r = 0;
		handles.sort(new Comparator<EntryHandle>() {
			@Override
			public int compare(EntryHandle o1, EntryHandle o2) {
				return (Double.valueOf(o1.getGrade()).compareTo(Double.valueOf(o2.getGrade())));
			}
		}); Collections.reverse(handles);
		for(EntryHandle e: handles) {
			if(e.getGrade() < pm) {
				pm = e.getGrade();
				r++;
				comp.put(r, new ArrayList<EntryHandle>());
			}
			comp.get(r).add(e);
		}
		return comp;
	}
	
	public static String parseID(int x) {
		if(x >= 10)
			return String.valueOf(x);
		return "0" + String.valueOf(x);
	}
	
	public static NumberFormat buildFormatter(int digitCount) {
		NumberFormat instance = NumberFormat.getInstance();
		instance.setParseIntegerOnly(false);
		instance.setMaximumFractionDigits(Integer.valueOf(digitCount));
		return instance;
	}

}


public class EntryHandle {
	
	private String name;
	private String classroom;
	private double grade;
	
	public EntryHandle(String name, String classroom, double grade) {
		this.name = name;
		this.classroom = classroom;
		this.grade = grade;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getClassroom() {
		return this.classroom;
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	public String getInfo() {
		return this.name + ";" + this.classroom;
	}
	
	public static EntryHandle parseHandle(String input, NumberFormat formatter) throws ParseException {
		String[] p = input.split(";");
		return (new EntryHandle(p[0], p[1], formatter.parse(p[2]).doubleValue()));
	}

}
