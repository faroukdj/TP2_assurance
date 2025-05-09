package org.example.exo3;

import org.junit.Before;
import org.junit.Test;
import org.example.exo3.Calculatrice;

import static org.junit.Assert.*;

public class CalculatriceTest {

    private Calculatrice calculatrice;

    @Before
    public void setUp() {
        calculatrice = new Calculatrice();
    }

    @Test
    public void testAddition() {
        // Test de l'addition avec des nombres positifs
        assertEquals("2 + 3 devrait être égal à 5", 5, calculatrice.addition(2, 3));
        
        // Test de l'addition avec des nombres négatifs
        assertEquals("-2 + (-3) devrait être égal à -5", -5, calculatrice.addition(-2, -3));
        
        // Test de l'addition avec zéro
        assertEquals("0 + 0 devrait être égal à 0", 0, calculatrice.addition(0, 0));
    }

    @Test
    public void testSoustraction() {
        // Test de la soustraction avec des nombres positifs
        assertEquals("5 - 3 devrait être égal à 2", 2, calculatrice.soustraction(5, 3));
        
        // Test de la soustraction avec des nombres négatifs
        assertEquals("-2 - (-3) devrait être égal à 1", 1, calculatrice.soustraction(-2, -3));
        
        // Test de la soustraction avec zéro
        assertEquals("0 - 0 devrait être égal à 0", 0, calculatrice.soustraction(0, 0));
    }

    @Test
    public void testMultiplication() {
        // Test de la multiplication avec des nombres positifs
        assertEquals("2 * 3 devrait être égal à 6", 6, calculatrice.multiplication(2, 3));
        
        // Test de la multiplication avec des nombres négatifs
        assertEquals("-2 * (-3) devrait être égal à 6", 6, calculatrice.multiplication(-2, -3));
        
        // Test de la multiplication avec zéro
        assertEquals("0 * 5 devrait être égal à 0", 0, calculatrice.multiplication(0, 5));
    }

    @Test
    public void testDivision() {
        // Test de la division avec des nombres positifs
        assertEquals("6 / 2 devrait être égal à 3", 3, calculatrice.division(6, 2), 0.001);
        
        // Test de la division avec des nombres négatifs
        assertEquals("-6 / (-2) devrait être égal à 3", 3, calculatrice.division(-6, -2), 0.001);
        
        // Test de la division avec zéro
        assertEquals("0 / 5 devrait être égal à 0", 0, calculatrice.division(0, 5), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionParZero() {
        // Test de la division par zéro qui doit lever une exception
        calculatrice.division(5, 0);
    }
} 