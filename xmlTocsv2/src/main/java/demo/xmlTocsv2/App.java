package demo.xmlTocsv2;

import java.util.Arrays;

import com.fordfrog.xml2csv.ConversionConfig;
import com.fordfrog.xml2csv.Converter;
import com.fordfrog.xml2csv.DefaultConversionConfig.DefaultConversionConfigBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DefaultConversionConfigBuilder builder = new DefaultConversionConfigBuilder()
        	    .setColumns(Arrays.asList("value1", "value2", "value3")) //sets columns to extract
        	    .setSeparator(",") //sets field separator
        	    .setTrim(true) //trims field values (defaults to false)
        	    .setJoin(true) //joins duplicate field values (defaults to false)
        	    .setRowItemName("/root/item"); //row item name
        	  
        	ConversionConfig config = builder.build();
        	Converter converter = new Converter(config);
        	String xmlContent="<root>\r\n" + 
        			"    <item>\r\n" + 
        			"        <subitem1>\r\n" + 
        			"            <value1>gfd</value1>\r\n" + 
        			"            <value2>dg</value2>\r\n" + 
        			"        </subitem1>\r\n" + 
        			"        <subitem2>\r\n" + 
        			"            <value3>dgd</value3>\r\n" + 
        			"        </subitem2>\r\n" + 
        			"    </item>\r\n" + 
        			"    <item>\r\n" + 
        			"        <subitem1>\r\n" + 
        			"            <value1>dggd</value1>\r\n" + 
        			"        </subitem1>\r\n" + 
        			"        <subitem2>\r\n" + 
        			"            <value3>dgdgdgdfg</value3>\r\n" + 
        			"        </subitem2>\r\n" + 
        			"    </item>\r\n"+
        			"    <item>\r\n" + 
         			"        <subitem1>\r\n" + 
         			"            <value1>dggd</value1>\r\n" + 
         			"        </subitem1>\r\n" + 
         			"        <subitem2>\r\n" + 
         			"            <value3>dgdgdgdfg</value3>\r\n" + 
         			"        </subitem2>\r\n" + 
         			"    </item>\r\n"+
        			"</root>";
        	String csvContent = converter.convert(xmlContent);
        	System.out.println(csvContent);
    }
}
