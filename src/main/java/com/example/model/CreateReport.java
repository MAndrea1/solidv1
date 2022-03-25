package com.example.model;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateReport {
    private static Logger logger = Logger.getLogger(CreateReport.class);

    private CreateReport(){}

    public static File createReport(String fileName, String fileBody) {
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
            logger.info("Report created");
            return fichero;

        } catch (FileNotFoundException e) {
            logger.error("IOFileNotFoundException in createReport method", e);
            System.out.println("File not found");
        } catch (IOException e) {
            logger.error("IOException in createReport method", e);
            System.out.println("File couldn't be created");
        }
        return null;
    }
}
