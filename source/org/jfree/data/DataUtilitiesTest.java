package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;
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
		
		
		
		System.out.println(DataUtilities.createNumberArray(doubleArray));
		
		

		
		// Columns   0,1,2,3,4
		         //0 1 4 1 4 1
		        // 1 4 4 9 5 2


}


	@After
	public void tearDown() {
		values2D = null;
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
	public void testCalculateColumnTotalReturns0WhenColumnisNegative5() {
		try {
		assertTrue("Should return 0.0", DataUtilities.calculateColumnTotal(values2D, -5) == 0.0);
	}
	catch (Exception e) {
		fail("Did not return 0.0");
	}

}
	
	
	@Test
	public void testCalculateColumnTotalReturns0WhenColumnis9() {
		try {
			assertTrue("Should return 0.0", (DataUtilities.calculateColumnTotal(values2D, 9) == 0.0));
	}
	catch (Exception e) {
		fail("Did not return 0.0");
	}

	
	}
	
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenValidInputIsEntered() {
		
		assertTrue(DataUtilities.calculateColumnTotal(values2D, 0) == 5.0);
			
	}
	
	

	@Test
	public void testCalculateColumnTotalThrowsInvalidParameterExceptionWhenDataisEmpty() {
		
		values2DEmpty = new DefaultKeyedValues2D();

		
		try {
			DataUtilities.calculateColumnTotal(values2DEmpty, 1);
			fail("No exception thrown‐Expected outcome was: a thrown exception of type: InvalidParameterException");

		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(InvalidParameterException.class));
		}

	}
	
	
	@Test
	public void testCalculateColumnTotalThrowsInvalidParameterExceptionWhenDataisEmptyAndColumnisNegative24() {
		
		
		try {
			DataUtilities.calculateColumnTotal(values2DEmpty, -24);
			fail("No exception thrown‐Expected outcome was: a thrown exception of type: InvalidParameterException");

		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(InvalidParameterException.class));
		}

	}
		

	@Test
	public void testCalculateColumnTotalThrowsInvalidParameterExceptionWhenDataisNullAndColumnIs1() {
		
		
		try {
			DataUtilities.calculateColumnTotal(null, 1);
			fail("No exception thrown‐Expected outcome was: a thrown exception of type: InvalidParameterException");

		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(InvalidParameterException.class));
		}

	}
		
	
	@Test
	public void testCalculateColumnTotalThrowsInvalidParameterExceptionWhenDataisEmptyAndColumnIs20() {
		
		values2DEmpty = new DefaultKeyedValues2D();

		assertTrue(DataUtilities.calculateColumnTotal(values2DEmpty, 20) == 0.0);
			
	}
		
	
	//Boundary Value Analysis
	
	@Test
	public void testCalculateColumnTotalReturns0WhenColumnIsNegative1() {
		
		try {
		assertTrue(DataUtilities.calculateColumnTotal(values2D, -1) == 0.0);
	}
	catch (Exception e) {
		fail("Did not return 0.0");

		
	}
		
	}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenColumnIs0() {
		
		assertTrue(DataUtilities.calculateColumnTotal(values2D, 0) == 5.0);
			
	}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenColumnIs1() {
		
		assertTrue(DataUtilities.calculateColumnTotal(values2D, 1) == 8.0);
			
	}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenColumnIs3() {
		
		assertTrue(DataUtilities.calculateColumnTotal(values2D, 3) == 9.0);
			
	}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenColumnIs4() {
		
		assertTrue(DataUtilities.calculateColumnTotal(values2D, 4) == 3.0);
			
	}
	
	@Test
	public void testCalculateColumnTotalReturnsExpectedAnswerWhenColumnIs5() {
		
		try {
		
		assertTrue(DataUtilities.calculateColumnTotal(values2D, 5) == 0.0);
		
		}
		catch (Exception e) {
			fail("Did not return 0.0");
		}

		
	}
	
	//calculateRowTotal() tests
	@Test
	public void testCalculateRowTotalReturns0WhenRowisNegative4() {
		try {
	
		assertTrue(DataUtilities.calculateRowTotal(values2D, -4) == 0.0);}
		
		catch (Exception e) {
			fail("Did not return 0.0");
		}
	}

	@Test
	public void testCalculateRowTotalReturns24WhenRowis1() {
		assertTrue(DataUtilities.calculateRowTotal(values2D, 1) == 24.0);
		
	}
	
	@Test
	public void testCalculateRowTotalThrowsInvalidParameterExceptionWhenDataisNullAndRowisNegative9() {
		try {
		DataUtilities.calculateRowTotal(null, -9);
		
	}
		catch (Exception e) {
			assertTrue("Correct exception type thrown",
					e.getClass().equals(InvalidParameterException.class));
		}
		
	}
	
	
	@Test
	public void testCalculateRowTotalThrowsInvalidParameterExceptionWhenDataisNullAndRowis1() {
		try {
		DataUtilities.calculateRowTotal(null, 1);
		
	}
		catch (Exception e) {
			assertTrue("Correct exception type thrown",
					e.getClass().equals(InvalidParameterException.class));
		}
		
	}
	
	@Test
	public void testCalculateRowTotalThrowsInvalidParameterExceptionWhenDataisEmptyAndRowis200() {
		try {
		DataUtilities.calculateRowTotal(values2DEmpty, 200);
		
	}
		catch (Exception e) {
			assertTrue("Correct exception type thrown",
					e.getClass().equals(InvalidParameterException.class));
		}
		
	}
	
	
	//Boundary Value Analysis

	@Test
	public void testCalculateRowTotalReturns0WhenRowIsNegative1() {
		try {
		assertTrue(DataUtilities.calculateRowTotal(values2D, -1) == 0.0);}
		catch (Exception e) {
			assertTrue("Correct exception type thrown",
					e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotalReturnsExpectedAnswerWhenRowIs0() {
		
		assertTrue(DataUtilities.calculateRowTotal(values2D, 0) == 11.0);
			
	}
	
	@Test
	public void testCalculateRowTotalReturnsExpectedAnswerWhenRowIs1() {
		
		assertTrue(DataUtilities.calculateRowTotal(values2D, 1) == 24.0);
			
	}
	
	
	@Test
	public void testCalculateRowTotalReturns0WhenRowIs2() {
		try {
		assertTrue(DataUtilities.calculateRowTotal(values2D, 2) == 0.0);}
		catch (Exception e) {
			fail("Did not return 0.0");
		}
			
	}
	
	//Tests for createNumberArray()
	
	@Test
	public void testCreateNumberArrayReturnsNumberArrayof2and1() {
		
		double[] doubleArray = {1.0, 2.0};
		
		assertTrue(DataUtilities.createNumberArray(doubleArray) instanceof java.lang.Number[]);
			
	}
	
	
	//Getting illegal argument exception
	@Test
	public void testCreateNumberArrayThrowsInvalidParameterExceptionWhenArrayisEmpty() {
		
		double[] doubleArray = null;
		

		try {
			DataUtilities.createNumberArray(doubleArray);
			
		}
			catch (Exception e) {
				assertTrue("Correct exception type thrown",
						e.getClass().equals(InvalidParameterException.class));
			}
			
		}
	
	
	//Tests for createNumberArray2D()

	@Test
	public void testCreateNumberArray2DReturns2DNumberArrayWhenInputIsValid() {
		
		double[][] double2DArray = { {0.0, 1.1}, {1.1, 2.2}, {3.3, 1.4}};
		
		int[][] int2DArray = { {0, 1}, {1, 2}, {3, 1}};

		
		System.out.println(double2DArray);

			Number[][] result = DataUtilities.createNumberArray2D(double2DArray);
			
			assertTrue("Correct exception type thrown",
					(result instanceof java.lang.Number[][]));
	
			
		}
	
	

	@Test
	public void testCreateNumberArray2DReturnsInvalidParameterExceptionWhenDataisEmpty() {
		
		double [] [] data = null;

		try {
			DataUtilities.createNumberArray2D(data);
			
		}
			catch (Exception e) {
				assertTrue("Correct exception type thrown",
						e.getClass().equals(InvalidParameterException.class));
			}
			
		}
	
	
	
	//Tests for getCumulativePercentages()

	@Test
	public void testGetCumulativePercentagesReturnsCorrectAnswerExceptionWhenDataisValid() {

		DefaultKeyedValues dataKeys = new DefaultKeyedValues();
		
		dataKeys.addValue("0", 5);
		dataKeys.addValue("1", 9);
		dataKeys.addValue("2", 2);
		

		try {
			
		   
		   KeyedValues result = DataUtilities.getCumulativePercentages(dataKeys);
		  		   		   
		   assertTrue((double)result.getValue(0) == 0.3125);
		   assertTrue((double)result.getValue(1) == 0.875);
		   assertTrue((double)result.getValue(2) == 1.0);


			
		}
			catch (Exception e) {
				fail("error:" + e);
			}
			
		}
	
	
	
	@Test
	public void testGetCumulativePercentagesReturnsInvalidParameterExceptionWhenDataisEmpty() {

		DefaultKeyedValues dataKeys = new DefaultKeyedValues();
			
		
		
		try {
			DataUtilities.getCumulativePercentages(dataKeys);
			
		}
			catch (Exception e) {
				assertTrue("Correct exception type thrown",
						e.getClass().equals(InvalidParameterException.class));
			}
			
		}
	
	
			
	}
	


		
		
	
	
	
	
	

