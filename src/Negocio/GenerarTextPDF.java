/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author crist
 */
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author xcheko51x
 */
public class GenerarTextPDF {

    /**
     * @param args the command line arguments
     */
    public GenerarTextPDF(String texto) throws FileNotFoundException, DocumentException {
        crearPDF(texto);
    }

    public static void crearPDF(String texto) throws FileNotFoundException, DocumentException {
        // Se crea el documento
        Document documento = new Document();

        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream("historialJugadas.pdf");

        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);

        // Se abre el documento
        documento.open();

        // Parrafo
        Paragraph titulo = new Paragraph("Lista de movimientos \n\n",
                FontFactory.getFont("arial",
                        22,
                        Font.BOLD,
                        BaseColor.BLUE
                )
        );

        // Añadimos el titulo al documento
        documento.add(titulo);

        // Parrafo
        Paragraph cuerpo = new Paragraph(texto + " \n\n",
                FontFactory.getFont("arial",
                        22,
                        Font.BOLD,
                        BaseColor.BLACK
                )
        );

        // Añadimos el cuerpo al documento
        documento.add(cuerpo);

        // Se cierra el documento
        documento.close();
    }

}
