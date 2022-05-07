/**
 *
 */
package tr.com.srdc.ontmalizer.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.com.srdc.ontmalizer.XSD2OWLMapper;

/**
 * @author Mustafa
 *
 */
public class XSD2OWLTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(XSD2OWLTest.class);

    @Test
    public void createCDAOntology() {

        // This part converts XML schema to OWL ontology.
        XSD2OWLMapper mapping = new XSD2OWLMapper(new File("src/test/resources/CDA/CDA.xsd"));
        mapping.setObjectPropPrefix("");
        mapping.setDataTypePropPrefix("");
        mapping.convertXSD2OWL();

        // This part prints the ontology to the specified file.
        File f = new File("src/test/resources/output/cda-ontology.n3");
        assert f.getParentFile().exists() || f.getParentFile().mkdirs();

        try (FileOutputStream ont = new FileOutputStream(f)) {
            mapping.writeOntology(ont, "N-TRIPLE"); // not "N3"
        } catch (Exception e) {
            LOGGER.error("createCDAOntology: {}", e.getMessage(), e);
        }
    }

    @Test
    public void createSALUSCommonOntology() {

        // This part converts XML schema to OWL ontology.
        XSD2OWLMapper mapping = new XSD2OWLMapper(new File("src/test/resources/salus-common-xsd/salus-cim.xsd"));
        mapping.setObjectPropPrefix("");
        mapping.setDataTypePropPrefix("");
        mapping.convertXSD2OWL();

        // This part prints the ontology to the specified file.
        File f = new File("src/test/resources/output/salus-cim-ontology.n3");
        assert f.getParentFile().exists() || f.getParentFile().mkdirs();

        try (FileOutputStream ont = new FileOutputStream(f)) {
            mapping.writeOntology(ont, "N-TRIPLE"); // not "N3"
        } catch (Exception e) {
            LOGGER.error("createSALUSCommonOntology: {}", e.getMessage(), e);
        }
    }

    @Test
    public void createTestOntology() {

        // This part converts XML schema to OWL ontology.
        XSD2OWLMapper mapping = new XSD2OWLMapper(new File("src/test/resources/test/test.xsd"));
        mapping.setObjectPropPrefix("");
        mapping.setDataTypePropPrefix("");
        mapping.convertXSD2OWL();

        // This part prints the ontology to the specified file.
        File f = new File("src/test/resources/output/test.n3");
        assert f.getParentFile().exists() || f.getParentFile().mkdirs();

        try (FileOutputStream ont = new FileOutputStream(f)) {
            mapping.writeOntology(ont, "N-TRIPLE"); // not "N3"
        } catch (Exception e) {
            LOGGER.error("createTestOntology: {}", e.getMessage(), e);
        }
    }

    @Test
    public void writerTest() {

        // This part converts XML schema to OWL ontology.
        XSD2OWLMapper mapping = new XSD2OWLMapper(new File("src/test/resources/test/test.xsd"));
        mapping.setObjectPropPrefix("");
        mapping.setDataTypePropPrefix("");
        mapping.convertXSD2OWL();

        // This part prints the ontology to the specified file.
        File f = new File("src/test/resources/output/test.n3");
        assert f.getParentFile().exists() || f.getParentFile().mkdirs();

        try (Writer w = new FileWriter(f)) {
            mapping.writeOntology(w, "N-TRIPLE"); // not "N3"
        } catch (Exception e) {
            LOGGER.error("writerTest: {}", e.getMessage(), e);
        }
    }
}
