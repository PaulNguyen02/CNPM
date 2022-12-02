package Function;

import java.util.ArrayList;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import DTO.CTHD_DTO;
import DTO.HD_DTO;
import DTO.SP_DTO;

public class ITextPDF {
    private HD_DTO Bill;
    private ArrayList<CTHD_DTO> Details;
    private ArrayList<SP_DTO> Products;
    private int Received;
    public ITextPDF() {
        
    }
    public void createDoc(HD_DTO Bill,  ArrayList<CTHD_DTO> Details, ArrayList<SP_DTO> Products, int Received){
        
        this.Bill = Bill;
        this.Details = Details;
        this.Products = Products;
        this.Received = Received;

        try {
            PdfWriter file = new PdfWriter("E:\\MiniStoreJavaSGU-main\\MiniStoreJavaSGU-main\\Bill\\"+Bill.getMahd()+".pdf");
            PdfDocument pdfDoc = new PdfDocument(file);
            pdfDoc.addNewPage();
            Document doc = new Document(pdfDoc);
            doc.add(getHeader());
            doc.add(new Paragraph());
            doc.add(new Paragraph("HOA DON BAN HANG").setTextAlignment(TextAlignment.CENTER));
            doc.add(getInfor());
            doc.add(new Paragraph("----------------------------------------------------------------------------------------------------").setTextAlignment(TextAlignment.CENTER));
            doc.add(getDetails());
            doc.add(new Paragraph("----------------------------------------------------------------------------------------------------").setTextAlignment(TextAlignment.CENTER));
            doc.add(getSumary());
            doc.add(new Paragraph());
            doc.add(new Paragraph("Gia da bao gom thue VAT").setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("VAT included").setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("----------------------------------------------------------------------------------------------------").setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("Chi xuat hoa trong ngay").setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("Tax invoice will be issued within same day").setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("----------------------------------------------------------------------------------------------------").setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("Cam on quy khach va hen gap lai <3").setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("Thank you for shopping and see you later <3").setTextAlignment(TextAlignment.CENTER));
            

            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Paragraph getSumary(){
        Paragraph p = new Paragraph();
        Table Table_Sumary = new Table(UnitValue.createPercentArray(new float[] { 3, 1}));
        Table_Sumary.setWidth(UnitValue.createPercentValue(100));
        Table_Sumary.setTextAlignment(TextAlignment.LEFT);
        Table_Sumary.addCell(new Cell().add(new Paragraph("Bill's Total Price:")).setBorder(Border.NO_BORDER));
        Table_Sumary.addCell(new Cell().add(new Paragraph(Bill.getTongtien()+"")).setBorder(Border.NO_BORDER));
        Table_Sumary.addCell(new Cell().add(new Paragraph("Received:")).setBorder(Border.NO_BORDER));
        Table_Sumary.addCell(new Cell().add(new Paragraph(Received+"")).setBorder(Border.NO_BORDER));
        Table_Sumary.addCell(new Cell().add(new Paragraph("Remainder:")).setBorder(Border.NO_BORDER));
        Table_Sumary.addCell(new Cell().add(new Paragraph((Received - Bill.getTongtien())+"")).setBorder(Border.NO_BORDER));

        p.add(Table_Sumary);
        return p;
    }

    private Paragraph getDetails(){
        Paragraph p = new Paragraph();

        Table Table_Details = new Table(UnitValue.createPercentArray(new float[] { 1, 1, 1, 1}));
        Table_Details.setWidth(UnitValue.createPercentValue(100));
        Table_Details.setTextAlignment(TextAlignment.LEFT);
        Table_Details.addCell(new Cell().add(new Paragraph("Product Name")).setBorder(Border.NO_BORDER));
        Table_Details.addCell(new Cell().add(new Paragraph("Price")).setBorder(Border.NO_BORDER));
        Table_Details.addCell(new Cell().add(new Paragraph("Quantity")).setBorder(Border.NO_BORDER));
        Table_Details.addCell(new Cell().add(new Paragraph("Total")).setBorder(Border.NO_BORDER));
        for (int i = 0; i < Details.size(); i++) {
            
            Table_Details.addCell(new Cell().add(new Paragraph(Products.get(i).getTensp())).setBorder(Border.NO_BORDER));
            Table_Details.addCell(new Cell().add(new Paragraph(Products.get(i).getDongia()+"")).setBorder(Border.NO_BORDER));
            Table_Details.addCell(new Cell().add(new Paragraph(Details.get(i).getSoluong()+"")).setBorder(Border.NO_BORDER));
            Table_Details.addCell(new Cell().add(new Paragraph(Details.get(i).getTotal()+"")).setBorder(Border.NO_BORDER));

        }
        p.add(Table_Details);
        return p;
    }

    private Paragraph getInfor(){
        Paragraph p = new Paragraph();
        
        Table Table_Infor = new Table(UnitValue.createPercentArray(new float[] { 2, 1 }));
        Table_Infor.setWidth(UnitValue.createPercentValue(100));
        Table_Infor.setTextAlignment(TextAlignment.LEFT);

        Table_Infor.addCell(new Cell().add(new Paragraph("Date: "+Bill.getNgxuat())).setBorder(Border.NO_BORDER));
        Table_Infor.addCell(new Cell().add(new Paragraph("Casher: "+Bill.getManv())).setBorder(Border.NO_BORDER));
        Table_Infor.addCell(new Cell().add(new Paragraph("ID: "+Bill.getMahd())).setBorder(Border.NO_BORDER));
        Table_Infor.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        p.add(Table_Infor);

        return p;
    }

    private Paragraph getHeader(){
        Paragraph p = new Paragraph();
        try {
            Paragraph P_Img = new Paragraph();
            Paragraph P_Text = new Paragraph();
            ImageData imgData = ImageDataFactory.create("src/icon/Logo_Yoi.png");
            Image img = new Image(imgData);
            P_Img.add(img);
            P_Img.setTextAlignment(TextAlignment.LEFT);
            //Text Text_CompanyName = new Text("D2P Company \n");
            Text Text_Header = new Text("   \n\nD2P Company \n  273 An Duong Vuong, P3, Quan 5, TP.HCM");
            P_Text.add(Text_Header);
            P_Text.setTextAlignment(TextAlignment.LEFT);
            Table Table_Header = new Table(UnitValue.createPercentArray(new float[] { 2, 2 }));
            Table_Header.setWidth(UnitValue.createPercentValue(100));
            Table_Header.addCell(new Cell().add(P_Img).setBorder(Border.NO_BORDER));
            Table_Header.addCell(new Cell().add(P_Text).setBorder(Border.NO_BORDER));
            p.add(Table_Header);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return p;
    }

}
