package spreadsheet.mapper.w2o.validation.validator.cell.buildin;

import org.testng.annotations.Test;
import spreadsheet.mapper.TestFactory;
import spreadsheet.mapper.model.core.Cell;
import spreadsheet.mapper.model.meta.FieldMeta;

import java.util.Map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by hanwen on 2017/1/12.
 */
public class DigitsValidatorTest {

  @Test
  public void testCustomValid() throws Exception {

    Map<String, FieldMeta> fieldMetaMap = TestFactory.createFieldMetaMap();

    DigitsValidator validator0 = new DigitsValidator();
    validator0.matchField("int1");
    DigitsValidator validator1 = new DigitsValidator();
    validator1.matchField("int2");
    DigitsValidator validator2 = new DigitsValidator();
    validator2.matchField("long1");
    DigitsValidator validator3 = new DigitsValidator();
    validator3.matchField("long2");
    DigitsValidator validator4 = new DigitsValidator();
    validator4.matchField("float1");
    DigitsValidator validator5 = new DigitsValidator();
    validator5.matchField("float2");
    DigitsValidator validator6 = new DigitsValidator();
    validator6.matchField("double1");
    DigitsValidator validator7 = new DigitsValidator();
    validator7.matchField("double2");

    Map<String, Cell> cellMap1 = TestFactory.createCellMap1();
    assertTrue(validator0.valid(cellMap1.get("int1"), fieldMetaMap.get("int1")));
    assertFalse(validator1.valid(cellMap1.get("int2"), fieldMetaMap.get("int2")));
    assertTrue(validator2.valid(cellMap1.get("long1"), fieldMetaMap.get("long1")));
    assertTrue(validator3.valid(cellMap1.get("long2"), fieldMetaMap.get("long2")));
    assertFalse(validator4.valid(cellMap1.get("float1"), fieldMetaMap.get("float1")));
    assertFalse(validator5.valid(cellMap1.get("float2"), fieldMetaMap.get("float2")));
    assertFalse(validator6.valid(cellMap1.get("double1"), fieldMetaMap.get("double1")));
    assertFalse(validator7.valid(cellMap1.get("double2"), fieldMetaMap.get("double2")));

    Map<String, Cell> cellMap2 = TestFactory.createErrorCellMap();
    assertFalse(validator0.valid(cellMap2.get("int1"), fieldMetaMap.get("int1")));
    assertTrue(validator1.valid(cellMap2.get("int2"), fieldMetaMap.get("int2")));
    assertFalse(validator2.valid(cellMap2.get("long1"), fieldMetaMap.get("long1")));
    assertTrue(validator3.valid(cellMap2.get("long2"), fieldMetaMap.get("long2")));
    assertFalse(validator4.valid(cellMap2.get("float1"), fieldMetaMap.get("float1")));
    assertTrue(validator5.valid(cellMap2.get("float2"), fieldMetaMap.get("float2")));
    assertFalse(validator6.valid(cellMap2.get("double1"), fieldMetaMap.get("double1")));
    assertTrue(validator7.valid(cellMap2.get("double2"), fieldMetaMap.get("double2")));
  }

}