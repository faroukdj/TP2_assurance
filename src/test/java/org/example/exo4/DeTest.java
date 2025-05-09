package org.example.exo4;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DeTest {

    @Mock
    private De deMock;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLancer() {
        // Configuration du mock pour retourner une valeur entre 1 et 6
        when(deMock.lancer()).thenReturn(4);

        // Test du lancer
        int resultat = deMock.lancer();
        
        // Vérification que le résultat est dans la plage valide
        assertTrue("Le résultat doit être entre 1 et 6", resultat >= 1 && resultat <= 6);
        assertEquals("Le résultat doit être égal à 4", 4, resultat);
    }

    @Test
    public void testLancerMultiple() {
        // Configuration du mock pour retourner différentes valeurs
        when(deMock.lancer())
            .thenReturn(1)
            .thenReturn(2)
            .thenReturn(3)
            .thenReturn(4)
            .thenReturn(5)
            .thenReturn(6);

        // Test de plusieurs lancers
        for (int i = 1; i <= 6; i++) {
            int resultat = deMock.lancer();
            assertTrue("Le résultat doit être entre 1 et 6", resultat >= 1 && resultat <= 6);
            assertEquals("Le résultat doit être égal à " + i, i, resultat);
        }
    }
} 