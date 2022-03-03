package com.example.utilidades;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateRepoprt {

    public static void createReport(String fileName, String fileBody) {
        try {
            File fichero = new File(fileName);

            PdfWriter pdfWriter = new PdfWriter(fichero);

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            Paragraph p = new Paragraph(fileBody);

            document.add(p);

            document.close();
            pdfWriter.close();
            pdfDocument.close();

            System.out.println("File created");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
