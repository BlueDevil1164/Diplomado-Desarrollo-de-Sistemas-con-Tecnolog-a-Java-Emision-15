package edu.dgtic.lsp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LiskovTest {
    @Test
    void testRectangle() {
        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println(rectangle.computeArea());
        useRectangle(rectangle);
    }

    @Test
    void testSquare() {
        Square square = new Square(10);
        System.out.println(square.computeArea());
        useRectangle(square);
    }

    private static void useRectangle(Shape shape) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            rectangle.setHeight(20);
            rectangle.setWidth(30);
            assertEquals(20, rectangle.getHeight(), "Height Not equal to 20");
            assertEquals(30, rectangle.getWidth(), "Width Not equal to 30");
        } else if (shape instanceof Square) {
            Square square = (Square) shape;
            square.setSide(20);
            assertEquals(20, square.getSide(), "Side Not equal to 20");
            assertEquals(20, square.getSide(), "Side Not equal to 20");
        }
    }
}