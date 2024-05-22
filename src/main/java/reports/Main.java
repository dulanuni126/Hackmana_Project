package reports;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws JRException, SQLException, ClassNotFoundException {
        JasperDesign design =JRXmlLoader.load("src/main/resources/Report/Hakmana_active_device_count.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint,false);
    }
}
