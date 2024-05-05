package com.calberto_barbosa_jr.mvc_example

import org.junit.Assert
import org.junit.Test


class CounterModelTest {
    @Test
    fun testIncrement() {
        // Arrange (Set up the object to be tested)
        val counterModel = CounterModel()
        val initialCount = counterModel.getCount()

        // Act (Perform the action to be tested)
        counterModel.increment()

        // Assert (Verify the expected outcome)
        Assert.assertEquals((initialCount + 1).toLong(), counterModel.getCount().toLong())
    }

    @Test
    fun testDecrement() {
        // Arrange
        val counterModel = CounterModel()
        counterModel.increment() // Set initial count to 1

        // Act
        counterModel.decrement()

        // Assert
        Assert.assertEquals(0, counterModel.getCount().toLong())
    }

    @Test
    fun testMultipleIncrements() {
        // Arrange
        val counterModel = CounterModel()
        val expectedCount = 3

        // Act
        counterModel.increment()
        counterModel.increment()
        counterModel.increment()

        // Assert
        Assert.assertEquals(expectedCount.toLong(), counterModel.getCount().toLong())
    }

    @Test
    fun testDecrementAfterIncrement() {
        // Arrange
        val counterModel = CounterModel()
        counterModel.increment()

        // Act
        counterModel.decrement()

        // Assert
        Assert.assertEquals(0, counterModel.getCount().toLong())
    }
}