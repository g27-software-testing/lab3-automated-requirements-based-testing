package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.*;



public class DataUtilitiesTest {
	
	private Values2D values2D;
	private Values2D values2DEmpty;
	private DefaultKeyedValues dataKeys;
	private Values2D values2DNull = null;
	
	@Before
	public void setUp()
{
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;

		
		//addValue(Number value, Comparable rowKey, Comparable columnKey)
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		
		testValues.addValue(4, 0, 1);
		testValues.addValue(4, 1, 1);
		
		testValues.addValue(9, 1, 2);
		testValues.addValue(1, 0, 2);
		
		testValues.addValue(4, 0, 3);
		testValues.addValue(5, 1, 3);
		
		testValues.addValue(1, 0, 4);
		testValues.addValue(2, 1, 4);
		
		double[] doubleArray = {1.0, 2.0};
		
		values2DEmpty = new DefaultKeyedValues2D();

		
		dataKeys = new DefaultKeyedValues();
		
		dataKeys.addValue("0", 5.0);
		dataKeys.addValue("1", 9.0);
		dataKeys.addValue("2", 2.0);
		
		
		//System.out.println(DataUtilities.createNumberArray(doubleArray));
		
		

		
		// Columns   0,1,2,3,4
		         //0 1 4 1 4 1
		        // 1 4 4 9 5 2


}


	@After
	public void tearDown() {
		values2D = null;
		values2DEmpty = null;
		dataKeys = null;
	}
	
	
//	@Test
//	public void testValidDataAndColumnColumnTotal() {
//		assertEquals("Wrong sum returned. It should be 5.0",
//				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
//	}
//	
//	@Test
//	public void testNullDataColumnTotal() {
//		try {
//			DataUtilities.calculateColumnTotal(null, 0);
//			fail("No exception thrown‐Expected outcome was: a thrown exception of type: InvalidParameterException");
//		}
//		catch (Exception e) {
//			assertTrue("Incorrect exception type thrown",
//					e.getClass().equals(InvalidParameterException.class));
//		}
//	}
	
	//Tests for calculateColumnTotal()
	
	@Test
	public void testCalculateColumnTotalReturnsZeroWhenColumnisNegative5() {
		try {
		assertEquals("Should return 0.0", 0.0, DataUtilities.calculateColumnTotal(values2D, -5), 0.0000001d);
	}
	catch (Exception e) {
		fail("Did not return 0.0");
	}

}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenValidInputIsEntered() {
		
		assertEquals("Should return 10.0", 10.0, DataUtilities.calculateColumnTotal(values2D, 2), 0.0000001d);

			
	}
	
	
	@Test
	public void testCalculateColumnTotalReturnsZeroWhenColumnis9() {
		try {
			assertEquals("Should return 0.0", 0.0, DataUtilities.calculateColumnTotal(values2D, 9), 0.0000001d);

	}
	catch (Exception e) {
		fail("Did not return 0.0");
	}

	
	}
	
	
	
	
	@Test
	public void testCalculateColumnTotalReturnsZeroWhenDataisEmptyAndColumnisNegative24() {
		
		
		try {
			assertEquals("Should return 0.0", 0.0, DataUtilities.calculateColumnTotal(values2DEmpty, -24), 0.0000001d);

	}
	catch (Exception e) {
		fail("Did not return 0.0");
	}

	}
		

	@Test
	public void testCalculateColumnTotalThrowsIllegalArgumentExceptionWhenDataisNullAndColumnIs1() {
		
		
		try {
			DataUtilities.calculateColumnTotal(null, 1);
			fail("No exception thrown‐Expected outcome was: a thrown exception of type: IllegalArgumentException");

		}
		catch (Exception e) {
			assertTrue("Correct exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}

	}
		
	
	@Test
	public void testCalculateColumnTotalReturnsZeroWhenDataisEmptyAndColumnIs20() {
		
		try {
			assertEquals("Should return 0.0", 0.0, DataUtilities.calculateColumnTotal(values2DEmpty, 20), 0.0000001d);

	}
	catch (Exception e) {
		fail("Did not return 0.0");
	}	
	}
		
	
	//Boundary Value Analysis
	
	@Test
	public void testCalculateColumnTotalReturnsZeroWhenColumnIsNegative1() {
		
		try {
			assertEquals(0.0, DataUtilities.calculateColumnTotal(values2D, -1), 0.0000001d);

	}
	catch (Exception e) {
		fail("Did not return 0.0");

	}
		
	}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenColumnIs0() {
		
		try {
		assertEquals(5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
		

	}
	catch (Exception e) {
		fail("Did not return 0.0");

	}
			
	}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenColumnIs1() {
		
		try {

		assertEquals(8.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);
		
		

	}
	catch (Exception e) {
		fail("Did not return 0.0");

	}
			
	}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenColumnIs3() {
		
		try {

		assertEquals(9.0, DataUtilities.calculateColumnTotal(values2D, 3), 0.0000001d);
			
		}
		catch (Exception e) {
			fail("Did not return 0.0");

		}
		
	}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenColumnIs4() {
		
		try {
		
		assertEquals(3.0, DataUtilities.calculateColumnTotal(values2D, 4), 0.0000001d);
		
	}
	catch (Exception e) {
		fail("Did not return 0.0");

	}
			
	}
	
	@Test
	public void testCalculateColumnTotalReturnsZeroWhenColumnIs5() {
		
		try {
		
		assertEquals(0.0, DataUtilities.calculateColumnTotal(values2D, 5), 0.0000001d);
		
		}
		catch (Exception e) {
			fail("Did not return 0.0");
		}

		
	}
	
	//calculateRowTotal() tests
	@Test
	public void testCalculateRowTotalReturnsZeroWhenRowisNegative4() {
		try {
	
		assertEquals(0.0, DataUtilities.calculateRowTotal(values2D, -4), 0.0000001d);}
		
		catch (Exception e) {
			fail("Did not return 0.0");
		}
	}

	@Test
	public void testCalculateRowTotalReturns24WhenRowis1() {
		try {
		assertEquals(24.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
		}
		
		catch (Exception e) {
			fail("Did not return 24.0");
		}

		
	}
	
	@Test
	public void testCalculateRowTotalReturnsZeroWhenRowis100() {
		
		try {
		assertEquals(0.0, DataUtilities.calculateRowTotal(values2D, 100), 0.0000001d);
		
		}
		
		catch (Exception e) {
			fail("Did not return 0.0");
		}

	}
	
	@Test
	public void testCalculateRowTotalThrowsIllegalArgumentExceptionWhenDataisNullAndRowisNegative9() {
		try {
		DataUtilities.calculateRowTotal(values2DNull, -9);
		fail("Did not throw exception - expected IllegalArgumentException");
		
	}
		catch (Exception e) {
			assertTrue("Correct exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
		
	}
	
	
	@Test
	public void testCalculateRowTotalThrowsIllegalArgumentExceptionWhenDataisNullAndRowis1() {
		try {
		DataUtilities.calculateRowTotal(values2DNull, 1);
		fail("Did not throw exception - expected IllegalArgumentException");
		
	}
		catch (Exception e) {
			assertTrue("Correct exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
		
	}
	
	@Test
	public void testCalculateRowTotalReturnsZeroWhenDataisEmptyAndRowis200() {
		try {
			assertEquals(0.0, DataUtilities.calculateRowTotal(values2DEmpty, 200), 0.0000001d);

		
	}
	
	
	catch (Exception e) {
		fail("Did not return 0.0");
	}

	}
	
	
	//Boundary Value Analysis

	@Test
	public void testCalculateRowTotalReturnsZeroWhenRowIsNegative1() {
		try {
			assertEquals(0.0, DataUtilities.calculateRowTotal(values2D, -1), 0.0000001d);

		}
		
		catch (Exception e) {
			fail("Did not return 0.0");
		}
	}
	
	@Test
	public void testCalculateRowTotalReturnsExpectedAnswerWhenRowIs0() {
		
		try {
		assertEquals(11.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
		
	}
	
	
	catch (Exception e) {
		fail("Did not return 11.0");
	}

			
	}
	

	
	@Test
	public void testCalculateRowTotalReturnsZeroWhenRowIs2() {
		try {
			assertEquals(0.0, DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d);

		}
		catch (Exception e) {
			fail("Did not return 0.0");
		}
			
	}
	
	//Tests for createNumberArray()
	
	@Test
	public void testCreateNumberArrayReturnsNumberArrayof2and1() {
		
		double[] doubleArray = {1.0, 2.0};
		Number[] numArray = {1,2};
		
		assertTrue(DataUtilities.createNumberArray(doubleArray) instanceof java.lang.Number[]);
		Arrays.deepEquals(DataUtilities.createNumberArray(doubleArray), numArray);
			
	}
	
	
	@Test
	public void testCreateNumberArrayThrowsIllegalArgumentExceptionWhenArrayisNull() {
		
		double[] doubleArray = null;
		

		try {
			DataUtilities.createNumberArray(doubleArray);
			
		}
			catch (Exception e) {
				assertTrue("Correct exception type thrown",
						e.getClass().equals(IllegalArgumentException.class));
			}
			
		}
	
	
	//Tests for createNumberArray2D()

	@Test
	public void testCreateNumberArray2DReturns2DNumberArrayWhenInputIsValid() {
		
		double[][] double2DArray = { {0.0, 1.1}, {1.1, 2.2}, {3.3, 1.4}};
		
		
		Number[][] num2DArray = { {0, 1}, {1, 2}, {3, 1}};

		
		System.out.println(double2DArray);

			Number[][] result = DataUtilities.createNumberArray2D(double2DArray);
			
			assertTrue("result is an instance of Number[][]",
					(result instanceof java.lang.Number[][]));
			
			Arrays.deepEquals(result, num2DArray);
	
		}
	
	

	@Test
	public void testCreateNumberArray2DReturnsIllegalArgumentExceptionWhenDataisNull() {
		
		double [] [] data = null;

		try {
			DataUtilities.createNumberArray2D(data);
			
		}
			catch (Exception e) {
				assertTrue("Correct exception type thrown",
						e.getClass().equals(IllegalArgumentException.class));
			}
			
		}
	
	
	
	//Tests for getCumulativePercentages()

	@Test
	public void testGetCumulativePercentagesReturnsCorrectAnswerExceptionWhenDataisValid() {

		try {
			
		   
		   KeyedValues result = DataUtilities.getCumulativePercentages((KeyedValues)dataKeys);
		   assertEquals("Should return 0.3125", 0.3125, (double)result.getValue("0"), 0.0000001d);
		   assertEquals("Should return 0.8750", 0.8750, (double)result.getValue("1"), 0.0000001d);
		   assertEquals("Should return 1.0000", 1.000, (double)result.getValue("2"), 0.0000001d);
		   
		}
			catch (Exception e) {
				fail("error:" + e);
			}
			
		}
	
	
	
	@Test
	public void testGetCumulativePercentagesReturnsIllegalArgumentExceptionWhenDataisNull() {
		
		try {
			DataUtilities.getCumulativePercentages(null);
			
		}
			catch (Exception e) {
				assertTrue("Correct exception type thrown",
						e.getClass().equals(IllegalArgumentException.class));
			}
			
		}
	
	
			
	}
	


		
		
	
	
	
	
	

