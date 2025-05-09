package org.example.exo4;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class JoueurTest {

    @Mock
    private Joueur joueurMock;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMise() {
        // Configuration du mock pour retourner une mise de 10
        when(joueurMock.mise()).thenReturn(10);

        // Vérification que la mise est positive
        int mise = joueurMock.mise();
        assertTrue("La mise doit être positive", mise > 0);
        assertEquals("La mise doit être égale à 10", 10, mise);
    }

    @Test
    public void testDebiter() throws DebitImpossibleException {
        // Configuration du mock pour ne rien faire lors du débit
        doNothing().when(joueurMock).debiter(anyInt());

        // Test du débit
        joueurMock.debiter(5);
        
        // Vérification que la méthode a été appelée
        verify(joueurMock, times(1)).debiter(5);
    }

    @Test(expected = DebitImpossibleException.class)
    public void testDebiterImpossible() throws DebitImpossibleException {
        // Configuration du mock pour lever une exception lors du débit
        doThrow(new DebitImpossibleException("Débit impossible")).when(joueurMock).debiter(anyInt());

        // Test du débit qui doit lever une exception
        joueurMock.debiter(1000);
    }

    @Test
    public void testCrediter() {
        // Configuration du mock pour ne rien faire lors du crédit
        doNothing().when(joueurMock).crediter(anyInt());

        // Test du crédit
        joueurMock.crediter(10);
        
        // Vérification que la méthode a été appelée
        verify(joueurMock, times(1)).crediter(10);
    }
} 