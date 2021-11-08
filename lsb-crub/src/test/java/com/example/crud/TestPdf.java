package com.example.crud;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestPdf {

    @Test
    public void test() throws DocumentException, FileNotFoundException {
        // 生成File所在文件夹
        String filename = "D:/HelloWorld.pdf";
        File file = new File(filename);
        file.getParentFile().mkdirs();

        // 生成PDF文档
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        for (int i = 0; i < 4; i++) {
            PdfPTable table = new PdfPTable(15);
            PdfPCell cell = new PdfPCell();
            cell.setPhrase(new Paragraph("user.getId().toString()"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("11.32"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("user.getAge().toString()"));
            table.addCell(cell);
            document.add(table);

            cell.setPhrase(new Paragraph("user.getId().toString()"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("11.32"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("user.getAge().toString()"));
            table.addCell(cell);
            document.add(table);

            cell.setPhrase(new Paragraph("user.getId().toString()"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("11.32"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("user.getAge().toString()"));
            table.addCell(cell);
            document.add(table);

            cell.setPhrase(new Paragraph("user.getId().toString()"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("11.32"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("user.getAge().toString()"));
            table.addCell(cell);
            document.add(table);


            cell.setPhrase(new Paragraph("user.getId().toString()"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("11.32"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("user.getAge().toString()"));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("user.getAge().toString()"));
            table.addCell(cell);
            document.add(table);
        }
        document.close();

    }
}
