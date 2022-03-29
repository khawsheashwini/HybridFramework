package com.jbk;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelWriting {
	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
		File file = new File("genderDataWrite.xls");

		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sht = wb.createSheet("genderData", 1);
		for (int i = 0; i < 5; i++) {
			sht.addCell(new Label(5, i, "Pass"));
		}
		wb.write();
		wb.close();
		System.out.println("Workbook is created");
	}

}
