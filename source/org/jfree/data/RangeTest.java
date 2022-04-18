package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.jfree.data.Range; 
import org.junit.*;


public class RangeTest {
	
	private Range rangeObjectUnderTestContains;
	private Range rangeObjectUnderTestIntersects;
	private Range rangeObjectUnderTestConstrain;
	
	

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTestContains = new Range(5, 22);
		rangeObjectUnderTestIntersects = new Range(-11, 74);
		rangeObjectUnderTestConstrain = new Range(-27, 57);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContainsReturnsTrueWhenValueInsideRange() {
		assertEquals("Value is inside the range so should return true",	
				true, rangeObjectUnderTestContains.contains(7.23));
	}
	
	@Test
	public void testContainsReturnsFalseWhenValueOutsideOfRangeOnLeftSide() {
		assertEquals("Value is outside of the range on the left side so should return false",	
				false, rangeObjectUnderTestContains.contains(-9));
	}
	
	@Test
	public void testContainsReturnsFalseWhenValueOutsideOfRangeOnRightSide() {
		assertEquals("Value is outside of the range on the right side so should return false",	
				false, rangeObjectUnderTestContains.contains(36.27561));
	}
	
	@Test
	public void testContainsReturnsTrueWhenValueEqualToLowerBoundOfRange() {
		assertEquals("Value is equal to the range's lower bound so should return true",	
				true, rangeObjectUnderTestContains.contains(5));
	}
	
	@Test
	public void testContainsReturnsFalseWhenValueEqualToLowerBoundOfRangeSubtractOne() {
		assertEquals("Value is equal to one value under the range's lower bound so should return false",	
				false, rangeObjectUnderTestContains.contains(4));
	}
	
	@Test
	public void testContainsReturnsTrueWhenValueEqualToLowerBoundOfRangeAddOne() {
		assertEquals("Value is equal to one value over the range's lower bound so should return true",	
				true, rangeObjectUnderTestContains.contains(6));
	}
	
	@Test
	public void testContainsReturnsTrueWhenValueEqualToUpperBoundOfRange() {
		assertEquals("Value is equal to the range's lower bound so should return true",	
				true, rangeObjectUnderTestContains.contains(22));
	}
	
	@Test
	public void testContainsReturnsTrueWhenValueEqualToUpperBoundOfRangeSubtractOne() {
		assertEquals("Value is equal to one value under the range's lower bound so should return true",	
				true, rangeObjectUnderTestContains.contains(21));
	}
	
	@Test
	public void testContainsReturnsTrueWhenValueEqualToUpperBoundOfRangeAddOne() {
		assertEquals("Value is equal to one value over the range's lower bound so should return false",	
				false, rangeObjectUnderTestContains.contains(23));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenLowerAndUpperInputsIntersectWithRange() {
		assertEquals("Lower and upper inputs intersect with range so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(-3.98, 23.362));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenLowerInputIntersectsWithRangeAndUpperInputDoesNotIntersect() {
		assertEquals("Lower input intersects with range and upper input doesn't so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(56, 84.39897251));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenUpperInputIntersectsWithRangeAndLowerInputDoesNotIntersect() {
		assertEquals("Upper input intersects with range and lower input doesn't so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(-17.26, 45.187235341));
	}
	
	@Test
	public void testIntersectsReturnsFalseWhenNeitherLowerOrUpperInputIntersectsWithRange() {
		assertEquals("Neither lower or upper input intersects with range",	
				false, rangeObjectUnderTestIntersects.intersects(-33, -27));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenLowerInputIsEqualToLowerBoundOfRangeandUpperInputIsOutsideOfRange() {
		assertEquals("Lower input is equal to lower bound of range and upper input is outside of range so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(-11, 99.12));
	}
	
	@Test
	public void testIntersectsReturnsFalseWhenLowerInputIsEqualToLowerBoundOfRangeSubtractOneandUpperInputIsOutsideOfRange() {
		assertEquals("Lower input is equal to one under the lower bound of the range and upper input is outside of range so should return false",	
				false, rangeObjectUnderTestIntersects.intersects(-12, 86));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenLowerInputIsEqualToLowerBoundOfRangeAddOneandUpperInputIsOutsideOfRange() {
		assertEquals("Lower input is equal to one over the lower bound of the range and upper input is outside of range so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(-10, 79.5783));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenLowerInputIsEqualToUpperBoundOfRangeandUpperInputIsOutsideOfRange() {
		assertEquals("Lower input is equal to the upper bound of the range and upper input is outside of range so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(74, 104));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenLowerInputIsEqualToUpperBoundOfRangeaSubtractOnendUpperInputIsOutsideOfRange() {
		assertEquals("Lower input is equal to one under the upper bound of the range and upper input is outside of range so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(73, 81.25));
	}
	
	@Test
	public void testIntersectsReturnsFalseWhenLowerInputIsEqualToUpperBoundOfRangeaAddOnendUpperInputIsOutsideOfRange() {
		assertEquals("Lower input is equal to one under the upper bound of the range and upper input is outside of range so should return false",	
				false, rangeObjectUnderTestIntersects.intersects(75, 83.01));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenUpperInputIsEqualToLowerBoundOfRangeandLowerInputIsOutsideOfRange() {
		assertEquals("Upper input is equal to lower bound of range and lower input is outside of range so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(-74.3729, -11));
	}
	
	@Test
	public void testIntersectsReturnsFalseWhenUpperInputIsEqualToLowerBoundOfRangeSubtractOneandLowerInputIsOutsideOfRange() {
		assertEquals("Upper input is equal to one under the lower bound of the range and lower input is outside of range so should return false",	
				false, rangeObjectUnderTestIntersects.intersects(-37, -12));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenUpperInputIsEqualToLowerBoundOfRangeAddOneandLowerInputIsOutsideOfRange() {
		assertEquals("Upper input is equal to one over the lower bound of the range and lower input is outside of range so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(-26.783468, -10));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenUpperInputIsEqualToUpperBoundOfRangeandLowerrInputIsOutsideOfRange() {
		assertEquals("Upper input is equal to the upper bound of the range and lower input is outside of range so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(-16.00, 74));
	}
	
	@Test
	public void testIntersectsReturnsTrueWhenUpperInputIsEqualToUpperBoundOfRangeaSubtractOnendLowerInputIsOutsideOfRange() {
		assertEquals("Upper input is equal to one under the upper bound of the range and lower input is outside of range so should return true",	
				true, rangeObjectUnderTestIntersects.intersects(-25.90, 73));
	}
	
	@Test
	public void testIntersectsReturnsFalseWhenUpperInputIsEqualToUpperBoundOfRangeaAddOnendLowerInputIsOutsideOfRange() {
		assertEquals("Upper input is equal to one under the upper bound of the range and lower input is outside of range so should return false",	
				false, rangeObjectUnderTestIntersects.intersects(-91.0, 75));
	}
	
	@Test
	public void testConstrainReturnsLowerBoundOfRangeWhenValueOutsideOfRangeOnTheLeft() {
		assertEquals("Value outside of range on the left so should return -27",	
				-27.0, rangeObjectUnderTestConstrain.constrain(-43.354), 0);
	}
	
	@Test
	public void testConstrainReturnsLowerBoundOfRangeWhenValueOutsideOfRangeOnTheRight() {
		assertEquals("Value outside of range on the right so should return 57.0",	
				57.0, rangeObjectUnderTestConstrain.constrain(61), 0);
	}
	
	@Test
	public void testConstrainReturnsNumberInRangeWhenValueisEqualToNumberInRange() {
		assertEquals("Value is equal to number in range so should return given number",	
				15.762, rangeObjectUnderTestConstrain.constrain(15.762), 0);
	}
	
	@Test
	public void testConstrainReturnsLowerBoundOfRangeWhenValueIsEqualToLowerBoundOfRange() {
		assertEquals("Value is equal to lower bound of range so should return lower bound",	
				-27.0, rangeObjectUnderTestConstrain.constrain(-27), 0);
	}
	
	@Test
	public void testConstrainReturnsLowerBoundOfRangeWhenValueIsEqualToLowerBoundOfRangeSubtractOne() {
		assertEquals("Value is equal to lower bound of range subtract one so should return lower bound",	
				-27.0, rangeObjectUnderTestConstrain.constrain(-28), 0);
	}
	
	@Test
	public void testConstrainReturnsLowerBoundOfRangeAddOneWhenValueIsEqualToLowerBoundOfRangeAddOne() {
		assertEquals("Value is equal to lower bound of range add one so should return lower bound of range add one",	
				-26.0, rangeObjectUnderTestConstrain.constrain(-26), 0);
	}
	
	@Test
	public void testConstrainReturnsUpperBoundOfRangeWhenValueIsEqualToUpperBoundOfRange() {
		assertEquals("Value is equal to upper bound of range so should return upper bound",	
				57.0, rangeObjectUnderTestConstrain.constrain(57), 0);
	}
	
	@Test
	public void testConstrainReturnsUpperBoundOfRangeSubtractOneWhenValueIsEqualToUpperBoundOfRangeSubtractOne() {
		assertEquals("Value is equal to upper bound of range subtract one so should return upper bound of range subtract one",	
				56.0, rangeObjectUnderTestConstrain.constrain(56), 0);
	}
	
	@Test
	public void testConstrainReturnsUpperBoundOfRangeWhenValueIsEqualToUpperBoundOfRangeAddOne() {
		assertEquals("Value is equal to upper bound of range add one so should return upper bound of range",	
				57.0, rangeObjectUnderTestConstrain.constrain(58), 0);
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameUpperBoundAndLowerBoundEqualToValueWhenValueIsOutsideOfRangeOnTheLeftAndAllOfRangeIsPositive() {
		assertEquals("Value is outside of range on the left and all values in the range are positive so should return range with same upper bound and lower bound equal to value",
				new Range(-20.0, 106.0), Range.expandToInclude(new Range(40, 106), -20));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameLowerBoundAndUpperBoundEqualToValueWhenValueIsOutsideOfRangeOnTheRightAndAllOfRangeIsPositive() {
		assertEquals("Value is outside of range on the right and all values in the range are positive so should return range with same lower bound and upper bound equal to value",	
				new Range(25.0, 52.0), Range.expandToInclude(new Range(25, 44), 52));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameLowerBoundAndSameUpperBoundEqualToValueWhenValueIsInsideOfRangeAndAllOfRangeIsPositive() {
		assertEquals("Value is inside of range and all values in the range are positive so should return range with same lower bound and same upper bound",	
				new Range(12.0, 67.0), Range.expandToInclude(new Range(12, 67), 43));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameUpperBoundAndLowerBoundEqualToValueWhenValueIsOutsideOfRangeOnTheLeftAndAllOfRangeIsNegative() {
		assertEquals("Value is outside of range on the left and all values in the range are negative so should return range with same upper bound and lower bound equal to value",
				new Range(-37, -2), Range.expandToInclude(new Range(-8, -2), -37));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameLowerBoundAndUpperBoundEqualToValueWhenValueIsOutsideOfRangeOnTheRightAndAllOfRangeIsNegative() {
		assertEquals("Value is outside of range on the right and all values in the range are negative so should return range with same lower bound and upper bound equal to value",	
				new Range(-88.0, 4.0), Range.expandToInclude(new Range(-88, -32), 4));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameLowerBoundAndSameUpperBoundEqualToValueWhenValueIsInsideOfRangeAndAllOfRangeIsNegative() {
		assertEquals("Value is inside of range and all values in the range are negative so should return range with same lower bound and same upper bound",	
				new Range(-41.0, -17.0), Range.expandToInclude(new Range(-41, -17), -26));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameUpperBoundAndLowerBoundEqualToValueWhenValueIsOutsideOfRangeOnTheLeftAndLowerBoundOfRangeIsNegativeWhileUpperBoundIsPositive() {
		assertEquals("Value is outside of range and the lower bound of the range is negative while the upper bound is positive so should return range with same upper bound and lower bound equal to value",
				new Range(-37, -2), Range.expandToInclude(new Range(-8, -2), -37));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameLowerBoundAndUpperBoundEqualToValueWhenValueIsOutsideOfRangeOnTheRightAndLowerBoundOfRangeIsNegativeWhileUpperBoundIsPositive() {
		assertEquals("Value is outside of range and the lower bound of the range is negative while the upper bound is positive so should return range with same lower bound and upper bound equal to value",	
				new Range(-88.0, 4.0), Range.expandToInclude(new Range(-88, -32), 4));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameLowerBoundAndSameUpperBoundEqualToValueWhenValueIsInsideOfRangeAndLowerBoundOfRangeIsNegativeWhileUpperBoundIsPositive() {
		assertEquals("Value is inside of range and the lower bound of the range is negative while the upper bound is positive so should return range with same lower bound and same upper bound",	
				new Range(-41.0, -17.0), Range.expandToInclude(new Range(-41, -17), -26));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithLowerBoundAndUpperBoundEqualtoValueWhenRangeIsNull() {
		assertEquals("Value is outside of range on the right and all values in the range are negative so should return range with same lower bound and upper bound equal to value",	
				new Range(15.0, 15.0), Range.expandToInclude(null, 15));
	}
	
	@Test
	public void testExpandToIncludeReturnsSameRangeWhenValueIsEqualToLowerBoundOfRange() {
		assertEquals("Value is equal to lower of range so should return range with same upper and lower bound",	
				new Range(34.0, 56.0), Range.expandToInclude(new Range(34, 56), 34));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameUpperBoundAndLowerBoundEqualToValueWhenValueIsEqualToLowerBoundOfRangeSubtractOne() {
		assertEquals("Value is equal to lower of range subtract one so should return range with same upper bound and lower bound equal to value",	
				new Range(33.0, 56.0), Range.expandToInclude(new Range(34, 56), 33));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameUpperBoundAndLowerBoundWhenValueIsEqualToLowerBoundOfRangeAddOne() {
		assertEquals("Value is equal to lower of range subtract one so should return range with same upper bound and lower bound equal to value",	
				new Range(34.0, 56.0), Range.expandToInclude(new Range(34, 56), 35));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameUpperBoundAndLowerBoundWhenValueIsEqualToUpperBoundOfRange() {
		assertEquals("Value is equal to upper of range so should return range with same upper and lower bound",	
				new Range(34.0, 56.0), Range.expandToInclude(new Range(34, 56), 56));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameUpperBoundAndLowerBoundWhenValueIsEqualToUpperBoundOfRangeSubtractOne() {
		assertEquals("Value is equal to lower of range subtract one so should return range with same upper bound and lower bound equal to value",	
				new Range(34.0, 56.0), Range.expandToInclude(new Range(34, 56), 55));
	}
	
	@Test
	public void testExpandToIncludeReturnsRangeWithSameLowerBoundAndUpperBoundEqualToValueWhenValueIsEqualToUpperBoundOfRangeAddOne() {
		assertEquals("Value is equal to upper bound of range add one so should return range with same lower bound and upper bound equal to value",	
				new Range(34.0, 57.0), Range.expandToInclude(new Range(34, 56), 57));
	}
	
	@Test
	public void testCombineReturnsNullRangeWhenBothRangesAreNull() {
		assertEquals("Both Ranges are equal to null so should return null range",	
				null, Range.combine(null, new Range(2, 13)));
	}
	
	@Test
	public void testCombineReturnsRange2WhenRange1IsNullAndRange2IsValid() {
		assertEquals("Range1 is null and range2 is valid so should return range2",	
				new Range(2, 13), Range.combine(null, new Range(2, 13)));
	}
	
	@Test
	public void testCombineReturnsRange1WhenRange2IsNullAndRange1IsValid() {
		assertEquals("Range2 is null and range1 is valid so should return range1",	
				new Range(47, 109), Range.combine(new Range(47, 109), null));
	}
	
	@Test
	public void testCombineReturnsRange1WhenRange1IsValidAndRange2IsWithinRange1() {
		assertEquals("Range1 is valid and range2 is within range1 so should return range1",	
				new Range(-3, 34), Range.combine(new Range(-3, 34), new Range(7, 18)));
	}
	
	@Test
	public void testCombineReturnsRangeWithLowerBoundOfRange2AndUpperBoundOfRange1WhenRange1IsValidAndRange2ExtendsOutsideOfRange1ToTheLeft() {
		assertEquals("Range1 is valid and range2 extends outside of range1 to the left so should return range with lower bound of range2 and upper bound of range1",	
				new Range(-78, 7), Range.combine(new Range(-26, 7), new Range(-78, 0)));
	}
	
	@Test
	public void testCombineReturnsRangeWithLowerBoundOfRange1AndUpperBoundOfRange2WhenRange1IsValidAndRange2ExtendsOutsideOfRange1ToTheRight() {
		assertEquals("Range1 is valid and range2 extends outsid eof range 1 to the right so should return range with lower bound of range1 and upper bound of range2",	
				new Range(58, 111), Range.combine(new Range(58, 100), new Range(92, 111)));
	}
	
	@Test
	public void testCombineReturnsRange2WhenRange1IsValidAndRange2ExtendsOutsideOfRange1ToTheRightAndLeft() {
		assertEquals("Range1 is valid and range2 extends outside of range 1 to the right and left so should return range with lower bound of range1 and upper bound of range2",	
				new Range(5, 99), Range.combine(new Range(31, 78), new Range(5, 99)));
	}
	
	@Test
	public void testCombineReturnsRange1WhenRange1IsValidAndLowerBoundOfRange2IsEqualToRange1LowerBoundandUpperBoundOfRange2IsWithinRange1() {
		assertEquals("Range1 is valid and lower bound of range2 is equal to range1 lower bound and upper bound of range2 is within range1 so should return range1",	
				new Range(-47, 19), Range.combine(new Range(-47, 19), new Range(-47, 10)));
	}
	
	@Test
	public void testCombineReturnsRangeWithLowerBoundOfRange2AndUpperBoundOfRange1WhenRange1IsValidAndLowerBoundOfRange2IsEqualToRange1LowerBoundSubtractOneandUpperBoundOfRange2IsWithinRange1() {
		assertEquals("Range1 is valid and lower bound of range2 is equal to range1 lower bound add one and upper bound of range2 is within range1 so should return range with lower bound of range2 and upper bound of range1",	
				new Range(-47, 19), Range.combine(new Range(-47, 19), new Range(-47, 10)));
	}
	
	@Test
	public void testCombineReturnsRange1WhenRange1IsValidAndLowerBoundOfRange2IsEqualToRange1LowerBoundAddOneandUpperBoundOfRange2IsWithinRange1() {
		assertEquals("Range1 is valid and lower bound of range2 is equal to range1 lower bound add one and upper bound of range2 is within range1 so should return range with lower bound of range2 and upper bound of range1",	
				new Range(-47, 19), Range.combine(new Range(-47, 19), new Range(-46, 8)));
	}
	
	@Test
	public void testCombineReturnsRange1WhenRange1IsValidAndLowerBoundOfRange2IsWithinRange1AndUpperBoundOfRange2IsEqualToRange1UpperBound() {
		assertEquals("Range1 is valid and upper bound of range2 is equal to range1 upper bound and lower bound of range2 is within range1 so should return range1",	
				new Range(-47, 19), Range.combine(new Range(-47, 19), new Range(-40, 19)));
	}
	
	@Test
	public void testCombineReturnsRange1WhenRange1IsValidAndLowerBoundOfRange2IsWithinRange1AndUpperBoundOfRange2IsEqualToRange1UpperBoundSubtractOne() {
		assertEquals("Range1 is valid and upper bound of range2 is equal to range1 upper bound subtract one and lower bound of range2 is within range1 so should return range1",	
				new Range(-47, 19), Range.combine(new Range(-47, 19), new Range(-36, 18)));
	}
	
	@Test
	public void testCombineReturnsRangeWithLowerBoundOfRange1AndUpperBoundOfRange1WhenRange1IsValidAndLowerBoundOfRange2IsWithinRange1AndUpperBoundOfRange2IsEqualToRange1UpperBoundAddOne() {
		assertEquals("Range1 is valid and upper bound of range2 is equal to range1 upper bound subtract one and lower bound of range2 is within range1 so should return range1",	
				new Range(-47, 19), Range.combine(new Range(-47, 19), new Range(-36, 18)));
	}
}
