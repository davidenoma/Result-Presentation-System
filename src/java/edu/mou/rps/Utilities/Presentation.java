package edu.mou.rps.Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kolis
 */
import edu.mou.rps.model.Grades;
import edu.mou.rps.model.Courses;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import java.util.List;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

public class Presentation {

    private XMLSlideShow pptx;
    private XSLFTable table;
    private XSLFSlide slide;
    private List<XSLFTableRow> tables;

    private String fileLocation = "C:\\Users\\kolis\\Documents\\NetBeansProjects\\ResultPresentationSystem\\sheet.pptx";

    public void createTitlePage(String department, String programme, int level, int Semester, String jobRole) {
        //This method creates a new slide show. 
        setPptx(new XMLSlideShow());

        //This method gives us access to the slide master and we obtain only the first slide.
        XSLFSlideMaster slideMaster = getPptx().getSlideMasters().get(0);

        //THis creates the layout that would be used for the slides. 
        XSLFSlideLayout slidelayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
        //slideMaster.getTheme().getParent().getRelationParts().get(0).getDocumentPart()
        //THis method creates the a new slide with the given layout. 
        XSLFSlide slide1 = getPptx().createSlide(slidelayout);

        //This method creads a text shape. 
        XSLFTextShape title = slide1.getPlaceholder(0);
        if (jobRole.equals("Dean")) {
            title.setText("\nDean Result Sheet for the Faculty of Natural and Applied Sciences \nDepartment:" + department.toUpperCase());
        } else {
            title.setText("\nHOD Result Sheet for the Faculty of Natural and Applied Sciences \nDepartment:" + department.toUpperCase());
        }

        XSLFTextShape body = slide1.getPlaceholder(1);
        body.clearText();
        body.setText(programme + " Program," + level + " Level," + Semester + " semester");
        body.setHorizontalCentered(Boolean.TRUE);
        body.setVerticalAlignment(VerticalAlignment.MIDDLE);
        body.setWordWrap(true);
        //New slidewith Title
        XSLFSlide slide2 = getPptx().createSlide(getPptx().getSlideMasters().get(0).getLayout(SlideLayout.TITLE_ONLY));
        XSLFTextShape txt = slide2.createTextBox();
        txt.setHorizontalCentered(false);
        txt.setVerticalAlignment(VerticalAlignment.TOP);
        txt.setWordWrap(true);
        XSLFTextRun tr = txt.setText(programme.toUpperCase() + ", Semester " + Integer.toString(Semester) + ", " + Integer.toString(level) + " Level.");
        tr.setFontSize(28.0);
        tr.setBold(true);
        setTable(slide2.createTable());
        getTable().setAnchor(new Rectangle2D.Double(0, 70, 70, 10));

    }

    public void addRowsToTable(XSLFTable table) {
        
        XSLFTableRow row = table.addRow();
        
        //  table.setColumnWidth(0, 10);
        row.addCell().setText("S/N").setFontSize(25.0);
        row.addCell().setText("COURSE CODE").setFontSize(25.0);
        // row.addCell().setText("TITLE");
        row.addCell().setText("TOTAL STUDENTS").setFontSize(25.0);
        row.addCell().setText("TOTAL PASS").setFontSize(25.0);
        row.addCell().setText("TOTAL FAIL").setFontSize(25.0);
        row.addCell().setText("A").setFontSize(25.0);
        row.addCell().setText("B").setFontSize(25.0);
        row.addCell().setText("C").setFontSize(25.0);
        row.addCell().setText("D").setFontSize(25.0);
        row.addCell().setText("E").setFontSize(25.0);
        row.addCell().setText("F").setFontSize(25.0);
        table.setColumnWidth(0, 40.0);
        table.setColumnWidth(5, 40.0);
        table.setColumnWidth(6, 40.0);
        table.setColumnWidth(7, 40.0);
        table.setColumnWidth(8, 40.0);
        table.setColumnWidth(9, 40.0);
        table.setColumnWidth(10, 40.0);
    }

    public void addMoreRowsToTable(Courses c, Grades g, XSLFTable table, int count) {
        int i = 0;
        while (i <= count) {
            XSLFTableRow name = table.addRow();
            name.addCell().setText(Integer.toString(i));
            name.addCell().setText(c.getCourseCodes()[count]);
            System.out.println(c.getCourseCodes()[count]);
            name.addCell().setText(c.getCourseTitles()[count]);
            System.out.println(c.getCourseTitles()[count]);
            name.addCell().setText(Integer.toString(g.getTotalNumber()[count]));
            name.addCell().setText(Integer.toString(g.getTotalNumberOfPass()[count]));
            name.addCell().setText(Integer.toString(g.getTotalNumberOfFails()[count]));
            name.addCell().setText(Integer.toString(g.getTotalNumberOfA()[count]));
            name.addCell().setText(Integer.toString(g.getTotalNumberOfB()[count]));
            name.addCell().setText(Integer.toString(g.getTotalNumberOfC()[count]));
            name.addCell().setText(Integer.toString(g.getTotalNumberOfD()[count]));
            name.addCell().setText(Integer.toString(g.getTotalNumberOfE()[count]));
            name.addCell().setText(Integer.toString(g.getTotalNumberOfF()[count]));
            ++i;
        }
    }

    public void addRowContent(Courses c, Grades g, int count) {
        XSLFTableRow name = (XSLFTableRow) (tables.get(0));
        name.addCell().setText(Integer.toString(count));
        name.addCell().setText(c.getCourseCodes()[count]);
        name.addCell().setText(c.getCourseTitles()[count]);
        name.addCell().setText(Integer.toString(g.getTotalNumber()[count]));
        name.addCell().setText(Integer.toString(g.getTotalNumberOfPass()[count]));
        name.addCell().setText(Integer.toString(g.getTotalNumberOfFails()[count]));
        name.addCell().setText(Integer.toString(g.getTotalNumberOfA()[count]));
        name.addCell().setText(Integer.toString(g.getTotalNumberOfB()[count]));
        name.addCell().setText(Integer.toString(g.getTotalNumberOfC()[count]));
        name.addCell().setText(Integer.toString(g.getTotalNumberOfD()[count]));
        name.addCell().setText(Integer.toString(g.getTotalNumberOfE()[count]));
        name.addCell().setText(Integer.toString(g.getTotalNumberOfF()[count]));

    }

    public void writeToFile() throws FileNotFoundException, IOException {
        if (new File(this.getFileLocation()).exists()) {
            //Files fp = Files.Paths.get(this.getFileLocation());
            System.out.println(new File(this.getFileLocation()).getParent());

            try (FileOutputStream fos = new FileOutputStream(this.getFileLocation().replace(".pptx", "(1).pptx"))) {

                pptx.write(fos);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        Presentation ps = new Presentation();

    }

    /**
     * @return the pptx
     */
    public XMLSlideShow getPptx() {
        return pptx;
    }

    /**
     * @param pptx the pptx to set
     */
    public void setPptx(XMLSlideShow pptx) {
        this.pptx = pptx;
    }

    /**
     * @return the table
     */
    public XSLFTable getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(XSLFTable table) {
        this.table = table;
    }

    /**
     * @return the tables
     */
    public List<XSLFTableRow> getTables() {
        return tables;
    }

    /**
     * @param tables the tables to set
     */
    public void setTables(List<XSLFTableRow> tables) {
        this.tables = tables;
    }

    /**
     * @return the slide
     */
    public XSLFSlide getSlide() {
        return slide;
    }

    /**
     * @param slide the slide to set
     */
    public void setSlide(XSLFSlide slide) {
        this.slide = slide;
    }

    /**
     * @return the fileLocation
     */
    public String getFileLocation() {
        return fileLocation;
    }

    /**
     * @param fileLocation the fileLocation to set
     */
    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }
}
